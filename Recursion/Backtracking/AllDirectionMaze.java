// Here we are travelling in all direction(up, down, left,right)
// The thing with backtracking is when we visit any cell we mark them visited(or false)
// And when return from recursion call the cells were marked false which would be modified for all the path which are supposed to call in future recursion
// So we re-mark the cell un visit(or true) when we come out of recursive call
// So that in future recursion call that cell can be visited again( NOTICE: not talking about visiting same path)

package Recursion.Backtracking;

import java.util.Arrays;

public class AllDirectionMaze {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allPath("", board, 0, 0);
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0, path, 1);
    }

    static void allPath( String str, boolean[][] maze , int r, int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(str);
            return;
        }
        if (maze[r][c]==false){
            return;
        }
        //visiting the cell
        maze[r][c]=false;

        if (r < maze.length-1){      // condition for down movement
            allPath( str+'D' , maze , r+1 , c);
        }

        if (c < maze[0].length-1){      // condition for right movement
            allPath( str+'R' , maze , r , c+1);
        }

        if (r > 0){      // condition for Up movement
            allPath( str+'U' , maze , r-1 , c);
        }

        if (c > 0){      // condition for left movement
            allPath( str+'L' , maze , r , c-1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function i.e, before returning make the cell true
        maze[r][c]=true;

    }


//  Printing all the paths in matrix form

    static void allPathPrint( String str, boolean[][] maze , int r, int c, int[][] path , int step){
        if(r== maze.length-1 && c==maze[0].length-1){
            path[r][c] = step;
            for(int[] ele: path){
                System.out.println(Arrays.toString(ele));
            }
            System.out.println(str);

            return;
        }
        if (maze[r][c]==false){
            return;
        }
        //visiting the cell and marking the step
        maze[r][c]=false;
        path[r][c] = step;

        if (r < maze.length-1){      // condition for down movement
            allPathPrint( str+'D' , maze , r+1 , c, path, step+1);
        }

        if (c < maze[0].length-1){      // condition for right movement
            allPathPrint( str+'R' , maze , r , c+1, path, step+1);
        }

        if (r > 0){      // condition for Up movement
            allPathPrint( str+'U' , maze , r-1 , c, path, step+1);
        }

        if (c > 0){      // condition for left movement
            allPathPrint( str+'L' , maze , r , c-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function i.e, before returning make the cell true
        maze[r][c]=true;
        path[r][c]=0;

    }
}
