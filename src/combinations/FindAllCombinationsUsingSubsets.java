package combinations;


import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class FindAllCombinationsUsingSubsets {
  
  
  public static void main(String[] args) {
   int[] ar= {1,2,3,4,5};
    printAllCombinations(ar,10) ;
  }
  
  public static void printAllCombinations(int[] ar,int sum){
     List<List<Integer>> list = new ArrayList<>();
    List<Integer> resultList = new ArrayList<Integer>();
    printAllCombinations(ar,0,list,resultList,sum);
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
		  List<Integer> resultList, int targetSum) {
      if(sum(resultList)==targetSum) {
	  list.add(new ArrayList<>(resultList)) ;
      }
    for(int i=start;i<ar.length;i++){
       resultList.add(ar[i]);
      printAllCombinations(ar,i+1,list,resultList,targetSum) ;
      resultList.remove(resultList.size()-1) ;
    
    }
  }

private static int sum(List<Integer> resultList) {
	int sum = 0;
	for(Integer i: resultList)
		sum = sum + i;

	return sum;
}
}


