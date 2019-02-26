package DataStructures;

public class Stack2 {

    public static void main(String args[]) {
        StackUsingQueue<Integer> stack = new StackUsingQueue<Integer>() ;
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        stack.printElementsFromTop();
        
        stack.pop();
        stack.printElementsFromTop();
        
        stack.push(4);
        stack.printElementsFromTop();
    }
}
