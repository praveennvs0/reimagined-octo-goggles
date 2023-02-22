package DataStructures;

public class ValidateBST {
	private static TreeNode prev ;
	public static void main(String[] args) {
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		
		five.left = one;
		five.right = four;
		
		four.left = three;
		four.right = six;
		
		boolean isBST = isValidBST(five);
		System.out.println("isBST : " + isBST);
		
	}

	private static boolean isValidBST(TreeNode node) {
		
		if(node == null)
			return true;
		
		boolean isBST = isValidBST(node.left);
		
		if(!isBST)
			return false;
		if(prev != null && prev.val > node.val) 
			return false;
		prev = node;
		
		return isValidBST(node.right);
		
		
		
		
	}

}
