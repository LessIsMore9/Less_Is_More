package edu.snu.csne.ds;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueueADT< T > implements QueueADT< T >
{
	
	private T[] k;
	private int backIndex;
	private static final int def_capacity = 50;
	
	// chained constructors
	
	// default
	public ArrayQueueADT()
	{
		this( def_capacity );
	}

	public ArrayQueueADT( int customCapacity )
	{
		// checkCapacity( customCapacity );
		
		@SuppressWarnings("unchecked")
		T[] tempStack = ( T[] )new Comparable[ customCapacity ];
		k = tempStack;
		backIndex = -1;
	}
	
	/*
	 * checks to see if space is available
	 * if not, double size of array
	 */
	private void ensureCapacity()
	{
		if ( backIndex == k.length - 1 )
		{
			// doubles size of array
			int newLength = 2 * k.length;
			k = Arrays.copyOf( k , newLength );
		}
	}

	@Override
	public void enqueue( T newEntry )
	{
		ensureCapacity();
		// move all items up/towards the back
		for ( int j = backIndex ; j >= 0 ; j -- )
		{
			// shift mechanism
			T currItem = k[ j ];
			k[ j + 1 ] = currItem;
			k[ j ] = null;
		}
		// stick new item in front (back of line)
		k[ 0 ] = newEntry;
		backIndex ++;
	}

	@Override
	public T dequeue()
	{
		if ( isEmpty() )
		{
			throw new EmptyStackException();
		}
		else
		{
			// item at back (front of line) is desired
			T currItem = k[ backIndex ];
			k[ backIndex ] = null;
			backIndex --;
			return currItem;
		}
	}

	@Override
	public T getFront()
	{
		if ( isEmpty() )
		{
			throw new EmptyStackException();
		}
		// returns "front of the line" which is back of our array
		return k[ backIndex ];
	}

	@Override
	public boolean isEmpty()
	{
		boolean result = false;
		// queue is enqueued from the back, so
		// if first slot is empty, queue is empty
		if ( k[ 0 ] == null )
		{
			return true;
		}
		return result;
	}

	@Override
	public void clear()
	{
		while ( !isEmpty() )
		{
			dequeue();
		}
	}

	@Override
	public String toFormattedString()
	{
		String str = "{ " + k.toString() + " }";
		return str;
	}
	
}
