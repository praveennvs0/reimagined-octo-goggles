package DataStructures;

public class MainClass1 {

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>() ;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printElements(); 
        stack.pop();
        
        stack.printElements(); 
        
        Queue<Integer> queue = new Queue<Integer>() ;
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        
        queue.printQueue();
        
        queue.dequeue() ;
        queue.printQueue();
        
        
        
    }
}
