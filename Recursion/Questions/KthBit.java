//  https://leetcode.com/problems/k-th-symbol-in-grammar/description/
//  https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/solutions/785548/java-c-python-o-1-solutions/       // this ques is also same as aforementioned


package Recursion.Questions;

public class KthBit {
    public static void main(String[] args) {
        System.out.println(kthGrammar(2,2));
    }

    static int kthGrammar(int n, int k) {
        // Base condition
        if(n==1 && k==1){
            return 0;
        }

        int mid = (int) (Math.pow(2,n-1))/2;
        if(k<=mid){
            return kthGrammar(n-1, k);
        }

        else{
            int ans =kthGrammar(n-1,k-mid);
            if(ans==1){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}
