package edu.snu.csne.ds;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStackADT< T > implements StackADT< T >
{
	
	private T[] stk;
	private int topIndex;
	private static final int def_capacity = 50;
	
	// chained constructors
	
	// default
	public ArrayStackADT()
	{
		this( def_capacity );
	}

	public ArrayStackADT( int customCapacity )
	{
		// checkCapacity( customCapacity );
		
		@SuppressWarnings("unchecked")
		T[] tempStack = ( T[] )new Comparable[ customCapacity ];
		stk = tempStack;
		topIndex = -1;
	}
	
	private void ensureCapacity()
	{
		if ( topIndex == stk.length - 1 )
		{
			// doubles size of array
			int newLength = 2 * stk.length;
			stk = Arrays.copyOf( stk , newLength );
		}
	}

	@Override
	public void push( T newEntry )
	{
		ensureCapacity();
		stk[ topIndex + 1 ] = newEntry;
		topIndex ++;
	}

	@Override
	public T pop()
	{
		if ( topIndex == -1 )
		{
			throw new EmptyStackException();
		}
		else
		{
			T top = stk[ topIndex ];
			stk[ topIndex ] = null;
			topIndex--;
			return top;
		}
	}

	@Override
	public T peek()
	{
		if ( isEmpty() )
		{
			throw new EmptyStackException();
		}
		else
		{
			T top = stk[ topIndex ];
			return top;
		}
	}

	@Override
	public boolean isEmpty()
	{
		return ( topIndex == -1 );
	}

	@Override
	public void clear()
	{
		while ( !isEmpty() )
		{
			pop();
		}
	}

	@Override
	public String toFormattedString()
	{
		return "{ " + stk.toString() + " }";
	}

}
