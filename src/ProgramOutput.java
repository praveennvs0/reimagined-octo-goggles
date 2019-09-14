public class ProgramOutput {

    public static void main(String args[]) {
    	//Superclass2 class3 = new Subclass2();
    	
    	Subclass2 class2 = new Subclass2();
    	
    }
}

 class Superclass2{
    public Superclass2(){
    	System.out.println("super class constructor invoked") ;
    }
   
}
 
class Subclass2 extends Superclass2{
    public Subclass2(){
        System.out.println("child class constructor invoked") ;
    }

   
}