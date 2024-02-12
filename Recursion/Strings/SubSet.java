package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = subSet(arr);
        System.out.println(ans);

        // With recusion
        List<List<Integer>> ans2 = new ArrayList<>();
        sets(ans2, new ArrayList<>() , 0, arr);
        System.out.println(ans2);

    }
    static void sets(List<List<Integer>> ans,List<Integer> inner,int i, int[] nums){

        if(i== nums.length){
            ans.add(inner);
            return;
        }
        int num= nums[i];

        List<Integer> innerWithNum = new ArrayList<>(inner);
        innerWithNum.add(num);

        sets(ans,innerWithNum ,i+1, nums);
        sets(ans, inner, i+1, nums) ;

    }



    // With iteration

    static List<List<Integer>> subSet( int [] arr){
        // First create a outer list
        List<List<Integer>> outer = new ArrayList<>();
        // And now in outer list add a empty list
        outer.add(new ArrayList<>());

        // Now iterate over numbers in array
        for(int num: arr){
            // For every num find the size of outer list to iterate in the outer list till i<size
            // To add the num we make an internal list which is initially copy of lists in the outer list
            // And now we add that num in the every list of outer list
            // And now the internal list is modified and add that internal list to outer list
            int size = outer.size();
            for(int i=0; i<size; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i)); // Here we made copy of i'th list of outer list
                internal.add(num);      // and will add num to this copied i'th list
                outer.add(internal);
            }

        }
        return outer;
    }

}
