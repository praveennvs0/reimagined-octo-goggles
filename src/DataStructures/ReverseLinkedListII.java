package DataStructures;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedListII {
	public static void main(String args[]) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		
		ListNode reversedList = reverseBetween(one,1,2);
		LinkedList.print(reversedList);
	}
	
	 public static ListNode reverseBetween(ListNode head, int leftPos, int rightPos) {
	        if(head.next == null)
	            return head;
	        if(leftPos == rightPos)
	        	return head;
	        
	        ListNode prev=null, curr=head,left = null,right = null ;
	        //Finding the left node
	        int currPos = 1;
	        while(curr != null) {
	            if(currPos == leftPos) {
	                left = curr;
	                break;
	            }
	            prev = curr;
	            curr = curr.next;
	            currPos++;
	        }
	        
	        ListNode left_prev = prev;
	        
	        
	        //reversing from left to right
	         ListNode prev1=null,curr1=left,next1=curr1.next;
	        while(curr1 != null) {
	            next1 = curr1.next;
	            curr1.next = prev1;
	            prev1 = curr1;
	            curr1 = next1;
	            if(currPos == rightPos){
	                break;
	            }
	            currPos++;
	            
	        }
	        //prev1 will be the head of the reversed part and curr1 will be the next of the right node
	        if(left_prev != null) {
	        left_prev.next = prev1;
	        }
	        else {
	        	//this case occurs when the left node is the very first node
	        	left.next = curr1;
	        	return prev1;
	        }
	        left.next = curr1;
	        
	        return head;
	        
	        
	        
	    }   
}