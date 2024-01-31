//      This is finding the subset of array with iteration method, not with recursion

package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = subSet(arr);
        for(List<Integer> l: ans){
            System.out.println(l);
        }

    }

    static List<List<Integer>> subSet( int [] arr){
        // First create a outer list
        List<List<Integer>> outer = new ArrayList<>();
        // And now in outer list add a empty list
        outer.add(new ArrayList<>());

        // Now iterate over numbers in array
        for(int num: arr){
            // Now find the size of outer list to iterate in the outer list till i<size
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
