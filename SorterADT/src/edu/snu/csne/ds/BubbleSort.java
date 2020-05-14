package edu.snu.csne.ds;


public class BubbleSort
{
	public int[] bubbleSort( int[] array )
	{
		/*
		 * start by compare sorting every pair of elements
		 * once finished with first round, we know the last element is in its proper place,
		 * so we can iterate back through n - 1 elements
		 * 
		 * we can repeat this process, the reason that j has an upper bound of j - i - 1
		 */
		for ( int i = 0 ; i < array.length - 1 ; i ++ )
		{
			for ( int j = 0 ; j < array.length - i - 1 ; j ++ )
			{
				if ( array[ j ] > array[ j + 1 ] )
				{
					int a = array[ j ];
					array[ j ] = array[ j + 1 ];
					array[ j + 1 ] = a;
				}
			}
		}
//		for ( int i = 0 ; i < array.length ; i ++ )
//		{
//			System.out.print( array[ i ] );
//			System.out.print( ", " );
//		}
		return array;
	}
	
	public long getExecTimeBubble( int[] array )
	{
		// start clock
		long startTime = System.nanoTime();
		bubbleSort( array );
		// stop clock
		long stopTime = System.nanoTime();
		// exec time
		long execTime = stopTime - startTime;
		return execTime;
	}
}
