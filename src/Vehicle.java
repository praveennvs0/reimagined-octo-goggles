public interface Vehicle{
 
    default void drive() {
        System.out.println("Vehicle is driving");    
    }
 
   
    default void applyBreaks(){
        System.out.println("Vehicle is applying breaks");    
    }
    
     default void applyBreaks2(){
        System.out.println("Vehicle is applying breaks");    
    }
}