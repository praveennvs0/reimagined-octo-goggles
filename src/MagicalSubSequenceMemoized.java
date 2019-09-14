import java.util.HashSet;
import java.util.Set;

public class MagicalSubSequenceMemoized {
	private static String[][] magicalSubSequenceLookUp = new String[25][25];
public static void main(String args[]) {
	String s = "aeiaaioooaauuaeiou" ;
	String v  = "aeiou";
	System.out.println("Given string is : " + s) ;
	LMS(s,v) ;
	
}


private static void LMS(String s, String v) {
	
	String subSeq = LMS(s,v,0,0,"") ;
	char[] charArray = subSeq.toCharArray() ;
	Set<Character> vowelsSet = new HashSet<Character>() ;
	
	
	for(int i=0; i < charArray.length ; i++) {
		vowelsSet.add(charArray[i]) ;
		
	}
	if(vowelsSet.size() == 5)
	System.out.println("longest magical subsequence is : " + subSeq +" and its length is : "+subSeq.length()) ;
	else 
		System.out.println("No magical subsequence") ;
}


private static String LMS(String s, String v, int i, int j, String subSequence) {
	if(magicalSubSequenceLookUp[i][j] != null) {
	//	System.out.println("Look up table visited") ;
		return magicalSubSequenceLookUp[i][j];
	}
	if(i>=s.length() ||  j >= v.length())
		return subSequence;
	
	if(s.charAt(i)==v.charAt(j)) {
		subSequence = subSequence + s.charAt(i) ;
		String lms1 = LMS(s,v,i+1,j,subSequence) ;
		String lms2 = LMS(s,v,i+1,j+1,subSequence) ;
		subSequence = longer(lms1, lms2);
		
	}
	else {
		return LMS(s,v,i+1,j,subSequence) ;
	}
	
	magicalSubSequenceLookUp[i][j]=subSequence;
	return subSequence;
}




private static String longer(String lms1, String lms2) {
	if(lms1.length() > lms2.length())
		return lms1;
	else 
		return lms2;
	
}
}
