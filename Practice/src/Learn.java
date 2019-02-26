
public class Learn {

    public static void main(String args[]) {

        int array[] = { -2,-3,4,-1,-2,1,5,-3} ;
        int largestSum = 0, size = array.length ;
        int startIndex = 0,endIndex = 0 ;
        
        Boolean b;

        for (int i = 0; i < size; i++) {
            System.out.println("evaluating for : " + array[i]);
            
            
            for (int j = i+1 ; j < size ; j++) {
                int sum = findSum(array,i,j) ;
                System.out.println("i value is :" + i);
                System.out.println("j value is :" + j);
                
                if(sum > largestSum) {
                    largestSum = sum ;
                     startIndex = i;
                    endIndex = j;
                }
            }


        }
        
        System.out.println("largest sum is : " + largestSum);
        System.out.println("start index is : " + startIndex);
        System.out.println("end index is : " + endIndex);
    }

    private static int findSum(int[] a, int i, int j) {
        int sum = 0 ;
        for(int k=i; k < j ; k++) {
            sum = sum + a[k] ;
        }
        return sum;
    
    }
}
