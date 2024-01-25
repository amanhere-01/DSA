//  Here we are not creating any new array we are modifying the input array

package Recursion.Sorting;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String[] args) {
        int [] nums = {5,4,3,2,1};
        sort(nums, 0 , nums.length);
        System.out.println(Arrays.toString(nums));
    }

    static void  sort(int[] arr, int s , int e){
        if(e-s == 1){
            return ;
        }

        int mid= (s+e)/2;
        sort(arr , s , mid);
        sort( arr , mid , e );

        merge( arr , s, mid , e);
    }

    static void  merge(int[] arr , int s , int m ,  int e ){
        int[] mix = new int[e-s];
        int i=s , j=m , k=0;

        while (i< m && j< e){
            if(arr[i] < arr[j]){
                mix[k++] = arr[i];
                i++;
            }
            else {
                mix[k++] = arr[j];
                j++;
            }
        }


        while (i< m){
            mix[k++] = arr[i];
            i++;
        }
        while (j< e){
            mix[k++] = arr[j];
            j++;
        }

        for(int z=0 ; z< mix.length ; z++){
            arr[s+z] = mix[z];
        }
    }
}
