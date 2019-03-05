package newPackage;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsAddingToASum {

    public static void main(String args[]) {
        int a[] = {1,2,3,4,5} ;
        int targetSum = 6 ;
        List<Integer> combination = new ArrayList<Integer>() ;
        
        findAllCombinations(a,targetSum,0,combination) ;
       
    }
    
    private static void findAllCombinations(int[] a, int sum,int start, List<Integer> combination) {
        if(sum<0) {
            return ;
        }
        
        if(sum == 0) {
            display(combination) ;
            return ; 
            
        }
        
        
        for(int i=start;i<a.length ; i++) {
            combination.add(a[i]) ;
            findAllCombinations(a,sum-a[i],i+1,combination) ;
            combination.remove(combination.size()-1) ;
        }
    }

    public static void display(List<Integer> list) {
        System.out.println(" ");
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + ",");
        }
        
    }

   
    
}
