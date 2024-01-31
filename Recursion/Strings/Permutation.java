package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
//        permutation("" , "abc");
//        System.out.println(permutationList("" , "abc"));
        System.out.println(permutationCount1("", "ab", 0));
        System.out.println(permutationCount2("", "abc"));

    }

    static void permutation(String str , String old){
        if(old.isEmpty()){
            System.out.println(str);
            return;
        }

        char ch = old.charAt(0);
        int end= str.length();
        for(int i=0 ; i<= end; i++){
            String first= str.substring(0,i);   // in substring(0,i) 0th index is inclusive and ith index is exclusive
            String last= str.substring(i,end);
            permutation(first+ ch + last , old.substring(1));
        }

    }


    //  Returning List
    static List<String> permutationList(String str , String old){
        if(old.isEmpty()){
            List<String> list= new ArrayList<>();
            list.add(str);
            return list;
        }

        char ch = old.charAt(0);
        int end= str.length();
        List<String> ans= new ArrayList<>();
        for(int i=0 ; i<= end; i++){
            String first= str.substring(0,i);   // in substring(0,i) 0th index is inclusive and ith index is exclusive
            String last= str.substring(i,end);
            ans.addAll( permutationList(first+ ch + last , old.substring(1)));
        }
        return ans;
    }


//     Returning total number of permutation and passing count in argument

    static int permutationCount1(String str , String old, int count){
        if(old.isEmpty()){
           return ++count;
        }

        char ch = old.charAt(0);
        int end= str.length();
        for(int i=0 ; i<= end; i++){
            String first= str.substring(0,i);   // in substring(0,i) 0th index is inclusive and ith index is exclusive
            String last= str.substring(i,end);
            count = permutationCount1(first+ ch + last , old.substring(1),count);
        }
        return count;
    }


//     Returning total number of permutation but  does not passing count in argument

    static int permutationCount2(String str , String old){
        if(old.isEmpty()){
            return 1;
        }

        char ch = old.charAt(0);
        int end= str.length();
        int count=0;
        for(int i=0 ; i<= end; i++){
            String first= str.substring(0,i);   // in substring(0,i) 0th index is inclusive and ith index is exclusive
            String last= str.substring(i,end);
            count = count+ permutationCount2(first+ ch + last , old.substring(1));
        }
        return count;
    }

}
