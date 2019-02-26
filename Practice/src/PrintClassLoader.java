import java.util.ArrayList;
import java.util.logging.Logger;

public class PrintClassLoader {

    public static void printClassLoaders() throws ClassNotFoundException {
        
        System.out.println("Classloader of this class:"
            + PrintClassLoader.class.getClassLoader());
     
        System.out.println("Classloader of Logging:"
            + Logger.class.getClassLoader());
     
        System.out.println("Classloader of ArrayList:"
            + ArrayList.class.getClassLoader());
    }
    
    public static void main(String args[]) {
        try {
            printClassLoaders() ;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
