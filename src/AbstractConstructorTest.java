public class AbstractConstructorTest {

    public static void main(String args[]) {
       Server server = new Tomcat("Apache Tomcat");
      // server.start();
    }
}

abstract class Server{
    protected String name="";
    
    public Server() {
    	System.out.println("default constructor superclass") ;
    }
    
    public Server(String name){
    	System.out.println("super class constructor invoked") ;
        this.name = name;
    }
   
    public abstract boolean start();
}

class Tomcat extends Server{
   
    public Tomcat(String name){
    	//super(name) ;
    	super(name) ;
        System.out.println("child class constructor invoked") ;
        
       
    }

    @Override
    public boolean start() {
       System.out.println( this.name + " started successfully");
       return true;
    }
   
}