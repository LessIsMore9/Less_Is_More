package fibonacci;

public class IterativeFibonacci
{
	int m = 1;
	int p = 1;
	int q = 0;
	
	// iterative Fibonacci generator
	public int fib( int n )
	{
		int count = 2;
		while ( count < n )
		{
			q = m + p;
			m = p;
			p = q;
			
			count ++;
		}
		System.out.println( q );
		return q;
	} 
	
	// recursive Fibonacci generator
}
