package edu.snu.csne.ds;

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
		long start = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int sum = 0;
		for ( int i = 0 ; i < 100 ; i ++ )
		{
			sum += getSumA( n );
		}
		long stop = System.currentTimeMillis();
		return ( stop - start ) / 100;
	}
	
	public static long getExecTimeB( int n )
	{
		long start = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int sum = 0;
		for ( int i = 0 ; i < 100 ; i ++ )
		{
			sum += getSumB( n );
		}
		long stop = System.currentTimeMillis();
		return ( stop - start ) / 100;
	}
	
	/*
	 * To conduct an experiment to see which loop executes faster,
	 * we should design a loop that finds the execution time for each
	 * method A and B, compares exec. time for each value of n, and
	 * return the greatest value of n for which loop B is faster.
	 */
	
	public static int getValueOfN( int[] array )
	{
		for ( int j = 0 ; j < array.length ; j ++ )
		{
			System.out.println( "attempting n = " + array[ j ] );
			long timeA = getExecTimeA( array[ j ] );
			long timeB = getExecTimeB( array[ j ] );
			if ( timeB > timeA )
			{
				System.out.println( "Value of N search stopped at " + array[ j ] );
				return array[ j ];
			}
		}
		System.out.println( "We give up!" );
		return 0;
	}
}
