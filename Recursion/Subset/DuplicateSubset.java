package Recursion.Subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class DuplicateSubset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
//        List<List<Integer>> ans = subsetDuplicate(arr);
//        System.out.println(ans);

        // calling recursion method
        System.out.println( subsetsWithDup(arr));
    }

    // Recursion method
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, nums);
        return res;
    }

    static void helper(List<List<Integer>> ans , List<Integer> inner, int pos, int[] nums) {
//        ans.add(inner); // we can't do this
        ans.add(new ArrayList<>(inner));

        for (int i = pos; i < nums.length; i++) {
            if (i>pos && nums[i]==nums[i-1]){
                continue;
            }
            inner.add(nums[i]);
            helper(ans, inner, i+1, nums);
            inner.remove(inner.size()-1);
        }
    }

    // Iteration method
    static List<List<Integer>> subsetDuplicate( int [] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start, end = 0;

        for(int i=0; i<arr.length; i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start = end+1;
            }
            end= outer.size()-1;
            int size = outer.size();
            for(int j= start; j<size; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }

        }
        return outer;
    }
}
