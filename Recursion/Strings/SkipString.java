package Recursion.Strings;

public class SkipString {
    public static void main(String[] args) {
        String old = "bcdapplezse";
        System.out.println(skipStr(old));
    }

    static String skipStr(String old){
        if(old.isEmpty()){
            return "";
        }
        if(old.startsWith("apple")){
            return skipStr(old.substring(5));   // Since apple have 5 chars
        }
        else {
            return old.charAt(0) + skipStr(old.substring(1));
        }
    }
}
