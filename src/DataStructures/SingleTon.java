package DataStructures;



public class SingleTon {
	
/*	
1->2->3->4 
1->2->3->7->8

4->3->2->1
8->7->3->2->1

1->2->3->4

1->2->3->7->8

4,7 -

4->
8-> 

        1 
      2   20
     3  5
   4   7  10
         8
        9
         
         
         
LCA(TreeNode root,TreeNode n1,TreeNode n2) {
	TreeNode result;
  int depth1 = findDepth(root,n1);
  int depth2 = findDepth(root,n2);
  if(depth1 == depth2) {
    print "same level";
   
  
  }
  else if(depth1 > depth2) {
  
     int diff = depth1-depth2;
     while(diff > 0) {
     n1 = n1.parent;
     diff--;
     
     }
     
     
     
  

}
else {
 int diff = depth2-depth1;
while(diff > 0) {
     n2 = n2.parent;
     diff--;
     
     }
     

}

result = findLCASameDepth(n1,n2);
        
         
   
         findLCASameDepth(n1,n2) {
         
         
    TreeNote temp1 = n1, temp2=n2;
    while(temp1 != temp2) {
    temp1 = temp1.parent;
    temp2 = temp2.parent;
    }
    result = temp1;
         }
         

LCA(TreeNode root,TreeNode n1,TreeNode n2) {

	if(root == null) {
	 return null;
	}
	
	if(root == n1 || root == n2) {
		return root;
	
	
	}
	
	
	TreeNode left_lca = LCA(root.left,n1,n2);
	TreeNode right_lca = LCA(root.right,n1,n2);
	
	if(left_lca != null && right_lca != null) {
	    return root;
	}
	else if(left_lca != null) {
	  return left_lca ;
	
	}
	else {
	  return right_lca;
	}
	
	
	




}
	
	
	
	*/
	
}