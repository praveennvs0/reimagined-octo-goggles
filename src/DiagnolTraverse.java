import java.util.ArrayList;
import java.util.List;

public class DiagnolTraverse {

	private static int m,n;
	public static void main(String[] args) {
		int mat[][] = {{2,5},{8,4},{0,-1 }};
		List<Integer> resultList = findDiagonalOrder(mat);
		  int[] arr
          = resultList.stream().mapToInt(i->i).toArray();
		System.out.println();
	}
	
	 public static List<Integer> findDiagonalOrder(int[][] mat) {
		 List<Integer> resultList = new ArrayList<>();
	        m=mat.length; n=mat[0].length;
	        
	        int leftX=0,leftY=0,rightX=0,rightY=0;
	        boolean straight = true;
	        while(leftX != m && leftY != n && rightX != m && rightY != n) {
	            
	        	printDiagonal(mat,leftX,leftY,rightX,rightY,resultList,straight);
	        	straight = !straight;
	            leftX += 1;
	            rightY += 1;
	        }
	        
	        leftX = m-1;
	        leftY =1;
	        rightX=1;
	        rightY=n-1;
	        
	        while(leftX != m && leftY != n && rightX != m && rightY != n) {
	        	printDiagonal(mat,leftX,leftY,rightX,rightY,resultList,straight);
	        	straight = !straight;
	            leftY += 1;
	            rightX += 1;
	        }
	        
	        System.out.println();
	        return resultList;
	    }


	private static void printDiagonal(int[][] mat, int leftX,int leftY,int rightX, int rightY, List<Integer> resultList,boolean straight) {
		if(straight) {
		while(leftX >=0 && leftX <m && leftY < n && leftY >=0) {
			resultList.add(mat[leftX][leftY]);
			leftX--;
			leftY++;
			
		}
		}
		else {
		
			while(rightX >=0 && rightX <m && rightY < n && rightY >=0) {
				resultList.add(mat[rightX][rightY]);
				rightX++;
				rightY--;
				
			}
		}
		
	}
	    
}
