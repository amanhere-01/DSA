package Strings;

import java.text.DecimalFormat;
import java.util.Arrays;

public class String_Buffer {
    public static void main(String[] args) {
        // Constructor 1
        StringBuffer sb =  new StringBuffer();

        // Constructor 2
        StringBuffer str = new StringBuffer(30);

        //  Constructor 3
        StringBuffer str2 = new StringBuffer("This is slower than String Builder");

        sb.append("This is ");
        sb.append("thread safe");
//        sb.insert(4, " Hahahha");
        sb.replace(5, 8, "noob ");   //8 is exclusive
        System.out.println(sb);
        sb.delete(0,5);
        sb.reverse();
        System.out.println(sb);

        // removing whitespaces
        String sentence = "Hi This Side To    tla S   eth   ";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s" , ""));

        // Split
        String st = "Frank-PMoney-JJ-TBag";
        String[] names = st.split("-");     // If there is whitespace instead of - then we gotta call st.split(" ");
        System.out.println(Arrays.toString(names));

        
        // rounding off
        DecimalFormat df = new DecimalFormat("00.0000");
        System.out.println(df.format(3.14));
    }
}
