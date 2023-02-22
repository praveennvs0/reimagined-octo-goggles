package newPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsOfAList {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>(); 
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		
		permutationsOfAList(nums);
		
		
	}

	private static void permutationsOfAList(List<Integer> nums) {
		List<Integer> permutation = new ArrayList<>() ;
		List<List<Integer>> result = new ArrayList<> () ;
		permutationsOfAList(nums,permutation,result) ;	
		System.out.println("hello world");
	}

	private static void permutationsOfAList(List<Integer> nums, List<Integer> permutation,List<List<Integer>> result) {
		if(nums.isEmpty()) {
			List<Integer> copy = permutation.stream()
					  .collect(Collectors.toList());
			result.add(copy) ;
			printList(permutation);
			return;
		}

		for(int i=0; i< nums.size() ; i++) {
			permutation.add(nums.get(i));
			permutationsOfAList(removeNumberAndGetList(nums,i),permutation,result) ;
			permutation.remove(permutation.size()-1);
		}
		
		
	}

	private static List<Integer> removeNumberAndGetList(List<Integer> nums, int i) {
		List<Integer> list = new ArrayList<>();
		for(int j=0;j<nums.size() ; j++) {
			if(j != i)
				list.add(nums.get(j));
		}
			
		return list;
	}

	private static void printList(List<Integer> permutation) {
		permutation.forEach(x-> { System.out.print(x) ;
		});
		System.out.println();
	}
}
