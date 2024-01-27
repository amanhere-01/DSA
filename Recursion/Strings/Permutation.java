package Recursion.Strings;

public class Permutation {
    public static void main(String[] args) {
        permutation("" , "abc");

    }

    static void permutation(String str , String old){
        if ((old.isEmpty())){
            System.out.println(str);
            return ;
        }

        char ch = old.charAt(0);
        int n= str.length();
        for(int i=0 ; i<= n ; i++){
            String first= str.substring(0,i);
            String second = str.substring(i , n);
            permutation( first + ch+ second , old.substring(1));
        }

    }
}
