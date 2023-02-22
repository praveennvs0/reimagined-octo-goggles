package DataStructures;

public class FlattenDoublyLinkedList {
	
public static void main(String[] args) {
	
	DLL dll = new DLL();
	Node one = new Node(1);
	Node two = new Node(2);
	Node three = new Node(3);
	Node four = new Node(4);
	Node five = new Node(5);
	Node six = new Node(6);
	Node seven = new Node(7);
	Node eight = new Node(8);
	Node nine = new Node(9);
	Node ten = new Node(10);
	Node eleven = new Node(11);
	Node twelve = new Node(12);
	
	one.next = two ;
	two.prev = one;
	
	two.next = three;
	three.prev = two;
	
	three.next = four;
	four.prev = three;
	three.child = seven;
	
	four.next = five;
	five.prev = four;
	
	five.next = six;
	six.prev = five;
	
	seven.next = eight;
	eight.prev = seven;
	
	eight.next = nine;
	nine.prev = eight;
	eight.child = eleven;
	
	nine.next = ten;
	ten.prev = nine;
	
	eleven.next = twelve;
	twelve.prev = eleven;
	
	dll.printlist(one);
	System.out.println("Flattening the list");
	flatten(one);
}

public static void flatten(Node node) {
	Node head = null;
	flatten(node,head);
	
}

private static void flatten(Node node, Node head) {
	System.out.print(node.data);
	System.out.print("->");

	if(node.child != null)
		flatten(node.child);
	
	if(node.next != null)
		flatten(node.next);	
}


}
