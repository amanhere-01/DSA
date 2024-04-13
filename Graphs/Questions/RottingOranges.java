//  https://leetcode.com/problems/rotting-oranges/description/
package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    static class Pair{
        int row;
        int column;
        int time;
        Pair(int row, int column,int time){
            this.row= row;
            this.column= column;
            this.time= time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int ctFresh=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }
                if(grid[i][j]==1){
                    ctFresh++;
                }
            }
        }

        int[] delRow = {-1,+1,0,0};
        int[] delCol= {0,0,-1,+1};
        int time=0;

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col= q.peek().column;
            int t= q.poll().time;
            time= Math.max(time,t);

            for (int i=0; i<4; i++){
                int nrow= row + delRow[i];
                int ncol= col + delCol[i];
                if(nrow>=0&&nrow<m && ncol>=0&&ncol<n && grid[nrow][ncol]==1){
                    ctFresh--;
                    q.offer(new Pair(nrow,ncol,t+1));
                    grid[nrow][ncol]=2;
                }
            }

        }

        if(ctFresh!=0){
            return -1;
        }
        return time;
    }
    
}
