package DataStructures;

public class OddEvenLinkedList {

	
	public static void main(String[] args) {
	    ListNode one = new ListNode(1);
//	    ListNode two = new ListNode(2);
//	    ListNode three = new ListNode(3);
//	    ListNode four = new ListNode(4);
//	    ListNode five = new ListNode(5);
//	    
//	    one.next = two;
//	    two.next = three;
//	    three.next = four;
//	    four.next = five;
	    
	    ListNode result = oddEvenList(one);
	    LinkedList.print(result);
		
	}
	
	    public static ListNode oddEvenList(ListNode head) {
	        ListNode oddHead=null,oddTail=null,evenHead=null, evenTail=null,temp;
	        int i=1;
	        temp = head;
	        while(temp != null) {
	            if(i % 2 == 0) {
	                if(evenHead == null) {
	                    evenHead = temp;
	                    evenTail = temp;
	                }
	                else {
	                    evenTail.next = temp;
	                    evenTail = evenTail.next;
	                }
	                
	            }
	            else{
	                 if(oddHead == null) {
	                    oddHead = temp;
	                    oddTail = temp;
	                }
	                else {
	                    oddTail.next = temp;
	                    oddTail = oddTail.next;
	                }
	            }
	            temp = temp.next;
	            i++;
	        }
	        evenTail.next = null;
	        oddTail.next = evenHead;
	        return oddHead;
	    }
}
