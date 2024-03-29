// Q)  https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
// Q)  https://leetcode.com/problems/find-peak-element/description/
// above both question are same

// Basically we gotta find index of max element
package BinarySearch;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {0,3,6,10,5,4,1};
        int[] arr1 = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
        System.out.println(findPeakElement(arr1));
    }

    static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else{
//            else if (arr[mid] > arr[mid-1])  {    // we can use this too instead of else
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are =
    }
}
