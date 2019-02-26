import java.util.Date;

public class DateChecker {
public static void main(String args[]) {
    Date d1 = new Date() ;
    System.out.println(d1.getYear());
    System.out.println(d1.hashCode());
    
    d1.setYear(2078);
    
    System.out.println(d1.getYear());
    System.out.println(d1.hashCode());
    
}
}
