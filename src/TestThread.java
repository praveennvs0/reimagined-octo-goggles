
// Java program to control the Main Thread 
public class TestThread extends Thread 
{ 
    public static void main(String[] args) throws InterruptedException 
    { 
        // getting reference to Main thread 
        Thread t = Thread.currentThread(); 
        t.start();
          t.join();
        // getting name of Main thread 
        System.out.println("Current thread: " + t.getName()); 
          
        // changing the name of Main thread 
        t.setName("Geeks"); 
        System.out.println("After name change: " + t.getName()); 
          
        // getting priority of Main thread 
        System.out.println("Main thread priority: "+ t.getPriority()); 
          
        // setting priority of Main thread to MAX(10) 
        t.setPriority(MAX_PRIORITY); 
          
        System.out.println("Main thread new priority: "+ t.getPriority()); 
          
          
} 
}