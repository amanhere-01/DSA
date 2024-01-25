package Recursion.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] nums ={21,32,43,54,65,76,87,98};
        int target = 76;
        System.out.println( search(nums, target, 0, nums.length-1));
    }

    static int search(int[] arr , int target , int s, int e){
        if(s>e){
            return -1;
        }
        int m= s + ( e - s ) / 2;

        if(arr[m]>target){
            return search(arr , target , s , m - 1);
        }
        else if (arr[m]<target){
            return search( arr , target , m + 1 , e);
        }
        else {
            return m;
        }
    }
}
