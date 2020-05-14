package edu.snu.csne.ds;

import java.util.Random;

public class EfficiencyTesting
{
	Random rd = new Random();
	
	BubbleSort bubble = new BubbleSort();
	InPlaceMergeSort merge = new InPlaceMergeSort();
	ShellSortAlternateAlg shell = new ShellSortAlternateAlg();
	
	public int[] getRandomArray( int n )
	{
		int[] array = new int[ n ];
		for ( int i = 0 ; i < n ; i ++ )
		{
			array[ i ] = rd.nextInt();	
		}
		return array;
	}
	
	public void getEfficiencies()
	{
		// small n
		for ( int n = 2 ; n <= 600 ; n += 2 )
		{
			int[] array = getRandomArray( n );
			
			long b = bubble.getExecTimeBubble( array ) / 1000;
			long m = merge.getExecTimeMerge( array ) / 1000;
			long s = shell.getExecTimeShellAlt( array ) / 1000;
			
			System.out.println( "For n = " + n );
			System.out.println( "BSE: " + b +
					", MSE: " + m +
					", SSE: " + s );
			System.out.println();
		}
		
		// large n
		for ( int n = 2 ; n <= 100000000 ; n *= 5 )
		{
			int[] array = getRandomArray( n );
			
			long b = bubble.getExecTimeBubble( array ) / 1000;
			long m = merge.getExecTimeMerge( array ) / 1000;
			long s = shell.getExecTimeShellAlt( array ) / 1000;
			
			System.out.println( "For n = " + n );
			System.out.println( "BSE: " + b +
					", MSE: " + m +
					", SSE: " + s );
			System.out.println();
		}
	}
}
