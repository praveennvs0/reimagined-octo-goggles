package newPackage;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutationsOfGivenLengthRepetitionAllowed {

    public static void main(String args[]) {
        int nums[] = {2,3,4,5};
        int len = 3 ;
        genPerm(nums,len) ;
        
    }

    private static void genPerm(int[] nums, int len) {
        List<Integer> perm = new ArrayList<Integer>() ;
        generatePermutationsHelper(nums,len,perm) ;
        
    }

    private static void generatePermutationsHelper(int[] nums, int len, List<Integer> perm) {
        if(perm.size() == len) {
            print(perm) ;
            return;
        }
        for(int i=0; i < nums.length ; i++) {
            perm.add(nums[i]) ;
            generatePermutationsHelper(nums,len,perm) ;
            perm.remove(perm.size()-1) ;
            
        }
    }

    private static void print(List<Integer> perm) {
        for(int i=0;i< perm.size() ; i++){
            System.out.print(perm.get(i));
        }
        System.out.println(" ");
    }
}
