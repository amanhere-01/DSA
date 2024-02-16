//  https://leetcode.com/problems/combination-sum/description/



package Recursion.Questions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        sets(ans, new ArrayList<>(), 0,target,candidates);

        return ans;
    }

    static void sets(List<List<Integer>> ans, List<Integer> ds, int index, int target, int[] arr){
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(target>=arr[index]){
            ds.add(arr[index]);
            sets(ans,ds,index,target-arr[index], arr);
            ds.remove(ds.size()-1);
        }
        sets(ans,ds,index+1, target,arr);
    }


    // 2nd method
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> combs = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        backtrack(combs, temp, candidates, target, 0);
//        return combs;
//    }
//
//    private void backtrack(List<List<Integer>> combs, List<Integer> temp, int[] nums, int remain, int start) {
//        if (remain == 0) {
//            combs.add(new ArrayList<>(temp));
//        } else if (remain > 0) {
//            for (int i = start; i < nums.length; i++) {
//                temp.add(nums[i]);
//                backtrack(combs, temp, nums, remain-nums[i], i);
//                temp.remove(temp.size()-1);
//            }
//        }
//    }
}
