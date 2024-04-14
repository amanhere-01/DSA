//  https://leetcode.com/problems/01-matrix/submissions/1232246737/

package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class NearestDistanceCell {

    static class Pair{
        int row;
        int column;
        int distance;
        Pair(int row, int column,int distance){
            this.row= row;
            this.column= column;
            this.distance= distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean [m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i< m; i++){
            for (int j=0; j<n; j++){
                if (mat[i][j]==0){      // put all the cell having value 0 and mark it as visited
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }


        int[] delRow = {-1,+1,0,0};
        int[] delCol= {0,0,-1,+1};
        while (!q.isEmpty()){
            int row= q.peek().row;
            int col= q.peek().column;
            int dis= q.poll().distance;
            ans[row][col]= dis;

            for (int i=0; i<4; i++){
                int newRow= row+delRow[i];
                int newCol= col+delCol[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis[newRow][newCol]){
                    vis[newRow][newCol]=true;
                    q.offer(new Pair(newRow,newCol,dis+1));
                }
            }
        }
        return ans;
    }
}
