package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMazeFourDirections {
	static int rows = 3 ;
	static int columns = 5; 
	
	public static void main(String args[]) {
		
		int m[][]=new int[rows][columns];
		m[0][0]=1;
		m[0][2]=1;
		m[0][3]=1;
		m[0][4]=1;
		m[1][0]=1;
		m[1][1]=1;
		m[1][2]=1;
		m[1][4]=0;
		m[2][4]=1;
		m[2][2]=1 ;
		m[1][3]=1;
		m[2][3]=1;
		
		
	        
	        findPath(m) ;
	        
	        
	       
	        
	}

	private static void findPath(int[][] m) {
		  List<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>() ;
	        int[][] visited = new int[rows+1][columns+1] ;
	        for(int i=0;i<columns+1 ;i++) {
	        	visited[rows][i]=1;
	        }
	        
	        for(int i=0;i<rows+1 ;i++) {
	        	visited[i][columns]=1;
	        }
	        
	      
		boolean PathFound = findPath(m,0,0,solution,rows,columns,visited) ;
		if(PathFound)
			System.out.println("Path found") ;
		else
			System.out.println("No path exists") ;
		
	}

	private static boolean findPath(int[][] m, int i, int j, List<ArrayList<Integer>> solution, int rows,
			int columns, int[][] visited) {
    	solution.add(new ArrayList<Integer>(
                Arrays.asList(i,j)));
    	
    	if(i==rows-1 && j == columns-1) {
    		return true ;
    	}
    	if(isSafeSquare(i,j,rows,columns,m)) {
    		visited[i][j]= 1 ;
    		
    		if(visited[i][j+1]==0) 
    			if(findPath(m,i,j+1,solution,rows,columns, visited)) {
    			return true ;
    		}
    		if(solution.size()>1) {
    		solution.remove(solution.size()-1) ;
    		}
    		
    		if(visited[i+1][j]==0)
    		if(findPath(m,i+1,j,solution,rows,columns, visited)) {
    			return true ;
    		}
    		if(solution.size()>1) {
    		solution.remove(solution.size()-1);
    		}
    		if(i>=1 && visited[i-1][j]==0)
        		if(findPath(m,i-1,j,solution,rows,columns, visited)) {
        			return true ;
        		}
    		if(solution.size()>1) {
        		solution.remove(solution.size()-1);
    		}
        		
        		if(j >=1 && visited[i][j-1]==0)
            		if(findPath(m,i,j-1,solution,rows,columns, visited)) {
            			return true ;
            		}
        		if(solution.size()>1) {
        		solution.remove(solution.size()-1);
        		}
            		visited[i][j]= 2 ;
            		
    	}
    	
    	return false ;
	}
	
	private static boolean isSafeSquare(int i, int j, int rows, int columns, int[][] m) {
		return (i>=0 && i < rows  && j >=0 && j < columns && m[i][j]==1) ;
	}
}
