//  question may be asked you have given a 3x3 matrix and print the no of ways to go to (3,3) from (1,1). We ae counting row & col from 1
//  And another condition is you can only go down and right in the matrix

package Recursion.Maze;

public class MazeRightDown {
    public static void main(String[] args) {
        System.out.println( count(1,1));
        path("" , 1,1);
    }

    static int count(int r, int c){
        if(r==3 || c==3){                  // If row is 3(col could be anything) then from there is  only one way to go to (3,3) which is right only
            return 1;                      // Likewise if col is 3(row could be anything) then from there is only one way to go to (3,3) which is down way
        }

        int left = count(r+1 , c);      // If we go down then r= r+1
        int right = count(r, c+1);      // If we go right then c=c+1

        return left+right;
    }

    static void path(String str , int r, int c){
//      D= down , R = right
        if(r==3 && c==3){
            System.out.println(str);
            return;
       }
        if(r<3){
            path(str + 'D',r+1 , c);
        }
        if(c<3){
            path( str + 'R' , r , c+1);
        }


    }


}
