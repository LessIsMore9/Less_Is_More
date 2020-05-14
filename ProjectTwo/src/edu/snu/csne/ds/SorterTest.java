package edu.snu.csne.ds;
import org.junit.Test;

import org.junit.Assert;

import java.util.Arrays;

public class SorterTest<T>
{
	ShellSorter<Integer> shell = new ShellSorter<>();
	BubbleSorter<Integer> bubble = new BubbleSorter<>();
	MergeSorter<Integer> merge = new MergeSorter<>();
	
	public final Integer[] _array = { 9 , 10 , 4 , 200 , 16 , 22 , 2 , 8 , 11 , 9 , 16 , -3 };
	public final Integer[] array = { 9 , 10 , 4 , 200 , 16 , 22 , 2 , 8 , 11 , 9 , 16 , -3 };
	public final Integer[] arr1 = {};
	public final Integer[] arr2 = { null, null, null };
	public final Integer[] arr3 = null;
	public final Integer[] arr4 = { null, null, 22 };
	
	
	/*
	 * shell sorter tests
	 */
	@Test
	public void shellSortTest0()
	{
		Arrays.parallelSort( _array );
		Assert.assertArrayEquals( shell.sort( array ) , _array );
	}
	
	@Test
	public void shellSortTest1()
	{
		Assert.assertArrayEquals( shell.sort(arr1), arr1);
	}
	
	@Test
	public void shellSortTest2()
	{
		Assert.assertArrayEquals( shell.sort( arr2 ), arr2 );
	}
	
	@Test(expected = IllegalStateException.class)
	public void shellSortTest3()
	{
		shell.sort(arr3);
	}
	
	@Test
	public void shellSortTest4()
	{
		Assert.assertArrayEquals( shell.sort(arr4), arr4 );
	}
	
	/*
	 * bubble sorter tests
	 */
	@Test
	public void bubbleSortTest0()
	{
		Arrays.parallelSort( _array );
		Assert.assertArrayEquals( bubble.sort( array ) , _array );
	}
	
	@Test
	public void bubbleSortTest1()
	{
		Assert.assertArrayEquals( bubble.sort(arr1), arr1);
	}
	
	@Test //(expected = NullPointerException.class)
	public void bubbleSortTest2()
	{
		Assert.assertArrayEquals( bubble.sort( arr2 ), arr2 );
	}
	
	@Test(expected = IllegalStateException.class)
	public void bubbleSortTest3()
	{
		bubble.sort(arr3);
	}
	
	@Test //(expected = NullPointerException.class)
	public void bubbleSortTest4()
	{
		Assert.assertArrayEquals( bubble.sort(arr4), arr4 );
	}
	
	
	/*
	 * merge sorter tests
	 */
	@Test
	public void mergeSortTest0()
	{
		Arrays.parallelSort( _array );
		Assert.assertArrayEquals( merge.sort( array ) , _array );
	}
	
	@Test
	public void mergeSortTest1()
	{
		Assert.assertArrayEquals( merge.sort(arr1), arr1);
	}
	
	@Test
	public void mergeSortTest2()
	{
		Assert.assertArrayEquals( merge.sort( arr2 ), arr2 );
	}
	
	@Test(expected = IllegalStateException.class)
	public void mergeSortTest3()
	{
		merge.sort(arr3);
	}
	
	@Test
	public void mergeSortTest4()
	{
		Assert.assertArrayEquals( merge.sort(arr4), arr4 );
	}
}
