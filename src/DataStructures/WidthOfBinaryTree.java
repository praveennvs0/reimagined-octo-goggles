package DataStructures;

import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WidthOfBinaryTree {

	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode three2 = new TreeNode(3);
		TreeNode nine = new TreeNode(9);
		
		one.left = three;
		one.right = two;
		
		three.left = five;
		three.right = three2;
		
		//two.right = nine;
		int width = widthOfBinaryTree(one);
		System.out.println("Width of binary tree is : " + width);
		
		

	}
	
	  public static int widthOfBinaryTree(TreeNode root) {
	       int treeWidth = 0 ;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        Map<TreeNode,Integer> map = new HashMap<>();
	        map.put(root,0);
	        while(!queue.isEmpty()) {
	            List<TreeNode> currLevelNodes = new ArrayList<>();
	            while(!queue.isEmpty()) {
	                TreeNode node = queue.remove();
	                currLevelNodes.add(node);
	                
	            }
	            
	            int currMin = Integer.MAX_VALUE, currMax = Integer.MIN_VALUE, width = 0;
	            for(TreeNode node : currLevelNodes) {
	                int currNodeVal = map.get(node);
	                if(node.left != null) {
	                    currMin = Math.min(currMin,currNodeVal-1);
	                    currMax = Math.max(currMax,currNodeVal-1);

	                    map.put(node.left,currNodeVal-1);
	                    queue.add(node.left);
	                }
	                
	                if(node.right != null) {
	                    currMin = Math.min(currMin,currNodeVal+1);
	                    currMax = Math.max(currMax,currNodeVal+1);
	                    
	                    map.put(node.right,currNodeVal+1);
	                    queue.add(node.right);
	                }
	            }
	            
	            width = currMax - currMin;
	            treeWidth = Math.max(treeWidth,width);
	        
	            
	        }
	        return treeWidth ;
	        
	    }
}
