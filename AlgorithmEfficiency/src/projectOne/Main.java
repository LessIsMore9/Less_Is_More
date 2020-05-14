package projectOne;

public class Main
{

	public static void main(String[] args)
	{
		// exercise two
		// ExerciseTwo.getValueOfN();
		
		// exercise four, string implementation of BagADT
		ExerciseFour< String > four = new ExerciseFour< String >();
		long result = four.getExecTimeA() - four.getExecTimeB();
		if ( result >= 0 )
		{
			System.out.println( "Method B is faster" );
		}
		else if ( result < 0 )
		{
			System.out.println( "Method A is faster" );
		}
	}

}
