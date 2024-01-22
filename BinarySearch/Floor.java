// Q) we have to find the greatest number which is smaller than or equal to target
//      nums = {2,3,5,9,14,16,18}
//      target = 15
//      so if 15 is present in the nums then return 15 if it is not then return the greatest no. which is smaller than 15 which is 14 here in this case

package BinarySearch;

public class Floor {
    public static void main(String[] args) {
        int[] nums = {2,3,5,9,14,16,18};
        int target= 15;
        System.out.println(floor(nums,target));

    }

    static int floor(int arr[] , int target){

        // if the target is smaller than the smaller number in the array
        if(target< arr[0]){
            return -1;
        }

        int start=0;
        int end= arr.length-1;

        while(start<=end){
            int mid= start + (end-start)/2;

            if(target<arr[mid]){
                end= mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else {
                return mid;
            }
        }

        return arr[end];

    }
}

// when start>end then while loop condition violates and start will be end=start-1 and here will be the ceiling number