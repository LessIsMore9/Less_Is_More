package edu.snu.csne.ds;

public class InPlaceMergeSort
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
    static void merge( int[] array , int start , int mid , int end ) 
    {
    	// pointer for right sub-array
        int startRight = mid + 1; 
      
        // if sub-arrays are already in order,
        if ( array[ mid ] <= array[ startRight ] )
        {
        	// we're done!
            return; 
        } 
      
        // 2 pointers to maintain start of arrays we want to merge
        while ( start <= mid && startRight <= end )
        {
            // If element 1 is in right place 
            if ( array[ start ] <= array[ startRight ] )
            {
                start ++; 
            }
            else
            {
                int value = array[ startRight ];
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
     * latter two arguments of merge sort method indicate pointers
     * for sub-arrays that need to be merged
     */
    public int[] mergeSort( int[] array , int l , int r ) 
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
    
	public long getExecTimeMerge( int[] array )
	{
		// start clock
		long startTime = System.nanoTime();
		mergeSort( array , 0 , array.length - 1 );
		// stop clock
		long stopTime = System.nanoTime();
		// exec time
		long execTime = stopTime - startTime;
		return execTime;
	}
}
