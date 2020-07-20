package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor {
	
	public static void main(String[] args) {
		TreeNode three = new TreeNode(3) ;
		
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);
		
		
		three.left = five;
		three.right = one;
		five.left = six;
		five.right = two ;
		two.left = seven;
		two.right = four;
		one.left = zero;
		one.right = eight;
		
		
		TreeNode lca = lowestCommonAncestor(three, five,two);
		System.out.println("Lowest Common Ancestor is : " + lca.val);
	}


	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		List<TreeNode> pathX = findPath(root,node1);
		List<TreeNode> pathY = findPath(root,node2);
		
		TreeNode lca = findCommonElements(pathX,pathY);
		
		return lca;
	}

	private static TreeNode findCommonElements(List<TreeNode> pathX, List<TreeNode> pathY) {
		Set<TreeNode> pathXSet = new LinkedHashSet<TreeNode>(pathX);
		Set<TreeNode> pathYSet = new LinkedHashSet<TreeNode>(pathY); 
		pathXSet.retainAll(pathYSet);
		TreeNode low = (TreeNode) pathXSet.toArray()[pathXSet.size()-1];
		return low;
	}

	private static List<TreeNode> findPath(TreeNode root, TreeNode node1) {
		List<TreeNode> path = new ArrayList<>();
		findPath(root,node1,path);
		
		return path;
	}

	private static boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
		
		if(root == null)
			return false;
		
		path.add(root);
		if(root.val == target.val) {
			return true;
		}
		
		boolean left = findPath(root.left,target,path) ;
		
		if(left == true)
			return true ;
		
		if(root.left != null && path.size() > 1 ) {
		path.remove(path.size()-1);
		}
		
		boolean right = findPath(root.right,target,path);
		if(right == true )
			return true ;
		
		if(root.right != null && path.size() > 1) {
		path.remove(path.size()-1);
		}
		return false;
		
		
	}


}
