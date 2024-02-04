package OOPs.ExceptionHandling;


class NegativeRadiusException extends Exception{

    @Override
    public String getMessage(){
        return "Radius can not be negative" ;
    }
}


public class CustomException {

    public static int divide(int a, int b) throws ArithmeticException{
        if(b==0){
            throw  new ArithmeticException("Can't divide by 0");
        }
        return a/b;
    }

    public static double area(int r) throws NegativeRadiusException{
        if ( r<0){
            throw new NegativeRadiusException();
        }
        return Math.PI *r*r;

    }

    public static void main(String[] args) {
        // When we use "throws" in any method then we call that method in try catch block

        try{
            double a= area(5);
            System.out.println(a);
            // when above method(area) throws exception then it will not execute below code

            int d = divide(24, 0);
            System.out.println(d);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
