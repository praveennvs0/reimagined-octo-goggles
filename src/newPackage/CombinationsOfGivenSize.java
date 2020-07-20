package newPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationsOfGivenSize {
	
	public static void main(String[] args) {
		List<Integer> combination = new ArrayList<>();
		int n = 4 , k = 2 ;
	//	printCombinations(n,1,combination,k);
		
		List<String> list = new ArrayList<> () ;
		list.add("Apple");
		list.add("Mango");
		list.add("Water melon");
		List<String> copy = list.stream()
				  .collect(Collectors.toList());
		
		list.add("Grapes");
		System.out.println("hello world");
	}



	private static void printCombinations(int n,int startIndex,List<Integer> combination, int k) {
		if(combination.size() == k) 
		print(combination);

		if(combination.size() > k) 
			return ;
		
		for(int i=startIndex;i <= n ; i++) {
			combination.add(i);
			printCombinations(n,i+1,combination,k);
			combination.remove(combination.size()-1);
		}
		
	}
	
	private static void print(List<Integer> combination) {
		System.out.print("Combination is : ") ;
		combination.forEach(x->  { System.out.print(x) ; System.out.print(","); });
		System.out.println();
		
		
	}

}
