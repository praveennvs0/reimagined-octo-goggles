
public interface InterfaceB {
    default void m() { System.out.println("hello from B"); } 
    default void m2B() { System.out.println("hello2 from B"); } 
}
