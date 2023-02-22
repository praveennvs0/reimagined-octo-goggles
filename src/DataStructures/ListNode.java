package DataStructures;

public class ListNode {

    
    
    public int val ;
    public ListNode next ; 
    boolean visited ;
    
    
    public ListNode(int x) {
        setKey(x) ;
    }


    public int getKey() {
        return val;
    }


    public void setKey(int key) {
        this.val = key;
    }


    public ListNode getNext() {
        return next;
    }


    public void setNext(ListNode next) {
        this.next = next;
    }
}
