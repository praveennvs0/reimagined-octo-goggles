
public class MaxArea {
	
	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		int area = maxAreaOfIsland(grid);
		System.out.println("Max area is : " + area);
	}

	    public static int maxAreaOfIsland(int[][] grid) {
	        boolean visited[][] = new boolean[grid.length][grid[0].length];
	        int max=0,count=0;
	         for(int i=0;i< grid.length;i++) {
	             for(int j=0;j<grid[0].length;j++) {
	            	 
	                 if(!visited[i][j] && grid[i][j] == 1) {
	                	 visited[i][j] = true;
	                int currArea = 0;
	                count++;
	                currArea = 1 + DFS_Visit(i,j,grid,visited);
	                     System.out.println("current area is : " + currArea);
	                 max = Math.max(currArea,max);
	                 }
	             }
	             
	         }
	         System.out.println("no. of islands is : " + count);
	        return max;
	    }
	    
	    private static int DFS_Visit(int i,int j,int[][] grid,boolean[][] visited) {
	        int area = 0,left=0,right=0,top=0,bottom=0 ;
	        
	        if(isWithInBoundaries(i+1,j,visited,grid)) {
	        visited[i+1][j] = true;            
	        bottom = 1 + DFS_Visit(i+1,j,grid,visited) ;
	        }
	        if(isWithInBoundaries(i,j+1,visited,grid)) {
	        visited[i][j+1] = true;
	        right = 1 + DFS_Visit(i,j+1,grid,visited) ;
	        }
	        if(isWithInBoundaries(i-1,j,visited,grid)) {
	        visited[i-1][j] = true;
	        top = 1 + DFS_Visit(i-1,j,grid,visited) ;
	        }
	        if(isWithInBoundaries(i,j-1,visited,grid)) {
	        visited[i][j-1] = true;
	        left =  1 + DFS_Visit(i,j-1,grid,visited) ;
	        }
	        area = top + bottom + left + right ;
	        return area;
	    }
	           
	           
	    private static boolean isWithInBoundaries(int i,int j,boolean[][] visited,int[][] grid){
	    return i>=0 && i<grid.length && j>=0 && j < grid[0].length && !visited[i][j] && grid[i][j] == 1;
	    }
}
