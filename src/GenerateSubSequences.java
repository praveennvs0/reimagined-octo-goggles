import java.util.ArrayList;
import java.util.List;

public class GenerateSubSequences {

	public static void main(String args[]) {
		
		
		String s ="ABC" ;
		String subsequence = "" ;
		List<String> subsequences = new ArrayList<String> () ;
		genSubSequence(s,subsequence,subsequences) ;
		
	}

	private static void genSubSequence(String s,String subsequence,List<String> subsequences) {
//
//		if(s.length()==1) {
//			System.out.println(subsequence + s.charAt(index))
//		}
	
		
		 if(!subsequence.isEmpty()) {
		System.out.println(subsequence) ;
		subsequences.add(subsequence);
		}
		
		for(int i=0; i < s.length() ; i++ ) {
			genSubSequence(s.substring(i+1,s.length()),subsequence+s.charAt(i),subsequences ) ;
			//if(!s.substring(i+1,s.length()).isEmpty())
			genSubSequence(s.substring(i+1,s.length()),subsequence,subsequences) ;
		}
		
	}
}
