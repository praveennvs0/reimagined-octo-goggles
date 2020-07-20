package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinarySearchTree {
    
    public TreeNode root ;
    TreeNode prev ;
    
    public BinarySearchTree() {
        root = null ;
    }

    public void insertNode(int key) {
        if(root==null){
            TreeNode newNode = new TreeNode(key) ;
            root = newNode ;
            return ;
            
        }
        
        TreeNode node = root ;
        while(true) {
            
         
            
            if(node.left == null && key < node.val) {
                TreeNode newNode = new TreeNode(key) ;
                node.left = newNode ;
                newNode.parent = node ;
                return ;
            }
            
            if(node.right == null && key > node.val) {
                TreeNode newNode = new TreeNode(key) ;
                node.right = newNode ;
                newNode.parent = node ;
                return ;
            }
            
            
            if( key < node.getKey()) {
                node = node.left ;
            }
            
            
            else if ( key > node.getKey()) {
                node = node.right ;
            }
           
         
            
               
        }
    }
  
   public void inorder()  { 
	   System.out.println("Inorder is : ");
        inorderRec(root); 
     } 
   
   
   public void preorder()  { 
	   System.out.println("Preorder is : ");
        preorderRec(root); 
     } 
   
   // A utility function to do preorder traversal of BST 
   public  void preorderRec(TreeNode root) { 
         if (root != null) { 
             System.out.print(root.val); 
             System.out.print(",");
             preorderRec(root.left); 
             preorderRec(root.right); 
         } 
     } 
   
   public void preorderAsList(TreeNode root,List<Integer> preOrderList) {
       if (root != null) { 
           System.out.print(root.val);
           System.out.print(",");
           preOrderList.add(root.val);
           preorderAsList(root.left,preOrderList); 
           preorderAsList(root.right,preOrderList); 
       } 
       
   }
     // A utility function to do inorder traversal of BST 
   public  void inorderRec(TreeNode root) { 
         if (root != null) { 
             inorderRec(root.left); 
             System.out.println(root.val); 
             inorderRec(root.right); 
         } 
     } 
     
     void inorderRec(TreeNode root,List<TreeNode> nodeList) {
         if (root != null) { 
             inorderRec(root.left,nodeList); 
             nodeList.add(root) ;
             inorderRec(root.right,nodeList); 
         } 
     }
    
     public int getHeight() {
         int height = 0 ;
         height = evaluateHeight(root) ;
         return height ;
     }

    private int evaluateHeight(TreeNode node) {
        
        int leftHeight = 0,rightHeight = 0 ;
        
        if(node.left != null) {
         leftHeight = 1  + evaluateHeight(node.left) ;
        }
        
        if(node.right != null) {
         rightHeight = 1 + evaluateHeight(node.right) ;
        }
         
        return max(leftHeight,rightHeight);
    }

    
    public void findNodesAtGivenHeight(TreeNode n,int currentHeight, int target) {
        
        if(currentHeight == target) {
            System.out.println(n.val);
        }
        
        if(currentHeight > target) {
            return ;
        }
        
        if(n.left != null)
        findNodesAtGivenHeight(n.left,1+currentHeight,target) ;
        
        if(n.right != null)
            findNodesAtGivenHeight(n.right,1+currentHeight,target) ;
    }
    
    
    private int max(int a, int b) {

        if(a > b){
            return a;
        }
        else 
            return b;
    }
    
    private int min(int a, int b) {

        if(a < b){
            return a;
        }
        else 
            return b;
    }
    
    public static void printPaths(TreeNode n, List<Integer> path, List<List<Integer>> listOfPaths) {
        
        if(n== null){
            return ;
        }
        
        path.add(n.getKey()) ;
        
        
        if(n.left == null && n.right == null) { // n is leaf node
            System.out.println("path is : " + path) ;
            //make a copy of path
            List<Integer> copyPath = copyList(path) ;
            listOfPaths.add(copyPath) ;
            return ;
            
        }
        
        
        printPaths(n.left,path,listOfPaths) ;
        
        if(n.left != null) {
        path.remove(new Integer(n.left.val)) ;
        }
        
        printPaths(n.right,path,listOfPaths) ;
        
        if(n.right !=null) {
        path.remove(new Integer(n.right.val)) ;
        }
        
    }
    
    private static List<Integer> copyList(List<Integer> path) {
        List<Integer> copiedList = new ArrayList<Integer>();
        for(Integer i : path) {
            copiedList.add(i) ;
        }
        return copiedList ;
    }
    
    public void printVerticalLine(TreeNode node, int line_no, int hd)  
    { 
        // Base case 
        if (node == null)  
            return; 
   
        // If this node is on the given line number 
        if (hd == line_no)  
            System.out.print(node.val + " "); 
        
   
        // Recur for left and right subtrees 
        printVerticalLine(node.left, line_no, hd - 1); 
        printVerticalLine(node.right, line_no, hd + 1); 
    } 
    
    public void printNodesAtDistanceFromRoot(TreeNode n,int currDistance,int targetDistance) {
        
        if(n == null) {
            return ;
        }
        
        if(currDistance == targetDistance) {
            System.out.println("node is : " + n.getKey());
            return ;
        }
        
        printNodesAtDistanceFromRoot(n.left,++currDistance,targetDistance) ;
        
        --currDistance ; 
        
        printNodesAtDistanceFromRoot(n.right,++currDistance,targetDistance) ;
        
    }
    
    public static void findPathToANode(TreeNode n,List<TreeNode> path,int target,List<TreeNode> result) {
        

        if(n == null) {
            return ;
        }
        
        path.add(n) ;
        if(n.getKey() == target) {
            result.addAll(path) ;
            printNodes(path) ;
        }
        
        
        findPathToANode(n.left,path,target,result) ;
        
        if(n.left != null) 
        path.remove(n.left) ;
        
        
        findPathToANode(n.right,path,target,result) ;
        
        if(n.right != null)
        path.remove(n.right) ;
    }
    
    public static void printNodes(List<TreeNode> path) {
        System.out.println("Path is : ");
        path.forEach(n-> System.out.println(n.val));
        
    }

    public void verticalOrder(List<TreeNode> nodes,Map<Integer,Integer> nodePathMap) {
       
        for(TreeNode n : nodes) {
            int verticalDistance = findVerticalDistance(n) ;
            nodePathMap.put(n.val, new Integer(verticalDistance)) ;
        
        }
        
        DataStructuresUtil.decorate(nodePathMap);
        
    }
    
   
    
    public int findVerticalDistance(TreeNode n) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        List<TreeNode> result = new ArrayList<TreeNode>() ;
        
        findPathToANode(root, path , n.val,result);
        
        int verticalDistance = findVerticalDistanceFromRootThroughPath(result) ;
        return verticalDistance ;
    }

    private int findVerticalDistanceFromRootThroughPath(List<TreeNode> result) {
        int verticalDistance = 0;
        for(int i=0 ; i < result.size() - 1 ; i++) {
            if(result.get(i).getRight() == result.get(i+1)) {
                verticalDistance++ ;
            }
            else if (result.get(i).getLeft() == result.get(i+1)) {
                verticalDistance-- ;
            }
        }
        return verticalDistance;
    }
    
    public void printNodesAtHorizontalDistance(TreeNode n,int currentDistance, int targetDistance) {
        if(currentDistance == targetDistance) {
            System.out.println(n.val);
        }
        
        if(n.left != null) 
            printNodesAtHorizontalDistance(n.left,currentDistance-1,targetDistance) ;
            
        if(n.right != null)
            printNodesAtHorizontalDistance(n.right,currentDistance+1,targetDistance) ;
        
    }
    
    
    boolean isBST()  { 
        prev = null; 
      //  return isBST(root); 
        return false ;
    } 
  
   public  boolean isBSTUtil( TreeNode root, TreeNode prev) 
    { 
        // traverse the tree in inorder fashion and  
        // keep track of prev node 
        if (root != null) 
        { 
            if (!isBSTUtil(root.left, prev)) 
              return false; 
       
            // Allows only distinct valued nodes  
            if (prev != null && root.val <= prev.val) 
              return false; 
       
            prev = root; 
       
            return isBSTUtil(root.right, prev); 
        } 
       
        return true; 
    } 
  
    
    
    
    
}

