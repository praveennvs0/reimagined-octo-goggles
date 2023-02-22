package DataStructures;

public class KthSmallest {

	
	private static  int count=0, element=0;
	  
	  public static void main(String[] args) {
		  BinarySearchTree.insertNode(3);
		  BinarySearchTree.insertNode(1);
		  BinarySearchTree.insertNode(4);
		  BinarySearchTree.insertNode(2);
		  TreeNode root = BinarySearchTree.root;
		  //BinarySearchTree.inorder();
		  int x = kthSmallest(root,4);
		  System.out.println(x);
		  
	  }
	  
	    public static int kthSmallest(TreeNode root, int k) {
	    	kthSmallestHelper(root,k);
	        return element;
	        
	    }
	    
	    
	    public static void kthSmallestHelper(TreeNode root,int k) {
	        
	          if(root == null)
	              return;
	        
	        if(element == 0) // not found yet
	        kthSmallest(root.left,k);
	        
	        //visiting the node
	        count++;
	        System.out.println("node val is : "+root.val);
	        
	        if(count==k) {
	            element = root.val;
	        }
	        
	        if(element == 0)
	        kthSmallest(root.right,k);
	    }
}
