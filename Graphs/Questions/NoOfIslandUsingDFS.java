//  https://leetcode.com/problems/number-of-islands/

package Graphs.Questions;

public class NoOfIslandUsingDFS {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    count++;
                    traverse(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    void traverse(int i, int j, char[][] grid,boolean[][] visited){
        visited[i][j] =true;

        //up
        if(i-1>=0 && grid[i-1][j] == '1' && !visited[i-1][j]){
            traverse(i-1,j,grid,visited);
        }
        //left
        if(j-1>=0 && grid[i][j-1] == '1' && !visited[i][j-1]){
            traverse(i,j-1,grid,visited);
        }
        //right
        if(j+1<grid[0].length && grid[i][j+1] == '1' && !visited[i][j+1]){
            traverse(i,j+1,grid,visited);
        }
        //down
        if(i+1<grid.length && grid[i+1][j] == '1' && !visited[i+1][j]){
            traverse(i+1,j,grid,visited);
        }
    }
}
