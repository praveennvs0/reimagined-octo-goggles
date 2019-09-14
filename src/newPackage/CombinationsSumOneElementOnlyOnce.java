package newPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSumOneElementOnlyOnce {

	static int count = 0 , combCount = 0;
	public static void main(String args[]) {
		int nums[] = {2,3,5,6,8} ;
		int n=10 ,currSum = 0;
		List<Integer> numsList = new ArrayList<Integer>();
		int maxNum = 0;
		Arrays.sort(nums);
		
		findCombinations(n,nums,currSum,numsList,0) ;
		
		System.out.println("no.of times called is : " + count ) ;
		System.out.println("no. of combinations is : "+ combCount);
	}

	private static void findCombinations(int n, int[] nums, int currSum, List<Integer> numsList,int startIndex) {
		// TODO Auto-generated method stub
		if(currSum==n) {
			printList(numsList) ;
			combCount++;
			return ;
		}
		
		if(currSum > n) 
			return ;
		
		
		
		for(int i=startIndex;i < nums.length ; i++ ) {
			numsList.add(nums[i]) ;
			currSum = currSum + nums[i] ;
			count++ ;
			findCombinations(n,nums,currSum,numsList,i+1) ;
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
