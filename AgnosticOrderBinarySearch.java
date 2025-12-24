public class AgnosticOrderBinarySearch{

    static int binarySearch(int[] arr, int target){

        if(arr.length==0){
            return -1;
        }

        
        
        int lower = 0;
        int upper = arr.length-1;

        /*
        Check the sorting order of the array.
        - arr[lower] > arr[upper] -> descending
        - arr[lower] > arr[upper] -> ascending
        */

        boolean isAscending = arr[lower]< arr[upper];
        
        while(lower<=upper){

            // int middle = (lower+upper)/2; // integer value can exceed in this case
            int middle = (lower) + ((upper-lower)/2); // more efficient way

            int middleEle = arr[middle]; //finding the middle element

            if(middleEle == target){
                return middle;
            }

            if(isAscending){
                // if target is greater than middle element, search in right half
                if(target>middleEle){
                    lower = middle + 1;
                }else{
                // if target is less than middle element, search in left half
                    upper = middle-1;
                }
            }else{
                // if target is greater than middle element, search in left half
                if(target>middleEle){
                    upper = middle-1;
                }else{
                // if target is less than middle element, search in right half
                    lower = middle + 1;
                }
            }
            
            
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {87, 56, 22, 12, 6, -45, -78};
        int target = 6;

        int pos = binarySearch(arr, target);

        if(pos!=-1){
            System.out.printf("Element(%d) found at index %d", target, pos);
        }else{
            System.out.printf("Element(%d) not found in the array", target);
        }
    }
}
