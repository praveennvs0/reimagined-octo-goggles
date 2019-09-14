package DataStructures;
//package DataStructures;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CombinatorialSumRepeat {
//
//    public static void main(String args[]) {
//        int[] nums={1,2,3} ;
//        int target = 5 ;
//        List<Integer> solution = new ArrayList<Integer>() ;
//        printCombinations(nums,target,solution) ;
//        
//    }
//
//    private static void printCombinations(int[] nums, int target, List<Integer> solution) {
//        if(target==0){
//            System.out.println("solution foundd");
//            solution.forEach(action);
//        }
//        
//       for(int i=0 ; i<nums.length ;i++) {
//           if(target >= nums[i]) {
//           solution.add(nums[i]) ;
//           printCombinations(nums,target-nums[i],solution) ;
//           solution.remove(solution.size()-1);
//           
//           }
//       }
//        
//    }
//    
//}
