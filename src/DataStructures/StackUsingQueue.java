package DataStructures;

public class StackUsingQueue<T> {

    Queue<T> primaryQueue ;
    Queue<T> secondaryQueue ;
    

@SuppressWarnings("unchecked")
public StackUsingQueue() {
    primaryQueue = new Queue<T>() ;
    secondaryQueue = new Queue<T>() ;
}

    
    public void push(T e) {
        
        primaryQueue.enqueue(e);
    }
    
    
    public void pop() {
        int  size = primaryQueue.size() ;
        secondaryQueue.clear(); 
        
        for(int i=0; i <size-1 ; i++) {
            T element = primaryQueue.dequeue() ;
            secondaryQueue.enqueue(element);
            
        }
        
        //Copy secondaryQueue into PrimaryQueue
        primaryQueue.front = secondaryQueue.front ;
        primaryQueue.rear = secondaryQueue.rear ;
        primaryQueue.array = secondaryQueue.array ;
        primaryQueue.size = secondaryQueue.size ;
                
        
    }
    
   private Queue<T> copyQueue(Queue<T> secondaryQueue2) {
       
       return null;
    }


public void printElementsFromTop() {
       primaryQueue.printQueueFromRear(); 
   }
}
