
public class LeetCodeIPO {
	
	public static void main(String[] args) {
		
		int[] Profits= {1,2,3};
		int Capital[]= {1,1,2};
		int k=1, W=0;
		int maxProfit = findMaximizedCapital(k,W,Profits,Capital);
		System.out.println("maximum profit is : " + maxProfit);
	}
	
	
	
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		int profit = 0 ;
		int num = 0;
		// pick the project with the max profit whose capital < W 
		// add project to the picked projects list
		//repeat this k times
		int[] projectsAlreadyPicked = new int[Profits.length] ;
		while (num < k) {
			profit = findProjectWithMaxProfit(Profits,W,Capital,projectsAlreadyPicked);
			W = W + profit;
			num++;
		}
		
		
		return W;
		
	}



	private static int findProjectWithMaxProfit(int[] profits, int W, int[] capital, int[] projectsAlreadyPicked) {
		int profit = 0, maxIndex = 0;
		for(int i=0; i < profits.length; i++) {
			if(projectsAlreadyPicked[i] != 1 && capital[i] <= W) {
				if(profits[i] > profit) {
					profit = profits[i];
					maxIndex = i;
				}
				 
			}
		}
		
		projectsAlreadyPicked[maxIndex] = 1;
		return profit;
	}

}
