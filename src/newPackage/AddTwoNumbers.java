package newPackage;

import DataStructures.LinkedList;
import DataStructures.ListNode;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode two = new ListNode(2);
		ListNode four = new ListNode(4);
		ListNode nine = new ListNode(9);
		
		two.next = four;
		four.next = nine;
		
		LinkedList.print(two);
		
		ListNode five2 = new ListNode(5);
		ListNode six2 = new ListNode(6);
		ListNode four2 = new ListNode(4);
		ListNode nine2 = new ListNode(9);
		
		five2.next = six2;
		six2.next = four2;
		four2.next = nine2;
		
		LinkedList.print(five2);
		
		ListNode sum = addTwoNumbers(two,five2);
		System.out.println("The sum is : " );
		LinkedList.print(sum);
	}
	
	
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
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
	        ListNode sum = null;
	        int carry = 0;
	        
	        ListNode temp1 = l1, temp2 = l2;
	        int len1 = getLength(l1);
	        int len2 = getLength(l2);
	        
	        if(len1 > len2) {
	        	addZeroes(l2,len1-len2);
	        	LinkedList.print(l2);
	        }
	        else if (len1 < len2) {
	        	addZeroes(l1,len2-len1);
	        	LinkedList.print(l1);
	        }
	        
	        
	        
	        while(temp1 != null && temp2 != null) {
	             int digit = temp1.val + temp2.val + carry ;
	             if(digit <= 9) {
	            	carry = 0;
	                sum = addAtTheEnd(sum,digit);
	             }
	             else {
	                 carry = 1;
	                 sum = addAtTheEnd(sum,digit-10);
	             }
	        
	             temp1 = temp1.next ;
	             temp2 = temp2.next;
	    }
	        
	        if(carry == 1) 
	        	sum = addAtTheEnd(sum,1);
	    return sum;
	    }
	    
	    private static void addZeroes(ListNode l,int num) {
	    	ListNode temp = l;
	    	while(temp.next != null) {
	    		temp = temp.next;
	    	}
	    	
	    	while(num > 0 ) {
	    	temp.next = new ListNode(0);
	    	temp = temp.next;
	    	num--;
	    	}
	    }
	    
	    private static int getLength(ListNode l1) {
		int len = 0;
		ListNode temp = l1;
		while(temp != null) {
			temp = temp.next;
			len++;
		}
		return len;
	}


		public static ListNode addAtTheEnd(ListNode head,int digit) {
	    	    if(head == null) {
	    	    	ListNode l = new ListNode(digit);
	    	    	return l;
	    	    }
	            ListNode newNode = new ListNode(digit);
	            ListNode temp = head ;
	            while(temp.next != null) {
	            	temp = temp.next;
	            }
	            temp.next = newNode;
	            return head;
	          
	}

}
