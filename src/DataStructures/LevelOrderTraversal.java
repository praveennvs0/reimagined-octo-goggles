package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LevelOrderTraversal {

    
    
    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new Queue<Node> () ;
        q.enqueue(root);
        
        while(!q.isEmpty()){
            Node poppedElement = q.dequeue() ;
            System.out.print(poppedElement.key + ":") ;
            
            if(poppedElement.left != null)
            q.enqueue(poppedElement.left);
            
            if(poppedElement.right != null)
            q.enqueue(poppedElement.right);
        }
        
        
    }
    
    

    public static void levelOrderTraversalLeftAndRight(Node root) {
        Queue<Node> q = new Queue<Node> () ;
        q.enqueue(root);
        
        Map<Integer,Integer > heightMap = new LinkedHashMap<Integer,Integer> () ;
        heightMap.put(root.key,0) ;
        
        
        while(!q.isEmpty()){
            Node poppedElement = q.dequeue() ;
            System.out.print(poppedElement.key + ":") ;
            int left,right ;
            int parentKey = poppedElement.key ;
            int parentLevel = heightMap.get(parentKey) ;
            
            if(poppedElement.left != null){
            q.enqueue(poppedElement.left);
            left = poppedElement.left.key ;
            heightMap.put(left, parentLevel + 1 ) ;
            }
            
            if(poppedElement.right != null){
            q.enqueue(poppedElement.right);
            right = poppedElement.right.key ;
            heightMap.put(right,parentLevel+1);
            }
        }
        
        System.out.println("hash map is : " + heightMap); 
    }
}
