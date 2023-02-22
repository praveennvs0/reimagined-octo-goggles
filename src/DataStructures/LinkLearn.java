package DataStructures;

public class LinkLearn {
	
	static ListNode left;
	static ListNode head ;

    public static void main(String args[]) {
       LinkedList l = new LinkedList();
       l.insert(1);
       l.insert(2);
       l.insert(3);
       l.insert(2);
       l.insert(1);
       head = l.head;
       
       boolean isPalindrome = isPalindrome(head);
       if(isPalindrome) 
    	   System.out.println("It is a palindrome");
       else
    	   System.out.println("Not a palindrome");
        
    }
    
   private static boolean isPalindromeUtil(ListNode right) 
    { 
        left = head; 
  
        /* stop recursion when right becomes NULL */
        if (right == null) 
            return true; 
  
        /* If sub-list is not palindrome then no need to 
           check for current left and right, return false */
        boolean isp = isPalindromeUtil(right.next); 
        if (isp == false) 
            return false; 
  
        /* Check values at current left and right */
        boolean isp1 = (right.val == (left).val); 
  
        /* Move left to next node */
        left = left.next; 
  
        return isp1; 
    } 
  
    // A wrapper over isPalindromeUtil() 
    static boolean isPalindrome(ListNode head) 
    { 
        boolean result = isPalindromeUtil(head); 
        return result; 
    } 
  
}
