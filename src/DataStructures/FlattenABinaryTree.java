package DataStructures;

public class FlattenABinaryTree {
	private static TreeNode linkedListRoot ;
	private static TreeNode linkedListTail;
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		
		one.left = two;
		one.right = five;
		
		two.left = three;
		two.right = four;
		
		five.right = six;
		
		BinarySearchTree.preorderRec(one);
		flatten(one);
		System.out.println();
		BinarySearchTree.preorderRec(linkedListRoot);
		
		
	}
	
	 public static void flatten(TreeNode root) { 
	        linkedListRoot = null;
	        linkedListTail = null;
	        flatten1(root);
	        root = linkedListRoot;
	    }
	    
	    public static void flatten1(TreeNode root) {
	        	if(root == null)
				return;
					
			insertIntoLinkedList(root);
			
			flatten1(root.left);
			flatten1(root.right);
	        
	    }

	private static void insertIntoLinkedList(TreeNode root) {
		TreeNode node = new TreeNode(root.val);
		if(linkedListRoot == null) {
			linkedListRoot = node;
			linkedListTail = node;
		}
		else {
			linkedListTail.right = node;
			linkedListTail = linkedListTail.right;
		}
			
		
	}

}
