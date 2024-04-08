package Others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class countSorting {
    // Time complexity is O(n) and It is best use for small numbers
    public static void main(String[] args) {
        int[] arr = {10,4,2,7,5,4};
//        countSort(arr);
        countSortHash(arr);
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

    // Using Hash to store frequency
    public static void countSortHash(int[] arr){
        if(arr==null || arr.length<=1){
            return;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // Store the frequency in the HashMap
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: arr) {
            countMap.put(num, countMap.getOrDefault(num,0) +1);
        }

        int index=0;
        for (int i=min; i<=max; i++){
            int freq= countMap.getOrDefault(i,0);
            for (int j=0; j<freq; j++){
                arr[index]= i;
                index++;
            }
        }
    }

}
