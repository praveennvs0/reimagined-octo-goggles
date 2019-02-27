
public class MaximumSubArray {

    public static void main(String args[]) {
      //  int array[] = {-2,1,-3,4,-1,2,1,-5,4} ;
        int array[]={-1,0,-2};
        int sum = maximumSubArray(array) ;
        System.out.println("maximum sum is : "+ sum ) ;
    }

    private static int maximumSubArray(int[] array) {
        int start = 0, end = 0, currentSum = 0, maximumSum =  array[0] ;
        int len = array.length ;
        for(int i=0;i<len ; i++) {
            
            currentSum = array[i] ;
            for(int j=i+1 ; j<len ; j++) {
                currentSum = currentSum + array[j] ;
                if(currentSum > maximumSum) {
                    maximumSum = currentSum ; 
                    start = i ; 
                    end = j ;
                }
                
            }
            
            if(array[i] > maximumSum) {
                maximumSum = array[i] ;
                start = i ;
                end = i ;
            }
        }
        
      
      
        System.out.println("maximum sum is " + maximumSum);
        System.out.println("start element index is : "  + start + " value is  : " + array[start]);
        System.out.println("end element is : "  + end+ " value is : " + array[end]);
        
        return maximumSum ;
    }
}
