//  Q)  https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
// infinite array means we don't know the length of array
// this will be working for element till 90 after that it would throw indexOutOfBond exception
// or use end= end+(end-start)*2 then we can find index of element greater than 90 but till 170


package BinarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target= 100;
        System.out.println(search(arr,target));
    }

    static int search(int[] arr , int target){
        // first we start from box of 2 element(box size=1) i.e start=0 and end=1 and gradually we increase the box size by 2*n[we are doing opposite of what we did in binary search, we were gradually decreasing the box range by n/2]
        int start=0;
        int end=1;

        while (target>arr[end]){
            int newStart= end+1;
            end= end+ (end-start+1) * 2  ;
            start=newStart;
        }
        return binarySearch(arr,target,start,end);
    }


    static int binarySearch(int arr[] , int target, int start, int end){

        while(start<=end){
            int mid= start + (end-start)/2;

            if(target<arr[mid]){
                end= mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else {
                return mid;
            }
        }

        return -1;

    }
}
