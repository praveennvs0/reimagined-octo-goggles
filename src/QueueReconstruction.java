import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DataStructures.ListNode;


public class QueueReconstruction {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		four.next = five;
		three.next = four ;
		two.next = three;
		one.next = two;
		
		 reorderList(one);
		System.out.println(one);
		
	}

	 public static void reorderList(ListNode head) {
	        
	       Map<Integer,ListNode> indexNodeMap = findSize(head);
	       int size = indexNodeMap.size();
	       int n= size-1;
	       ListNode output = head ;
	       
	       int increment = 0, decrement = n;
	       
	       for(int k=0;k<size; k++) {
	    	if(k % 2 == 0) {
	    		ListNode curr = indexNodeMap.get(increment);
	    		increment++;
	    		insertAtTheEnd(output,curr); 
	    	}
	    	
	    	else {
	    		ListNode curr = indexNodeMap.get(decrement);
	    		decrement--;
	    		insertAtTheEnd(output,curr); 
	    		
	    	}
	    	   
	       }
	        
	       	head = output;
	        
	    }
	 
	 private static void insertAtTheEnd(ListNode output, ListNode curr) {
		ListNode temp = output ;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = curr ;
		curr.next = null;
		 
	}

	public static Map<Integer, ListNode> findSize(ListNode head) {
		 Map<Integer,ListNode> indexNodeMap = new HashMap<Integer,ListNode> ();
	        int count = 0;
	        ListNode temp = head;
	        while(temp != null) {
	        	indexNodeMap.put(count,temp);
	            count++;
	            temp=temp.next;
	                        
	        }
	        
	        return indexNodeMap;
	    }


}
