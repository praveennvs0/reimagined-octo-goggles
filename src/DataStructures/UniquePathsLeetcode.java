package DataStructures;

public class UniquePathsLeetcode {

	public static void main(String[] args) {
		int m = 3, n =7;
		int x = uniquePaths(m,n);
		System.out.println("no. of unique paths is : " + x);
		
	}
	
	 public static int uniquePaths(int m, int n) {
			int[][] cache = new int[m][n];
	        int count = findPaths(0,0,m,n,cache);
	        return count;
	    }
	    
	    
	    
	    private static int findPaths(int i, int j, int m,int n,int[][] cache) {
			
	        if(i>m-1 || j > n-1 ) { //outside the boundaries
				return 0;
			}
			
			if(cache[i][j] != 0) {
	            return cache[i][j];
	        }
	        
			if(i==m-1 && j == n-1) {			
				return 1; 
				
			}
			
			int right = findPaths(i+1,j,m,n,cache);
			int down = findPaths(i,j+1,m,n,cache);
			int result = right+ down;
	        cache[i][j] = result;
			return result ;
			
		}
}
