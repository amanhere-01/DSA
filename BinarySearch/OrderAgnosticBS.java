//  Order agnostic means the array will be sorted increasing or decreasing


package BinarySearch;
public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] nums = {-18,-12,-6,-2,0,3,5,9,12,21,43,65};
        int[] nums1 = {65,54,43,32,21,0,-1,-12,-34,-54};
        int target = 5;
        System.out.println(OAsearch(nums , target));
        System.out.println(OAsearch(nums1 , -34));
    }

    static int OAsearch(int arr[] , int target){
        int start=0;
        int end= arr.length-1;

        boolean isAscending = arr[start] <arr[end];


        while(start<=end){
            int mid= start + (end-start)/2;

            if (arr[mid]==target){
                return mid;
            }

            if (isAscending){           // for increasing order array
                if(target<arr[mid]){
                    end= mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else {                      // for decreasing order array
                if(target>arr[mid]){
                    end= mid-1;
                }
                else if(target<arr[mid]){
                    start=mid+1;
                }
            }
        }

        return -1;

    }
}
