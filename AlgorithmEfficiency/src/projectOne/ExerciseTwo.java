package projectOne;
import java.util.Date;

public class ExerciseTwo
{
	public static int getSumA( int n )
	{
		int sum = 0;
		for ( int i = 0 ; i <= n ; i ++ )
		{
			for ( int j = 0 ; j <= 10000 ; j ++ )
			{
				sum += j;
			}
		}
		return sum;
	}
	
	public static int getSumB( int n )
	{
		int sum = 0;
		for ( int i = 0 ; i <= n ; i ++ )
		{
			for ( int j = 0 ; j <= n ; j ++ )
			{
				sum += j;
			}
		}
		return sum;
	}
	
	public static long getExecTimeA( int n )
	{
		// date object
		Date current = new Date();
		// start clock
		long startTime = current.getTime();
		getSumA( n );
		// stop clock
		long stopTime = current.getTime();
		// exec time
		long execTime = stopTime - startTime;
		return execTime;
	}
	
	public static long getExecTimeB( int n )
	{
		// date object
		Date current = new Date();
		// start clock
		long startTime = current.getTime();
		getSumB( n );
		// stop clock
		long stopTime = current.getTime();
		// exec time
		long execTime = stopTime - startTime;
		return execTime;
	}
	
	/*
	 * To conduct an experiment to see which loop executes faster,
	 * we should design a loop that finds the execution time for each
	 * method A and B, compares exec. time for each value of n, and
	 * return the greatest value of n for which loop B is faster.
	 */
	
	public static int getValueOfN()
	{
		// for each value of n
		int n = 1;
		while ( true )
		{
			long execTimeA = getExecTimeA( n );
			long execTimeB = getExecTimeB( n );
			if ( execTimeB > execTimeA )
			{
				int m = n - 1;
				System.out.println( "Loop B is faster for values of n up to " + m );
				return n;
			}
			else if ( execTimeB <= execTimeA && n == 10000 )
			{
				System.out.println( "Loop B is faster for all values of n." );
				return n;
			}
			System.out.println( n );
			n++;
		}
	}
}
