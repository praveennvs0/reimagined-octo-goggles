package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMaze {

    public static void main(String args[]) {
        int m[][] = new int[4][4] ;
    	m[0][0] = 1 ;
		m[0][1] = 1 ;
		m[0][2] = 1 ;
		m[0][3] = 1  ;
		m[1][1] = 1 ;
		m[1][2] = 1 ;
		m[1][3] = 1 ;
		m[2][3] = 0 ;
		m[3][3] = 1 ;
        
        //1 means you can go..0 means it is a forbidden square...All other elements will be 0 because in Java, array elements are initialized to 0
        
        findIfPathExists(m) ;
        
       // findPath(m,0,0,solution,rows,columns) ;
        
    }

    private static void findIfPathExists(int[][] m) {
    	   int rows = 4,columns = 4 ; ; 
            List<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>() ;
        
    	 boolean isPathPresent = findIfPathExists(m,0,0,solution,rows,columns) ;
    	 if(isPathPresent)
    		 System.out.println("path found") ;
    	 else
    		 System.out.println("path not found") ;
         
	}

	private static boolean findIfPathExists(int[][] m, int i, int j, List<ArrayList<Integer>> solution, int rows,
			int columns) {
    	solution.add(new ArrayList<Integer>(
                Arrays.asList(i,j)));
    	
    	if(i==rows-1 && j == columns-1) {
    		return true ;
    	}
    	if(isSafeSquare(i,j,rows,columns,m)) {
    		if(findIfPathExists(m,i,j+1,solution,rows,columns)) {
    			return true ;
    		}
    		solution.remove(solution.size()-1) ;
    		
    		if(findIfPathExists(m,i+1,j,solution,rows,columns)) {
    			return true ;
    		}
    		solution.remove(solution.size()-1);
    		
    	}
    	
    	return false ;
	}

	private static boolean isSafeSquare(int i, int j, int rows, int columns, int[][] m) {
		return (i>=0 && i < rows  && j >=0 && j < columns && m[i][j]==1) ;
	}

	private static void findPath(int[][] m, int i, int j, List<ArrayList<Integer>> solution,int rows,int columns) {
        solution.add(new ArrayList<Integer>(
                Arrays.asList(i,j)));
        
        if(i>=rows || j >=columns ) // we are overstepping..means no path ..so,go back
            return ;
        
        if(m[i][j] == 0) {
            //obstacle reached..can't go further..go back
            return ;
        }
        if(i==rows-1 && j==columns-1) { //goal reached
            System.out.print("path found  :  ");
            print(solution) ;
            System.out.println("-----");
            return ;
        }
        
        findPath(m,i+1,j,solution,rows,columns) ;
        
        solution.remove(solution.size()-1) ;
        
        findPath(m,i,j+1,solution,rows,columns) ;
        solution.remove(solution.size()-1) ;
        
        
    }

    private static void print(List<ArrayList<Integer>> solution) {
       solution.forEach( ele-> { printVertex(ele) ;
       System.out.print("->") ;
           
       
       }) ;
           
    }

    private static void printVertex(ArrayList<Integer> ele) {
        System.out.print(ele.get(0));
            System.out.print(",") ;
            System.out.print(ele.get(1));
            
        }
        
}


 
