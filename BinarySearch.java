public class BinarySearch{

    static int binarySearch(int[] arr, int target){

        if(arr.length==0){
            return -1;
        }

        int lower = 0;
        int upper = arr.length-1;
        

        
        while(lower<=upper){

            // int middle = (lower+upper)/2; // integer value can exceed in this case
            int middle = (lower) + ((upper-lower)/2); // more efficient way

            int middleEle = arr[middle]; //finding the middle element

            if(middleEle == target){
                return middle;
            }
            
            // if target is greater than middle element, search in right half
            if(target>middleEle){
                lower = middle + 1;
            }else{
            // if target is less than middle element, search in left half
                upper = middle-1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {-23, -12, 0, 2, 5, 6, 8, 13, 23, 43, 67, 88};
        int target = 43;

        int pos = binarySearch(arr, target);

        if(pos!=-1){
            System.out.printf("Element(%d) found at index %d", target, pos);
        }else{
            System.out.printf("Element(%d) not found in the array", target);
        }
    }
}