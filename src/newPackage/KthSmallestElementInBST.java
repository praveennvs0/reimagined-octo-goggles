package newPackage;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class KthSmallestElementInBST {
	static int count = 0;
	static int K = 0;
	private static int result;
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertNode(5);
		tree.insertNode(3);
		tree.insertNode(6);
		tree.insertNode(2);
		tree.insertNode(4);
		tree.insertNode(1);
		int k = 3;
		kthSmallest(tree.root,k);
	}

	 private static void kthSmallest(TreeNode root, int k) {
		 kthSmallest1(root,k);
		 System.out.println(result);
	}

	public static boolean kthSmallest1(TreeNode root, int k) {
		 if(root == null)
			 return false;
	     
		 boolean elementFound = kthSmallest1(root.left,k) ;
		 if(elementFound)
			 return true;
		  
		 System.out.println("Visiting : " + root.getKey());
		 count++;
		 
		 if(count==k) {
			 System.out.println("kth smallest element is : " + root.getKey());
			 result = root.getKey();
			 return true;
		 }
		 
		 return kthSmallest1(root.right,k);
	    }
}
