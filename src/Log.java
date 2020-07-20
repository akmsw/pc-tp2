/**
 * @author Luna, Lihué Leandro
 * @author Coronati, Federico Joaquín
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 * @since 01/07/2020
 */

import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.concurrent.Semaphore;

import java.io.File;
import java.io.IOException;

import Jama.Matrix;

public class Log extends Thread {

	//Campos privados.
	private Object lock;
	private int stepToLog;
	private ArrayList<String> transitionsSequence;
	private File f;
	private FileHandler FH;
	private Logger logger;
	private Monitor monitor;

	/**
	 * Constructor.
	 * 
	 * @param fileName nombre del archivo log.
	 * @param monitor Monitor que controla la red de Petri.
	 * @param stepToLog Paso que se utilizará para escribir en el log
	 * 					(cada cuántas transiciones disparadas escribiremos).
	 * @param lock Lock que interactúa entre el Log y el hilo que disparó.
	 * @throws IOException Si hubo un error al crear el archivo log.
	 */
	public Log(String fileName, Monitor monitor, int stepToLog, Object lock) throws IOException {
		this.monitor = monitor;
		this.stepToLog = stepToLog;
		this.lock = lock;

		transitionsSequence = new ArrayList<String>();

		f = new File(fileName);
		
		if(!f.exists()) f.createNewFile();
		
		SimpleFormatter formatter = new SimpleFormatter();		

		FH = new FileHandler(fileName,true);
		
		FH.setFormatter(formatter);
	}

	// ----------------------------------------Overrides----------------------------------------
	
	/**
	 * Este método hace que el objeto Log escriba en un archivo .txt información importante
	 * sobre la ejecución del programa. Esta información consta de la transición disparada,
	 * la carga de las memorias, la carga de los procesadores y la ejecución de las tareas
	 * en los procesadores. Esto se escribe cada 'stepToLog' transiciones disparadas y mientras
	 * no se haya llegado a la condición de corte del programa.
	 * Además, se almacena en un arreglo cada transición disparada por cada hilo para luego
	 * imprimirla en el archivo .txt y poder analizar en él los invariantes de transición más adelante.
	 * Por cada transición disparada y escrita, se chequea que se cumplan los invariantes
	 * de plaza de la red.
	 */
	@Override
	public void run() {
		logger = Logger.getLogger("ReportTest");
		
		logger.addHandler(FH);
		logger.setLevel(Level.INFO);

		logger.info("------------------------------------------------------------------------------" + 
					"\nSTART LOGGING" + 
					"\n------------------------------------------------------------------------------");

		Matrix initialMark, currentMark, aux;

		boolean transitionInvariant;

		int transitionInvariantsAmount = 0;

		initialMark = monitor.getPetriNet().getInitialMarkingVector();

		while(!monitor.getPetriNet().hasCompleted()) {
			transitionInvariant = true;
			
			synchronized(lock) {
				try {
					lock.wait();
				} catch(InterruptedException e) {
					System.out.println("Error en espera en el log.");
				}
			}

			currentMark = monitor.getPetriNet().getCurrentMarkingVector();

			aux = initialMark.minus(currentMark);

			for(int i=0; i<aux.getColumnDimension(); i++)
				if(aux.get(0, i)!=0) {
					transitionInvariant = false;
					break;
				}
			
			transitionsSequence.add(monitor.getPetriNet().getLastFiredTransition() + "");
			
			if(transitionInvariant) {
				System.out.println("SE VOLVIÓ AL MARCADO INICIAL");
				transitionsSequence.add("#");
				transitionInvariantsAmount++;
			}
			
			//monitor.getPetriNet().checkPlacesInvariants();

			if(monitor.getPetriNet().getTotalFired()%stepToLog==0)
				logger.info("\n"+monitor.getPetriNet().getMemoriesLoad() +
							"\n" + monitor.getPetriNet().getProcessorsLoad() +
							"\n" + monitor.getPetriNet().getProcessorsTasks() );	

			synchronized(lock) {
				lock.notify();
			}
		}
		
		logger.info("Se completaron exitosamente " + monitor.getPetriNet().getStopCondition() + " tareas." + 
					"\n" + monitor.getPetriNet().getMemoriesLoad() + 
					"\n" + monitor.getPetriNet().getProcessorsLoad() + 
					"\n" + monitor.getPetriNet().getProcessorsTasks() +
					"\nSe dispararon "+ (transitionsSequence.size()-transitionInvariantsAmount) + " transiciones.");
		
		logger.info(transitionsSequence.toString());

		logger.info("------------------------------------------------------------------------------" + 
					"\nFINISH LOGGING" + 
					"\n------------------------------------------------------------------------------");

		for(Semaphore queue : monitor.getConditionQueues())
			if(queue.hasQueuedThreads())
				queue.release(queue.getQueueLength());
		
		if(monitor.getEntryQueue().hasQueuedThreads())
			monitor.getEntryQueue().release(monitor.getEntryQueue().getQueueLength());
	}
}