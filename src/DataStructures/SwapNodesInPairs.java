package DataStructures;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		
//		one.next = two;
//		two.next = three;
//		three.next = four;
//		four.next = five;
		
		
		ListNode head = swapPairs(one);
		LinkedList.print(head);
	}
	
	
	
	
	public static ListNode swapPairs(ListNode node) {
		
		ListNode curr = node;
		ListNode next = node.next;
		ListNode head = null;
		ListNode futurePointer = null;
		ListNode tail = null;
		
		
		boolean isFirstPair = true;
		while(curr != null) {
			 if(next == null) {
				 tail.next = curr;
				 return head;
			 }
			 futurePointer = next.next;
			 
			// swap
			ListNode temp = curr;
			curr = next;
			next = temp;
			
			
			next.next = null;
			curr.next = null;
			
			curr.next = next;
			
			tail = next;
			if (futurePointer != null) {
			tail.next = futurePointer.next;
			}
			
			if(isFirstPair) {
				head = curr;
				isFirstPair = false;
			}
		
		
		curr = futurePointer;
		
		if(futurePointer != null) {
		next=futurePointer.next;
		}
		}
		
		return head;
	}
	
	
	
	
}
