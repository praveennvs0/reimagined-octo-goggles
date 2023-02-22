package DataStructures;

import java.util.List;

public class LinkedList {

    ListNode head ;
    
    
    //inserts at the head of the linked list
    public void insert(int x)
    {
        
        ListNode newNode = new ListNode(x) ;
        newNode.setNext(head);
        head =  newNode ;
            
        }
        
    
    public void append(int x) {
    	ListNode newNode = new ListNode(x);
    	
    }
    
    public static void print(ListNode n){
        ListNode temp = n ;
        System.out.println("elements in the list are : ") ;
        while(temp != null) {
            System.out.print(temp.getKey()+" : ");
            temp = temp.getNext() ;
            
        }
        System.out.println();
        
        
    }
    
    
        /* Function to reverse the linked list */
    public ListNode reverse(ListNode node) { 
        ListNode prev = null; 
        ListNode current = node; 
        ListNode next = null; 
            while (current != null) { 
                next = current.next; 
                current.next = prev; 
                prev = current; 
                current = next; 
            } 
            node = prev; 
            return node; 
        } 
    
    
    
    public ListNode reverseKgroups(ListNode node,int k) {
        System.out.println("reversal of k groups begins") ;
        ListNode current = node ;
        int processedElements = 0 ;// tracks the no. of elements reversed so far
        int size = computeSizeOfList(node) ;
        
        if(size < k) 
            return node ;
        ListNode head = node ;
        ListNode futureTail = null ;
        boolean evalHead = true ;
        while(current != null && size-processedElements >=k  ) {
            
        ListNode futurePointer = evalFuture(current,k) ;
        
         ListNode currentReversed = reverse(current,k) ;
         futureTail = current ;
        ListNode prev = current ;
        
        if(evalHead){
        head = currentReversed ;
        evalHead = false ;
        }
        
        ListNode linkInNextList = evalFuture(futurePointer,k - 1) ;
        prev.next = linkInNextList ;
        current = futurePointer ;
        processedElements = processedElements + k ;
        }
        
        
        if(processedElements < size) 
            futureTail.next = current ;
            //We are not done yet ! There are some elements at the end of the list that were left out as their number was less than k grouping.
            //Occurs when the size of the list is not a multiple of k
          
        return head ;
        
        
        
    }



    private int computeSizeOfList(ListNode node) {
        // TODO Auto-generated method stub
        int size = 0 ;
        while(node != null) {
            node = node.next ;
            size++ ;
        }
        return size ;
    }



    private ListNode reverse(ListNode node,int k) {
        // reverse only k number of elements
        int i = 0 ;
        ListNode prev = null; 
        ListNode current = node; 
        ListNode next = null; 
            while ( i < k) { 
                next = current.next; 
                current.next = prev; 
                prev = current; 
                current = next; 
                i++ ;
            } 
            node = prev; 
            return node; 
        
    }



    private ListNode evalFuture(ListNode node,int k) {
        //evaluates the future node by pushing the current node by Kgrouping number of times
        for( int i=0;i<k;i++) {
            if(node != null) 
            node = node.next ;
        }
        
            return node ;
    }
    
    public static void displayList(List<Integer> list){
    	System.out.println();
        for(Integer i: list) {
          System.out.print(i);
          System.out.print(":");
      }
    }
    
    public static void traverse(ListNode node) {
    	 ListNode prev = null; 
         ListNode current = node; 
         ListNode next = null;
    	
    	while(current != null) {
    	
    		
    		
    		prev = current ;
    		current = current.next ;
    		
    	
    	}
    }



}
