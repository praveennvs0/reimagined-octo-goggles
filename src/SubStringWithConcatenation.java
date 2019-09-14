import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenation {

public static void main(String args[]) {
	
	String s = "wordgoodgoodgoodbestword";
	
			
	String[] words = {"word","good","best","good"};
	
	
	
	
 	
 	List<Integer> indices = findSubstring(s,words);
 	System.out.println();
 	System.out.println("-----");
 	
 	
}


private static List<Integer> findSubstring(String s, String[] wordsArray) {
	List<Integer> indicesList = new ArrayList<Integer> () ;
	if(wordsArray.length==0)
		return indicesList ;
	List<String> words = getList(wordsArray) ;
	int sizeOfConcatenation = findSize(words) ;
	if(s.length() < sizeOfConcatenation)
		return indicesList ;
	
	
	int len = wordsArray[0].length() ;
	
	List<String> permutation = new ArrayList<String>();
	List<String> permutationList = new ArrayList<String>();
	genPermutations(words.size(),words,permutation,permutationList) ;
	Map<String,Boolean> subStringMap = new HashMap<String,Boolean> () ;
	
	for(int i=0;i<s.length()-sizeOfConcatenation+1;i++) {
		String substring = s.substring(i,i+sizeOfConcatenation);
		if(subStringMap.get(substring)  != null) {
		indicesList.add(i);	
		}
		else if (permutationList.contains(substring)) {
			
			indicesList.add(i) ;
		}
	}
	
	return indicesList;
}


private static List<String> getList(String[] wordsArray) {
	List<String> words = new ArrayList<String> () ;
	for(String s: wordsArray)
		words.add(s);
	return words;
}


private static int findSize(List<String> words) {
	int size = 0;
	for(String word: words)
		size=size+word.length() ;
	return size;
}


public static void genPermutations(int size,List<String> words,List<String> permutation,List<String> permutationList) {


if(permutation.size()==size)  {
print(permutation);
String concat = concatenate(permutation) ;
permutationList.add(concat) ;
return ;
}

for(int i=0; i < words.size(); i++) {
permutation.add(words.get(i));
//List<String> removedList = getRemovedList(words,i) ;
String wordToRemove = words.remove(i);
genPermutations(size,words,permutation,permutationList) ;
words.add(i, wordToRemove);
permutation.remove(permutation.size()-1);
}

}




private static String concatenate(List<String> permutation) {
	String concatenatedString = "" ;
	for(String s : permutation)
		concatenatedString+= s ;
	return concatenatedString;
}


public static void print(List<String> permutation) {
	System.out.println(" ");
permutation.forEach(x->System.out.print(x));
}
}
