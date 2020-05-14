package edu.snu.csne.ds;

public class CustomDequeADT< T > implements DequeADT< T >
{
	static final int DEF_CAPACITY = 100;
	ArrayListADT< T > dq = new ArrayListADT< T >(DEF_CAPACITY);

	
	public CustomDequeADT()
	{
		
	}
	
	public CustomDequeADT( int customSize )
	{
		ArrayListADT< T > customDeque = 
				new ArrayListADT< T >( customSize );
		dq = customDeque;
	}
	
	@Override
	public void addToFront(T newEntry)
	{
		dq.add( 0 , newEntry );
	}

	@Override
	public void addToBack(T newEntry)
	{
		dq.add( newEntry );
	}

	@Override
	public T removeFront()
	{
		return dq.remove( 0 );
	}

	@Override
	public T removeBack()
	{
		return dq.remove( dq.getLength() - 1 );
	}

	@Override
	public T getFront()
	{
		return dq.getEntry( 0 );
	}

	@Override
	public T getBack()
	{
		return dq.getEntry( dq.getLength() - 1 );
	}

	@Override
	public String toFormattedString()
	{
		String str = "{ " + dq.toString() + " }";
		return str;
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
	
	public int getSize()
	{
		return dq.getLength();
	}
	
}
