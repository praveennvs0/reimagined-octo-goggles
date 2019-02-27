package DataStructures;

public class Queue<T> {

    T array[];
    int front = -1, rear = -1;
     int size = 0;;

    @SuppressWarnings("unchecked")
    public Queue() {
        this.array = (T[]) new Object[10];
    }

    public void enqueue(T e) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = rear + 1;
        }

        array[rear] = e;
        size = size + 1;
    }

    public boolean isEmpty() {
        if (front == -1 && rear == -1)
            return true;

        if (front > rear)
            return true;
        else
            return false;
    }

    public T dequeue() {
        T e = array[front];
        front = front + 1;
        size = size - 1;
        return e;

    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        front = -1;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        System.out.println("Printing the contents of the queue");
        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + ":");

        }
        System.out.println(" ");
    }

    public void printQueueFromRear() {
        System.out.println("Printing the contents of the queue from the rear");
        for (int i = rear; i >= front; i--) {
            System.out.print(array[i] + ":");

        }
        System.out.println(" ");
    }
}
