package edu.snu.csne.ds;

public class MergeSorter<T extends Comparable<? super T>> implements Sorter<T>
{
	/*
	 * quick note:
	 * 
	 * 		The textbook used a utility merge function, but I was constantly having unresolvable issues with it.
	 * 		GeeksForGeeks.com supplied a merge sort implementation that also used a merge utility function. They
	 * 		are not the exact same function, but I owe them credit as I took some pointers from their implementation.
	 * 
	 */
	
	// utility merge function
    public void merge( T[] array , int start , int mid , int end ) 
    {
    	// pointer for right sub-array
        int startRight = mid + 1; 
      
        // if sub-arrays are already in order,
        if ( array[ mid ].compareTo(array[ startRight ]) <= 0 )
        {
        	// we're done!
            return; 
        } 
      
        // 2 pointers to maintain start of arrays we want to merge
        while ( start <= mid && startRight <= end )
        {
            // If element 1 is in right place 
            if ( array[ start ].compareTo(array[ startRight ]) <= 0 )
            {
                start ++; 
            }
            else
            {
                T value = array[ startRight ];
                int index = startRight;
      
                /*
                 * shift all elements b/w 1 and 2 to the right by 1
                 */
                while ( index != start )
                { 
                    array[ index ] = array[ index - 1 ]; 
                    index --; 
                } 
                array[ start ] = value; 
      
                // update pointers 
                start ++; 
                mid ++; 
                startRight ++; 
            }
        }
    }
    
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
     * latter two arguments of merge sort method indicate pointers
     * for sub-arrays that need to be merged
     */
    public T[] mergeSort( T[] array , int l , int r ) 
    {
        if ( l < r )
        { 
      
            // Same as (l + r) / 2, but avoids overflow 
            // for large l and r 
            int m = ( l + r ) / 2;
      
            // Sort first and second halves 
            mergeSort( array , l , m ); 
            mergeSort( array , m + 1 , r ); 
      
            merge( array , l , m , r ); 
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
    
	/*
	 * - move nulls to end
	 * - find indices of non-null portion using getNumberOfNulls
	 * - sort non-null portion
	 */
    @Override
    public T[] sort( T[] array )
    {
    	ensureValidity( array );
    	nullsToEndInPlace( array );
    	int first = 0;
    	int last = array.length - getNumberOfNulls( array ) - 1;
    	T[] sorted = mergeSort( array, first, last );
    	return sorted;
    }
    
    
	public long getExecTimeMerge( T[] array )
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
