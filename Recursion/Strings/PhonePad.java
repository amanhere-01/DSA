//  https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// This ques is like above only but here we are taking 1(a,b,c), 2(d,e,f), 3(g,h,i).....9(y,z). The numbers attached are dial pad of phone

package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        pad("" , "12");
        System.out.println(padList("", "12"));
    }

    static void pad(String str, String old) {
        if(old.isEmpty()){
            System.out.println(str);
            return;
        }

        int digit = old.charAt(0) - '0';    // It will convert '2' into integer 2
        for(int i=(digit-1)*3 ; i< 3*digit ; i++){
            char ch = (char) ('a' + i);
            pad(str+ch, old.substring(1));
        }
    }

//  Returning List

    static List<String> padList(String str, String old) {
        if(old.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }

        List<String> ans = new ArrayList<>();
        int digit = old.charAt(0) - '0';    // It will convert '2' into integer 2
        for(int i=(digit-1)*3 ; i< 3*digit ; i++){
            char ch = (char) ('a' + i);
            ans.addAll(padList(str+ch, old.substring(1)));
        }
        return ans;
    }
}
