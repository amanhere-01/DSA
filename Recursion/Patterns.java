package Recursion;

public class Patterns {
    public static void main(String[] args) {
        star(4,0);
        System.out.println("\n --------------------------------");
        Invertstar(4,0);
    }

    static void  star(int r, int c){
        if(r==0){
            return;
        }
        if( r > c ){
            star( r, c+1);
            System.out.print("* ");

        }
        else {
            star( r-1 , 0);
            System.out.println();

        }

    }
    static void Invertstar(int r, int c){
        if(r==0){
            return;
        }
        if( r > c ){
            System.out.print("* ");
            Invertstar( r, c+1);
        }
        else {
            System.out.println();
            Invertstar( r-1 , 0);
        }

    }
}
