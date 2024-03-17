//  https://leetcode.com/problems/insert-interval/submissions/1206378641/?envType=daily-question&envId=2024-03-17

package POTD;
import java.util.ArrayList;
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
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
