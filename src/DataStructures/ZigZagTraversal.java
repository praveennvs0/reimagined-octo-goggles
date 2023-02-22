package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue; 

public class ZigZagTraversal {

	public static void main(String[] args) {
		TreeNode three = new TreeNode(3);
		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		
		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);
		
		three.left = nine;
		three.right = twenty;
		
		twenty.left = fifteen;
		twenty.right = seven;
		
		zigzagLevelOrder(three);
				
		
	}
	    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(root == null)
	            return result;
	        Queue<TreeNode> q = new LinkedList<>() ;
	        q.add(root);
	        int i=0;
	        
	        while(!q.isEmpty()) {
	            List<Integer> currLevel = new ArrayList<>();
	            int size = q.size();
	            for(int j=0 ; j< size; j++) {
	                TreeNode currNode = q.remove();
	                if(i % 2 == 0)
	                	currLevel.add(currNode.val);
	                else
	                	currLevel.add(0,currNode.val);
	                
	                if(currNode.left != null)
	                    q.add(currNode.left);
	                if(currNode.right != null)
	                    q.add(currNode.right);
	            }
	            i++;
	            result.add(currLevel);
	           
	        }
	        
	        return result;
	    }
	}
