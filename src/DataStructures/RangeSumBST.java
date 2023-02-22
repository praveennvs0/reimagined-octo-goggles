package DataStructures;


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

public class RangeSumBST {
	
    private static int sum = 0;

    
    public static void main(String[] args) {
    	TreeNode ten = new TreeNode(10);
    	TreeNode five = new TreeNode(5);
    	TreeNode fifteen = new TreeNode(15);
    	TreeNode three = new TreeNode(3);
    	TreeNode seven = new TreeNode(7);
    	TreeNode eighteen = new TreeNode(18);
    	
    	
    	ten.left = five;
    	ten.right = fifteen;
    	
    	five.left = three;
    	five.right = seven;
    	
    	fifteen.right = eighteen;
    	
    	int x = rangeSumBST(ten,7,15);
    	System.out.println("sum is : " + x);
    	
    	
    }
    
    
    
    
    
    public static int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        rangeSumBST1(root,low,high);
        return sum;
    }
    public static void rangeSumBST1(TreeNode root, int low, int high) {
        
        if(root == null)
            return ;
        
        if(root.val >= low && root.val <= high) {
            sum += root.val;
            rangeSumBST1(root.left,low,high) ;
            rangeSumBST1(root.right,low,high);
            
        }
        
        else if(root.val < low) {
           rangeSumBST1(root.right,low,high);
            
        }
        
        else if(root.val > high){
           rangeSumBST1(root.left,low,high);
        }
        
        
        
        
        
    }
}