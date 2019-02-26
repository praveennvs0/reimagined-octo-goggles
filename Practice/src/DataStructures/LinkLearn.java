package DataStructures;

public class LinkLearn {

    public static void main(String args[]) {
        LinkedList l = new LinkedList() ;
        l.insert(1);
        
//        l.insert(3);
//        l.insert(4);
//        l.insert(5);
//        l.insert(6);
//        l.insert(7);
//        l.insert(8);
//        l.insert(9);
//        l.insert(10);
//        l.insert(11);
//        l.insert(12);
        
        System.out.println(" ---Before reversing ");
        l.print(l.head);
        
      //  
        System.out.println(" --- ");
        
        ListNode reverse = l.reverseKgroups(l.head,2);
        System.out.println("After reversing ");
        l.print(reverse);
        
        
    }
}
