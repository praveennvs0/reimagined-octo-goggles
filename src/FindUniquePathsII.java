import java.util.ArrayList;

public class FindUniquePathsII {
	private static int count = 0;
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		int m = grid.length , n = grid[0].length;
		
		int x = findPaths(grid,0,0,m,n,new ArrayList<int[]>());
		System.out.println("No. of paths is : " + x);
		
		
		
	}

	private static int findPaths(int[][] grid, int i, int j, int m,int n, ArrayList<int[]> arrayList) {
		if(i>m-1 || j > n-1) { //outside the boundaries
			return 0;
		}
		
		if(grid[i][j] == 1 ) { // obstacle
			return 0;
		}
		
		if(i==m-1 && j == n-1) {
			count++;
			return 1; 
			
		}
		
		int right = findPaths(grid,i+1,j,m,n,arrayList);
		int down = findPaths(grid,i,j+1,m,n,arrayList);
		
		return right + down ;
		
	}

}
