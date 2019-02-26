public class Class1 implements Constants {

    public static final int CONSTANT3 = 2;   // *

    public static void main(String args[]) throws Exception {
        System.out.println(CONSTANT3);
        System.gc();
    }
}