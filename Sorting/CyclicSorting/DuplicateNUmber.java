package Sorting.CyclicSorting;

public class DuplicateNUmber {
    public static void main(String[] args) {
        int[] nums= {2,4,1,4,3};
        System.out.println(findDuplicate(nums));
    }

     static int findDuplicate(int[] nums) {
         int i=0;
         while(i<nums.length){
             int correct = nums[i]-1;
             if(nums[i] != nums[correct]){
                 swap(nums,i,nums[i]-1);
             }
             else {
                 i++;
             }
         }

         int ans=0;
         for(int index=0; index<nums.length; index++){
             if(nums[index]!= index+1){
                 ans = nums[index];
             }
         }
         return ans;

     }

      static void swap(int[] arr, int first , int second){
         int temp = arr[first];
         arr[first] =arr[second];
         arr[second]=temp;
     }
}
