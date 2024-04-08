package Others;

import java.util.Arrays;

public class countSorting {
    // Time complexity is O(n) and It is best use for small numbers
    public static void main(String[] args) {
        int[] arr = {10,4,2,7,5};
        countSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void countSort(int[] arr){
        if(arr == null || arr.length <= 1) {
            return;
        }
        
        // First find the largest number in array then make a new array of size largestNo+1
        int max=arr[0];
        for(int num:arr){
            if(num>max)  max=num;
        }
        int[] freqArr = new int[max+1];

        // store the frequency of numbers in arr into freqArr
        for (int num:arr){
            freqArr[num]++;
        }

        // Now traverse in the freqArr and jo index pe jitni baar frequency hai utni baar old array me print kr do
        int index=0;
        for(int i=0; i< freqArr.length; i++){
            while (freqArr[i]>0){
                arr[index]=i;
                index++;
                freqArr[i]--;
            }
        }
    }

}
