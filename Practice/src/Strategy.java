
public enum Strategy {

    Strategy_A{
        @Override
        public void execute() {
            System.out.print("Executing strategy A");
        }
    },
    
    Strategy_B{
        @Override
        public void execute(){
            System.out.println("Executing strategy B");
        }
    };

    public abstract void execute() ;
};
    
