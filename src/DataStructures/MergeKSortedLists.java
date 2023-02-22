package DataStructures;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.key = val; }
 *     ListNode(int val, ListNode next) { this.key = val; this.next = next; }
 * }
 */
public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode temp1 = new ListNode(1);
		ListNode four1 = new ListNode(4);
		ListNode five1 = new ListNode(5);
		temp1.next = four1;
		four1.next = five1;
		
		ListNode temp2 = new ListNode(1);
		ListNode three2 = new ListNode(3);
		ListNode four2 = new ListNode(4);
		temp2.next = three2;
		three2.next = four2;
		
		ListNode temp3 = new ListNode(2);
		ListNode six3 = new ListNode(6);
		temp3.next = six3;
		
		ListNode[] lists = {temp1,temp2,temp3};
		ListNode mergedList = mergeKLists(lists);
		LinkedList.print(mergedList); 
		
		
		
		
	}
    public static ListNode mergeKLists(ListNode[] lists) {
        
        ListNode list  = mergeSort(lists,0,lists.length-1);
        return list;
        
    }
    
    public static ListNode mergeSort(ListNode[] lists,int l,int r) {      
    	if(l == r)
    		return lists[l];
    	else if(l < r && l >=0 && r < lists.length) {
            int mid = (l+r-1)/2;
            ListNode left = mergeSort(lists,l,mid);
            ListNode right = mergeSort(lists,mid+1,r);
            ListNode merge = merge(left,right);
            return merge;
        }
    	else 
    		return null;
        
        
    }
    
    public static ListNode merge(ListNode a,ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode temp1 = a;
        ListNode temp2 = b;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                tail.next = temp1;
                temp1 = temp1.next;
            }
            else {
                tail.next = temp2;
                temp2 = temp2.next;
            }
            tail = tail.next;
        }
        if(temp1 == null) {
            tail.next = temp2;
        }
        if(temp2 == null) {
            tail.next = temp1;
        }
        
        return dummy.next;
    }
}
