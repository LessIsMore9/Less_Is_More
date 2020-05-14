package edu.snu.csne.ds;

import java.util.Date;

public class ShellSort
{
	
	public void incrementalInsertionSort( int[] array , int first , int last , int space )
	{
		for ( int unsorted = first + space ; unsorted <= last ; unsorted += space )
		{
			int nextToInsert = array[ unsorted ];
			int index = unsorted - space;
			while ( ( index >= first ) && ( array[ index ] > nextToInsert ) )
			{
				array[ index + space ] = array[ index ];
				index = index - space;
			}
			array[ index + space ] = nextToInsert;
		}
		
	}
	
	public int[] shellSort( int[] array )
	{
		int first = array[ 0 ];
		int last = array[ array.length - 1 ];
		// start with gap n / 2
		int space = array.length / 2;
		// continue process until space = 1
		while ( space > 0 )
		{
			// start with first element
			// skip to next element 'space' elements away
			for ( int start = first ; start <= first + space - 1 ; start ++ )
			{
				// perform insertion sort on the two elements in question
				incrementalInsertionSort( array , start , last , space );
			}
			// divide gap size
			space /= 2;
		}
//		System.out.println( array );
		return array;
	}
	
	public long getExecTimeShell( int[] array )
	{
		// date object
		Date current = new Date();
		// start clock
		long startTime = current.getTime();
		shellSort( array );
		// stop clock
		long stopTime = current.getTime();
		// exec time
		long execTime = stopTime - startTime;
		System.out.println( "Execution time of toArrayA is " + execTime );
		return execTime;
	}
}
