//  https://leetcode.com/problems/single-element-in-a-sorted-array/description/
package BitwiseOperators;//  Q) Every number is appearing 2 times but one number is not find that unique number

public class uniqueElement {
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4};
        System.out.println(ans(arr));
    }
    static int ans(int[] arr){
        int unique = 0;
        for(int num: arr){
            unique = unique ^ num;
        }
        return unique;
    }
}
