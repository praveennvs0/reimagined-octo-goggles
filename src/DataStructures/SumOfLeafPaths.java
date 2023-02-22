package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue; 
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SumOfLeafPaths {

	static int totalSum = 0;
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		one.left = two;
		one.right = three;
		List<Character> path = new ArrayList<>();
	//	path.add(one.val);
		printPaths(one,path);
		System.out.println("total sum is : "  + totalSum);
		
	}

	private static void printPaths(TreeNode root,List<Character> path) {
		
		if(root == null)
			return;
		
		path.add(Character.forDigit(root.val,10));
		
		if(root.left == null && root.right == null) {
			System.out.println("currPath is :" );
			System.out.println();
			String numString = path.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
			int num = Integer.parseInt(numString);
			totalSum += num;
			return;
		}
		
		
		
		
		printPaths(root.left,path);
		
		    if(root.left != null) {
     		path.remove(path.size()-1);
     		
		    }
		    
			
		    printPaths(root.right,path);

			if(root.right != null) {
				path.remove(path.size()-1);
			}
			
	}
	
	
}
