import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OptimalSubsequence {
private	static Map<Integer, ArrayList<Integer>> indices = new HashMap<Integer,ArrayList<Integer>>();
public static void main(String[] args) {
	int nums[] = {10,9,2,5,3,7,101,18};
	
	
	int maxLen = lengthOfLIS(nums);
	
	System.out.println("maximum length is :" + maxLen);
}

private static int lengthOfLIS(int[] nums) {
	List<Integer> result = new ArrayList<>();
	List<Integer> maxSequence = new ArrayList<>();
	List<Integer> indicesList = new ArrayList<>();
	int maxLen =optimalSubsequence(nums,0,result,0,maxSequence,0,indicesList);
	return maxLen;
}


private static int optimalSubsequence(int[] nums, int index, List<Integer> result, int maxLen, List<Integer> maxSequence,int len,List<Integer> indicesList) {
	//System.out.println("index is : " + index);
	print(result);
	if(result.size() > maxLen) {
		maxLen = result.size();
		List<Integer> indicesCopy = copy(indicesList);
		indices.put(indicesCopy.get(0), (ArrayList<Integer>) indicesCopy);
	//	maxSequence = copy(result);
	}
	
	for(int i=index ; i < nums.length ; i++) {
		
		result.add(nums[i]);
		indicesList.add(i);
		
		if(result.size() >=2 && nums[i] <= result.get(result.size()-2)) {
			result.remove(result.size()-1);
			indicesList.remove(indicesList.size()-1);
			
		}
		else {
		maxLen=optimalSubsequence(nums,i+1,result,maxLen,maxSequence,len+1,indicesList);
		
		result.remove(result.size()-1);
		indicesList.remove(indicesList.size()-1);
		}
	}
	
	return maxLen ;
	
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
