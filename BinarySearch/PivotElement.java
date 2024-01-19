//   suppose For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2] then we have to find pivot element.
//  Pivot element is that element from where the increasing or decreasing order changes. Basically it is the highest element after  rotation of array

package BinarySearch;

public class PivotElement {
    public static void main(String[] args) {
        int []nums = {3,4,5,6,7,8,0,1,2};   // here array with increasing order gives error ex-{1,2,3} gives error likewise decreasing order
        int []nums1 = {3};                  // but for one element it will work
        System.out.println(search(nums));
        System.out.println(search(nums1));
    }

    static int search(int[] nums) {

        int start=0;
        int end= nums.length-1;
        int index=0;
        while(start<=end){
            int mid= start+ (end-start)/2;

            if(mid<end && nums[mid]>nums[mid+1] ){
                return index=mid;
            } else if(mid>start && nums[mid]<nums[mid-1]){
                return index= mid-1;
            }
            else if(mid<end && nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            if (mid==end || mid== start){
                break;
            }
        }
        return 1;
    }
}
