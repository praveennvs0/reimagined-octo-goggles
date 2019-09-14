public class ReadJob implements Runnable 
{ 
      
    private TestResource test; 
      
    ReadJob(TestResource tr) 
    { 
        test = tr; 
    } 
    @Override
    public void run()  
    { 
        System.out.println("read job"); 
        test.readRecord(new Object()); 
    } 
} 