//package DataStructures;
//
// class Solution {
//    
//    class ListNode {
//            int val;
//             ListNode next;
//             boolean visited ;
//             ListNode(int x) {
//                 val = x;
//                 next = null;
//             }
//         }
//
//    public static void main(String args[]) {
//        Solution lc = new Solution() ;
//        
//        Solution.ListNode  one = lc.new ListNode(1) ;
//        Solution.ListNode two = lc.new ListNode(2) ;
//        Solution.ListNode three = lc.new ListNode(3);
//        Solution.ListNode four = lc.new ListNode(4) ;
//        one.next = two ;
//        two.next = three ;
//        three.next = four ;
//        four.next = two ;
//        
//        boolean hasCycle = hasCycle1(one) ;
//        System.out.println("hasCycle : "+hasCycle);
//        
//    }
//    
//    
// public static boolean hasCycle1(ListNode head) {
//     ListNode temp = head ;
//     while(temp!=null) {
//         temp.visited=true;
//         if(temp.next!=null && temp.next.visited==true)
//             return true ;
//         
//         temp = temp.next ;
//     }
//    return false;
//        
//    }
// 
// public static boolean hasCycle2(ListNode head) {
//     ListNode temp = head ;
//     ListNode[] visited ;
//     int i;
//     while(temp!=null) {
//         visited[i] = temp ;
//         if(temp.next!=null && temp.next.visited==true)
//             return true ;
//         
//         temp = temp.next ;
//     }
//    return false;
//        
//    }
//}
