//  It is basically subset

package Recursion.Strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subSequence("" , "abc");
        System.out.println(subSeq( "" , "123"));
    }

    static void subSequence(String str , String old){
        if(old.isEmpty()){
            System.out.println(str);
            return;
        }
        char ch = old.charAt(0);

//      We have mainly two option with char ch either take it or leave it.
//      Take it means add char ch to the str and leave it means skip the char ch

        subSequence(str + ch, old.substring(1));
        subSequence(str , old.substring(1));

    }

    static ArrayList<String> subSeq(String str , String old){
        if(old.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }
        char ch = old.charAt(0);

        ArrayList<String> left = subSeq(str + ch, old.substring(1));
        ArrayList<String > right = subSeq(str , old.substring(1));
        left.addAll(right);
        return left;
    }

}
