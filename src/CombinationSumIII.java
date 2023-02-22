import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSumIII {

	public static void main(String[] args) {
		
		List<List<Integer>> list = combinationSum3(2,18);
		System.out.println("list");
	}

    public static List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> currList = new ArrayList<>();
    	if(k > n)
    		return result;
    	combinationSum(k,n,result,currList,n,1);
        return result;
    }

	private static void combinationSum(int k, int n, List<List<Integer>> result, List<Integer> currList,Integer currSum,int start) {
		
		if(currSum == 0 && currList.size() == k) {
			System.out.println("combination found");
			List<Integer> copy = currList.stream()
					  .collect(Collectors.toList());
			result.add(copy);
			return;
		}
		
		if(currSum < 0 || currList.size() > k) {
			return;
		}
		
		
		
		for(int i=start;i<=9;i++) {
			currList.add(i);
			combinationSum(k,n,result,currList,currSum-i,i+1);
			currList.remove(currList.size()-1);
		}
			
		
	}
}
