package DataStructures;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class NodeInClonedTree {
	public static void main(String[] args) {
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode nineteen = new TreeNode(19);
		
		seven.left = four;
		seven.right = three;
		three.left = six;
		three.right = nineteen;
		
		TreeNode target = three;
		
		TreeNode seven1 = new TreeNode(7);
		TreeNode four1 = new TreeNode(4);
		TreeNode three1 = new TreeNode(3);
		TreeNode six1 = new TreeNode(6);
		TreeNode nineteen1 = new TreeNode(19);
		
		seven1.left = four1;
		seven1.right = three1;
		three1.left = six1;
		three1.right = nineteen1;
		
		TreeNode t = getTargetCopy(seven,seven1,target);
		System.out.println("The value in the node is : " + t.val);
		
	}
	
    static int depth = 0;
	static int horizontalDistance = 0;
    static TreeNode dest = null;
    public final static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
             
        getLocation(original,target,0,0);
        System.out.println("depth is : " + depth);
        System.out.println("horizontalDistance is : " + horizontalDistance);
        getNode(cloned,target,0,0);
        return dest;
    }
    
    public static boolean getLocation(TreeNode original,TreeNode target,int dep,int dist){
        
        if(original == null)
            return false;
        if(original == target)  {
            depth = dep;
            horizontalDistance = dist;
            return true;
        }
        
        boolean left = getLocation(original.left,target,dep+1,dist-1);
        if(!left) 
            return getLocation(original.right,target,dep+1,dist+1);
     
        return false;
    }
    
    public static boolean getNode(TreeNode cloned,TreeNode target,int dep,int dist){
        
        if(dep == depth && dist == horizontalDistance) {
            dest = cloned;
            return true;
        }
        
        if(cloned == null)
            return false;
        
        boolean left = getNode(cloned.left,target,dep+1,dist-1);
        if(!left)
            return getNode(cloned.right,target,dep+1,dist+1);
    
        return false;
    }
}