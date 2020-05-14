package edu.snu.csne.ds;
import org.junit.Test;

import org.junit.Assert;

import java.util.Arrays;

public class SorterTest
{
	ShellSortAlternateAlg shell = new ShellSortAlternateAlg();
	ShellSort _shell = new ShellSort();
	BubbleSort bubble = new BubbleSort();
	InPlaceMergeSort merge = new InPlaceMergeSort();
	
	public final int[] _array = { 10 , 9 , 4 , 200 , 16 , 22 , 2 , 8 , 11 , 9 , 16 , -3 };
	public final int[] array = { 10 , 9 , 4 , 200 , 16 , 22 , 2 , 8 , 11 , 9 , 16 , -3 };
	
	@Test
	public void shellSortAlternativeTest()
	{
		Arrays.parallelSort( _array );
		Assert.assertArrayEquals( shell.shellSort( array ) , _array );
	}
	
	@Test
	public void shellSortTest()
	{
		Arrays.parallelSort( _array );
		Assert.assertArrayEquals( _shell.shellSort( array ) , _array );
	}
	
	@Test
	public void bubbleSortTest()
	{
		Arrays.parallelSort( _array );
		Assert.assertArrayEquals( bubble.bubbleSort( array ), _array );	
	}
	
	@Test
	public void mergeSortTest()
	{
		Arrays.parallelSort( _array );
		Assert.assertArrayEquals( merge.mergeSort( array , 0 , array.length - 1 ) , _array );	
	}
}
