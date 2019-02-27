package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverClass {

    public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree(); 
  
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
        
        
        List <Integer> nums = Arrays.asList(50,30,20,40,70,60,80);
        for (Integer x : nums ) {
            tree.insertNode(x);
        }
        
        
        
//        Node root = new Node(4) ;
//        tree.root = root ;
//        
//        Node three = new Node(3) ;
//        tree.root.left = three ;
//        
//        Node seven = new Node(7);
//        tree.root.left.left = seven ;
//        
//        Node ten = new Node(10) ;
//        tree.root.left.left.left = ten ;
//        
//        Node twelve = new Node(12) ;
//        tree.root.left.left.right = twelve ; 
//        
//        Node thirteen = new Node(13) ;
//        tree.root.left.left.right.left = thirteen ;
//        
//        Node eight = new Node(8) ;
//        tree.root.left.right = eight ;
//        
//        Node two = new Node(2);
//        tree.root.right = two ;
        
       
        
       boolean isBST =  tree.isBSTUtil(tree.root,null) ;
        
       if(isBST) 
           System.out.println("yes it is a BST");
       else
           System.out.println("No. Not a BST");
        
    } 
    
    
} 
