package DataStructures;

import newPackage.CommonUtils;

public class leetcode1721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		swapNodes(one,2);
		
		
		
	}

	
	    public static ListNode swapNodes(ListNode head, int k) {
	        int size = 0;
	        ListNode first=head,second=head;        
	    
	        int i=0;
	        while(i<k-1) {
	           first = first.next;
	            i++;
	        }
	        System.out.println("first value is : " + first.val);
	        
	        int firstVal = first.val;
	        
	        while(first.next != null) {
	            first = first.next;
	            second = second.next;
	        }
	        
	        
	        int temp1 = firstVal;
	        first.val = second.val;
	        second.val = temp1;
	        
	        return head;
	    }
}
