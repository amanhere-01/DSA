package Recursion.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] nums = {5,4,3,2,1};
//      here after sorting the returned array is new object, it will not modify the nums array . If we print nums after sorting it will return the same input array
        nums = sort(nums);  // we modified the nums array by ourselves
        System.out.println(Arrays.toString(nums));
    }

    static int[] sort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid= arr.length/2;
        int [] left = sort(Arrays.copyOfRange(arr , 0 , mid));    // this will send copy of arr from 0 to mid-1
        int [] right= sort( Arrays.copyOfRange( arr , mid , arr.length ));  // this will send copy of arr from mid to length-1

        return  merge( left , right);
    }

    static int[] merge(int[] first , int[] second){
        int[] mix = new int[first.length + second.length];
        int i=0 , j=0 , k=0;

        while (i< first.length && j< second.length){
            if(first[i] < second[j]){
                mix[k++] = first[i];
                i++;
            }
            else {
                mix[k++] = second[j];
                j++;
            }
        }

//      Now if any one of array is iterated completely then it might be possible that other array is not completely iterated
        while (i< first.length){
            mix[k++] = first[i];
            i++;
        }
        while (j< second.length){
            mix[k++] = second[j];
            j++;
        }
        return mix;
    }
}
