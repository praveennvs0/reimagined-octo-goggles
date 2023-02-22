package DataStructures;

import java.util.List;

public class CountGoodNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static void printPaths(TreeNode n, List<Integer> path, List<List<Integer>> listOfPaths) {
	        
	        if(n== null){
	            return ;
	        }
	        
	        path.add(n.getKey()) ;
	        
	        
	        if(n.left == null && n.right == null) { // n is leaf node
	            System.out.println("path is : " + path) ;
	            //make a copy of path
                
	            return ;
	            
	        }
	        
	        
	        printPaths(n.left,path,listOfPaths) ;
	        
	        if(n.left != null) {
	        path.remove(new Integer(n.left.val)) ;
	        }
	        
	        printPaths(n.right,path,listOfPaths) ;
	        
	        if(n.right !=null) {
	        path.remove(new Integer(n.right.val)) ;
	        }
	        
	    }
	    

}
