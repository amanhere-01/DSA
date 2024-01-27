package Recursion.Strings;

public class SkipString {
    public static void main(String[] args) {
        String old = "bcdapplezse";
        String old2= "bcdapplezseappjkl";
        System.out.println(skipStr(old));
        System.out.println(skipAppNotApple(old2));
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

//  This method will only skip app when apple is not along with. If only app is there it will skip
    static String skipAppNotApple(String old){
        if(old.isEmpty()){
            return "";
        }
        if(old.startsWith("app")  && !old.startsWith("apple")  ){
            return skipAppNotApple(old.substring(3));   // Since app have 3 chars
        }
        else {
            return old.charAt(0) + skipAppNotApple(old.substring(1));
        }
    }
}
