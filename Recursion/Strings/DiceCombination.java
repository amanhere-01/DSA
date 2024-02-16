//  Question may be asked that list the possible number of combination of dice numbers to make a sum of 4

package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class DiceCombination {
    public static void main(String[] args) {
//        dice("", 4);
        System.out.println(diceList("", 4));
    }

    static void dice(String str, int target){     // We have to concatenate the possible numbers combination so we take String in arguments
        if(target == 0){
            System.out.println(str);
            return;
        }
        for(int i=1; i<=6 && i<= target ; i++){
            dice( str + i , target -i);
        }
    }

//  To return a list
    static List<String> diceList(String str, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(diceList(str + i, target - i));
        }
        return ans;
        }
}
