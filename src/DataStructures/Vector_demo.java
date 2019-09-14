package DataStructures;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

public class Vector_demo { 
    public static void main(String[] arg) 
    { 
  
        // create default vector 
        Vector v = new Vector(); 
  
        v.add(1); 
        v.add(2); 
        v.add("geeks"); 
        v.add("forGeeks"); 
        v.add(3); 
  
        System.out.println("Vector is " + v); 
        
        
        ArrayList l = new ArrayList();
        l.add(1);
        l.add("geeks");
        System.out.println("List is " + l); 
    } 
}