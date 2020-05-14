package projectOne;
import java.util.Date;

public class ExerciseFour< T >
{
	BagADT< T > bag = new BagADT< T >();
	
	public long getExecTimeA()
	{
		// date object
		Date current = new Date();
		// start clock
		long startTime = current.getTime();
		bag.toArrayA();
		// stop clock
		long stopTime = current.getTime();
		// exec time
		long execTime = stopTime - startTime;
		System.out.println( "Execution time of toArrayA is " + execTime );
		return execTime;
	}
	
	public long getExecTimeB()
	{
		// date object
		Date current = new Date();
		// start clock
		long startTime = current.getTime();
		bag.toArrayB();
		// stop clock
		long stopTime = current.getTime();
		// exec time
		long execTime = stopTime - startTime;
		System.out.println( "Execution time of toArrayB is " + execTime );
		return execTime;
	}
}
