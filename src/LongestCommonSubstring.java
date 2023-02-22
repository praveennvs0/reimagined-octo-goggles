
public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "leetcode" ;
	String s2 = "nletbdz" ;
		
		int length = lcs(s1.toCharArray(),s2.toCharArray(),s1.length()-1,s2.length()-1,0);
		System.out.println(length);
	}
	
	public static int lcs(char[] A, char[] B, int m, int n, int res) {
        if (m == -1 || n == -1) {
            return res;
        }
        if (A[m] == B[n]) {
            res = lcs(A, B, m - 1, n - 1, res + 1);
        }
        return Math.max(res, Math.max(lcs(A, B, m, n - 1, 0), lcs(A, B, m - 1, n, 0)));
    }

    public int longestCommonSubString(char[] A, char[] B) {
        return lcs(A, B, A.length - 1, B.length - 1, 0);
    }

	private static void longestCommonSubstring(String s1, String s2, int i, int j, String subString) {
		if(i >= s1.length()) {
			System.out.println(subString);
			return;
		}
		
		if(j >= s2.length()) {
			System.out.println(subString);
			return;
		}
		
		
		if(s1.charAt(i) == s2.charAt(j)) {
			char ch = s1.charAt(i);
			longestCommonSubstring(s1,s2,i+1,j+1,subString + ch );
		 
		}
		else {
		longestCommonSubstring(s1,s2,i,j+1,subString) ;
		longestCommonSubstring(s1,s2,i+1,j,subString);
		}
	}

	private static String longer(String first, String second) {
		if(first.length() > second.length())
			return first;
		else
			return second;
	}
}
