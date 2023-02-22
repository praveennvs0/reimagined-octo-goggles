package DataStructures;

public class PathSum {
	public static void main(String[] args) {
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode eight = new TreeNode(8);
		TreeNode eleven = new TreeNode(11);
		TreeNode seven = new TreeNode(7);
		TreeNode two = new TreeNode(2);
		TreeNode thirteen = new TreeNode(13);
		TreeNode four2 = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		
		five.left = four;
		five.right = eight;
		
		four.left = eleven;
		
		eleven.left = seven;
		eleven.right = two;
		
		eight.left = thirteen;
		eight.right=four;
		
		four.right = one;
		
		boolean hasPath = hasPathSum(five,18);
		System.out.println(hasPath);

	}
	
    public static boolean hasPathSum(TreeNode root, int sum) {
    	
    	if(root == null)
    		return false;
        
    	//the path must end at a leaf node
    	if(root.left == null && root.right == null && root.val == sum) 
    		return true;
    	
    	boolean left = hasPathSum(root.left,sum-root.val);
    	if(left == true)
    		return true;
    	
    	return hasPathSum(root.right,sum-root.val);
    }


}
