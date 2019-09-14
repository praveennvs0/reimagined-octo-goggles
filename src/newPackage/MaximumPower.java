package newPackage;

import java.util.Arrays;
import java.util.List;

public class MaximumPower
{
public static void main(String args[]) {

	List<Integer> pairs = Arrays.asList(new Integer[]{-2,3,1,-5});
	int min = findMin(pairs) ;
}

private static int findMin(List<Integer> p) {
	// TODO Auto-generated method stub
	int min  = Integer.MAX_VALUE ;
	int currSum = 0,minCurrSum = Integer.MAX_VALUE;
	for(int i=0; i < p.size(); i++) {
		currSum = currSum + p.get(i);
		minCurrSum = Math.min(minCurrSum, currSum) ;
	}
	
	
	return Math.abs(min) + 1 ;
}
}
