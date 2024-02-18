//  https://leetcode.com/problems/combination-sum-ii/description/

package Recursion.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        System.out.println(combinationSum2(candidates, 5));
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        sets(ans, 0, target, new ArrayList<>(), candidates);
        return ans;
    }

    static void sets(List<List<Integer>> ans, int index, int target, List<Integer> ds, int[] arr) {

        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // Take it
        if (target >= arr[index]) {
            ds.add(arr[index]);
            sets(ans, index + 1, target - arr[index], ds, arr); // here we can't take the same value twice so index+1
            ds.remove(ds.size() - 1);
        }

        // Leave it
        int j = index + 1;
        while (j < arr.length && arr[j] == arr[j - 1]) {    // If duplicate then index++;
            j++;
        }
        sets(ans, j, target, ds, arr);
    }

    // 2nd approach

    // static void sets(List<List<Integer>> ans, int index, int target, List<Integer> ds, int[] arr) {
    //     if (target == 0) {
    //         ans.add(new ArrayList<>(ds));
    //     } else if (target > 0) {
    //         for (int i = index; i < arr.length; i++) {
    //             if (i > index && arr[i] == arr[i - 1]) {
    //                 continue;
    //             }
    //             ds.add(arr[i]);
    //             sets(ans, i + 1, target - arr[i], ds, arr);
    //             ds.remove(ds.size() - 1);
    //         }
    //     }
    // }
}
