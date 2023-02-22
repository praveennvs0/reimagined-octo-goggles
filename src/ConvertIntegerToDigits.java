
public class ConvertIntegerToDigits {
	public static void main(String[] args)
	{
	     
	    // Given number
	    int N = 12349;
	    int len = 5;
	 
	    // Function call
	    int[] arr = convertIntegerToInt(N);
	 
	    
	    
	    // Print char array
	    for(int i = 0; i < len; i++)
	        System.out.printf("%c, ", arr[i]);
	    
	}

	public static int[] convertIntegerToInt(int N)
	{
	 
	    // Count digits in number N
	    int m = N;
	    int digit = 0;
	     
	    while (m > 0)
	    {
	         
	        // Increment number of digits
	        digit++;
	 
	        // Truncate the last
	        // digit from the number
	        m /= 10;
	    }
	 
	    // Declare int array for result
	    int[] arr;
	 
	    // Declare duplicate int array
	    int []arr1 = new int[digit + 1];
	 
	    // Memory allocation of array
	    arr = new int[digit];
	 
	    // Separating integer into digits and
	    // accommodate it to intacter array
	    int index = 0;
	     
	    while (N > 0)
	    {
	         
	        // Separate last digit from
	        // the number and add ASCII
	        // value of intacter '0' is 48
	        arr1[++index] = (int)(N % 10 + '0');
	 
	        // Truncate the last
	        // digit from the number
	        N /= 10;
	    }
	 
	    // Reverse the array for result
	    int i;
	    for(i = 0; i < index; i++)
	    {
	        arr[i] = arr1[index - i];
	    }
	 
	    // Return int array
	    return (int[])arr;
	}


}
