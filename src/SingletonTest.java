

public class SingletonTest {

    public static void main(String args[]) {
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                Singleton s1 = Singleton.getInstance();
                
            }
            
        }) ;
        
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                Singleton s2 = Singleton.getInstance();
                
            }
            
        }) ;
        
        t1.start();
        t2.start();
        
    }
}
