package DataStructures;

public class MergeNodesInBetweenZeroes {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
//		list.insert(0);
//		list.insert(3);
//		list.insert(1);
//		list.insert(0);
//		list.insert(4);
//		list.insert(5);
//		list.insert(2);
//		list.insert(0);
//		
		list.insert(0);
		list.insert(2);
		list.insert(5);
		list.insert(4);
		list.insert(0);
		list.insert(1);
		list.insert(3);
		list.insert(0);
		
		
		ListNode head = list.head;
		mergeNodes(head);
		
		
	}
	
	 public static ListNode mergeNodes(ListNode head) {
	        ListNode temp = head,curr = null,head1 = null ;
	        boolean firstTime = true;
	        while(temp != null) {
	        	if(temp.val == 0) {
	        		curr = temp ;
	        		if(firstTime) {
	        			head1 = curr;
	        			firstTime = false;
	        		}
	        		ListNode temp2 = temp.next;
	        		int sum = 0;
	        		if(temp2 == null)
	        			break;
	        		while(temp2.val != 0) {
	        			sum = sum + temp2.val;
	        			temp2 = temp2.next;
	        		}
	        		
	        		ListNode newNode = new ListNode(sum) ;
		        	curr.next = newNode;
		        	newNode.next = temp2;
		        	temp = temp2;
	        		
	        	}
	        	
	        	
	        }
	        
	         
	         ListNode head2 = head1.next;
	         temp = head2;
	        while(temp != null) {
	        	if(temp.next != null) {
      	        	temp.next = temp.next.next;
      	        	temp = temp.next;
	        	}
	        }
	        
	        
	        return head2;
	    }

}
