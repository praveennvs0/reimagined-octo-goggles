package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		
		one.left = two;
		one.right = three;
		
		binaryTreePaths(one);
		
	}

	private static List<String> binaryTreePaths(TreeNode root) {
		StringBuilder path = new StringBuilder();
		List<String> result = new ArrayList<>();
		binaryTreePaths(root,path,result);
		return result;
		
	}

	private static void binaryTreePaths(TreeNode root,StringBuilder path, List<String> result) {

		if(root == null) {
			return;
		}

		path.append(Integer.toString(root.val) + "->");
		
		if(root.left == null && root.right == null) {
			path.deleteCharAt(path.length()-1);
			path.deleteCharAt(path.length()-1);
			System.out.println(path.toString());
			result.add(path.toString());
		}
		
		binaryTreePaths(root.left,path,result);
		
		if(root.left != null ) {
			if(Character.isDigit(path.charAt(path.length()-1))){
				path.deleteCharAt(path.length()-1);
			}
			else {
		  path.deleteCharAt(path.length()-1);
		  path.deleteCharAt(path.length()-1);
			}
		}
		binaryTreePaths(root.right,path,result);
		
		if(root.right != null)  {
			if(Character.isDigit(path.charAt(path.length()-1))){
				path.deleteCharAt(path.length()-1);
			}
			else {
		  path.deleteCharAt(path.length()-1);
		  path.deleteCharAt(path.length()-1);
			}
		}
	}
}
