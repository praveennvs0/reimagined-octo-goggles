
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [][]grid = {{1,3,1},{1,5,1},{4,2,1}} ;
      int sum = minPathSum(grid);
      System.out.println("Minimum sum is : " + sum);
      
	}

	    public static int minPathSum(int[][] grid) {
	         int m = grid.length , n = grid[0].length;
			int[][] cache = new int[m][n];
	     int sum = findPaths(grid,0,0,m,n,cache,0);
	        return sum;
	    }
	    
	     private static int findPaths(int[][] grid, int i, int j, int m,int n,int[][] cache,int sum) {
			
	        if(i>m-1 || j > n-1  ) { //outside the boundaries
				return Integer.MAX_VALUE;
			}
			
//	        if(cache[i][j] != 0) {
//	        	return cache[i][j];
//	        }
	         sum = sum + grid[i][j];
	        
			if(i==m-1 && j == n-1) {
				System.out.println("Sum is : " + sum);
				return sum; 
				
			}
			
			int down = findPaths(grid,i+1,j,m,n,cache,sum);
			int right = findPaths(grid,i,j+1,m,n,cache,sum);
			int result = Math.min(right,down);
	        cache[i][j] = result;
			return result ;
			
	}
}
