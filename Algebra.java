// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) 
	{
	    // Tests some of the operations
	    System.out.println(plus(-5,-3));   // 2 + 3
	    System.out.println(minus(7,-2));  // 7 - 2
   		System.out.println(minus(-5,-3));  // 2 - 7
 		System.out.println(times(-2,3));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-15,-3));   // 12 / 3    
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
		if (x2>0)
		{
			for (int i=0; i<x2; i++)
			{
				x1++;
			}
		}
		else if (x2<0)
		{
			for (int i=x2; i<0; i++)
			{
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) 
	{
		// Replace the following statement with your code
		if (x2>0)
		{
			for (int i=0; i<x2; i++)
			{
				x1--;
			}
		}
		else
		{
			for (int i=x2; i<0; i++)
			{
				x1++;
			}
		}

		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) 
	{
		// Replace the following statement with your code
		int x3 = x2;
		
		if (x1 == 0)
			x3=plus(x1 ,x1);
		else if (x2==0)
			x3=plus(x2 ,x2);
		else if (x2>0 && x1>0) 
		{
			for (int i=0; i<x1-1; i++)
			{
				x3=plus(x2, x3);
			}
		}
		else if ((x1>0 && x2<0))
		{	
			
			for (int i=0; i<x1-1; i++)
			{
				x3=plus(x2, x3);
			}
		} 

		else if ((x1<0 && x2>0) )
		{	
			int tran=x1;
			x1=x2;
			x2=tran;
			x3=x2;
			for (int i=0; i<x1-1; i++)
			{
				x3=plus(x2, x3);
			}
		} 
		else if ((x1<0 && x2<0) )
		{	
			for (int i=x1; i<=0; i++)
			{
				x3=minus(x3, x2);
			}
		} 

		return x3;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) 
	{
		int x3 = x;
		if (n==0)
			return 1;
		else 
		{
			for (int i=0; i<n-1; i++)
			{
				x = times(x, x3);
			}
		}

		// Replace the following statement with your code
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) 
	{
		// Replace the following statement with your code
		int counter = 0;
		if (x1 >= 0 && x2>=0)
		{
			while (x1 != 0 && x1>0 && x1>=x2)
			{
				x1 = minus(x1, x2);
				counter++;
			}
		}
		else if (x1 > 0 && x2<0)
		{
			while (x1 != 0 && x1>0 && x1>=x2)
			{
				x1 = plus(x1, x2);
				counter--;
			}
		}
		else if (x1 < 0 && x2>0)
		{
			while (x1 != 0 && x1<0 && x1<=x2)
			{
				x1 = plus(x1, x2);
				counter--;
			}
		}
		else if (x1 < 0 && x2<0)
		{
			while (x1 != 0 && x1<0 && x1<=x2)
			{
				x1 = minus(x1, x2);
				counter++;
			}
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
		int x1 = 1 ;
		int multiple = 1 ;
		if (x==0)
			return 0;
		else
		{
			while (times(x1+1, x1+1) <= x)
			{
				
				x1++;
				multiple = times(x1, x1);
				
			}
		}
		return x1;
	}	  	  //76123
}