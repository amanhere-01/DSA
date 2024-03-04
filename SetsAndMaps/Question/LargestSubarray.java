//  https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
// To find the largest subarray with sum 0
package SetsAndMaps.Question;

import java.util.HashMap;

public class LargestSubarray {

    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(arr, arr.length));
    }

    static int maxLen(int[] arr, int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLength=0;
        int sum=0;
        map.put(0,-1);

        for(int i=0; i<n; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                maxLength= Math.max(maxLength, i- map.get(sum));    // if i- map.get(sum) > maxLength then put set it
            }else{
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
