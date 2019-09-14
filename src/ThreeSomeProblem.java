import java.util.ArrayList;
import java.util.List;

public class ThreeSomeProblem {
public static void main(String args[]) {
	int[] nums = {-1,0,1,2,-1,-4};
	//int[] nums = {-4,-1,-3,2};
	List<Integer> subset = new ArrayList<Integer>() ;
	List<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>() ;
	findSubsets(nums,0,subset,resultList) ;
}

public static void findSubsets(int[] nums,int start, List<Integer> subset, List<ArrayList<Integer>> resultList) {
	
	
	for(int i=start;i<nums.length;i++) {
		subset.add(nums[i]) ;
		System.out.println("subset is : " + subset) ;
		findSubsets(nums,i+1,subset,resultList) ;
		subset.remove(subset.size()-1) ;
		
	}
}
}
