package DataStructures;

public class PlayGround {

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
//		list.insert(3);
		list.insert(2);
		list.insert(1);
//		list.insert(6);
//		list.insert(7);
//		
		ListNode head = list.head;
		LinkedList.print(head);
		
		boolean isPalinDrome = isPalinDrome(head) ;
		if(isPalinDrome)
		System.out.println("It is a palindrome") ;
		else
	    System.out.println("Not a palindrome");
			
	}

	private static boolean isPalinDrome(ListNode head) {
		int size = computeSize(head);
		
		int i=0;
		ListNode curr=head,prev=null,next=null ;
		while(i< size/2 ) {
		   next = curr.next ;
		   curr.next = prev ;
		   prev = curr ;
		   
		   curr = next ;
		   i++;
		   
		}
		
		boolean areContentsSame = checkContents(prev,curr,size); 
		
		
		return areContentsSame;
	}

	private static boolean checkContents(ListNode prev, ListNode curr,int size) {
		ListNode temp1 = prev;
		ListNode temp2 = curr ;
		if(size % 2 == 1 && curr !=null) 
			temp2 = curr.next;
		while(temp1 != null && temp2 !=null ) {
			if(temp1.key != temp2.key )
				return false;
			temp1=temp1.next;
			temp2=temp2.next;
			
		}
		
		return true;
	}

	private static int computeSize(ListNode head) {
		int size = 0;
		for(ListNode temp = head; temp != null ; temp=temp.next) {
		  size++;	
		}
		
		return size;
	}
}
