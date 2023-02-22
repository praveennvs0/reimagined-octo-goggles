package DataStructures;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class CompleteBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		
		one.left = two;
		one.right = three;
		
//		two.left = four;
//		two.right = five;
//		
		three.left = six;
		three.right = seven;
		
		boolean x = isCompleteTree(one);
		System.out.println("Complete tree : " + x);
	}
	
	public static boolean isCompleteTree(TreeNode root) {
        if(root.left == null && root.right == null)
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currLevel = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr = queue.poll();
                if(curr == null) {
                	values.add(-1);
                	continue;
                }
                
                currLevel.add(curr);
                values.add(curr.val);
            
                //push the children
                    queue.add(curr.left);                    
                    queue.add(curr.right);
                
            }
            
            if(orderViolated(values,size) && !LastLevel(values)) {
                return false;
            }
            

            
            
        }
        return true;
    }
	    
	    private static boolean LastLevel(List<Integer> values) {
		for(Integer value : values) {
			if(value != -1) 
				return false;
		}
		return true;
	}

		private static boolean orderViolated(List<Integer> values,int size) {
            int i;
	        for( i=0;i<values.size();i++) {
	            if(values.get(i) == -1 ) {
	                break;
	            }
	        }
            
            for(int j=i+1;j<values.size();j++) {
                if(values.get(j) != -1) 
                    return true;
            }
	        
	        return false;
	    }

}
