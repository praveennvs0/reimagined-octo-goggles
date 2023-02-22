package DataStructures;

import java.net.URL;
import java.util.Random;

import org.junit.Test;

import junit.framework.Assert;

public class Problem2 {
	
	static Random random = new Random();
	
	public static String generateURL(String longUrl,String keyWord) throws Exception {
		
		if(keyWord.length() > 20 ) {
			throw new Exception("Keyword Invalid length exception"); 	
		}
		
		// URL valid or not
		 char[] pool = {'A','B','C','D','E','a','b','c','d','e','1','2','3','4'}; 
		
		//generate a random number - 4 times Da01;
		
		
		String randomSequence = getRandomSequence(pool);
		
		
		
		String result = "";
		result = "http://short.com/" + randomSequence;
		return result;
	}

	
	private static String getRandomSequence(char[] pool) {
		String result = "";
		for(int i=0;i<4;i++) {
			int index = random.nextInt(14);
			char ch = pool[index];
			result += ch;
					
		}
		
		return result;
	}

	@Test
	public void testShortURLGeneration() throws Exception {
		String longUrl = "http://looooong.com/somepath" ;
		String keyWord = "MY-NEW-WS";
		String output = generateURL(longUrl,keyWord);
	//	Assert.assertEquals("http://short.com/" + keyWord, output);
		
		
	}
	
//	@Test(expected = Exception.class)
//	public void testShortURLGeneration_throwsException_invalidKeyword() throws Exception {
//		String output = generateURL("http://looooong.com/somepath","BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
//		
//	}
//	
	
	// KeyWord > 20 , empty keyword, empty longurl , // URL is valid
	
	
	

}
