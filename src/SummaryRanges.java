import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {

		int[] nums = {0,2};
		List<String> list = summaryRanges(nums) ;
		System.out.println("hello world");
		// "0->2","4->5","7"
	}

	private static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		int start=0,end=0;
		
		
		while(start <= end && end < nums.length) {
			if(end + 1 < nums.length && nums[end+1] == nums[end]+1) {
				end++;
			}
			else {
				String x = nums[start] + "->" + nums[end];
				if(start==end) {
					x = String.valueOf(nums[start]);
				}
				
				System.out.println("The string is : " + x);
				result.add(x);
				end++;
				start = end;
			}
			
			
		}
		
		
		return result;
	}

}
