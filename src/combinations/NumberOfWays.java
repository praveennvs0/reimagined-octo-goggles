package combinations;


import java.util.*;


public class NumberOfWays {
  
  
  public static void main(String[] args) {
   int[] ar= {1,2,3};
    int x = printAllCombinations(ar,4) ;
    System.out.println("No. of ways : " + x) ;
  }
  
  public static int printAllCombinations(int[] ar,int sum){
     List<List<Integer>> list = new ArrayList<>();
    List<Integer> resultList = new ArrayList<Integer>();
    Arrays.sort(ar);
    int x = printAllCombinations(ar,0,list,resultList,sum,0,Integer.MAX_VALUE);
    display(list);
    return x ;
}
  
  public static void display(List<List<Integer>> list){
  for(int i=0;i<list.size();i++){
    System.out.println(" ");
    displayList(list.get(i));
  
  }
  }
    
    public static void displayList(List<Integer> list){
      for(Integer i: list) {
        System.out.print(i);
        System.out.print(":");
    }
    }
    
  
  public static int printAllCombinations(int[] ar,int start,List<List<Integer>> list,
		  List<Integer> resultList, int targetSum,int currentSum,int minNumberOfWays) {
   if(currentSum > targetSum) {
	   return 0;
   }
   else if(currentSum == targetSum) {
	   list.add(new ArrayList<>(resultList));
	   if(resultList.size() < minNumberOfWays)
		   minNumberOfWays = resultList.size();
	   return minNumberOfWays;
   }
   else 
    for(int i=start;i<ar.length;i++){
       resultList.add(ar[i]);
       currentSum=currentSum+ar[i];
      int min= printAllCombinations(ar,i,list,resultList,targetSum,currentSum,minNumberOfWays) ;
      
      currentSum = currentSum-resultList.get(resultList.size()-1);
      resultList.remove(resultList.size()-1) ;
      
    
    }

   return minNumberOfWays;
  }
  

}


