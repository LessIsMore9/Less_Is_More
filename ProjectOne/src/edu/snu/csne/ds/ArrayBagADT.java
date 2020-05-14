package edu.snu.csne.ds;

import java.util.Arrays;

public class ArrayBagADT< T > 
{
	// build a simple bag ADT for our purposes
	
    T[] bag;
    private final int DEFAULT_CAPACITY = 50;
    private int numberOfEntries;

    
    /*
     * chained some constructors here for code in main
     */
    
    @SuppressWarnings("unchecked")
	public ArrayBagADT()
    {
        this.bag = ( T[] ) new Object[ DEFAULT_CAPACITY ];
        numberOfEntries = DEFAULT_CAPACITY;
    }
    
    @SuppressWarnings("unchecked")
	public ArrayBagADT( int size )
    {
    	this.bag = ( T[] ) new Object[ size ];
    	numberOfEntries = 0;
    }
    
	public T[] toArrayA()
	{
		@SuppressWarnings("unchecked")
		T[] result = ( T[] ) new Object[ numberOfEntries ];
		for ( int index = 0 ; index < numberOfEntries ; index ++ )
		{
			result[ index ] = bag[ index ];
		}
		return result;
	}
	
	public T[] toArrayB()
	{
		return Arrays.copyOf( bag , bag.length );
	}
	
	public boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	}
	
	public void add( T newEntry )
	{
		bag[ numberOfEntries ] = newEntry;
		numberOfEntries ++;
	}
	
	public int getNumberOfEntries()
	{
		return numberOfEntries;
	}
	
	public T remove()
	{
		T result = null;
		if ( numberOfEntries > 0 )
		{
			result = bag[ numberOfEntries - 1 ];
			bag[ numberOfEntries - 1 ] = null;
			numberOfEntries --;
		}
		return result;
	}
	
	
}
