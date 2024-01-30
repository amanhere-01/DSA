//  Q) https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

package BinarySearch;

public class SearchRotatedSorted {
    public static void main(String[] args) {
        int [] nums= {2,5,6,0,0,1,2};
        System.out.println(search(nums,0));
    }

    static boolean search(int[] nums, int target) {

        return bs(nums, target, 0, nums.length-1);

    }
    static boolean bs(int[] nums, int target, int s, int e){
        while(s<=e){
            int m= s+(e-s)/2;

            if(nums[m]==target){
                return true;
            }
            if(nums[s]==nums[m] && nums[m]==nums[e]){
//          this condition is for test case when nums= [1,0,1,1,1] and target is 0
                s++;
                e--;
                continue;
            }
            if(nums[s]<= nums[m]){
                if(target>=nums[s] && target<nums[m]){
                    return bs(nums, target, s,m-1);
                }
                else{
                    return bs(nums, target, m+1, e);
                }
            }
            if(target>nums[m] && target<=nums[e]){
                return bs(nums, target, m+1,e);
            }

            return bs(nums, target, s, m-1);
        }
        return false;
    }

}
