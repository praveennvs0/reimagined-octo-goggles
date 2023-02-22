package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Map;

public class WordLadder {

	
	public static void main(String[] args) {
		String[] wordArray = {"hot","dot","dog","lot","log","cog"};
		
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList(wordArray);
		
		int minSteps = ladderLength(beginWord,endWord,wordList);
		System.out.println("min steps is : " + minSteps);
	}
	
	
		  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		    // Since all words are of same length.
		    int L = beginWord.length();

		    // Dictionary to hold combination of words that can be formed,
		    // from any given word. By changing one letter at a time.
		    Map<String, List<String>> allComboDict = new HashMap<>();

		    wordList.forEach(
		        word -> {
		          for (int i = 0; i < L; i++) {
		            // Key is the generic word
		            // Value is a list of words which have the same intermediate generic word.
		            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
		            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
		            transformations.add(word);
		            allComboDict.put(newWord, transformations);
		          }
		        });

		    // Queue for BFS
		    Queue<Pair<String, Integer>> Q = new LinkedList<>();
		    Q.add(new Pair(beginWord, 1));

		    // Visited to make sure we don't repeat processing same word.
		    Map<String, Boolean> visited = new HashMap<>();
		    visited.put(beginWord, true);

		    while (!Q.isEmpty()) {
		      Pair<String, Integer> node = Q.remove();
		      String word = node.getKey();
		      int level = node.getValue();
		      for (int i = 0; i < L; i++) {

		        // Intermediate words for current word
		        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

		        // Next states are all the words which share the same intermediate state.
		        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
		          // If at any point if we find what we are looking for
		          // i.e. the end word - we can return with the answer.
		          if (adjacentWord.equals(endWord)) {
		            return level + 1;
		          }
		          // Otherwise, add it to the BFS Queue. Also mark it visited
		          if (!visited.containsKey(adjacentWord)) {
		            visited.put(adjacentWord, true);
		            Q.add(new Pair(adjacentWord, level + 1));
		          }
		        }
		      }
		    }

		    return 0;
		  }
}
