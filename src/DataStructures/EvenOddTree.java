package DataStructures;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EvenOddTree {

	public static void main(String[] args) {
		
		TreeNode one = new TreeNode(1);
		TreeNode ten = new TreeNode(10);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);
		TreeNode twelve = new TreeNode(12);
		TreeNode eight = new TreeNode(8);
		TreeNode six = new TreeNode(6);
		
		TreeNode two = new TreeNode(2);
		
		one.left = ten;
		one.right = four ;
		ten.left = three;
		three.left = twelve;
		three.right = eight;
		four.left = seven;
		four.right = nine;
		seven.left = six;
		nine.right = two;
		
		boolean result = isEvenOddTree(one);
		System.out.println(result);
		
		
		
		
	}
	
	  public static boolean isEvenOddTree(TreeNode root) {
	        int level = 0;
	        
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            if (level % 2 == 0) {    // even level
	             Integer lastElement = -1;
	             for(int i=0;i<size;i++) {
	               TreeNode currNode = queue.poll();
	               Integer currVal = currNode.val ;
	               if(currVal % 2 == 0 ) //even nodes at even level - not allowed.
	                   return false;
	                 
	                if(lastElement != -1 && currVal  <= lastElement) {
	                    return false;
	                }
	                 
	                 if (currNode.left != null) {
	                     queue.offer(currNode.left);
	                 }
	                 if (currNode.right != null) {
	                     queue.offer(currNode.right);
	                 }
	                 
	                 lastElement = currVal ;
	            }
	            
	        }
	            else {
	                Integer lastElement = -1;
	                  for(int i=0;i<size;i++) {
	                    TreeNode currNode = queue.poll();
	               Integer currVal = currNode.val ;
	               if(currVal % 2 == 1 ) //odd nodes at odd level - not allowed.
	                   return false;
	                 
	                if(lastElement != -1 && currVal  >= lastElement) {
	                    return false;
	                }
	                 if (currNode.left != null) {
	                     queue.offer(currNode.left);
	                 }
	                 if (currNode.right != null) {
	                     queue.offer(currNode.right);
	                 }
	                 lastElement = currVal ;
	            }
	            }
	            level++;
	        }
	        
	        return true;
	        }
}
