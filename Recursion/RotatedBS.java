

package Recursion;

public class RotatedBS {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,8,0,1,2};
        int[] arr = {3,4,0,1,2};
        System.out.println( search( nums ,6, 0 , nums.length-1 ));
        System.out.println( search( arr ,3, 0 , arr.length-1 ));
    }

    static int search(int [] arr , int target, int s, int e){
        if(s>e){
            return -1;
        }
        int m = s + (e - s)/2;

        if(arr[m] == target){
            return m;
        }

        if(arr[s] <= arr[m]){
            if ( target>= arr[s] && target < arr[m]){
                return search(arr,target, s , m-1);
            }
            else{
                return search(arr, target, m+1 , e);
            }
        }

        if(target > arr[m] && target <= arr[e]){
            return search(arr ,target, m+1 , e);
        }

        return search(arr,target, s , m-1);

    }
}
