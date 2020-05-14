package edu.snu.csne.ds;

public class CustomPriorityQueueADT< T extends Comparable < T > > implements PriorityQueueADT< T >
{
	
	static final int DEF_CAPACITY = 100;
	ArrayListADT< T > dq = new ArrayListADT< T >( DEF_CAPACITY );
	
	public CustomPriorityQueueADT()
	{
		
	}
	
	private int findPriorityIndex( T newEntry )
	{
		int index = dq.getLength();
		for ( int i = 0 ; i < dq.getLength() ; i++ )
		{
			// if priority of newEntry is greater than or equal to
			// the entry we're comparing, stick it there
			T currEntry = dq.getEntry( i );
			int compare = newEntry.compareTo( currEntry );
			if ( compare >= 0 )
			{
				return i;
			}
		}
		// if we didn't find it, return last index
		return index;
	}
	
	/*
	 * sticks entry w/ highest priority at the front of the queue
	 */
	@Override
	public void add( T newEntry )
	{
		int index = findPriorityIndex( newEntry );
		dq.add( index, newEntry );
	}

	@Override
	public T remove()
	{
		// ArrayList remove method shifts rightward entries left so no further action is needed
		return dq.remove(0);
	}

	@Override
	public boolean isEmpty()
	{
		return dq.isEmpty();
	}

	@Override
	public void clear()
	{
		dq.clear();
	}

	@Override
	public T peek()
	{
		return dq.getEntry(0);
	}

	@Override
	public int getSize()
	{
		return dq.getLength();
	}

	@Override
	public String toFormattedString()
	{
		return "{ " + dq.toString() + " }";
	}
	
}
