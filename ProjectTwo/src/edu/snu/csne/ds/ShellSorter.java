package edu.snu.csne.ds;

public class ShellSorter< T  extends Comparable< ? super T > > implements Sorter< T >
{
	
	public long getExecTimeShell( T[] array )
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
	
	public void ensureValidity( T[] arr )
	{
		if ( arr == null )
		{
			throw new IllegalStateException();
		}
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
	
	public T[] shellSort( T[] unsorted )
	{
		ensureValidity( unsorted );
		// length of non-null portion
		int n = unsorted.length - getNumberOfNulls( unsorted );
		// use gaps of size (n/2)^{k}
		for ( int gap = n / 2 ; gap > 0 ; gap /= 2 )
		{
			
			for ( int i = gap ; i < n ; i += 1 )
			{ 
				// temporarily store array[ i ] until we can find it's correct position
				T temp = unsorted[ i ];
				// shift elements sorted earlier up to find correct position for array[ i ]
				int j;
				// the conditions on this loop are necessary for the
				// insertion element of the subarray sorting
				for ( j = i ; j >= gap && unsorted[ j - gap ].compareTo( temp ) > 0 ; j -= gap )
				{
					// sort!
					unsorted[ j ] = unsorted[ j - gap ];
				}

				// put temp in correct location
				unsorted[ j ] = temp;
			}
		}
		return unsorted;
	}
	
	@Override
	public T[] sort( T[] unsorted )
	{
		shellSort( unsorted );
		return unsorted;
	}
}