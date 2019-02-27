import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadLocalDemo extends Thread {

    public static void main(String args[]) {
        
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("hello") ;
        hashSet.add("hello") ;
        
        Hashtable<String,String> t ;
        HashMap<String,String> m ;
        TreeMap<String,String> m1 ;

        BlockingQueue bq = new ArrayBlockingQueue(10) ;
        
        
        System.out.println("world");
//        Thread threadOne = new ThreadLocalDemo();
//        threadOne.start();
//
//        Thread threadTwo = new ThreadLocalDemo();
//        threadTwo.start();
    }

    @Override
    public void run() {
        // sample code to simulate transaction id
        Context context = new Context();
        context.setTransactionId(getName());

        // set the context object in thread local to access it somewhere else
        MyThreadLocal.set(context);

        /* note that we are not explicitly passing the transaction id */
        BusinessService bus =  new BusinessService() ;
        bus.businessMethod();
        MyThreadLocal.unset();

    }
}