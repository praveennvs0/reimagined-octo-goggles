import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javafx.util.Pair;

public class Robot {

	public static void main(String args[]) {
		List<List<Integer>> lot = new ArrayList<List<Integer>>();

		ArrayList<Integer> firstList = new ArrayList<Integer>( 
	            Arrays.asList(1,0,0));

		lot.add(firstList) ;
		ArrayList<Integer> secondList = new ArrayList<Integer>( 
	            Arrays.asList(1,0,0));
		lot.add(secondList) ;
		ArrayList<Integer> thirdList = new ArrayList<Integer>( 
	            Arrays.asList(1,9,1));
		lot.add(thirdList) ;
		int min  = removeObstacle(3,3,lot) ;
		
	}
	
	
	public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
		Map<Pair,Pair> parentMap = new HashMap<Pair,Pair>() ;
        int min=-1;
        int grid[][] = new int[numRows][numColumns] ;
        grid = populateGrid(grid,lot,numRows,numColumns);
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>() ;
        boolean isFound = false ;
        
        List<Integer> start = new ArrayList<Integer>();
        start.add(0);
        start.add(0);
        Pair <Integer, Integer> source =  
                new Pair <Integer, Integer> (0, 0); 

        queue.add(source);
        boolean visited[][] = new boolean[numRows][numColumns] ;
        visited[0][0]=true ;
        Pair<Integer,Integer> child = new Pair <Integer, Integer> (0, 0);  ;
        while(queue!=null) {
        	Pair<Integer,Integer> pos = queue.poll();
        	if(pos == null)
        		break ;
        	int x = pos.getKey();
        	int y=pos.getValue();
        	
        	if(x+1>=0 && x+1 < numRows && y >=0 && y < numColumns && grid[x+1][y] == 1 && visited[x+1][y]==false ) {
        		visited[x+1][y]= true ;
        		
        		Pair <Integer, Integer> adj =  
                        new Pair <Integer, Integer> (x+1, y); 
        		parentMap.put(adj,pos) ;
        		queue.add(adj);
        		if(grid[x+1][y]==9) {
        			isFound = true ;
        			child = adj;
        			break;
        		}
        	}
        	
        	if(x-1>=0 && x-1 < numRows &&  y >=0 && y < numColumns && grid[x-1][y] == 1 && visited[x-1][y]==false ) {
        		visited[x-1][y]= true ;

        		Pair <Integer, Integer> adj =  
                        new Pair <Integer, Integer> (x-1, y);
        		parentMap.put(adj,pos) ;
        		queue.add(adj);
        		if(grid[x+1][y]==9) {
        			isFound = true ;
        			child = adj;
        			break;
        		}
        	}
        	
        	if(x>=0 && x < numRows && y+1 >=0 && y+1 < numColumns &&  grid[x][y+1] == 1 && visited[x][y+1]==false ) {
        		visited[x][y+1]= true ;

        		Pair <Integer, Integer> adj =  
                        new Pair <Integer, Integer> (x, y+1);
        		parentMap.put(adj,pos) ;
        		queue.add(adj);
        		if(grid[x+1][y]==9) {
        			isFound = true ;
        			child = adj;
        			break;
        		}
        	}
        	
        	if(x>=0 && x < numRows &&  y-1 >=0 && y-1 < numColumns && grid[x][y-1] == 1 && visited[x][y-1]==false ) {
        		visited[x][y-1]= true ;

        		Pair <Integer, Integer> adj =  
                        new Pair <Integer, Integer> (x, y-1);
        		parentMap.put(adj,pos) ;
        		queue.add(adj);
        		if(grid[x+1][y]==9) {
        			isFound = true ;
        			child = adj;
        			break;
        		}
        	}
        	
        	
        	
        	
        }
        
        Pair<Integer,Integer> pair = child ;
        int count = 0;
        while(pair!=null) { 
        	
        	pair = parentMap.get(pair);
        	count++;
        }
        
        if(!isFound)
        	return -1;
        return count ;
    }


	private static int[][] populateGrid(int[][] grid, List<List<Integer>> lot, int numRows, int numColumns) {
		
		for(int i=0;i<lot.size();i++) {
			List<Integer> list = lot.get(i);
			for(int j=0;j<numColumns;j++) {
				grid[i][j]=list.get(j);
			}
		}
		return grid;
	}
}
