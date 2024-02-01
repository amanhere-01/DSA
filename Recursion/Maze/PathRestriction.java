//  Suppose there is restriction in path in the matrix(starting from 0 index).
//  Let's suppose restriction is in (1,1) then we can't go through this path.
//  For ex if you are at (0,2) then you can't go down as there is restriction but you can go right

package Recursion.Maze;

public class PathRestriction {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        pathRes("", board, 0, 0);
    }

    static void pathRes( String str , boolean [][] maze , int r, int c){
        if( r== maze.length-1 &&  c== maze[0].length-1){
            System.out.println(str);
            return;
        }
        if(maze[r][c]== false){     // if we encounter any cell which is restricted then we simply return from there
            return;
        }
        if( r< maze.length-1){
            pathRes(str+ 'D' , maze , r+1 , c);
        }
        if( c< maze.length-1){
            pathRes(str+ 'R' , maze , r , c+1);
        }

    }
}
