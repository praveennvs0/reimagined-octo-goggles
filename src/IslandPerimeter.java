
public class IslandPerimeter {
	private static int perimeter = 0,m,n;
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		int x = islandPerimeter(grid);
		System.out.println("Perimeter is : " + x);
		
	}
	
	 public static int islandPerimeter(int[][] grid) {
	        m=grid.length;
	        n=grid[0].length;
	        int[][] visited = new int[m][n];
	        for(int i=0;i<m;i++) 
	            for(int j=0;j<n;j++) {
	                if(visited[i][j]==0) {
	                DFS_Visit(grid,visited,i,j);
	                }
	            }
	        return perimeter;
	    }
	    
	    
	    private static void DFS_Visit(int[][] grid,int[][] visited,int i,int j) {
	    	
	        if((visited[i][j] == 1 || grid[i][j] == 0)) 
	            return;
	        
	        visited[i][j] = 1;
	        
	        
	        if(i+1 >=0 && i+1 < m && grid[i+1][j] == 0) {
	        	perimeter++;
	        }
	        if(i-1 >=0 && i-1 < m && grid[i-1][j] == 0) {
	        	perimeter++;
	        }
	        if(j-1 >=0 && j-1 < n && grid[i][j-1] == 0) {
	        	perimeter++;
	        }
	        if(j+1 >=0 && j+1 < n && grid[i][j+1] == 0) {
	        	perimeter++;
	        }
	        
	        if(i+1 >=0 && i+1 < m && j >= 0 && j < n) {
	        DFS_Visit(grid,visited,i+1,j);
	        }
	        if(i>=0 && i < m && j-1 >=0 && j-1 < n ) {
	        DFS_Visit(grid,visited,i,j-1);
	        }
	        if(i-1 >=0 && i-1 < m && j >=0 && j < n) {
	        DFS_Visit(grid,visited,i-1,j);
	        }
	        if(i>=0 && i < m && j+1 >=0 && j+1 < n) {
	        DFS_Visit(grid,visited,i,j+1);
	        }
	        
	        if(i == 0) {
	        	perimeter++;
	        }
	        if(i == m-1) {
	        	perimeter++;
	        }
	        
	        if(j==0) {
	        	perimeter++;
	        }
	        
	        if(j == n-1) {
	        	perimeter++;
	        }
	        
	    }

}
