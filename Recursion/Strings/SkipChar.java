// Ques is to skip a from the string

package Recursion.Strings;

public class SkipChar {
    public static void main(String[] args) {
        String old = "baccad";
        skip("" , old);
        System.out.println(skip2(old));
    }

    static void skip(String str, String old){
        if(old.isEmpty()){
            System.out.println(str);
            return;
        }

        char ch = old.charAt(0);
        if(ch == 'a'){
            skip(str, old.substring(1));
        }else {
            skip(str + ch, old.substring(1));
        }
    }

    // without passing the new string to arguments 
    static String skip2(String old){
        if(old.isEmpty()){
            return "";
        }
        char ch = old.charAt(0);
        if(ch == 'a'){
            return skip2(old.substring(1));
        }else {

            return ch + skip2(old.substring(1));
        }

    }
}
