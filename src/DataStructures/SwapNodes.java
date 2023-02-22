package DataStructures;

public class SwapNodes {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		one.next = two;
		//two.next = three;
//		three.next = four;
//		four.next = five;
//		five.next= six;
		LinkedList.print(one);
		
		ListNode swapped = swapPairs(one);
		
		LinkedList.print(swapped);
		
		
		
	}
	
	public static ListNode swapPairs(ListNode head) {
        if(head== null || head.next == null)
            return head;
        
        if(head.next.next == null) {
          ListNode temp = head;
          head = head.next;
          head.next = temp;
          head.next.next = null;
          return head;
          
        }
        
        ListNode temp = head;
        ListNode first=temp,second=first.next;
        ListNode headToReturn = first;
        ListNode nextFirst,nextSecond,tail=head;
        boolean headFound = true;
        while(temp != null) {
        	first = temp;
            second = temp.next;
        	
            if(second == null) {
            	tail.next = first;
            	break;
            }
        	nextFirst = second.next;
            if(nextFirst == null) {
            	 ListNode temp1 = first;
                 first = second;
                 second = temp1;
                 first.next = second;
                 second.next = null;
            	break;
            }
            nextSecond = nextFirst.next;
            
            // swap the first and the second nodes
            ListNode temp1 = first;
            first = second;
            second = temp1;

            //important... assigning second node as first.next;
            first.next = second;
            
            second.next = nextSecond;
            tail = second;
            
            if(headFound) {
            	headToReturn = first;
            	headFound = false;
            }
            temp = nextFirst;
            
            
        }
     
        
        return headToReturn;
    }

}
