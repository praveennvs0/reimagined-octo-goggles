import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class letterCasePerm {
    
    
public static void main(String args[]) {
   String s = "AbCd" ;
   Set<String> resultSet = new HashSet<String>() ;
   letterCase("",s,resultSet) ;
   
   Iterator<String> iter = resultSet.iterator();
   System.out.println("no. of letter case permutations " + resultSet.size());
   while (iter.hasNext()) {
       System.out.println(iter.next());
   }
}

public static void letterCase(String prefix,String s,Set<String> resultSet){
    
    if(prefix.length()==4){
       resultSet.add(new String(prefix)) ;
    }
    
    for(int i=0 ; i < s.length() ; i++) {
        Character lowerCase = s.charAt(i) ;
        prefix = prefix + String.valueOf(Character.toLowerCase(lowerCase)) ;
        letterCase(prefix,s.substring(i+1,s.length()),resultSet) ;
        
        
        //
       prefix = prefix.substring(0,prefix.length()-1) ;
       Character upperCase = s.charAt(i) ;
       prefix = prefix + String.valueOf(Character.toUpperCase(upperCase)) ;
       
       letterCase(prefix,s.substring(i+1,s.length()),resultSet) ;
       
    }
}
}

