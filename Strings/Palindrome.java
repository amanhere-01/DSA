package Strings;

public class Palindrome {
    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String sen){
        if(sen == null || sen.length()==0){
            return true;
        }

        sen.toLowerCase();
        for (int i=0 ; i<sen.length() ; i++){
            char start = sen.charAt(i);
            char end = sen.charAt(sen.length() -1 -i);
            if(start != end){
                return false;
            }
        }
        return true;
    }
}
