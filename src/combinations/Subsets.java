package combinations;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Subsets {
  
  
  public static void main(String[] args) {
   int[] ar= {1,2,3,4,5};
    printAllCombinations(ar) ;
  }
  
  public static void printAllCombinations(int[] ar){
     List<List<Integer>> list = new ArrayList<>();
    List<Integer> resultList = new ArrayList<Integer>();
    printAllCombinations(ar,0,list,resultList);
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
    
  
  public static void printAllCombinations(int[] ar,int start,List<List<Integer>> list,List<Integer> resultList) {
    list.add(new ArrayList<>(resultList)) ;
    for(int i=start;i<ar.length;i++){
       resultList.add(ar[i]);
      printAllCombinations(ar,i+1,list,resultList) ;
      resultList.remove(resultList.size()-1) ;
    
    }
  }
}


