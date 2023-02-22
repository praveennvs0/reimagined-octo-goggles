package newPackage;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfAList {
	
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		List<Integer> combination = new ArrayList<>();
		printCombinations(nums,0,combination);
		
	}

	private static void printCombinations(int[] nums,int startIndex,List<Integer> combination) {
		if(combination.size() > 0) {
		print(combination);
		}
		for(int i=startIndex;i < nums.length ; i++) {
			combination.add(nums[i]);
			printCombinations(nums,i+1,combination);
			combination.remove(combination.size()-1);
		}
		
	}

	

	private static void print(List<Integer> combination) {
		System.out.print("Combination is : ") ;
		combination.forEach(x->  { System.out.print(x) ; System.out.print(","); });
		System.out.println();
		
		
	}

}
