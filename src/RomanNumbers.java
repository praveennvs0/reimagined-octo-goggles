import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
	public static void main(String args[]) {
		String s = "LVIII";
		int num = romanToInt(s);
		System.out.println("Number is : " + num);
	}
    public static int romanToInt(String s) {
        
        Map<String,Integer> romanMap = buildRomanMap() ;
        int num = 0,i=0;
        while(i < s.length()) {
            
            char ch = s.charAt(i);
            if(i+1<s.length()) {
            char next = s.charAt(i+1);
            int value = getSubtractedValue(ch,next) ;
            
            if(value != 0){
                num=num + value ;
                i=i+2;
                continue ;
            }
                
            }
            
            String str = Character.toString(ch);
            int valueFromMap = romanMap.get(str);
            num = num + valueFromMap ;
            i=i+1;
        
            
        }
        return num;
    }
    
    public static int getSubtractedValue(char ch,char next) {
        int value = 0;
        if(ch=='I' && next == 'V')
            value = 4 ;
        else if (ch=='I' && next=='X')
            value = 9;
        else if(ch=='X' && next == 'L')
            value = 40;
        else if(ch=='X' && next == 'C')
            value = 90;
        else if(ch=='C' && next == 'D')
            value = 400;
        else if(ch=='C' && next == 'M')
            value = 900;
        
        return value ;
            
    }
    
    public static Map<String,Integer> buildRomanMap() {
        Map<String,Integer> romanMap = new HashMap<String,Integer>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        
        return romanMap;
    }
}