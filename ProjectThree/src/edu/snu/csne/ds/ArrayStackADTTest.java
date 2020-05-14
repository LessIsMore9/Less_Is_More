package edu.snu.csne.ds;
import org.junit.Test;
import org.junit.Assert;

public class ArrayStackADTTest
{
	// create stack via interface
	ArrayStackADT< String > stk = new ArrayStackADT< String >( 1000 );
	
	String[] st = { "blue" , "red" , "yellow" , "green" };
	
	@Test
	public void pushTest()
	{
		stk.push( st[1] );
		stk.push( st[2] );
		stk.push( st[3] );
		Assert.assertEquals( stk.pop() , "green" );
		Assert.assertEquals( stk.pop() , "yellow" );
		Assert.assertEquals( stk.pop() , "red" );
	}
	
	@Test
	public void popTest()
	{
		stk.push( st[1] );
		stk.push( st[2] );
		stk.push( st[3] );
		Assert.assertEquals( stk.pop() , "green" );
		Assert.assertEquals( stk.pop() , "yellow" );
		Assert.assertEquals( stk.pop() , "red" );
	}
	
	@Test
	public void peekTest()
	{
		stk.push( st[1] );
		stk.push( st[2] );
		stk.push( st[3] );
		Assert.assertEquals( "green" , stk.peek() );
	}
	
	@Test
	public void isEmptyTest()
	{
		stk.clear();
		Assert.assertTrue( stk.isEmpty() );
	}
	
	@Test
	public void clearTest()
	{
		stk.push( st[1] );
		stk.push( st[2] );
		stk.push( st[3] );
		stk.clear();
		Assert.assertTrue( stk.isEmpty() );
	}
}
