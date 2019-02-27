
public class RemoveBankWorkflow extends BaseUpdateWorkflow {

    public void executeWorkFlow() {
        super.executeWorkflow();
    }
    
    @Override
    public void validateRequest() {
        System.out.println("validate request in remove bank work flow");
    }
}
