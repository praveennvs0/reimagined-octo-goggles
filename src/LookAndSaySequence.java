
public class LookAndSaySequence {

	public static void main(String args[]) {
		int n=5;
		String number = generateSequence(n) ;
		System.out.println(number);
		
	}

	private static String generateSequence(int n) {
		if(n==1)
			return "1" ;
		if(n==2)
			return "11";
		String  sequence[] = new String[n+1] ;
		sequence[0]="0";
		sequence[1]="1";
		sequence[2]="11";
		
		for(int num=3;num <= n; num++) {
			String prev = sequence[num-1] ;
			String number = generateNum(prev) ;
			sequence[num]=number;
		}
		
		return sequence[n];
	}

	private static String generateNum(String prev) {
		String numberInString = "";
		char digits[] = prev.toCharArray();
		char num = digits[0];
		int i=0,count=1;
		while(i<digits.length-1) {
			
			if(digits[i+1] == digits[i]) {
				count++;
			}
			else {
				
				String countInString = Integer.toString(count) ;
				numberInString+= countInString ;
				String temp = Character.toString(num) ;
				numberInString +=  temp;
				num=digits[i+1];
				count=1;
			}
			i++;
		}
		
		String countInString = Integer.toString(count) ;
		numberInString+= countInString ;
		String temp = Character.toString(num) ;
		numberInString +=  temp;
		
		return numberInString;
	}

	
}
