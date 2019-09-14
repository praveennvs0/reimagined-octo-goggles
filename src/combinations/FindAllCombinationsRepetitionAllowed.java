package combinations;


import java.util.*;


public class FindAllCombinationsRepetitionAllowed {
  
  
  public static void main(String[] args) {
   int[] ar= {1,2,3};
    printAllCombinations(ar,4) ;
  }
  
  public static void printAllCombinations(int[] ar,int sum){
     List<List<Integer>> list = new ArrayList<>();
    List<Integer> resultList = new ArrayList<Integer>();
    Arrays.sort(ar);
    printAllCombinations(ar,0,list,resultList,sum,0);
    display(list);
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
    
  
  public static void printAllCombinations(int[] ar,int start,List<List<Integer>> list,
		  List<Integer> resultList, int targetSum,int currentSum) {
   if(currentSum > targetSum) {
	   return ;
   }
   else if(currentSum == targetSum) {
	   list.add(new ArrayList<>(resultList));
	   return ;
   }
   else 
    for(int i=start;i<ar.length;i++){
       resultList.add(ar[i]);
       currentSum=currentSum+ar[i];
      printAllCombinations(ar,i,list,resultList,targetSum,currentSum) ;
      currentSum = currentSum-resultList.get(resultList.size()-1);
      resultList.remove(resultList.size()-1) ;
      
    
    }
  }

}


