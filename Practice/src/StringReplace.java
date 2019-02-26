
public class StringReplace {

    public static void main(String args[]) {
        String s = "geekabcdgeekabcd" ;
        String replace = "abcd" ;
        String newString = "XY" ;
        char[] chars = replaceAndReturn(s.toCharArray(),replace,newString);
        System.out.println(chars);
    }

    private static char[] replaceAndReturn(char[] charArray, String replace, String newString) {
        int differing = replace.length() - newString.length() ;
        int newlen = replace.length() ;
        
        for(int i=0;i<charArray.length && charArray[i] != '\0';i++){
            int futureIndex = i+newlen-1 ;
            if(checkIfMatches(charArray,i,futureIndex,replace) )  {
                System.out.println("Match found : " + i);
                //start replacing string from index i with new string
                int indexWhereItStopped=i ;
                
                for(int j=0; indexWhereItStopped<= futureIndex && j<newString.length() ; j++,indexWhereItStopped++) {
                    charArray[indexWhereItStopped] = newString.charAt(j) ;
                }
                
                for(int l = indexWhereItStopped  ;  l < charArray.length && l >=0 && l+differing < charArray.length ; l++) {
                    charArray[l] = charArray[l+differing] ;                    
                }
                
                for(int k=0,end = charArray.length-1 ; k<differing ; k++,end--) {
                    charArray[end] = '\0' ;
                }
                
                i = indexWhereItStopped-1 ;
                
            }
            
        }
        return charArray;
    }

    private static boolean checkIfMatches(char[] charArray, int start, int endIndex, String replace) {

        if(!(endIndex < charArray.length-1))
        return false;
        int count = 0;
        for(int k=start,j=0 ; k <= endIndex && j < replace.length() ; k++,j++){
            if(charArray[k] != replace.charAt(j)) {
                return false;
            }
            else {
                count++;
            }
        }
        
        return count==replace.length() ;
        
    }
}
