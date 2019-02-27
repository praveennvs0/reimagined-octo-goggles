import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsecutiveNumbers {



    public static void main(String args[]) {
        int num = 30;
      
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>> ();
        
        int number = 0 ;
        for(int i= 1 ; i <= num/2 + 1 ; i++){
            ArrayList<Integer> result = new ArrayList<Integer>() ;
            
            findConsecutiveCombinations(num,result,0,resultList,i,false);
        }
            
        
        
         number = resultList.size() ;
        number = number + 1; 
        System.out.println("No. of ways : " + number);
        
        for(int i= 0 ; i < resultList.size() ; i++)
            print(resultList.get(i)) ;
        
    }
    
    
    public int consecutiveNumbersSum(int num) {
     ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>> ();
     int number = 0 ;
     
     for(int i= 1 ; i < num ; i++){
         ArrayList<Integer> result = new ArrayList<Integer>() ;
     findConsecutiveCombinations(num,result,0,resultList,i,false);
    
     }
     //because each number can be written as the sum of itself.that one
     //too needs to be taken into account as per the question
     number = resultList.size() ;
     number = number + 1; 
     System.out.println("No. of ways : " + number);
     return number ;
 }
    
    public static void findConsecutiveCombinations(int num,ArrayList<Integer> result,int currentSum,ArrayList<ArrayList<Integer>> resultList,int index,boolean isReached) {
        if(currentSum==num){
            resultList.add(result) ;
            return ;
            
        }
        
      if(currentSum > num) { 
          return ;
      }
      
      if(index == num && !result.isEmpty() && result.get(0)==num-1) { // reached the end of the search
          isReached  = true ;
      }
        
        if(index < num && !isReached) {
            
            result.add(index) ;
            currentSum = currentSum + index ;
            
            findConsecutiveCombinations(num,result,currentSum,resultList,index+1,isReached) ;
            }
           
    }

    private static void print(List<Integer> result) {
        for(Integer i : result) {
            System.out.print(i+"  :  ");
        }
        System.out.println("printed");
        
    }
}
