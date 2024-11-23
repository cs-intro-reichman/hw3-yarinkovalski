// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) 
	{		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) 
	{
		
		for (int i=1; i<=n; i++)
		{
			loan = (loan-payment)*(1.0+(rate/100));
		}	
		// Replace the following statement with your code
		return loan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) 
	{
		// Replace the following statement with your code
		double g = loan/n;
		iterationCounter=0;
		while (endBalance(loan, rate, n, g)>0) 
		{
			g = g+epsilon;
			iterationCounter++;
			
			
		}
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon)
	{  
		
		double l = 0;
		double h = loan;
		double g = (l+h)/2;
		iterationCounter=0;
		
		while ((h - l) >= epsilon )
		{
			
			if ((endBalance(loan, rate, n, g))> 0)
				l = g;
			else
				h = g;
			g = (l + h)/2;	
			iterationCounter++;
		}
		return g;
    }




	       // Replace the following statement with your code
							//// Sets L and H to initial values such that f(L) > 0, f(H) < 0,
					//// implying that the function evaluates to zero somewhere between L and H.
					// So, let’s assume that L and H were set to such initial values.
					// Set g to (L + H)/2
					//while (H − L) > ε {
						// Sets L and H for the next iteration
						//if f(g)∙f(L) > 0
						// the solution must be between g and H
						// so set L or H accordingly
						//else
						// the solution must be between L and g
						// so set L or H accordingly
						// Computes the mid-value (g) for the next iteration
						//}
					//	return g
}