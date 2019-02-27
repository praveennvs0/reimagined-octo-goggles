
public class Rackets extends TennisDecorator {
   
    
    public  Rackets(CourtBooking cb) {
        super(cb) ;
    }
    
    @Override
    public int cost() {
        // TODO Auto-generated method stub
        return 50 + cb.cost();
    }
    
}
