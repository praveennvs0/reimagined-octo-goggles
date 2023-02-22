package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfAList {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		//list.add(4);
		printCombinations(list);
		
	}

	private static void printCombinations(List<Integer> list) {
		List<Integer> result = new ArrayList<>();
		printCombinations(list,0,result );
		
	}

	private static void printCombinations(List<Integer> list, int index, List<Integer> result) {

		printList(result);
		
		for(int i=index ; i < list.size() ; i++) {
			result.add(list.get(i));
			printCombinations(list,i+1,result);
			result.remove(result.size()-1);
			
		}
		
		
	}

	private static void printList(List<Integer> result) {
		result.forEach(x->{System.out.print(x) ;
							System.out.print(",")
							;
		});
		System.out.println();
	}

}
