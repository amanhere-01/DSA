package LinearSearch;// Q)  Search for element in range of index


public class SearchInRange {
    public static void main(String[] args) {

        int[] arr= {12,23,34,45,56,67,78,79,-1,-54};
        int start= 2;
        int end= 7;
        int target1= 79;
        int target2 = 23;

        System.out.println(search(arr,start,end,target1));
        System.out.println(search(arr,start,end,target2));
    }

    static boolean search(int[] arr , int start, int end, int target ){
        if(arr.length==0|| end>arr.length || start<0){
            return false;
        }

        for (int index= start; index<=end ; index++){
            if (arr[index]== target){
                return true;
            }
        }
        return false;
    }
}
