package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinarySearchTree {
    
    Node root ;
    Node prev ;
    
    public BinarySearchTree() {
        root = null ;
    }

    public void insertNode(int key) {
        if(root==null){
            Node newNode = new Node(key) ;
            root = newNode ;
            return ;
            
        }
        
        Node node = root ;
        while(true) {
            
         
            
            if(node.left == null && key < node.key) {
                Node newNode = new Node(key) ;
                node.left = newNode ;
                newNode.parent = node ;
                return ;
            }
            
            if(node.right == null && key > node.key) {
                Node newNode = new Node(key) ;
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
  
    void inorder()  { 
        inorderRec(root); 
     } 
   
     // A utility function to do inorder traversal of BST 
     void inorderRec(Node root) { 
         if (root != null) { 
             inorderRec(root.left); 
             System.out.println(root.key); 
             inorderRec(root.right); 
         } 
     } 
     
     void inorderRec(Node root,List<Node> nodeList) {
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

    private int evaluateHeight(Node node) {
        
        int leftHeight = 0,rightHeight = 0 ;
        
        if(node.left != null) {
         leftHeight = 1  + evaluateHeight(node.left) ;
        }
        
        if(node.right != null) {
         rightHeight = 1 + evaluateHeight(node.right) ;
        }
         
        return max(leftHeight,rightHeight);
    }

    
    public void findNodesAtGivenHeight(Node n,int currentHeight, int target) {
        
        if(currentHeight == target) {
            System.out.println(n.key);
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
    
    public void printPaths(Node n, List<Integer> path, List<List<Integer>> listOfPaths) {
        
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
        path.remove(new Integer(n.left.key)) ;
        }
        
        printPaths(n.right,path,listOfPaths) ;
        
        if(n.right !=null) {
        path.remove(new Integer(n.right.key)) ;
        }
        
    }
    
    private List<Integer> copyList(List<Integer> path) {
        List<Integer> copiedList = new ArrayList<Integer>();
        for(Integer i : path) {
            copiedList.add(i) ;
        }
        return copiedList ;
    }
    
    public void printVerticalLine(Node node, int line_no, int hd)  
    { 
        // Base case 
        if (node == null)  
            return; 
   
        // If this node is on the given line number 
        if (hd == line_no)  
            System.out.print(node.key + " "); 
        
   
        // Recur for left and right subtrees 
        printVerticalLine(node.left, line_no, hd - 1); 
        printVerticalLine(node.right, line_no, hd + 1); 
    } 
    
    public void printNodesAtDistanceFromRoot(Node n,int currDistance,int targetDistance) {
        
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
    
    public void findPathToANode(Node n,List<Node> path,int target,List<Node> result) {
        

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
    
    public void printNodes(List<Node> path) {
        System.out.println("Path is : ");
        path.forEach(n-> System.out.println(n.key));
        
    }

    public void verticalOrder(List<Node> nodes,Map<Integer,Integer> nodePathMap) {
       
        for(Node n : nodes) {
            int verticalDistance = findVerticalDistance(n) ;
            nodePathMap.put(n.key, new Integer(verticalDistance)) ;
        
        }
        
        DataStructuresUtil.decorate(nodePathMap);
        
    }
    
   
    
    public int findVerticalDistance(Node n) {
        List<Node> path = new ArrayList<Node>();
        List<Node> result = new ArrayList<Node>() ;
        
        findPathToANode(root, path , n.key,result);
        
        int verticalDistance = findVerticalDistanceFromRootThroughPath(result) ;
        return verticalDistance ;
    }

    private int findVerticalDistanceFromRootThroughPath(List<Node> result) {
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
    
    public void printNodesAtHorizontalDistance(Node n,int currentDistance, int targetDistance) {
        if(currentDistance == targetDistance) {
            System.out.println(n.key);
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
  
   public  boolean isBSTUtil( Node root, Node prev) 
    { 
        // traverse the tree in inorder fashion and  
        // keep track of prev node 
        if (root != null) 
        { 
            if (!isBSTUtil(root.left, prev)) 
              return false; 
       
            // Allows only distinct valued nodes  
            if (prev != null && root.key <= prev.key) 
              return false; 
       
            prev = root; 
       
            return isBSTUtil(root.right, prev); 
        } 
       
        return true; 
    } 
  
    
    
    
    
}

