package newPackage;

import java.util.ArrayList;

public class DiceRolls {
	
	private static int count = 0;
	public static void main(String[] args) {
		int n = 2, k =6, target = 7;
		int count = numRollsToTarget(n,k,target,new ArrayList<Integer>());
		System.out.println("No. of ways to roll the dice is : " + count);
	}
	
	 public static int numRollsToTarget(int n, int k, int target, ArrayList<Integer> result) {
		 int count = 0 ;
		 if(result.size() > n || target < 0) {
			 
			 return 0;
		 }
		 
		 if(result.size() == n && target == 0) {
			 CommonUtils.displayList(result);
			 System.out.println();
			 return 1 ;
		 }
		 
		 for(int i=1;i<=k;i++) {
			 result.add(i);
			 count += numRollsToTarget(n,k,target-i,result);
			 if(result.size() >= 1) {
			 result.remove(result.size()-1);
			 }
		 }
	     
		 return count ;
	    }

}
