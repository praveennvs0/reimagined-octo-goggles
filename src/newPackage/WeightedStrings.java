package newPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedStrings {

	public static void main(String args[]) {
		int weight = 25 ;
		String x = smallestString(weight) ;
		
		
		
	}

	public static String smallestString(long weight) {
		char[] charArray = buildCharArray();
		int nums[] = computeWeights(charArray) ;
		Map<Integer,Character> weightCharMap = new HashMap<Integer,Character>();
		for(int i=0;i<nums.length;i++) {
			weightCharMap.put(nums[i], charArray[i]) ;
		}
		
		List<Integer> numsList = new ArrayList<Integer>();
		List<List<Integer>> output = new ArrayList<>();
		int currSum=0;
		findCombinations(weight,nums,currSum,numsList,output) ;
		List<Integer> smallestList = findSmallest(output) ;
		String x = buildString(weightCharMap,smallestList) ;
		
		return x;
	}

	private static String buildString(Map<Integer, Character> weightCharMap, List<Integer> smallestList) {
		String s= "";
		for(Integer x : smallestList) {
			char ch = weightCharMap.get(x);
			s=s+ch ;
		}
		
		return s;
	}

	private static char[] buildCharArray() {
		char[] charArray = new char[26];
		int i=0;
		for(char ch='A';ch<='Z';ch++) {
		charArray[i] = ch;
		i++ ;
		}
		return charArray ;
	}

	private static List<Integer> findSmallest(List<List<Integer>> output) {
		int minSize = Integer.MAX_VALUE ;
		List<Integer> smallestList = new ArrayList<Integer>();
		for(int i=0;i<output.size();i++) {
			List<Integer> temp = output.get(i);
			if(temp.size() < minSize) {
				minSize = temp.size();
				smallestList = temp ;
			}
				
		}
		return smallestList;
	}

	private static int[] computeWeights(char[] charArray) {
		int weights[] = new int[26];
		weights[0]=1;
		int j=2;
		for(int i=1;i<weights.length;i++) {
			weights[i] = (j*weights[i-1]) + weights[i-1]; 
			j++;
		}
		
		
		return weights;
	}

	private static void findCombinations(long weight, int[] nums, int currSum, List<Integer> numsList,List<List<Integer>> output) {
		// TODO Auto-generated method stub
		if(currSum==weight) {
			printList(numsList) ;
			output.add(createCopyOfList(numsList)) ;
			return ;
		}
		
		if(currSum > weight) 
			return ;
		
		
		
		for(int i=0;i < nums.length ; i++ ) {
			numsList.add(nums[i]) ;
			currSum = currSum + nums[i] ;
			findCombinations(weight,nums,currSum,numsList,output) ;
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
	
	private static List<Integer> createCopyOfList(List<Integer> originalList) {
		List<Integer> newList = new ArrayList<Integer>();
		for(Integer x: originalList) {
			newList.add(x.intValue()) ;
		}
		return newList;
	}

}
