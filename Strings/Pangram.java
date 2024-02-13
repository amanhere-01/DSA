package Strings;

public class Pangram {
    public static void main(String[] args) {

        String str ="dZeTePmPcOeWkUkWhOmZmSdWfXjRjWbQhQcUeRcSjX";
        String str2= "TheQuickBrownFoxJumpsOverTheLazyDog";
        System.out.println(isPangram(str));
        System.out.println(isPangram(str2));
    }

    public static boolean isPangram (String str) {
        str = str.toLowerCase();
        if(str.length()<26){
            return false;
        }
        else{
            for(char ch='a'; ch<='z'; ch++){
                if(str.indexOf(ch)<0){
                    return false;
                }
            }
        }
        return true;
    }
}
