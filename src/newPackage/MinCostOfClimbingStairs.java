package newPackage;

public class MinCostOfClimbingStairs {
	
	public static void main(int[] args) {
		int[] cost =   {10,15,20};
		int minCost = minCostClimbingStairs(cost);
		System.out.println(minCost);
	}

	
	    public static int minCostClimbingStairs(int[] cost) {
	        int[] cache = new int[cost.length+2];
	        int startWithIndexZero = minCostClimbingStairs(cost,0,0,cache);
	        int startWithIndexOne = minCostClimbingStairs(cost,1,0,cache);
	        return Math.min(startWithIndexZero,startWithIndexOne);
	    }
	    
	    public static int minCostClimbingStairs(int[] cost,int currStep,int currCost,int[] cache) {
	        
	        if(cache[currStep] != 0) 
	            return cache[currStep];
	        if(currStep >= cost.length )
	            return currCost;
	        
	        int oneStepCost = minCostClimbingStairs(cost,currStep+1,currCost+cost[currStep],cache);
	        int twoStepCost = minCostClimbingStairs(cost,currStep+2,currCost+cost[currStep],cache) ;
	        
	        int min = Math.min(oneStepCost,twoStepCost);
	        cache[currStep] = min;
	        return min;
	        
	        
	    }
}
