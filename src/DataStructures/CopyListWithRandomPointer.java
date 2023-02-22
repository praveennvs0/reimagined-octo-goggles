package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	
	public static void main(String[] args) {
		
		// Definition for a Node.
		

	}
	

    public Node copyRandomList(Node head) {
        Map<Node,Node> nodesMap = new HashMap<>();
        Node temp = head;
        
        while(temp != null) {
        Node newNode = new Node(temp.val);
        nodesMap.put(temp,newNode);
        temp = temp.next;
        }
        
        temp = head ;
        while(temp != null) {
            Node currNode = nodesMap.get(temp.val);
            if(temp.next != null){
            Node next = nodesMap.get(temp.next.val);
            currNode.next = next;    
            }
            if(temp.random != null) {
            Node random = nodesMap.get(temp.random.val);
            currNode.random = random;
            }
            temp = temp.next;
        }
        
        return nodesMap.get(head);
    }

}
