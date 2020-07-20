import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateNumbers {

	public static void main(String args[]) {
		int nums[] = {1,2,3};
		List<Integer> numsList = new ArrayList<>();
		generateNumbers(nums,numsList);
		
		
	}

	private static void generateNumbers(int[] nums, List<Integer> numsList) {
		if(numsList.size() == nums.length) {
		print(numsList);
		return;
		}
		for(int i=0;i < nums.length ; i++) {
			
		  numsList.add(nums[i]);
		  generateNumbers(nums,numsList);
		  numsList.remove(numsList.size()-1);
		}
		
		
	}

	private static void print(List<Integer> numsList) {
		System.out.println();
		numsList.forEach(x->System.out.print(x));
		
	}

 
}
