package edu.snu.csne.ds;

public class ExerciseFour< T >
{
	
	public long getExecTimeA( int size )
	{
		ArrayBagADT< T > bag = new ArrayBagADT< T >( size );
		long start = System.currentTimeMillis();
		for ( int j = 0 ; j < 500 ; j ++ )
		{
			bag.toArrayA();
		}
		long stop = System.currentTimeMillis();
		return ( stop - start ) / 500;
	}
	
	public long getExecTimeB( int size )
	{
		ArrayBagADT< T > bag = new ArrayBagADT< T >( size );
		long start = System.currentTimeMillis();
		for ( int j = 0 ; j < 500 ; j ++ )
		{
			bag.toArrayB();
		}
		long stop = System.currentTimeMillis();
		return ( stop - start ) / 500;
	}
}
