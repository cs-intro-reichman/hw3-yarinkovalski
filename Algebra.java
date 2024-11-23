// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) 
	{
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) 
	{
		// Replace the following statement with your code
		for (int i=0; i<x2; i++)
		{
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) 
	{
		// Replace the following statement with your code
		for (int i=0; i<x2; i++)
		{
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) 
	{
		// Replace the following statement with your code
		int x3 = x2;
		for (int i=0; i<x1-1; i++)
		{
			x2=plus(x2, x3);
		}
		return x2;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) 
	{
		int x3 = x;
		for (int i=0; i<n-1; i++)
		{
			x = times(x, x3);
		}
		// Replace the following statement with your code
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) 
	{
		// Replace the following statement with your code
		int counter = 0;
		while (x1 != 0 && x1>0 && x1>=x2)
		{
			x1 = minus(x1, x2);
			counter++;
		}
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) 
	{
		// Replace the following statement with your code
		while (x1>=x2)
		{
			x1 = minus(x1, x2);
		}
		
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) 
	{
		// Replace the following statement with your code
		int x1 = 0 ;
		int multiple = 1 ;
		while (multiple <= x)
		{
			x1++;
			multiple = times(x1, x1);
		}
		return x1;
	}	  	  
}