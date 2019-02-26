
public class Singleton {

    private static  Singleton instance ;
    
    
    private Singleton() {
        
    }
    
    public static synchronized Singleton getInstance() {
        System.out.println("entering get instance method");
        if(instance == null) {
            System.out.println("entering first condition");
            synchronized(Singleton.class) {
                System.out.println("inside synchronized block");
                if(instance == null){
                    instance = new Singleton() ;
                    System.out.println("instance is created");
                    
                }
            }
            
            
            
            
        }
        
        return instance ;
        
    }
    
  
}
