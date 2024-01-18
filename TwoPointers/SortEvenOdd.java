// Q)  In an array 'a' move all even integers at the beginning followed by all odd integers

package TwoPointers;

import java.util.Arrays;

public class SortEvenOdd {
    public static void main(String[] args) {
        int[] arr = {21, 32, 545, 65, 64, 24, 55, 76, 987, 921};
        System.out.println(Arrays.toString(sort(arr)));
        ;
    }


    static int[] sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;


        int[] newArr = new int[arr.length];
        while (start < end) {

//          First method
//            for(int i =0;i<=end;i++){
//                if (arr[i]%2==0){
//                    newArr[start]=arr[i];
//                    start++;
//                }
//                else{
//                    newArr[end]= arr[i];
//                    end--;
//                }
//            }

            // Second method
            if (arr[start] % 2 != 0 && arr[end] % 2 == 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            if (arr[start] % 2 == 0) {
                start++;
            }
            if (arr[end] % 2 != 0) {
                end--;
            }

        }
//        return newArr;
        return arr;
    }

}
