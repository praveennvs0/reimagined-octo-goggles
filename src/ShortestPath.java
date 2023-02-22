import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPath {

	public static void main(String[] args) {
		int[][] grid = {{0,1},{1,0}};
		int dist = shortestPathBinaryMatrix(grid);
		System.out.println("The shortest distance is : " + dist);
	}
	
	 public static int shortestPathBinaryMatrix(int[][] grid) {
		 int n = grid.length;
		 boolean[][] visited = new boolean[n][n];
	     Queue<int[]> queue = new LinkedList<>();
	     int[] source = new int[] {0,0,1} ;
	     queue.add(source) ;
	     while(!queue.isEmpty()) {
	    	 
	    	 int[] position = queue.remove();
	    	 int x = position[0], y = position[1];
	    	 visited[x][y] = true;
	    	 int currDist = position[2];
	    	 if(position[0] == n-1 && position[1] == n-1) {
	    		 return currDist;
	    	 }
	    	 
	    	 int[][] neighbours = {{x-1,y},{x,y-1},{x+1,y},{x,y+1},{x-1,y-1},{x+1,y-1},{x-1,y+1},{x+1,y+1}};
	    	 
	    	 for(int i=0; i < neighbours.length ; i++) {
	    	 int neighbourX = neighbours[i][0];
	    	 int neighbourY = neighbours[i][1];
	    	 if(isValid(neighbourX,neighbourY,n,grid,visited)) {
	    		 queue.add(new int[] {neighbourX,neighbourY,currDist+1});
	    	 }
	    	 }
	    	
	    	 
	     }
	     
	     return -1;
	    }

	private static boolean isValid(int x, int y, int n, int[][] grid, boolean[][] visited) {
		return x >= 0 && x < n && y >=0 && y < n && grid[x][y] == 0 && !visited[x][y] ;
		
	}
}
