package edu.snu.csne.ds;

import java.util.Arrays;

import edu.snu.csne.ds.ListADT;

public class ArrayListADT< T > implements ListADT< T >
{
	
	T[] list;
	private int numberOfEntries;
	private static final int def_capacity = 50;
	
	public ArrayListADT()
	{
		this( def_capacity );
	}
	
	public ArrayListADT( int initialCapacity )
	{
		if ( initialCapacity < def_capacity )
		{
			initialCapacity = def_capacity;
		}
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[ initialCapacity + 1 ];
		list = tempList;
		numberOfEntries = 0;
	}
	
	public void ensureCapacity()
	{
		if ( numberOfEntries == list.length )
		{
			int newLength = 2 * list.length;
			list = Arrays.copyOf( list , newLength );
		}
	}

	@Override
	public void add(T newEntry)
	{
		ensureCapacity();
		// add to end of list
		list[ numberOfEntries ] = newEntry;
		numberOfEntries++;
	}

	@Override
	public void add(int newIndex, T newEntry)
	{
		ensureCapacity();
		// move all items to right up 1 then insert
		for ( int i = numberOfEntries - 1 ; i >= newIndex ; i -- )
		{
			T currItem = list[ i ];
			list[ i + 1 ] = currItem;
			list[ i ] = null;
		}
		list[ newIndex ] = newEntry;
		numberOfEntries++;
	}

	@Override
	public T remove(int index)
	{
		if ( isEmpty() )
		{
			throw new IllegalStateException();
		}
		else
		{
			T item = list[ index ];
			list[ index ] = null;
			for ( int j = index + 1 ; j <= numberOfEntries - 1 ; j ++ )
			{
				list[ j - 1 ] = list[ j ];
				list[ j ] = null;
			}
			numberOfEntries--;
			return item;
		}
	}

	@Override
	public void clear()
	{
		if ( numberOfEntries == 0 )
		{
			return;
		}
		for ( int i = numberOfEntries - 1 ; i >= 0 ; i -- )
		{
			list[ i ] = null;
		}
		numberOfEntries = 0;
	}

	@Override
	public T replace(int givenIndex, T newEntry)
	{
		T item = null;
		
		if ( givenIndex > numberOfEntries - 1 )
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		else
		{
			item = list[ givenIndex ];
			list[ givenIndex ] = newEntry;
		}
		return item;
	}

	@Override
	public T getEntry(int givenIndex)
	{
		T item = null;
		if ( givenIndex > numberOfEntries - 1 
				|| givenIndex < 0 )
		{
			throw new ArrayIndexOutOfBoundsException
						("handled intentionally");
		}
		else if ( isEmpty() )
		{
			throw new IllegalStateException();
		}
		else
		{
			item = list[ givenIndex ];
		}
		return item;
	}

	@Override
	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[ numberOfEntries ];
		for ( int i = 0 ; i < numberOfEntries ; i ++ )
		{
			array[ i ] = list[ i ];
		}
		return array;
	}

	@Override
	public boolean contains(T entry)
	{
		boolean result = false;
		for ( int i = 0 ; i < numberOfEntries ; i ++ )
		{
			if ( entry.equals( list[ i ] ) )
			{
				result = true;
			}
		}
		return result;
	}

	@Override
	public int getLength()
	{
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty()
	{
		return ( numberOfEntries == 0 );
	}

}
