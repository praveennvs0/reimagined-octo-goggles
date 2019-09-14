import java.util.concurrent.*;
 
/**
 * SimpleScheduledExecutorExample.java
 *
 * This program demonstrates how to schedule a task to execute after
 * a given delay.
 *
 * @author www.codejava.net
 */
public class SimpleScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler
                            = Executors.newSingleThreadScheduledExecutor();
 
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Hi!");
            }
        };
 
        int delay = 5;
        scheduler.schedule(task, delay, TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}