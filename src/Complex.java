
public  class Complex {

    private final double re;
    private final double im;
    
    
    public Complex(double re,double im) {
        this.re = re;
        this.im = im ;
    }
    
    public void print() {
        System.out.println("hello");
    }
    
    public double realPart() {
        return re; }
    
    public double imaginaryPart(){
        return im;
    }
    
    public Complex add(Complex c) {
        return new Complex(re+c.re,im+c.im) ;
    }
}
