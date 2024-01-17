package LinearSearch;

public class ArraySearch {
    public static void main(String[] args) {

        int[] arr= {21,32,-45,64,756,76-21,-42,432};
        int target = 32;

        System.out.println("Index of target is: "+ search(arr , target));
    }


    // -1 will be returned if element is not present
    static int search(int[] a, int element){
        if (a.length==0){
            return -1;
        }
        for(int index=0; index<a.length ; index++){
            if(a[index]==element){
                return index;
            }
        }
        return -1;
    }
}

