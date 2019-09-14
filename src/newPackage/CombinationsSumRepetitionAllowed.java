package newPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSumRepetitionAllowed {

	public static void main(String args[]) {
		int nums[] = {2,3,5} ;
		int n=10 ,currSum = 0;
		List<Integer> numsList = new ArrayList<Integer>();
		Arrays.sort(nums);
		findCombinations(n,nums,currSum,numsList) ;
		
	}

	private static void findCombinations(int n, int[] nums, int currSum, List<Integer> numsList) {
		// TODO Auto-generated method stub
		if(currSum==n) {
			printList(numsList) ;
			return ;
		}
		
		if(currSum > n) 
			return ;
		
		
		
		for(int i=0;i < nums.length ; i++ ) {
			numsList.add(nums[i]) ;
			currSum = currSum + nums[i] ;
			findCombinations(n,nums,currSum,numsList) ;
			numsList.remove(numsList.size()-1) ;
			currSum = currSum - nums[i];
		}
	}

	private static void printList(List<Integer> numsList) {
		System.out.println("Combination found : " ) ;
		for(Integer x : numsList) {
			System.out.print(x+" : ");
		}
		System.out.println(" ");
		
	}
}
