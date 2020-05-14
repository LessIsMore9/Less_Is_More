package edu.snu.csne.ds;

import org.junit.Test;
import org.junit.Assert;

public class LinkedNiceListADTTest
{
	
	LinkedNiceListADT nl = new LinkedNiceListADT();
	
	String[] str = { "John", "Sara", "Allison", "Peter" };
	ListADT<String> arr1 = new ArrayListADT<String>(100);
	ListADT<String> arr2 = new ArrayListADT<String>(100);
	ListADT<String> arr3 = new ArrayListADT<String>(100);
	ListADT<String> arr4 = new ArrayListADT<String>(100);
	
	
	
	/*
	 * utility method tests
	 */
//	@Test
//	public void getNodeAtIndexText()
//	{
//		
//	}
//	
//	public void getNodeAtNameTest()
//	{
//		
//	}
	
	@Test
	public void addTest()
	{
		nl.add(str[0], arr1);
		Assert.assertTrue( nl.getLength() == 1 );
		nl.add(str[1], arr2);
		nl.add(str[2], arr3);
		Assert.assertTrue( "first set not added (add test)", nl.contains( "John" ) );
		Assert.assertTrue( "second set not added (add test)", nl.contains( "Sara" ) );
		Assert.assertTrue( "third set not added (add test)", nl.contains( "Allison" ) );
		Assert.assertTrue( nl.getLength() == 3 );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeTest()
	{
		nl.add(str[0], arr1);
		Assert.assertTrue( nl.getLength() == 1 );
		nl.add(str[1], arr2);
		nl.add(str[2], arr3);
		Assert.assertTrue( nl.contains("John") );
		nl.remove("John");
		Assert.assertFalse( nl.contains("John") );
		nl.clear();
		nl.remove(str[0]);
	}
	
	@Test
	public void containsTest()
	{
		nl.add(str[0], arr1);
		Assert.assertTrue( nl.getLength() == 1 );
		nl.add(str[1], arr2);
		nl.add(str[2], arr3);
		Assert.assertTrue( nl.contains("John") );
		Assert.assertTrue( nl.contains("Allison") );
		nl.remove( "John" );
		Assert.assertFalse( nl.contains("John") );
	}
}






