
public abstract class TennisDecorator extends CourtBooking {
    protected CourtBooking cb ;
    public TennisDecorator(CourtBooking cb) {
        this.cb = cb;
    }

}
