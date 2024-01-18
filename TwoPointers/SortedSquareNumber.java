// Q)  For an array 'a' sorted in non-decreasing order, return an array of squares of each number sorted in non-decreasing order
//  input = {-10, -5 , -2 , 1, 4, 9}
//  output= {1, 4, 16, 25, 81, 100}


package TwoPointers;

import java.util.Arrays;

public class SortedSquareNumber {
    public static void main(String[] args) {
        int[] arr = {-10, -5 , -2 , 1, 4, 9};
        System.out.println(Arrays.toString(sort(arr)));
    }

    static int[] sort(int [] arr){
        int n=arr.length;
        int start=0;
        int end= n-1;
        int[] ans = new int[n];
        int k=0;

        while (start<=end) {
            if (Math.abs(arr[start]) > Math.abs(arr[end])) {
                ans[k++] = arr[start] * arr[start];
                start++;
            } else {
                ans[k++] = arr[end] * arr[end];
                end--;
            }
        }
        return rev(ans);
    }

    static int[] rev(int[] arr){
        int end= arr.length;
        for(int i=0; i<end/2 ; i++){
            int temp = arr[i];
            arr[i]= arr[end-i-1];
            arr[end-i-1]=temp;
        }
        return arr;
    }
}
