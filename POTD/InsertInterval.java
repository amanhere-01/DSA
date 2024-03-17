//  https://leetcode.com/problems/insert-interval/submissions/1206378641/?envType=daily-question&envId=2024-03-17

package POTD;
import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{6,9}};
//        int[] newInter = {2,5};
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInter = {4,8};
        System.out.println(Arrays.deepToString(insert(intervals, newInter)));
    }


    static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] in: intervals){
            if(in[1] < newInterval[0]){
                list.add(in);
            }
            else if(in[0] > newInterval[1]){
                list.add(newInterval);
                newInterval = in;
            }
            else{
                newInterval[0] = Math.min(newInterval[0],in[0]);
                newInterval[1] = Math.max(newInterval[1],in[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
