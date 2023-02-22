import java.util.ArrayList;
import java.util.List;

public class FindAllCombinations {

	public static void main(String[] args) {
		int n = 5 ;
		List<Integer> numsList = new ArrayList<>();
		int currSum = 0;
		findAllCombinations(n,1,numsList,currSum);
	}

	private static void findAllCombinations(int n, int start, List<Integer> numsList, int currSum) {
		if(currSum == n) {
			display(numsList);
		}
		if(currSum > n)
			return ;
		
		for(int i=start; i <= n ; i++) {
			numsList.add(i);
			currSum = currSum + i;
			findAllCombinations(n,i,numsList,currSum);
			
			numsList.remove(numsList.size()-1);
			currSum = currSum - i;
			
		}
		
	}

	private static void display(List<Integer> numsList) {
		System.out.println();
		for(Integer x : numsList) {
			System.out.print(x);
			System.out.print(",");
		}
		
	}
}
