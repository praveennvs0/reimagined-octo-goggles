package DataStructures;

public class ListNode {

    
    
    public int key ;
    public ListNode next ; 
    boolean visited ;
    
    
    public ListNode(int x) {
        setKey(x) ;
    }


    public int getKey() {
        return key;
    }


    public void setKey(int key) {
        this.key = key;
    }


    public ListNode getNext() {
        return next;
    }


    public void setNext(ListNode next) {
        this.next = next;
    }
}
