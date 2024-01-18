package TwoPointers;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,0,1,1,0};
        System.out.println(Arrays.toString(sortZeroesAndOne(arr)));;
    }

    static int[] sortZeroesAndOne(int[] arr){
        int start=0;
        int end= arr.length-1;
        while(start<=end){
            if(arr[start]==1 && arr[end]==0){
                arr[start]=0;
                arr[end]=1;
                start++;
                end--;
            }
            if(arr[start]==0){
                start++;
            }
            if(arr[end]==1){
                end--;
            }
        }

        return arr;
    }
}
