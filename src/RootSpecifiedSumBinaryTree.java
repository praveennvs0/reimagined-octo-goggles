import java.util.ArrayList;
import java.util.List;

import DataStructures.TreeNode;

public class RootSpecifiedSumBinaryTree {
	
	public static void main(String[] args) {
		
		List<Integer> path = new ArrayList<Integer>();
		
		
		TreeNode root = new TreeNode(10);
		TreeNode twentyEight = new TreeNode(28);
		TreeNode thirteen = new TreeNode(13);
		TreeNode fourteen = new TreeNode(14);
		TreeNode fifteen = new TreeNode(15);
		TreeNode twentyOne = new TreeNode(21);
		TreeNode twentyTwo = new TreeNode(22);
		TreeNode twentyThree = new TreeNode(23);
		TreeNode twentyFour = new TreeNode(24);
		
		root.left = twentyEight;
		root.right = thirteen;
		
		thirteen.left = fourteen;
		thirteen.right = fifteen;
		
		fourteen.left = twentyOne;
		fourteen.right = twentyTwo;
		
		fifteen.left = twentyThree;
		fifteen.right = twentyFour;
		
		printAllPaths(root,path,38);
	}

	public static void printAllPaths(TreeNode treeNode,List<Integer> path,int sum )  {
		
		if(treeNode == null)
			return;
		
		path.add(treeNode.getKey());
		
		if(treeNode.getKey() == sum) {
			printPath(path);
		}
		
		
		sum = sum - treeNode.getKey();
		if(treeNode.left !=null )
		printAllPaths(treeNode.left,path,sum);
		
		if(treeNode.left != null && path.size() > 0) {
			path.remove(path.size()-1);
		}
		
		if(treeNode.right != null)
		printAllPaths(treeNode.right,path,sum);
		
		if(treeNode.right != null && path.size() > 0) {
		path.remove(path.size()-1);
		}
		
		
	}

	private static void printPath(List<Integer> path) {
		System.out.println();
		System.out.println("Path is : ");
		path.forEach(x->{System.out.print(x) ;
						 System.out.print("->");});
		
	}
}
