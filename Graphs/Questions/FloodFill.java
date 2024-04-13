//  https://leetcode.com/problems/flood-fill/

package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    static class Pair{
        int row;
        int column;
        Pair(int row, int column){
            this.row= row;
            this.column= column;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n= image[0].length;
        boolean[][] visited = new boolean[m][n];

        bfs(sr,sc, image, color,visited);
        return image;
    }

    private void bfs(int sr, int sc, int[][] image, int color, boolean[][] visited) {
        int m = image.length;
        int n= image[0].length;
        int temp= image[sr][sc];
        visited[sr][sc]= true;
        image[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));

        while(!q.isEmpty()){
            int row= q.peek().row;
            int col= q.poll().column;

            for (int delro= -1; delro<=1; delro++){
                for (int delco= -1; delco<=1; delco++){
                    int newro= row + delro;
                    int newco= col + delco;
                    if (newro==row|| newco==col){
                        if(newro>=0 &&  newro<m && newco>=0 && newco<n && !visited[newro][newco] && image[newro][newco]==temp){
                            visited[newro][newco] = true;
                            image[newro][newco] = color;
                            q.offer(new Pair(newro,newco));
                        }
                    }
                }
            }

        }


    }
}
