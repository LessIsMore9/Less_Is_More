package edu.snu.csne.ds;

public interface ListADT< T >
{
	// ListADT interface
	public void add( T newEntry );
	public void add( int newIndex , T newEntry );
	public T remove( int index );
	public void clear();
	public T replace( int givenIndex , T newEntry );
	public T getEntry( int givenIndex );
	public T[] toArray();
	public boolean contains( T entry );
	public int getLength();
	public boolean isEmpty();
}
