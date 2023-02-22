package newPackage;

public class NoOfMatchingSubSequences {
	public static void main(String[] args) {
		String s = "abcde";
		String[] words = {"acd"};
		int count = numMatchingSubseq(s,words);
		System.out.println("matching count is : " + count);
	}
    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++) {
            if(isSubSequence(s,words[i]))
                count++;
        }
        return count;
    }
    
    public static boolean isSubSequence(String s,String word) {
        int j=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == word.charAt(j)) 
                j++;
            if(j==word.length())
                return true;
            i++;
        }
        return false;
    }
}