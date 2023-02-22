import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DataStructures.LinkedList;
import DataStructures.TreeNode;

public class PseudoPalindromicPaths {
	
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
	    static Map<Integer,Integer> map = new HashMap<>();
	    static Integer count,last;
	    

	    public static void main(String[] args) {
	       TreeNode a = new TreeNode(2);
	       TreeNode b = new TreeNode(1);
	       TreeNode c = new TreeNode(1);
	       TreeNode d = new TreeNode(1);
	       TreeNode e = new TreeNode(3);
	       TreeNode f = new TreeNode(1);
	        
	       a.left = b;
	       a.right = c;
	       b.left = d;
	       b.right = e;
	       
	       e.left = f;
	    	
	    	
	    	
	    	
	    	int num = pseudoPalindromicPaths(a);
	    	System.out.println();
	    	System.out.println("No. of pseudo palindromic paths is : " + num);
	    	
	    }
	    
	    
	    public static int pseudoPalindromicPaths (TreeNode root) {
	        //resetting the count
	        count = 0;
	        List<Integer> path = new ArrayList<>();
	        findPaths(root,path);
	        return count;
	        
	    }
	    
	    public static void findPaths(TreeNode root,List<Integer> path) {
	        if(root==null) {
	         path.add(null);
	         return;   
	        }
	        
	        path.add(root.val);
	        map.put(root.val,map.getOrDefault(root.val,0)+1);
	        if(root.left == null && root.right == null) {
	        	
	        	System.out.println();
	        	LinkedList.displayList(path);
	        	
	            if(isPalindrome(map)) {
	            	System.out.println();
	            System.out.println("Palindromic path");
	            LinkedList.displayList(path);
                	            	
	            count++;
	            return;
	            }
	            
	        }
	        
	        
	        
	        findPaths(root.left,path);
	        
	        if(path != null && path.size() > 0) {
	         last = path.get(path.size()-1);
	        path.remove(path.size()-1);
	        map.put(last,map.getOrDefault(last,0)-1);
	        if(map.get(last) <= 0)             {
	            map.remove(last);
	        }
	        
	        findPaths(root.right,path);
	        
	        if(path != null && path.size() > 0) {
	         last = path.get(path.size()-1);
	        path.remove(path.size()-1);
	        map.put(last,map.getOrDefault(last,0)-1);
	            if(map.get(last) <= 0)             {
	            map.remove(last);
	        }
	        
	        }
	    }
	    }
	    
	    public static boolean isPalindrome(Map<Integer,Integer> freqMap) { 
	        int oddCount = 0;
	        for(Integer x : freqMap.keySet()) {
	            if(freqMap.get(x) % 2 == 1) {
	                oddCount++;
	            }
	            
	            if(oddCount > 1) 
	                return false;
	            
	            
	        }
	        return true;
	    }

}
