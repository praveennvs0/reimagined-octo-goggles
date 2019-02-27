package CreditBank;

public class LeftRotation {

    public static void main(String args[]) {
        int[] ar={1,2,3} ;
        int d= 1 ;
        
        
        rotateArray(ar,d) ;
       
        
        
    }

    private static int[] rotateArray(int[] ar, int d) {
        int size = ar.length ;
        int temp ;
        for(int k=1; k <=d ; k++) {
            System.out.println("Performing rotation : " + k);
            temp = ar[0] ;
        for(int i=0 ; i+1 < ar.length ; i++) {
            ar[i] = ar[i+1] ;
        }
        ar[size-1] = temp ;
        printArray(ar) ;
        
        }
        
        return ar;
    }

    private static void printArray(int[] ar) {
     System.out.println("Printing the array after rotation");
     for(int i=0;i<ar.length ;i++) {
         System.out.print(ar[i]+" : ");
     }
     
     System.out.println("------ ");
     
        
    }
}
