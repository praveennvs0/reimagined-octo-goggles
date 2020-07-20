package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LevelOrderTraversal {

    
    
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new Queue<TreeNode> () ;
        q.enqueue(root);
        
        while(!q.isEmpty()){
            TreeNode poppedElement = q.dequeue() ;
            System.out.print(poppedElement.val + ":") ;
            
            if(poppedElement.left != null)
            q.enqueue(poppedElement.left);
            
            if(poppedElement.right != null)
            q.enqueue(poppedElement.right);
        }
        
        
    }
    
    

    public static void levelOrderTraversalLeftAndRight(TreeNode root) {
        Queue<TreeNode> q = new Queue<TreeNode> () ;
        q.enqueue(root);
        
        Map<Integer,Integer > heightMap = new LinkedHashMap<Integer,Integer> () ;
        heightMap.put(root.val,0) ;
        
        
        while(!q.isEmpty()){
            TreeNode poppedElement = q.dequeue() ;
            System.out.print(poppedElement.val + ":") ;
            int left,right ;
            int parentKey = poppedElement.val ;
            int parentLevel = heightMap.get(parentKey) ;
            
            if(poppedElement.left != null){
            q.enqueue(poppedElement.left);
            left = poppedElement.left.val ;
            heightMap.put(left, parentLevel + 1 ) ;
            }
            
            if(poppedElement.right != null){
            q.enqueue(poppedElement.right);
            right = poppedElement.right.val ;
            heightMap.put(right,parentLevel+1);
            }
        }
        
        System.out.println("hash map is : " + heightMap); 
    }
}
