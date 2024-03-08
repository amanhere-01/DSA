package SlidingWindow;

public class LargestSubarrayOfSumK {

    public static void main(String[] args) {
//        int[] arr = {10, 5, 2, 7, 1, 9};  k=15
//        int[] arr = {4,1,4,1,1,1,3,5};    k=5
        int[] arr = {2,3,4,6,9,1,1,1,1,4 };
        System.out.println(largestSubarray(arr , 13));
    }

    static int largestSubarray(int[] arr, int k){
        int i=0, j=0;
        int maxSize=0;
        int sum=0;
        while(j<arr.length){
            sum += arr[j];

            if(sum<k){
                j++;
            }

            else if(sum == k){
                maxSize= Math.max(maxSize, j-i+1);      // j-i+1 is the window size
                j++;
            }

            else {                              // if sum>k
                while (sum> k){
                    sum -= arr[i];
                    i++;
                    if(sum==k){
                        maxSize = Math.max(maxSize, j-i+1);
                    }
                }
                j++;
            }
        }
        return maxSize;
    }
}
