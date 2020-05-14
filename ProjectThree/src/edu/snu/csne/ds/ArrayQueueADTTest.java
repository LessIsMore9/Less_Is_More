package edu.snu.csne.ds;
import org.junit.Test;
import org.junit.Assert;

public class ArrayQueueADTTest
{
	ArrayQueueADT< String > k = new ArrayQueueADT< String >( 1000 );
	
	String[] st = { "blue" , "red" , "yellow" , "green" };
	
	@Test
	public void enqueueTest()
	{
		k.enqueue( st[0] );
		k.enqueue( st[1] );
		k.enqueue( st[2] );
		Assert.assertEquals( "blue" , k.getFront() );
	}
	
	@Test
	public void dequeueTest()
	{
		k.enqueue( st[0] );
		k.enqueue( st[1] );
		k.enqueue( st[2] );
		Assert.assertEquals( "blue" , k.dequeue() );
		Assert.assertEquals( "red" , k.dequeue() );
		Assert.assertEquals( "yellow" ,  k.dequeue() );
	}
	
	@Test
	public void getFrontTest()
	{
		k.enqueue( st[0] );
		k.enqueue( st[1] );
		k.enqueue( st[2] );
		Assert.assertEquals( "blue" , k.getFront() );
	}
	
	@Test
	public void isEmptyTest1()
	{
		k.enqueue( st[0] );
		k.enqueue( st[1] );
		k.enqueue( st[2] );
		Assert.assertFalse( k.isEmpty() );
	}
	
	@Test
	public void isEmptyTest2()
	{
		Assert.assertTrue( k.isEmpty() );
	}
	
	@Test
	public void clearTest()
	{
		k.enqueue( st[0] );
		k.enqueue( st[1] );
		k.enqueue( st[2] );
		k.clear();
		Assert.assertTrue( k.isEmpty() );
	}
	
	
}
