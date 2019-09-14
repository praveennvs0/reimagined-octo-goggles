public class DisplayJob implements Runnable 
{ 
      
    private TestResource test; 
    DisplayJob(TestResource tr) 
    { 
        test = tr; 
    } 
    @Override
    public void run()  
    { 
        System.out.println("display job"); 
        test.displayRecord(new Object()); 
    } 
} 