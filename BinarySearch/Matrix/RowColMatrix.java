//  This matrix is sorted row wise and column wise

package BinarySearch.Matrix;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int [][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int [][] arr= {{-1,3}};
        System.out.println(Arrays.toString( search(arr, 3)));
    }

    static int[] search(int[][] matrix, int target){
        int r=0;    // lower bound
        int c= matrix[0].length-1;     // upper bound

        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return new int[]{-1,-1};
        }
        while(r< matrix.length && c>=0){
            if(matrix[r][c] == target){
                return new int[]{r,c};
            }
            if(target < matrix[r][c]){
                c--;
            }
            else if (target > matrix[r][c]){
                r++;
            }
        }
        return new int[]{-1,-1};
    }
}
