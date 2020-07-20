package DataStructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue; 

public class BinaryTreeCousins {
	
	public  static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		
		
		root.left = two;
		root.right = three;
		
		two.right = four;
		three.right = five;
		
		boolean isCousins =  isCousins(root,1,5);
		System.out.println(isCousins);
		
	}
	
	
	public static boolean isCousins(TreeNode root, int x, int y) {
        boolean isCousins = true ; 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int firstNodeLevel = -1, secondNodeLevel = -1;
        boolean firstNodeFound = false, secondNodeFound = false;
        Map<TreeNode,Integer> levelMap = new HashMap<>();
        levelMap.put(root,0);
        while(!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if((currNode.left!=null && currNode.left.val == x && currNode.right != null && currNode.right.val  == y)) {
            	System.out.println("Siblings");
            	isCousins = false ;
                break;
            }
            if ((currNode.left != null && currNode.left.val ==y && currNode.right!= null && currNode.right.val == x )) {
            	System.out.println("Siblings");
            	isCousins = false;
            	break;
            }
            
            int currLevel = levelMap.get(currNode);
            
            if(firstNodeFound == true && currLevel > firstNodeLevel ) {
            	if(secondNodeFound == false) {
            		System.out.println("Level crossed");
            		isCousins = false;
            		break;
            	}
            }
            
            if(secondNodeFound == true && currLevel > secondNodeLevel) {
            	if(firstNodeFound == false) {
            		System.out.println("Level crossed");
            		isCousins = false;
            		break;
            	}
            }
            
            if(currNode.val == x) {
            	firstNodeLevel = currLevel ;
            	firstNodeFound = true;
            }
            
            if(currNode.val==y) {
            	secondNodeLevel = currLevel ;
            	secondNodeFound = true; 
            }
            
           
            if(currNode.left != null) {
            	levelMap.put(currNode.left,currLevel + 1);
                queue.add(currNode.left);
            }
                
            if(currNode.right != null) {
            	levelMap.put(currNode.right,currLevel + 1);
                queue.add(currNode.right);
            }
                
            
        }
        return isCousins ;

}
}
