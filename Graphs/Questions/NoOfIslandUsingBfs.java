package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslandUsingBfs {
    static class Pair{
        int row;
        int column;
        Pair(int row, int column){
            this.row= row;
            this.column= column;
        }
    }

    public int numIslands(char[][] grid) {
        int rs= grid.length;
        int cs= grid[0].length;
        boolean[][] visited= new boolean[rs][cs];
        int count=0;
        for (int i=0; i<rs; i++){
            for(int j=0; j<cs; j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }


    //  https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    private void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col]= true;
        int rs= grid.length;
        int cs= grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));

        while (!q.isEmpty()){
            int ro= q.peek().row;
            int co= q.poll().column;

            for (int delro= -1; delro<=1; delro++){
                for (int delco= -1; delco<=1; delco++){
                    int newro= ro + delro;
                    int newco= co + delco;
                    // Here we are checking in all 8 direction
                    if(newro>=0 &&  newro<rs && newco>=0 && newco<cs && !visited[newro][newco] && grid[newro][newco]=='1'){
                        visited[newro][newco] = true;
                        q.offer(new Pair(newro,newco));
                    }
                }
            }
        }
    }

    //  https://leetcode.com/problems/number-of-islands/description/
    private void bfs2(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col]= true;
        int rs= grid.length;
        int cs= grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));

        while (!q.isEmpty()){
            int ro= q.peek().row;
            int co= q.poll().column;

            for (int delro= -1; delro<=1; delro++){
                for (int delco= -1; delco<=1; delco++){
                    int newro= ro + delro;
                    int newco= co + delco;
                    // Here we are checking in only 4 direction(right,left,top,bottom)
                    if (newro==ro|| newco==co){
                        if(newro>=0 &&  newro<rs && newco>=0 && newco<cs && !visited[newro][newco] && grid[newro][newco]=='1'){
                            visited[newro][newco] = true;
                            q.offer(new Pair(newro,newco));
                        }
                    }
                }
            }
        }
    }

}
