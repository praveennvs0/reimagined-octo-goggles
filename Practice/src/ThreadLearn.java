
public class ThreadLearn implements Runnable{
    private static final ThreadLocal<Table> obj = new ThreadLocal<Table>() {
      
        @Override
        protected Table initialValue()
        {
            return new Table();
        }
    };

    public static void main(String args[]) throws InterruptedException {
        
        Table obj = new Table();
      MyThread1 t1= new MyThread1(obj) ;
      t1.start();
      
      t1.wait(10); 
      
      MyThread2 t2= new MyThread2(obj) ;
      t2.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
}
