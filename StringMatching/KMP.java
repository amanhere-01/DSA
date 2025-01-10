package StringMatching;

import java.util.ArrayList;

public class KMP {
    public static void main(String[] args) {
        
    }

    static ArrayList<Integer> search(String txt, String pat){
        int N = txt.length();
        int M = pat.length();
        ArrayList<Integer> ans = new ArrayList<>();

        // compute LPS(longest prefix suffix)
        int[] LPS = new int[M];
        computeLPS(pat,LPS,M);

        int i=0, j=0;

        while(i<N){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==M){       // pattern found in text
                ans.add(i-M+1);  // store the index from where pattern is started in text
                j=LPS[j-1];   // it will further check in the text for pattern
            }
            else if(i<N && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j = LPS[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return ans;
    }
        
    private static void computeLPS(String pat, int[] LPS, int M) {
        int len=0; //length of previous longest prefix and suffix which were equal
        LPS[0] = 0;

        int i=1;
        while(i<M){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                LPS[i] = len;
                i++;
            }
            else{
                if(len!=0){
                    len = LPS[len-1];
                }
                else{
                    LPS[i] = 0;
                    i++;
                }
            }
        }
    }
}
