//  Question may be asked
package Recursion.Strings;

public class DiceCombination {
    public static void main(String[] args) {
        dice("", 4);
    }

    static void dice ( String str, int target){     // We have to concatenate the possible numbers so we take String in arguments
        if(target==0){
            System.out.println(str);
            return;
        }
        for(int i=1; i<=6 && i<= target ; i++){
            dice( str + i , target -1);
        }
    }
}
