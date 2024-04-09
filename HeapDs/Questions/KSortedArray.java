// https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
package HeapDs.Questions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        System.out.println(nearlySorted(arr, arr.length, 3));
    }

    public static ArrayList<Integer> nearlySorted(int arr[], int num, int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int n: arr){
            minHeap.offer(n);
            if(minHeap.size() >k){
                list.add(minHeap.poll());
            }
        }


        while(!minHeap.isEmpty()){
            list.add(minHeap.poll());
        }
        return list;
    }



    // 2nd approach
    // public static ArrayList <Integer> nearlySorted(int arr[], int num, int k){

    //     PriorityQueue<Integer> pq = new PriorityQueue<>();

    //     for(int n: arr){
    //         pq.offer(n);
    //     }

    //     ArrayList<Integer> list = new ArrayList<>();
    //     while(!pq.isEmpty()){
    //         list.add(pq.poll());
    //     }
    //     return list;
    // }
}
