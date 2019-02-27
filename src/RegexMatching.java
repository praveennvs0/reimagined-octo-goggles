import java.util.HashMap;
import java.util.Map;

public class RegexMatching {
    
    


    public static void Regex(String s, String pattern) {
        Map<Character,String> solMap = new HashMap<Character,String>() ;
        RegexMatch(s,pattern,"",solMap,0,pattern,new HashMap<Character,String>(),false) ;
        
    }
    
    private static boolean RegexMatch(String s, String pattern, String current, Map<Character, String> solMap,int currentIndex,String originalpattern, HashMap<Character, String> currentMap2,
            boolean solutionFound) {

        for(int i=0;  i < s.length() ; i++) {
           
            current= current + s.charAt(i) ;
            
            solMap.put(originalpattern.charAt(currentIndex), current) ;
             
             char temp = originalpattern.charAt(currentIndex) ;
             
             String replacedPattern = replaceAndGetAString(pattern,temp,'X') ;
             
             
             int compartmentsInString = findNoOfCompartments(s.replaceAll(current, "X")) ;
             int compartmentsInreplacedPattern = findNoOfCompartments(replacedPattern) ;
             
             int emptyCompartmentsInString = findNoOfEmptyCompartments(s.replaceAll(current, "X")) ;
             int emptyCompartmentsInreplacedPattern = findNoOfEmptyCompartments(replacedPattern) ;
             
             int xCountString = findNoOfX(s.replaceAll(current, "X")) ;
             int XCountInreplacedPattern = findNoOfX(replacedPattern) ;
             
             
             
             if(solutionFound(s.replaceAll(current, "X"),replacedPattern)) {
                 System.out.println("solution map is : " + solMap);
                 solutionFound = true ;
                 
                 return true;
             }
             
             
             if(compartmentsInString == compartmentsInreplacedPattern && emptyCompartmentsInString == emptyCompartmentsInreplacedPattern
                     && xCountString == XCountInreplacedPattern ) { // right way of partitioning the String
             
             
                 String splitString[] = s.replaceAll(current,"X").split("X") ;
                 
                 System.out.println("Split string is : " ) ;
                 printStringArray(splitString) ;
                 
                 String splitPattern[]=replacedPattern.split("X") ;
                 System.out.println("Split pattern is : " );
                 printStringArray(splitPattern) ;
                 
                 int oldCopy = currentIndex ;
                 int newIndex = goToNextIndex(replacedPattern,currentIndex) ;
                 
                 
                 
                 for(int k=0;k< splitString.length ; k++) {
                     if(splitString[k] == null || splitString[k] == "" || splitString[k].isEmpty()) {
                         continue ;
                     }
                     else {
                         
                         newIndex = goToNextIndex(replacedPattern,currentIndex) ;
                         
                     HashMap<Character,String> currentMap = new HashMap<Character,String>(solMap); 
                     String tempString = splitString[k] ;
                     String tempPat = splitPattern[k] ;
                    boolean innerMatch = RegexMatch(tempString,tempPat,"",solMap,newIndex,originalpattern,currentMap,false ) ;
                     
                     System.out.println(innerMatch);
                     
                     if(innerMatch==true){
                         String genString = generateRequiredNoX(tempPat.length()) ;
                         replacedPattern = replacedPattern.replaceAll(tempPat,genString ) ;
                     }
                     
                     //originalpattern.charAt(index) 
                     if(innerMatch == false ) {
                         // partitioning at i th position is wrong ; 
                         solMap = new HashMap<Character,String>(currentMap); 
                         currentIndex = oldCopy ;
                         
                         
                     }
                     }
                 }
                 
             }
             
             
        }
        
        
        return false ;
        
    }

    private static String generateRequiredNoX(int length) {

        String xString = "" ;
        for(int i=0 ; i < length; i++) {
            xString+="X" ;
        }
        return xString;
    }

    private static int goToNextIndex(String replacedPattern, int index) {
        int newIndex = index ; 
        for(int i= index ; i < replacedPattern.length() ; i++) {
            if(replacedPattern.charAt(i) != 'X') {
                return i ;
            }
            
        }
        
        return newIndex;
    }

    public static int findNoOfEmptyCompartments(String s) {
        String compartments[] = s.split("X") ;
        int count = 0;
        for(int i=0 ; i < compartments.length ; i++) {
            if(compartments[i] == null || compartments[i].isEmpty()) {
                count++ ;
            }
        }
        return count;
    }
    
    private static int findNoOfX(String s) {
        int count = 0;
         for(int i=0 ; i < s.length() ; i++) {
             if(s.charAt(i) == 'X') {
                 count++ ;
             }
         }
         
         return count ;
    }

    private static boolean solutionFound(String s, String replacedPattern) {
       if(s.length() != replacedPattern.length()) {
           return false ;
       }
        
       if(checkContainsOnly(s) && checkContainsOnly(replacedPattern)) {
           return true ;
       }
       
        
        return false;
    }

    private static void printStringArray(String[] s) {
        
        for(int i=0 ; i  < s.length ; i++) {
            System.out.println(s[i]);
        }
        
    }

    public  static int findNoOfCompartments(String s) {
        String compartments[] = s.split("X") ;
        return compartments.length ;
        
    }

    private static String replaceAndGetAString(String current, char temp, char dummy) {
        String replacedString = "" ;
        char[] charArray=current.toCharArray() ;
        for(int i=0;i<charArray.length ; i++){
            if(charArray[i]==temp) {
                charArray[i] = dummy;
            }
        }
        replacedString = new String(charArray) ;
        
        return replacedString;
    }

    private static boolean checkContainsOnly(String s) {
        int count=0;
        for(int i=0; i < s.length() ; i++) {
            if(s.charAt(i) == 'X') {
                count ++ ;
            }
        }
        
        
        return count==s.length();
    }

    public static void main(String args[]) {
        String s ="ninjageekgeekninjaprogramprogramworld";
        String pattern = "abbaccd" ;
        Regex(s,pattern) ;
    }
}
