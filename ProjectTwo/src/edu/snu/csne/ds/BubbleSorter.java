package edu.snu.csne.ds;


public class BubbleSorter<T extends Comparable<? super T>> implements Sorter<T>
{
    /*
     * method to throw appropriate exceptions where necessary before sort operation begins
     */
	public void ensureValidity( T[] arr )
	{
		if ( arr == null )
		{
			throw new IllegalStateException();
		}
	}
	
	
	/*
	 * move nulls to end, then sort portion of non null array
	 */
	public T[] bubbleSort( T[] array )
	{
		ensureValidity( array );
		nullsToEndInPlace( array );
		int n = array.length;
		int m = getNumberOfNulls( array );
		int newBound = n - m - 1;
		/*
		 * start by compare sorting every pair of elements
		 * once finished with first round, we know the last element is in its proper place,
		 * so we can iterate back through n - 1 elements
		 * 
		 * we can repeat this process, the reason that j has an upper bound of j - i - 1
		 */
		for ( int i = 0 ; i < newBound ; i ++ )
		{
			for ( int j = 0 ; j < newBound - i ; j ++ )
			{
				if ( array[ j ].compareTo( array[ j + 1 ] ) > 0 )
				{
					T a = array[ j ];
					array[ j ] = array[ j + 1 ];
					array[ j + 1 ] = a;
				}
			}
		}
		return array;
	}
	
	/*
	 * method to sort nulls to end of array
	 * 
	 * start at each end of the arry
	 * 		if we find a null at the front, move to back
	 * 		if we finda null at the back, leave it
	 * 			if not null, move to front
	 */
	public T[] nullsToEndInPlace( T[] array )
	{
		int i = 0;
		int j = array.length - 1;
		while (i < j)
		{
			T left = array[i];
			T right = array[j];
			// leave non null at front
			if (left != null)
			{
				i++;
			}
			else if (right == null)
			{
				// leave null at end
				j--;
			}
			else
			{
				// switch
				array[i] = right;
				array[j] = null;
				i++;
				j--;
			}
		}
		return array;
	}
	
	public int getNumberOfNulls( T[] array )
	{
		int numberOfNulls = 0;
		for ( int i = 0 ; i < array.length ; i++ )
		{
			if (array[i] == null)
			{
				numberOfNulls++;
			}
		}
		return numberOfNulls;
	}
	
	public T[] sort( T[] array )
	{
		bubbleSort( array );
		return array;
	}

	public long getExecTimeBubble( T[] array )
	{
		// start clock
		long startTime = System.nanoTime();
		sort( array );
		// stop clock
		long stopTime = System.nanoTime();
		// exec time
		long execTime = stopTime - startTime;
		return execTime;
	}
}
