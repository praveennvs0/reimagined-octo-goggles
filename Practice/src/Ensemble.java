
public enum Ensemble {
SOLO,DUET,TRIO ;
    
    public int numberOfMusicians() {
        return ordinal() + 1 ;
    }
}
