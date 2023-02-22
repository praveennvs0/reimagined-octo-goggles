package DataStructures;


	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int key;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int key) { this.key = key; }
	 *     ListNode(int key, ListNode next) { this.key = key; this.next = next; }
	 * }
	 */
	public class RemoveDuplicatesFromSortedList {
		
		public static void main(String[] args) {
			ListNode one = new ListNode(1);
			ListNode one2 = new ListNode(1);
			ListNode two = new ListNode(2);
			
			one.next = one2;
			one2.next = two;
			
			
			ListNode newSorted = deleteDuplicates(one) ;
			LinkedList.print(newSorted);
			
			
		}
		
	    public static ListNode deleteDuplicates(ListNode head) {
	    	
	    	
	        
	        ListNode temp = head ;
	        ListNode prev = null;
	        ListNode firstNonRepeatingElement = null;
	        boolean flag = false;
	        while(temp != null) {
	            if(temp.next != null && temp.val != temp.next.val) {
	                prev = temp;
	                if(!flag) {
	                firstNonRepeatingElement = temp;
	                    flag = true;
	                }
	                temp = temp.next;
	                
	            }
	            
	            else if(temp.next == null) {
	            	if(!flag)
	            		firstNonRepeatingElement = temp;
	            	temp = temp.next;
	            	
	            }
	            
	            else { 
	                 ListNode tempDup = temp;
	                  while(tempDup != null && tempDup.next != null && tempDup.val == tempDup.next.val)  {
	                      tempDup = tempDup.next;
	                  }
	                
	                if(prev == null) { // first element is repeating
	                    temp = tempDup.next;
	                }
	                
	                
	                
	                else  {
	                prev.next = tempDup.next;
	                temp = tempDup.next;
	                }
	            }
	            
	            
	            
	            
	            
	        }
	        return firstNonRepeatingElement;
	    }
}
