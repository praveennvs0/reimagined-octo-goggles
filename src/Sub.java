import java.util.Date;

public final class Sub extends Super{

    
    public Sub(){
        System.out.println("Constructor of sub invoked");
    }
    
    @Override
    public void overrideMe() {
        System.out.println("sub class method invoked");
    }
    
}
