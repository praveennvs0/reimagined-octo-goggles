import java.util.HashMap;
import java.util.Map;

public class StonesRemoved {
	
	public static void main(String[] args) {
		int stones[][] = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		int x = removeStones(stones);
		System.out.println(x);
	}

	private static int removeStones(int[][] stones) {
		
		int max = 0;
		Map<Integer,Integer> stoneRows  = new HashMap<>();
		Map<Integer,Integer> stoneColumns = new HashMap<>() ;
		
		int[][] stoneMatrix = createMatrix(stones);
		
		int m = stoneMatrix.length;
		int n = stoneMatrix[0].length;
		char visited[][] = new char[m][n];
		
		
		
		for(int i=0;i< m; i++) {
			for(int j=0; j < n; j++) {
				if(stoneMatrix[i][j] != 0) {
				
				Integer currRow = stoneRows.get(i) ;
				if(currRow == null)
					stoneRows.put(i,1);
				else
				stoneRows.put(i, currRow+1);
				
				int currColumn = stoneRows.get(j);
				stoneColumns.put(j,currColumn+1);
			}
		}
		}
		
		
		for(int i=0;i < m; i++) {
			for(int j=0; j < n; j++) {
				
				int remove = DFS_Visit(stoneMatrix,i,j,stoneRows,stoneColumns,visited);
				max = Math.max(max, remove);
			}
		}
		return max;
	}

	private static int[][] createMatrix(int[][] stones) {
		int x=0,y=0;
		for(int i=0;i<stones.length;i++) {
			int currX = stones[i][0];
			int currY = stones[i][1];
			x = Math.max(x, currX);
			y = Math.max(y, currY);
		}
		int[][] matrix = new int[x+1][y+1];
		
		for(int i=0; i < stones.length; i++) {
			int posX = stones[i][0];
			int posY = stones[i][1];
			matrix[posX][posY] = 1;
		}
		return matrix;
	}

	private static int DFS_Visit(int[][] matrix, int i, int j,Map<Integer, Integer> stoneRows,
			Map<Integer, Integer> stoneColumns, char[][] visited) {
		
		visited[i][j] = 'R';
		stoneRows.put(i,stoneRows.get(i)-1);
		stoneColumns.put(j, stoneColumns.get(j)-1);
		
		int count = 0;
		if(isWithInLimits(i+1,j,matrix) && matrix[i+1][j] != 0 && visited[i+1][j] != 'R') {
			if(stoneRows.get(i+1) !=0 || stoneColumns.get(j) != 0) {
			count = 1 + DFS_Visit(matrix,i+1,j,stoneRows,stoneColumns,visited);
			}
		}
		
		if(isWithInLimits(i-1,j,matrix) && matrix[i-1][j] != 0 && visited[i-1][j] != 'R') {
			if(stoneRows.get(i-1) !=0 || stoneColumns.get(j) != 0) {
			count = 1 + DFS_Visit(matrix,i-1,j,stoneRows,stoneColumns,visited);
			}
		}
		
		if(isWithInLimits(i,j+1,matrix) && matrix[i][j+1] != 0 && visited[i][j+1] != 'R') {
			if(stoneRows.get(i) !=0 || stoneColumns.get(j+1) != 0) {
			count = 1 + DFS_Visit(matrix,i,j+1,stoneRows,stoneColumns,visited);
		}
		}
		
		if(isWithInLimits(i,j-1,matrix) && matrix[i][j-1] != 0 && visited[i][j-1] != 'R') {
			if(stoneRows.get(i) !=0 || stoneColumns.get(j-1) != 0) {
			count = 1 + DFS_Visit(matrix,i,j-1,stoneRows,stoneColumns,visited);
		}
		}
		
		return count;
	}

	private static boolean isWithInLimits(int i, int j, int[][] stones) {
		int m = stones.length, n = stones[0].length;
		return i >=0 && i < m && j >=0 && j < n ;
	}

}
