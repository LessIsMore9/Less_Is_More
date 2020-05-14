package edu.snu.csne.ds;

public class Main {

	public static void main(String[] args)
	{
		EfficiencyTesting e = new EfficiencyTesting();
		e.getEfficiencies();
		
		BubbleSorter<Integer> b = new BubbleSorter<Integer>();
		
		Integer[] array = { 2 , null, 5 , 6 , null, 4, 1 };
		
		b.sort(array);
		System.out.println( array.toString() );
	}

}
