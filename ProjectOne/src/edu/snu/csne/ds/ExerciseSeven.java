package edu.snu.csne.ds;

public class ExerciseSeven
{
	public static void main( String[] args )
	{
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
		 */
		
		
		
		// start clock, return avg of 50 iterations at the end
		long start = System.currentTimeMillis();
		for ( int k = 0 ; k < 50 ; k ++ )
		{
			System.out.println( "Attempt " + k + " out of 50" );
			bag.add( "hello" );
			while ( bag.getNumberOfEntries() != 0 )
			{
				// pull random item from bag
				String currentItem = bag.remove();
				System.out.println( "Just removed item: " + currentItem );
				// substring(1) returns string w/o head character
				String subString = currentItem.substring( 1 );
				// if there is something left to add, add it twice
				if ( currentItem.length() != 1 )
				{
					bag.add( subString );
					bag.add( subString );
				}
			}
		}
		long stop = System.currentTimeMillis();
		// take average execution
		long avgTime = ( stop - start ) / 50;
		System.out.println( "average execution for Hydra method performed in " + avgTime + " milliseconds" );
	}
	
}
