// Q) https://leetcode.com/problems/flipping-an-image/

package BitwiseOperators;

import java.util.Arrays;

public class FlipAndInverseArray {
    public static void main(String[] args) {
        int[][] arr3 = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] arr4 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        flipAndInvertImage(arr3);
        flipAndInvertImage(arr4);
        System.out.println(Arrays.deepToString(arr3));
        System.out.println(Arrays.deepToString(arr4));
    }

    static int[][] flipAndInvertImage(int[][] image) {
        // we have to first reverse the array and then inverse(complement) the array
        // we will inverse the array using XOR(^)
        // we know that doing XOR of any number with 1 gives complement of its ex- 0^1= 1 and 1^1=0

        for(int i=0; i<image.length ; i++ ){
            for(int j=0 ; j<(image[i].length +1)/2; j++){
                int temp= image[i][j] ^ 1;
                image[i][j] = image[i][image[i].length-1-j] ^ 1;
                image[i][image[i].length-1-j] = temp;
            }
        }
        return image;
    }
}


