package edu.snu.csne.ds;

import org.junit.Test;
import org.junit.Assert;

public class CustomDequeADTTest
{
	CustomDequeADT<String> cd = new CustomDequeADT<String>(25);
	
	@Test
	public void addToFrontTest()
	{
		cd.addToFront("a");
		Assert.assertEquals(cd.getFront(), "a");
		cd.addToFront("b");
		cd.addToFront("c");
		Assert.assertEquals(cd.getFront(), "c");
		Assert.assertEquals(cd.getSize(), 3);
	}
	
	@Test
	public void addToBackTest()
	{
		cd.addToBack("a");
		Assert.assertEquals(cd.getBack(), "a");
		cd.addToBack("b");
		cd.addToBack("c");
		Assert.assertEquals(cd.getBack(), "c");
		Assert.assertEquals(cd.getSize(), 3);
	}
	
	@Test
	public void removeTests()
	{
		cd.addToFront("a");
		Assert.assertEquals(cd.getFront(), "a");
		cd.addToFront("b");
		cd.addToFront("c");
		cd.removeFront();
		Assert.assertEquals(cd.getSize(), 2);
		cd.removeBack();
		Assert.assertEquals(cd.getFront(), "b");
		Assert.assertEquals(cd.getSize(), 1);
	}
	
	@Test
	public void clearTest()
	{
		cd.addToFront("a");
		Assert.assertEquals(cd.getFront(), "a");
		cd.addToFront("b");
		cd.addToFront("c");
		cd.clear();
		Assert.assertEquals(cd.getSize(), 0);
	}
	
	@Test
	public void isEmptyTest()
	{
		cd.addToFront("a");
		Assert.assertEquals(cd.getFront(), "a");
		cd.addToFront("b");
		cd.addToFront("c");
		Assert.assertFalse( cd.isEmpty() );
		cd.clear();
		Assert.assertTrue( cd.isEmpty() );
	}
	
}
