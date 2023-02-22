import java.util.ArrayList;
import java.util.List;

import DataStructures.LinkedList;

public class CombinationSum32 {
	
	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 8;
		combinationSum(candidates,target);
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<>();
		combinationSum(candidates,target,0,new ArrayList<>(),combinations);
		return combinations;
		
	}

	private static void combinationSum(int[] candidates, int target,int index, List<Integer> result, List<List<Integer>> combinations) {
		if(target==0) {
			combinations.add(new ArrayList<>(result));
			LinkedList.displayList(result);
			return;
		}
		
		if(target < 0) {
			return ;
		}
		
		
		for(int i=index;i<candidates.length;i++) {
			if(candidates[i] <= target ) {
				result.add(candidates[i]);
				combinationSum(candidates,target-candidates[i],i,result,combinations);
				if(result.size() >=1 ) {
				result.remove(result.size()-1);
				}
			}
			
			
		}
			
	}

}
