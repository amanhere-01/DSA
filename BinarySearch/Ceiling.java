// Q) we have to find the smallest number which is greater than or equal to target
//      nums = {2,3,5,9,14,16,18}
//      target = 15
//      so if 15 is present in the nums then return 15 if it is not then return the smallest no. which is  greater than 15 which is 16 here in this case

package BinarySearch;

public class Ceiling {
    public static void main(String[] args) {
        int[] nums = {2,3,5,9,14,16,18};
        int target= 15;
        System.out.println(ceiling(nums,target));   

    }

    static int ceiling(int arr[] , int target){

        // if the target is greater than the greatest number in the array
        if(target> arr[arr.length-1]){
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

        return arr[start];

    }
}

// when start>end then while loop condition violates and start will be start=end+1 and here will be the ceiling number