package OOPs.ExceptionHandling;

public class TryCatch {
    public static void main(String[] args) {

        int a=1000;
        int b=0;

        try {
            int c = a/b;
            System.out.println("The result is "+ c);
        } catch (Exception e) {
            System.out.println("Can't get the answer.Reason: " + e.getMessage());
        }
        finally {
            System.out.println("This will execute every time whether there is exception or not");
        }
    }
}
