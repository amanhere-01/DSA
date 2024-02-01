//  Here we can go right, down and diagonal. Also here indices starts from 3 to 1(backward) so we ae going from top left (3,3) to bottom right (1,1)

package Recursion.Maze;


import java.util.ArrayList;
import java.util.List;

public class ThreeDirection {
    public static void main(String[] args) {
        System.out.println(diag("", 3, 3));
    }

    static List<String> diag(String str, int r, int c){
        if(r==1 && c==1){
            List<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }
        List<String> ans = new ArrayList<>();
        if(r>1){                                           //   For going down
            ans.addAll(diag(str + 'D' , r-1 , c));
        }
        if(c>1){                                            //  For going right
            ans.addAll(diag(str+'R' , r, c-1));
        }
        if(r>1 && c>1){                                      // For goinf diagonally
            ans.addAll(diag(str + 'd' , r-1, c-1));
        }
        return ans;
    }
}
