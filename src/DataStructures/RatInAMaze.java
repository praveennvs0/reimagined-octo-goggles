package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMaze {

    public static void main(String args[]) {
        int m[][] = new int[4][4] ;
        m[0][0] = 1 ;
        m[1][0] = 1 ;
        m[1][1] = 1 ;
        m[1][3] = 1 ;
        m[2][0] = 1 ;
        m[2][1] = 1 ;
        m[3][0] = 1 ;
        m[3][1] = 1 ;
        m[3][2] = 1 ;
        m[3][3] = 1 ;
        
        //1 means you can go..0 means it is a forbidden square...All other elements will be 0 because in Java, array elements are initialized to 0
       int rows = 4,columns = 4 ; ; 
       
        
       // int solution[][] = new int[3][3] ;
        List<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>() ;
        
        
        
        findPath(m,0,0,solution,rows,columns) ;
        
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


 
