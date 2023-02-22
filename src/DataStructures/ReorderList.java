package DataStructures;

import java.util.HashMap;
import java.util.Map;

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
public class ReorderList {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		
		one.next = two;
		two.next = three;
		three.next = four;
		
		reorderList(one);
		
	}
	
    public static void reorderList(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode temp = head;
        int i=0;
        while(temp != null) {
            map.put(i,temp);
            temp = temp.next;
            i++;
        }
        int n = i;
        i = 1;
        int j = n-1,k=0;
        ListNode curr = map.get(0);
        
        while(k < n && i>=0 && j >=0 && curr != null) {
        	System.out.println("Current node is : " + curr.val);
            if(k%2 == 0) {
                curr.next = map.get(j);
                j--;
            }
            else {
                curr.next = map.get(i);
                i++;
            }
            curr = curr.next;
            k++;
            
        }
        
        curr.next = null;
        LinkedList.print(map.get(0));
        
    }
}
