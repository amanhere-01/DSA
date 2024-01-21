package Strings;

import java.util.ArrayList;

public class StringsBasics {
    public static void main(String[] args) {
        String a= "chicony";
        String b= "chicony";
        // here both a and b are pointing towards same object int the heap memory
        System.out.println(a==b);

        String c= new String("kazama");
        String d= new String("kazama");
        // here c and d are two different objects in the heap memory so c==d will give false but to check value we use .equals
        System.out.println(c==d);
        System.out.println(c.equals(d));

        // to get character of strings we use charAt
        System.out.println(d.charAt(2));


//  --------------------------------------------------------------------------------------------------------------------

        float z= 2121.3945f;
        // %n = new line
        System.out.printf("Formatted number is %.2f  %n" , z);  // Notice we are using printf bc we are formatting the string
        System.out.printf("Pie: %.3f  %n" , Math.PI);
        System.out.printf("Hey this side %s and i have %d joints   %n" , "Chicony" , 2);



//  --------------------------------------------------------------------------------------------------------------------
        // Operators

        System.out.println('a'+'b');    // this will add the ascii value
        System.out.println("c" + "h");  // this will concatenate the c and h
        System.out.println("c" + 'h');
        System.out.println('a'+ 3);     // add 3 to the ascii value of a
        System.out.println((char)('a'+3));
        System.out.println("a" + 1);

        System.out.println("kazama"+ new ArrayList<>());
        System.out.println("Kunal" + new Integer(56));

//        String ans = new Integer(56 )  +  new ArrayList<>();   // This will throw error
        String ans = new Integer(56 )  +  " " +  new ArrayList<>();  // this will not throw error as we are using string in between so it is important to have at least one string while adding complex data types
        System.out.println(ans);
    }
}
