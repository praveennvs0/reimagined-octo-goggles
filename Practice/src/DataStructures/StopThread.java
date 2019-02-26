package DataStructures;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested ; 
    
    public static void main(String args[]) throws InterruptedException {
        
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i=0;
                long start = System.currentTimeMillis() ;
                while(!stopRequested)
                {
                    i++ ;
                }
                System.out.println(stopRequested);
                System.out.println(i);
                long end = System.currentTimeMillis() ;
                long timetaken = end-start ;
                System.out.println("time taken in seconds: " + timetaken/1000);
            }
        });
            backgroundThread.start(); 
            TimeUnit.SECONDS.sleep(1);
            stopRequested = true ;
        }
    }


