package BinarySearch;

public class ArraySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 5;
        System.out.println(search(nums , target));
    }


    // It will return -1 if element si not in the array
    static int search(int arr[] , int target){
        int start=0;
        int end= arr.length-1;

        while(start<=end){
            int mid= start + (end-start)/2;     // it is used in this way for integer bounds

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

        return -1;

    }
}
