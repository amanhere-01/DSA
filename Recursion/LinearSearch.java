package Recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int [] nums= {12,23,34,45,56,67};
        System.out.println(find(nums ,5 ,  0));
        System.out.println(findIndex(nums ,45 ,  0));
    }

    static boolean find(int [] arr , int target , int index){
        if(index== arr.length){
            return false;
        }
        return  arr[index]==target || find(arr,target, index+1);
    }

    static int findIndex(int [] arr , int target , int index){
        if(index== arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }

        return  findIndex(arr,target, index+1);
    }
}
