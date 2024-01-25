package Recursion.Arrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {

//        int [] nums= {12,23,34,45,56,67};
//        System.out.println(find(nums ,5 ,  0));
//        System.out.println(findIndex(nums ,45 ,  0));
//
        int[] arr = {1,2,3,4,5,4,6};
        ArrayList<Integer> ans = findAllIndex(arr , 4, 0, new ArrayList<>());
        System.out.println(ans);
        ArrayList<Integer> ans2 = findAllIndex2(arr , 4, 0 );
        System.out.println(ans2);

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



// ----------------------------Return Array List------------------------------------------------------------------------
    static ArrayList<Integer> findAllIndex(int[] arr , int target, int index , ArrayList<Integer> list){
        if(index== arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return  findAllIndex(arr,target, index+1 , list);
    }


//  -----------------Returning array list but without passing the list into argument------------------------------------

    static ArrayList<Integer> findAllIndex2(int[] arr , int target, int index ){
        ArrayList<Integer> list = new ArrayList<>();
//      The list created here will be of that particular function call

        if(index== arr.length){
            return list;
        }

        if(arr[index]==target){
            list.add(index);
        }

        ArrayList<Integer> listFromBelowCalls = findAllIndex2(arr, target, index+1);
        list.addAll(listFromBelowCalls);

        return  list;
    }

}
