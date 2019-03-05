package newPackage;

import java.util.Arrays;

public class MinimumSwaps {

    public  static void main(String args[]) {
        int[] a= {4,2,1,3} ;
        
        System.out.println("Array before sorting : " );
        display(a) ;
        int num = findMinimumSwaps(a) ;
        System.out.println("Minimum no. of swaps is : " + num);
        System.out.println("Displaying contents of the array after swapping " );
        display(a) ;
    }

    private static void selectionSort(int[] b) {
        int index;
        for(int i= 0 ; i < b.length ; i++) {
            index = i ;
            for(int j=i+1; j < b.length ; j++) {
                if(b[j] < b[index]) 
                    index = j ;
            }
            
            int temp = b[i] ;
            b[i] = b[index] ;
            b[index] = temp ;
        }
        
        
    }
    
    private static void display(int[] b) {
        System.out.println("Displaying the contents of the array : " );
        for(int i=0; i < b.length ; i++) {
            System.out.print(b[i] + " : ");
        }
        
        System.out.println("-----");
    }

    private static int findMinimumSwaps(int[] a) {
        int minSwaps=0;
        
        int[] b = Arrays.copyOf(a, a.length) ;
        selectionSort(b);
      
        int indexOfRightElement ;
        for(int i=0; i < a.length ; i++) {
            if(a[i] == b[i])
                continue ;
            
            indexOfRightElement = evaluateIndexOfRightElement(a,i,b[i]) ;
            //swap a[i] with index of the right element
            
            int temp = a[i] ;
            a[i] = a[indexOfRightElement];
            a[indexOfRightElement] = temp ;
            
            minSwaps++;
            System.out.println("Swap no : " + minSwaps + " swapping elements at indices : "+ i + "  and  " + indexOfRightElement ) ;
          //  display(a) ;
        }
        
        return minSwaps;
    }

    private static int evaluateIndexOfRightElement(int[] a,int startingIndex, int elementToBeSearched) {
        int i;
        for(i=startingIndex; i < a.length ; i++) {
            if(a[i] == elementToBeSearched) 
                break ;
        }
        
        return i;
    }
}
