package edu.snu.csne.ds;

public class Main
{

	public static void main(String[] args)
	{
		/*
		 * Exercise Two
		 */

		// assign array of large n
		int[] array = new int[ 100 ];
		for ( int i = 0 ; i < 100 ; i ++ )
		{
			array[ i ] = i * 5000;
		}
		ExerciseTwo.getValueOfN( array );
		
		/*
		 * Exercise four
		 */
		
		// string implementation of ArrayBagADT
		ExerciseFour< String > four = new ExerciseFour< String >();
		for ( int i = 0 ; i < 100 ; i ++ )
		{
			// to try for bags of different sizes
			long result = four.getExecTimeA( i * 50 ) - four.getExecTimeB( i * 500 );
			if ( result >= 0 )
			{
				System.out.println( "Method B is faster for bag of size " + i * 500 );
			}
			else
			{
				System.out.println( "Method A is faster for bag of size " + i * 500 );
			}
		}
		
		
		
		
		/*
		 *  Exercise seven
		 */
		
		
		// bag object
		ArrayBagADT< String > bag = new ArrayBagADT< String >( 100 );
		
		/*
		 * check if bag is empty
		 * if not,
		 * remove str from bag
		 * if word is one letter, break
		 * if not,
		 * delete first letter
		 * put this new entry into bag twice
		 * inc numOfEntries by two
		 * if substring is one letter, don't add substring
		 * 
		 * I'd predict this algorithm to be O(n^2) time, as each
		 * additional character in the original string will cause
		 * almost a subtree of further decisions.
		 */
		
		
		
		// start clock, return avg of 50 iterations at the end
		long start = System.currentTimeMillis();
		for ( int k = 0 ; k < 50 ; k ++ )
		{
			System.out.println( "Attempt " + k + " out of 50" );
			bag.add( "hello" );
			while ( bag.getNumberOfEntries() != 0 )
			{
				String currentItem = bag.remove();
				System.out.println( "Just removed item: " + currentItem );
				String subString = currentItem.substring( 1 );
				if ( currentItem.length() != 1 )
				{
					bag.add( subString );
					bag.add( subString );
				}
			}
		}
		long stop = System.currentTimeMillis();
		long avgTime = ( stop - start ) / 50;
		System.out.println( "average execution for Hydra method performed in " + avgTime + " milliseconds" );
	}

}
