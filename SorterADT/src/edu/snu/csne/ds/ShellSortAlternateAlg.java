package edu.snu.csne.ds;

public class ShellSortAlternateAlg 
{

	/* function to sort array using shellSort */
	public int[] shellSort( int[] array )
	{
		int n = array.length;
		// use gaps of size (n/2)^{k}
		for ( int gap = n / 2 ; gap > 0 ; gap /= 2 )
		{
			
			for ( int i = gap ; i < n ; i += 1 )
			{ 
				// temporarily store array[ i ] until we can find it's correct position
				int temp = array[ i ]; 
				// shift elements sorted earlier up to find correct position for array[ i ]
				int j;
				// the conditions on this loop are necessary for the
				// insertion element of the subarray sorting
				for ( j = i ; j >= gap && array[ j - gap ] > temp ; j -= gap )
				{
					// sort!
					array[ j ] = array[ j - gap ];
				}

				// put temp in correct location
				array[ j ] = temp;
			}
		}
		return array;
	}
	
	public long getExecTimeShellAlt( int[] array )
	{
		// start clock
		long startTime = System.nanoTime();
		shellSort( array );
		// stop clock
		long stopTime = System.nanoTime();
		// exec time
		long execTime = stopTime - startTime;
		return execTime;
	}
}