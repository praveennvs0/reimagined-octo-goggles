import java.util.ArrayList;
import java.util.Arrays;

public class CombinationalSum {
    public static void main(String args[]) {
        
        int []nums = {2,3,6,7} ;
        int target =7 ;
         
        combinationSum(nums,target) ;
    }

public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
    if(candidates == null || candidates.length == 0) return result;
 
    ArrayList<Integer> current = new ArrayList<Integer>();
    Arrays.sort(candidates);
 
    combinationSum(candidates, target, 0, current, result);
 
    return result;
}
 
public static void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
   if(target == 0){
       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
       result.add(temp);
       print(temp) ;
       return;
   }
 
   for(int i=j; i<candidates.length; i++){
       if(target < candidates[i]) 
            return;
 
       curr.add(candidates[i]);
       combinationSum(candidates, target - candidates[i], i, curr, result);
       curr.remove(curr.size()-1); 
   }
   
}

private static void print(ArrayList<Integer> temp) {
    for(int i=0 ; i < temp.size() ; i++) {
        System.out.println(temp.get(i)+":");
    }
    System.out.println("");
    
}
}