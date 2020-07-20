
public class CountNoOfWaysToTraverseAMatrix {

	public static void main(String args[]) {
		int m,n;
		m=5;
		n=5;
		int noOfWays = findNoOfWays(0,0,m,n);
		System.out.println("no. of ways is : " + noOfWays);
	}

	private static int findNoOfWays(int i, int j,int m,int n) {

		int num_ways = 0;
		
		if(i == m-1 && j == n-1)
			return 1;
		
		if(i<0 || i > m-1 || j < 0 || j > n-1)
			return 0;
		
		num_ways = findNoOfWays(i+1,j,m,n) + findNoOfWays(i,j+1,m,n) ;
		
		
		return num_ways;
	}
}
