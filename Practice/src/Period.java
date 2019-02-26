import java.util.Date;

public final class Period {

    private final Date start ;
    private final Date end ;
    

    public Period(Date start,Date end) {
        if(start.compareTo(end) > 0)
            throw new IllegalArgumentException(start+ " after " + end) ;
        this.start = new Date(start.getTime()) ;
        this.end = new Date(end.getTime()) ;
//        
//        this.start = start ;
//        this.end = end ;
    }
    
    
    public Date start(){
        return start;
    }
    
    public Date end(){
        return end ;
    }
    
}
