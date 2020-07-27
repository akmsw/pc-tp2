import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestTinvariant {
    
    final static ArrayList<String> netInvariants = new ArrayList<String>();

    final static String regex = "(T0,)(.*?)(((T1,)(.*?)(T3,)(.*?)(((T5,)(.*?)(((T9,)(.*?)(T15,))|((T10,)(.*?)(T16,))))|((T13,)(.*?)(T7,))(.*?)(((T9,)(.*?)(T15,))|((T10,)(.*?)(T16,)))))|()(T2,)(.*?)(T4,)(.*?)(((T6,)(.*?)(((T11,)(.*?)(T15,))|((T12,)(.*?)(T16,))))|((T14,)(.*?)(T8,)(.*?)(((T11,)(.*?)(T15,))|((T12,)(.*?)(T16,))))))";
    
    /*final static String regex1 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T5,)((?!(T5,)).)*(T9,)((?!(T9,)).)*(T15,)";
    
    final static String regex2 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T5,)((?!(T5,)).)*(T10,)((?!(T10,)).)*(T16,)";

    final static String regex3 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T6,)((?!(T6,)).)*(T11,)((?!(T11,)).)*(T15,)";

    final static String regex4 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T6,)((?!(T6,)).)*(T12,)((?!(T12,)).)*(T16,)";

    final static String regex5 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T13,)((?!(T13,)).)*(T7,)((?!(T7,)).)*(T9,)((?!(T9,)).)*(T15,)";

    final static String regex6 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T13,)((?!(T13,)).)*(T7,)((?!(T7,)).)*(T10,)((?!(T10,)).)*(T16,)";
    
    final static String regex7 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T14,)((?!(T14,)).)*(T8,)((?!(T8,)).)*(T11,)((?!(T11,)).)*(T15,)";

    final static String regex8 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T14,)((?!(T14,)).)*(T8,)((?!(T8,)).)*(T12,)((?!(T12,)).)*(T16,)";
    */
    
    public static void main(String args[]) {
        netInvariants.add(regex);
        // netInvariants.add(regex1);
        // netInvariants.add(regex2);
        // netInvariants.add(regex3);
        // netInvariants.add(regex4);
        // netInvariants.add(regex5);
        // netInvariants.add(regex6);
        // netInvariants.add(regex7);
        // netInvariants.add(regex8);

        String outputSequence = "[T0, T1, T3, T0, T1, T0, T1, T0, T1, T0, T2, T0, T2, T0, T2, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T3, T15, T0, T1, T5, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T10, T3, T16, T0, T1, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5,"+
         "T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13,  T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T12, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T4, T9, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4,"+
         "T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T12, T4, T16, T0, T2, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T3, T16, T0, T1, T13, T7, T9, T3, T15, T0, T1, T5, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, ]";
        

      //  String outputSequence = "[T0, T1, T3, T0, T1, T0, T1, T0, T1, T0, T2, T0, T2, T0, T2, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T3, T15, ]";
      //  System.out.println(outputSequence.length());
        
        int difference;
        
        Pattern pattern;
        Matcher matcher;

        String pre, post, middle;
        
        for(int i=0; i<10; i++) {
            pattern = Pattern.compile(netInvariants.get(0), Pattern.MULTILINE | Pattern.COMMENTS);
            matcher = pattern.matcher(outputSequence);

            while(matcher.find()) {
                for(int j=1; j<matcher.groupCount(); j++) {
                    middle = "";
                    
                    difference = matcher.end(j)-matcher.start(j);
    
                    if(j%2!=0 && difference>2 && difference<=4) { //Si el grupo corresponde a un (multiplo de 3) + 1
                        pre = outputSequence.substring(0, matcher.start(j));
                        post = outputSequence.substring(matcher.end(j));
            
                        for(int k=0; k<difference; k++)
                            middle += "_";
            
                        outputSequence = pre + middle + post;
            
                        //System.out.println("pre: " + pre + "\nmiddle: " + middle + "\npost: " + post + "\noutputSequence: " + outputSequence);
                                        
                        //outputSequence = outputSequence.substring(0, matcher.start(i)-1).concat(outputSequence.substring(matcher.end(i)+1, outputSequence.length())); //Tomamos [start(i) - 1] y [end(i) + 1] para retirar los matches 
                                
                       // System.out.println("Group " + j + ": " + matcher.group(j) + "  " + matcher.start(j) + "-" + matcher.end(j));
                    }
                }
            }
        }

        //System.out.println("outputSequence: " + outputSequence);
        
        //System.out.println(outputSequence.length());

        outputSequence = outputSequence.replaceAll("_", "");
        outputSequence = outputSequence.replaceAll(" ", "");
        //outputSequence = outputSequence.replaceAll("T", "");

        System.out.println("outputSequence: " + outputSequence);

        //TODO: chequear prioridad (niggas > white ones)
        //TODO: chequear regex y por qué hacen flayings y quedan full T15 y T16
    }
}