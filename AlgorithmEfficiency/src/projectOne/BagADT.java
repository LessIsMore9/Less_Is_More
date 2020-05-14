package projectOne;
import java.util.Arrays;

public class BagADT< T > 
{
    T[] bag;
    private final int DEFAULT_CAPACITY = 50;
    private int numberOfEntries;

    @SuppressWarnings("unchecked")
	public BagADT()
    {
        this.bag = ( T[] ) new Object[ DEFAULT_CAPACITY ];
        numberOfEntries = DEFAULT_CAPACITY;
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
	
	public boolean add( T newEntry )
	{
		boolean result = true;
		if ( isArrayFull () )
		{
			result = false;
		}
		else
		{
			bag[ numberOfEntries ] = newEntry;
			numberOfEntries ++;
		}
		return result;
	}
}
