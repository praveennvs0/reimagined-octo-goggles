import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfAList {

	static int maxAdvantage = 0;
	static int[] maxAdvPerm ;
	
	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(7);
		nums.add(11);
		nums.add(15);
		
	//	int[] b = {1,10,4,11};
		
		List<Integer> b = Arrays.asList(1,10,4,11);
		
		permutations(nums,b);
		
		System.out.println("hello");
	}

	private static void permutations(List<Integer> nums, List<Integer> b) {
		List<Integer> perm = new ArrayList<>();
		permutations(nums,perm,nums.size(),b);
		
	}

	private static void permutations(List<Integer> nums, List<Integer> perm,int size, List<Integer> b) {
		if(perm.size() == size) {
			printList(perm);
			int advantage = getAdvantage(perm,b);
			if(advantage > maxAdvantage) {
				maxAdvantage = advantage;
				maxAdvPerm = createArray(perm);
			}
			return;
		}
		
		for(int i=0; i < nums.size() ; i++) {
			perm.add(nums.get(i));
			
			permutations(removeNumberAndGetList(nums,i),perm,size,b);
			
			perm.remove(perm.size()-1);
			
		}
		
		
		
		
	}
	
	private static int[] createArray(List<Integer> perm) {
		int[] arr = new int[perm.size()];
		for(int i=0;i<perm.size();i++) {
			arr[i] = perm.get(i);
		}
		return arr;
	}

	private static int getAdvantage(List<Integer> perm, List<Integer> b) {
		int adv = 0;
		for(int i=0;i<perm.size();i++) {
			if(perm.get(i) > b.get(i)) {
				adv++;
			}
		}
		
		return adv;
	}

	private static List<Integer> removeNumberAndGetList(List<Integer> nums, int i) {
		List<Integer> list = new ArrayList<>();
		for(int j=0;j<nums.size() ; j++) {
			if(j != i)
				list.add(nums.get(j));
		}
			
		return list;
	}

	private static void printList(List<Integer> perm) {
		System.out.println();
		perm.forEach(x->{System.out.print(x);
						 System.out.print(",");});
		
	}
}
