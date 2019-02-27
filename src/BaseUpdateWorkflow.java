
public abstract class BaseUpdateWorkflow {

    
    public void executeWorkflow() {
        System.out.println("execute work flow in base update");
        validateRequest() ;
    }

    public  void validateRequest() {
        System.out.println("validate request in base update");
    }
}
