package newPackage;

public class KnapsackProblem {
public static void main(String args[]) {
	
	
	int weights[]= {10,20,30};
	int values[]= {60,100,120};
	int W=50;
	int max = knapsack(W,weights,values) ;
	System.out.println("max is : " + max);
}

private static int knapsack(int w, int[] weights, int[] values) {
	
	int x = knapsack(w,weights,values,0) ;
	return x ;
}

private static int knapsack(int w, int[] weights, int[] values, int i) {
	if(i==weights.length)
	return 0;
	if(weights[i] > w) 
		return knapsack(w,weights,values,i+1) ;
	
	return 0;
}
}
