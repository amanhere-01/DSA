package Recursion.Sorting;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String[] args) {

    }

    static void  sort(int[] arr, int s , int e){
        if(e-s == 1){
            return ;
        }

        int mid= arr.length/2;
        sort(arr , 0 , mid);
        int [] right= sort( Arrays.copyOfRange( arr , mid , arr.length ));

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
