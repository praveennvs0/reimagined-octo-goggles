package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathWithMinimumEffort {
	 private static int minEffort = Integer.MAX_VALUE;
	 
	 public static void main(String[] args) {
		 int[][] heights = {{1,10,6,7,9,10,4,9}};
		 minimumEffortPath(heights);
	 }
	
	 public static int minimumEffortPath(int[][] heights) {
	         DFS(heights);
	         System.out.println("minimum effort is : " + minEffort);
	         return minEffort;
	        
	    }

	private static void DFS(int[][] heights) {
		int rows = heights.length;
        int columns = heights[0].length ;
        boolean[][] recStack = new boolean[rows][columns];
        List<int[]> path = new ArrayList<> ();
        path.add(new int[] {0,0});
        List<Integer> values = new ArrayList<>();
        values.add(heights[0][0]);
		DFSUtil(heights,0,0,path, recStack,values);
		
		
	}

	private static void DFSUtil(int[][] heights, int i, int j,List<int[]> path,boolean[][] recStack,List<Integer> values) {
			
		if(i==heights.length-1 && j == heights[0].length-1) {
			System.out.println("path found");
			int maxAbsDiff = findMaxAbsDiff(values);
			minEffort = Math.min(minEffort, maxAbsDiff);
			
			return;
		}
		
		recStack[i][j] = true;
		List<int[]> adjacencyList = Arrays.asList(new int[]{i-1,j},new int[] {i+1,j},new int[] {i,j+1}, new int[] {i,j-1});
		//List<int[]> adjacencyList = Arrays.asList(new int[] {i+1,j},new int[] {i,j+1});
		for(int[] intArray : adjacencyList) {
			int x = intArray[0];
			int y = intArray[1];
			if(isSafe(heights,x,y) && recStack[x][y] == false) {
				path.add(new int[] {x,y});
				values.add(heights[x][y]);
				DFSUtil(heights,x,y,path,recStack,values);
				path.remove(path.size()-1);
				values.remove(values.size()-1);
			}
		}
		recStack[i][j] = false;
		
		
		
	}

	private static int findMaxAbsDiff(List<Integer> values) {
		int maxAbsDiff = 0,currDiff;
		for(int i=0; i < values.size() - 1 ; i++ ) {
			currDiff = Math.abs(values.get(i+1) - values.get(i)); 
			maxAbsDiff = Math.max(maxAbsDiff, currDiff);
		}
		return maxAbsDiff;
	}

	
	private static boolean isSafe(int[][] heights, int x, int y) {
		int rows = heights.length ;
		int columns = heights[0].length;
		if(x >=0 && x <= rows-1 && y >= 0 && y <= columns-1)
			return true;
		return false;
	}

}
