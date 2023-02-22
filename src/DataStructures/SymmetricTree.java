package DataStructures;

import java.util.ArrayList;
import java.util.List;

import DataStructures.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SymmetricTree {
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode two_2 = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		
		TreeNode four_2 = new TreeNode(4);
		TreeNode three_2 = new TreeNode(3);
		
		root.left = two;
		root.right = two_2;
		
		two.left = three;
		two.right = four;
		
		two_2.left = four_2;
		two_2.right = three_2;
		
		boolean isSymmetric = isSymmetric(root);
		System.out.println(isSymmetric);
	}
    public static boolean isSymmetric(TreeNode root) {
        List<Integer> preList = new ArrayList<>();
        preOrderAsList(root,preList);
        
        List<Integer> reversePreList = new ArrayList<>();
        reversePreOrderAsList(root,reversePreList);
        
        return isSymmetric(preList,reversePreList);
    }
    
    public static boolean isSymmetric(List<Integer> list1,List<Integer> list2) {
        if(list1 == null && list2 != null)
            return false;
        if(list2 == null && list1 != null)
            return false;
            
        if(list1.size() != list2.size())
            return false;
        
        for(int i=0;i<list1.size() ;i++) {
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }
    
    private static void preOrderAsList(TreeNode root,List<Integer> preList) {
        if(root == null) {
            preList.add(null);
            return;
    }
        preList.add(root.val);
        preOrderAsList(root.left,preList);
        preOrderAsList(root.right,preList);
    }
    
    
    private static void reversePreOrderAsList(TreeNode root,List<Integer> reversePreList) {
        if(root == null){
            reversePreList.add(null);
            return;
        }
        reversePreList.add(root.val);
        reversePreOrderAsList(root.right,reversePreList);
        reversePreOrderAsList(root.left,reversePreList);
    }
}