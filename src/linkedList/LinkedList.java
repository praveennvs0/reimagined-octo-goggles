package linkedList;

public class LinkedList {
	
	private static Node head ;
	private static Node tail ;
	
	public static void main(String[] args) {
		
		add(1);
		display(head);
		add(2);
		display(head);
	}
	
	
	public static void add(int key) {
		// add at the end
		Node newNode = new Node(key);
		
		if(head == null && tail == null) {
			head = newNode;
			tail = newNode;
			return ;
		}
		
		tail.next = newNode ;
		tail = tail.next;
		
	}
	
	public static void display(Node node) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.key);
			System.out.print(":");
			temp=temp.next;
		}
		System.out.println();
	}
	
	
	public static void get(int key) {
		
	}
	
	public static void remove(int key) {
		
		boolean elementFound = false;
		Node temp = head;
		
		if(head.key == key) { // first element
			head = head.next;
			return;
		}
		
		while(temp!= null) {
			if(temp.next != null && temp.next.key == key) { // intermediate elements
				Node temp = n
				temp.next = temp.next.next;
			    elementFound = true;
			    //temp 3 .. 1->2->3->4  ..del 4
			    
				break;
			}
			
			
			
			temp = temp.next;
		}
		
		if(!elementFound) {
			System.out.println("Element does not exist");
			
		}
		
	}

}
