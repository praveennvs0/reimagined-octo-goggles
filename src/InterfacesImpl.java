

class InterfacesImpl implements InterfaceA,InterfaceB {

//    @Override
//    public void m() {
//        // TODO Auto-generated method stub
//      //  InterfaceB.super.m(); 
//    System.out.println("my own method") ;
//    }
//    




    public static void main(String[] args) {
        InterfacesImpl obj = new InterfacesImpl();
        obj.m2B();
        obj.m2();
        obj.m();
        
//        
  
//        
        //all the method calls below are going to same concrete implementation
    
     
    }

@Override
public void m() {
	// TODO Auto-generated method stub
	InterfaceA.super.m();
	
}


}