package edu.snu.csne.ds;

import org.junit.Test;
import org.junit.Assert;

public class CustomPriorityQueueADTTest
{
	CustomPriorityQueueADT<String> cpq = 
			new CustomPriorityQueueADT<String>();
	
	@Test
	public void addTest()
	{
		cpq.add("a");
		cpq.add("b");
		cpq.add("c");
		Assert.assertEquals("c", cpq.peek());
		cpq.clear();
		// does add work regardless of order?
		cpq.add("b");
		cpq.add("c");
		cpq.add("a");
		Assert.assertEquals("c", cpq.peek());
	}
	
	@Test
	public void removeTest()
	{
		cpq.add("a");
		cpq.add("b");
		cpq.add("c");
		Assert.assertEquals("c", cpq.remove());
		Assert.assertEquals("b", cpq.peek());
		cpq.clear();
		// does remove work regardless of order?
		cpq.add("b");
		cpq.add("c");
		cpq.add("a");
		cpq.remove();
		Assert.assertEquals("b", cpq.peek());
		cpq.remove();
		Assert.assertEquals("a", cpq.peek());
	}
	
	@Test
	public void clearTest()
	{
		cpq.add("a");
		cpq.add("b");
		cpq.add("c");
		cpq.clear();
		Assert.assertEquals(cpq.getSize(), 0);
	}
	
	@Test
	public void getSizeTest()
	{
		cpq.add("a");
		cpq.add("b");
		cpq.add("c");
		Assert.assertEquals(3, cpq.getSize());
		cpq.clear();
		Assert.assertEquals(0, cpq.getSize());
	}
}
