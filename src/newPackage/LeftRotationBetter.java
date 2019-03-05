package newPackage;

public class LeftRotationBetter {

    public static void main(String args[]) {
        int[] ar={0,1,2,3,4} ;
        int d= 3 ;
        d = d % ar.length ;
        
        rotateArray(ar,d) ;
       
        
        
    }

    private static int[] rotateArray(int[] ar, int d) {
        
        int size = ar.length ;
        int b[] = new int[size] ;

        int k=0;
        for(int i=d; i<size; i++,k++) {
            b[k] = ar[i] ;
            
        }
        
        for(int i=0;i<d;i++) {
            b[k] = ar[i] ;
            k++ ;
        }
        
        printArray(b) ;
        
        
        return b;
    }

    private static void printArray(int[] ar) {
     System.out.println("Printing the array after rotation");
     for(int i=0;i<ar.length ;i++) {
         System.out.print(ar[i]+" : ");
     }
     
     System.out.println("------ ");
     
        
    }
}
