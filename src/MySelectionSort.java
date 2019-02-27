public class MySelectionSort {
 
    public static int[] doSelectionSort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            System.out.print("array after pass " + i + "  is " );
            printArray(arr) ;
            
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) 
                    index = j;
      
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
     
    private static void printArray(int[] arr) {

        for(int i=0 ; i < arr.length ;i++) {
            System.out.print(arr[i] + " ,");
        }
    }

    public static void main(String a[]){
         
        int[] arr1 = {5,1,12,-5,16,2,14};
        int[] arr2 = doSelectionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println(" printing over");
    }
}