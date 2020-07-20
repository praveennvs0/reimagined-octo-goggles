import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
public static void main(String[] args) {
	int nums[] = {10,9,2,5,3,7,101,18};
	
	
	int maxLen = lengthOfLIS(nums);
	
	System.out.println("maximum length is :" + maxLen);
}

private static int lengthOfLIS(int[] nums) {
	List<Integer> result = new ArrayList<>();
	List<Integer> maxSequence = new ArrayList<>();
	maxSequence=optimalSubsequence(nums,0,result,0,maxSequence);
	return maxSequence.size();
}

private static List<Integer> subsequence(int[] nums, int index, List<Integer> result, int maxLen, List<Integer> maxSequence) {
	
	//print(result);
	if(result.size() > maxSequence.size()) {
		maxLen = result.size();
		maxSequence = copy(result);
	}
	
	for(int i=index ; i < nums.length ; i++) {
		
		result.add(nums[i]);
		if(result.size() >=2 && nums[i] <= result.get(result.size()-2)) {
			result.remove(result.size()-1);
		}
		else {
		maxSequence=subsequence(nums,i+1,result,maxLen,maxSequence);
		result.remove(result.size()-1);
		}
	}
	
	return maxSequence ;
	
}

private static List<Integer> optimalSubsequence(int[] nums, int index, List<Integer> result, int maxLen, List<Integer> maxSequence) {
	System.out.println("index is : " + index);
	print(result);
	System.out.println("----");
	if(result.size() > maxSequence.size()) {
		maxLen = result.size();
		maxSequence = copy(result);
	}
	
	for(int i=index ; i < nums.length ; i++) {
		
		result.add(nums[i]);
		if(result.size() >=2 && nums[i] <= result.get(result.size()-2)) {
			result.remove(result.size()-1);
		}
		else {
		maxSequence=optimalSubsequence(nums,i+1,result,maxLen,maxSequence);
		result.remove(result.size()-1);
		}
	}
	
	return maxSequence ;
	
}


private static List<Integer> copy(List<Integer> result) {
	List<Integer> copyList = result.stream().collect(Collectors.toList());
	return copyList;
}

private static void print(List<Integer> result) {
	result.forEach(x->{System.out.print(x);
	System.out.print(",");
	});
	System.out.println("");
	
}
}
