package Patterns;

public class Codes {
    public static void main(String[] args) {
        pattern31(5);
    }

    static void pattern2(int  n){
        for(int row=1; row<=n ; row++){
            for(int col=1; col<= row ; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int  n){
        for(int row=1; row<=n ; row++){
            for(int col=n-row; col>=0 ; col--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int  n){
        for(int row=1; row<=n ; row++){
            for(int col=1; col<= row ; col++){
                System.out.print(col+ " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int  n){
        int i=1;
        for(int row=1; row < 2*n ; row++){
            if(row<=n){
                for(int col=1; col<= row ; col++){
                    System.out.print("* ");
                }
            }
            else{
                for(int col=1; col<=row-2*i; col++){
                    System.out.print("* ");
                }
                i++;
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row: row;  // if row>n then col=2n-row else col= row

            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern30(int n){
        for(int row=1; row<=n ; row++){
            for(int space=0; space<n-row;space++){
                System.out.print("  ");
            }
            for (int col=row; col>0 ; col--){
                System.out.print(col+" ");
            }
            for(int col=2; col<=row; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n){
        for(int row=1; row<2*n ; row++){

            int c = row > n ? 2 * n - row: row;

            for(int space=0; space<n-c;space++){
                System.out.print("  ");
            }

            for (int col= c; col> 0 ; col--){
                System.out.print(col+" ");
            }

            for(int col=2; col<=c; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static void pattern31(int n){
        int originalN=n;
        n=2*n-2;
        for(int row= 1; row< n; row++){
            for (int col=1; col<n; col++){
                int atEveryIndex= originalN - Math.min(Math.min(row,col) , Math.min(n-row,n-col));
                System.out.print(atEveryIndex + " ");

            }
            System.out.println();
        }
    }


}
