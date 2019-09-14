package Interview;

public class SMSCheck {
    
   
    public static void main(String args[]) {
        String s="SMS messages are really short" ;
        int K= 12;
        int x = solution(s,K) ;
        if(x==-1)
            System.out.println("Cannot break into SMS " );
        else
        System.out.println("no. of SMS is : " + x);
       
        
    }
    
    
    public static int solution(String s, int K) {
        //split by space to get the no. of words needed as we cannot cut words in the middle
        String[] wordArray = s.split(" ");  
        
        
        
        if(anyWordLongerThanSMSLength(wordArray,K)) {
            return -1 ;
        }
        int totalNoOfSMS=0;
        int count = 0;
        
        int i=0;
        while(i<wordArray.length) {
            
            int num_words = evalNoOfWords(i,wordArray,K) ;
            count++ ;
            i = i + num_words  ; 
            totalNoOfSMS = totalNoOfSMS + 1 ;
            
        }
        
        System.out.println("total number of  SMS is : " + totalNoOfSMS);
       
        return totalNoOfSMS;
    }


    private static boolean anyWordLongerThanSMSLength(String[] wordArray, int k) {
        for(int i=0 ; i<wordArray.length ; i++) {
            if(wordArray[i].length() > k) {
                return true ;
            }
                
        }
        return false;
    }


    private static int evalNoOfWords(int startingPosition,String[] wordArray, int k) {
        String sms = "" ; int i;
        for( i=startingPosition; i<wordArray.length ; i++) {
            String potentialSmsUptoThisWord = sms+wordArray[i] ;
            if(potentialSmsUptoThisWord.length() == k){
                sms = potentialSmsUptoThisWord;
                break ;
            }
                
            String potentialSms=sms+wordArray[i]+" "  ;
         // check whether adding another word exceeds the maximum allowed value K
            if(potentialSms.length() > k) { 
                break ;
            }
         // still our sms length is less than length k. so, we can safely add this word
            else {  
                sms=sms+wordArray[i]+" " ;
            }
            
            
        }
        
     // returns no. of words chosen in our SMS. We can also use i-startingPosition+1 to find the no. of words but it is simpler to use java split function to count the no. of words
        System.out.println("SMS is : " + sms);
        return sms.split(" ").length ; 
       
    }

}
