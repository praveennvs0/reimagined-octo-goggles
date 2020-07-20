package DataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class LeftViewBinaryTree {

	public static void main(String args[]) {
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		
		one.left = two;
		one.left.right=four;
		one.left.right.right = five;
		one.left.right.right.right = six ;
		
		one.right = three ;
       
        System.out.println("level order traversal");
        LevelOrderTraversal.levelOrderTraversal(one);
        
        System.out.println("");
		System.out.println("left view is : ");
		
	    leftView(one);	
	}

	private static void leftView(TreeNode root) {
		Map<TreeNode,Integer> heightMap = new HashMap<TreeNode,Integer>();
		Queue<TreeNode> queue = new LinkedList<> () ;
		queue.add(root);

		int level = 0, lastSeenHeight =-1 ;
		heightMap.put(root, 0);
		
		System.out.println(root.getKey());
		while (!queue.isEmpty()) {
			TreeNode poppedElement = queue.remove();
			int currLevel = heightMap.get(poppedElement) ;
			
			if (poppedElement.left != null) {
				level = currLevel + 1 ;
				queue.add(poppedElement.left);
				heightMap.put(poppedElement.left, level);
				if(level > lastSeenHeight) {
					System.out.println(poppedElement.left);
				lastSeenHeight = level ;
				}

			}
			if (poppedElement.right != null) {
				level = currLevel + 1 ;
				queue.add(poppedElement.right);
				heightMap.put(poppedElement.right, level);
				if(level > lastSeenHeight) {
					System.out.println(poppedElement.right);
				lastSeenHeight = level ;
				}

			}
			
		}

	}
	
	
	
}
