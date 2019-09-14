package DataStructures;

public class ReverseKGroups {

	 public static void main(String args[]) {
	        LinkedList l = new LinkedList() ;
	        
	        l.insert(15);
	        l.insert(2);
	        
	        l.insert(4);
	        l.insert(7);
	        l.insert(10);
	        l.insert(3);
	        l.insert(1);
	        l.insert(8);
	        l.insert(6);

	        System.out.println("Elements Of the List are : ");
	        LinkedList.print(l.head);
	        
	        int k=3;
	      ListNode reverseHead =  reverseKGroups(l.head,k) ;
	       

	        System.out.println("Elements Of the List after reversing are : ");
	        LinkedList.print(reverseHead);
//	        
	    }

	private static ListNode reverseKGroups(ListNode head, int k) {
		
		ListNode current = head ;
		int noofProcessedElements = 0;
		int size = computeSizeOfList(head);
		if(size < k)
			return head ;
		
		boolean isHeadFound = true ;
		ListNode prev = null;
		ListNode reverseHead = null ;
		while(size - noofProcessedElements >=k) {
		

        ListNode futurePointer = evaluateFuturePointer(current,k) ;
		
        
        ListNode currentReversed = reverseKElements(current,k);
        
        if(prev != null)
        prev.next = currentReversed ;
        
       
		if(isHeadFound ) {
			reverseHead = currentReversed ;
			isHeadFound = false ;
		}
		
        current.next = futurePointer ;
        
        System.out.println();
        
        prev = current ;
        current = current.next ;
		
		
		
		noofProcessedElements = noofProcessedElements + k ;
		
		}
		
		
		return reverseHead ;
	}

	private static ListNode evaluateFuturePointer(ListNode current, int k) {
		ListNode futurePointer =current; 
		int i=0;
		while(i<k) {
			if(futurePointer != null) {
				futurePointer = futurePointer.next;
			i++;
			}
		}
		
		return futurePointer;
	}

	private static int computeSizeOfList(ListNode head) {
		int size = 0;
		
		ListNode current = head ;
		while(current!=null) {
			size++;
			current=current.next;
		}
		return size;
	}

	private static ListNode reverseKElements(ListNode head, int k) {
		ListNode prev = null ;
		ListNode curr = head ;
		ListNode next = null ; 
		
		int i=0;
		while (i < k) {
			next = curr.next ;
			curr.next = prev;
			prev = curr ;
			curr = next ;
			i++;
		}
		
		return prev;
	}
}
