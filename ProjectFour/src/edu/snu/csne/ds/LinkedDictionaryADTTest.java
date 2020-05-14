package edu.snu.csne.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import org.junit.Test;

public class LinkedDictionaryADTTest<K extends Comparable<? super K>, V>
{
	
	
	// phone book attributes
	protected static String _cat = "cat";
	protected static String _0102 = "0102";
	protected static String _dog = "dog";
	protected static String _0103 = "0103";
	protected static String _banana = "banana"; 
	protected static String _0104 = "0104";
	
	@Test
	public void addTest() 
	{
		 LinkedDictionaryADT<String, String> _addPhoneBook 
		= new LinkedDictionaryADT<String, String>();
		_addPhoneBook.add(_cat, _0102);
		assertTrue("Did not add correctly", _addPhoneBook.contains(_cat));
		_addPhoneBook.add(_dog, _0103);
		assertTrue("Did not add correctly", _addPhoneBook.contains(_dog));
		assertEquals("Did not return correct value", _addPhoneBook.add(_dog, _0104), _0103);
	}
	
	@Test
	public void removeTest() 
	{
		// creates a new phone book
		LinkedDictionaryADT<String, String> _removePhoneBook 
		= new LinkedDictionaryADT<String, String>();
		_removePhoneBook.add(_cat, _0102);
		assertEquals("Did not remove", _removePhoneBook.remove(_cat), _0102);
		_removePhoneBook.add(_dog, _0103);
		assertEquals("Did not remove", _removePhoneBook.remove(_dog), _0103);
		assertTrue("Dictionary should be empty", _removePhoneBook.isEmpty());
	}

	@Test
	public void getValueTest() 
	{
		// creates a new phone book
		LinkedDictionaryADT<String, String> _getValuePhoneBook 
		= new LinkedDictionaryADT<String, String>();
		_getValuePhoneBook.add(_cat, _0102);
		assertEquals("Did not return correctly", _getValuePhoneBook.getValue(_cat), _0102);
		_getValuePhoneBook.add(_dog, _0103);
		assertEquals("Did not return correctly", _getValuePhoneBook.getValue(_dog), _0103);
		_getValuePhoneBook.add(_dog, _0104);
		assertEquals("Did not return correctly", _getValuePhoneBook.getValue(_dog), _0104);
	}
	
	@Test
	public void containsTest() 
	{
		// creates a new phone book
		LinkedDictionaryADT<String, String> _containsPhoneBook = new LinkedDictionaryADT<String, String>();
		_containsPhoneBook.add(_dog, _0103);
		_containsPhoneBook.add(_cat, _0102);
		_containsPhoneBook.add(_banana, _0104);
		assertTrue("did not contain dog", _containsPhoneBook.contains(_dog));
		assertTrue("did not contain cat", _containsPhoneBook.contains(_cat));
		assertTrue("did not contain banana", _containsPhoneBook.contains(_banana));
		_containsPhoneBook.clear();
		assertFalse("contains entry after clearing", _containsPhoneBook.contains(_dog));
	}
	
	@Test
	public void getKeyIteratorTest() 
	{
		LinkedDictionaryADT<K, V> _keyIteratorPhoneBook 
		= new LinkedDictionaryADT<K, V>();
		Iterator<K> _ki = _keyIteratorPhoneBook.getKeyIterator();
		assertTrue( "did not return type KeyIterator",
				_keyIteratorPhoneBook.getKeyIterator().getClass().equals(_ki.getClass()));
	}
	@Test
	public void getValueIteratorTest() 
	{
		LinkedDictionaryADT<K, V> _valueIteratorPhoneBook 
		= new LinkedDictionaryADT<K, V>();
		Iterator<V> _vi = _valueIteratorPhoneBook.getValueIterator();
		// check to make sure the method returns type ValueIterator
		assertTrue( "did not return type ValueIterator",
				_valueIteratorPhoneBook.getValueIterator().getClass().equals(_vi.getClass()));
	}

	
	@Test
	public void isEmptyTest() 
	{
		LinkedDictionaryADT<String, String> _isEmptyPhoneBook 
		= new LinkedDictionaryADT<String, String>();
		assertTrue("Phonebook is not empty", _isEmptyPhoneBook.isEmpty());
		_isEmptyPhoneBook.add(_dog, _0103);
		assertFalse("phonebook is empty", _isEmptyPhoneBook.isEmpty());
	}
	
	@Test
	public void isFullTest()
	{
		// creates a new phone book with the size of 3
		LinkedDictionaryADT<String, String> _isFullPhoneBook 
		= new LinkedDictionaryADT<String, String>();
		
		// add 2 k:v to the dictionary
		_isFullPhoneBook.add(_dog, _0103);
		_isFullPhoneBook.add(_cat, _0102);
		
		// use assertFalse to see if phone book is full
		assertFalse("phone book is full", _isFullPhoneBook.isFull());
		
		// add another k:v to the dictionary and see if it is full
		// should resize itself
		_isFullPhoneBook.add(_banana, _0104);
		assertFalse("phone book is not full", _isFullPhoneBook.isFull());
	}
	
	@Test
	public void getSizeTest() 
	{
		// creates a new phone book
		LinkedDictionaryADT<String, String> _getSizePhoneBook 
		= new LinkedDictionaryADT<String, String>();
		
		// add 3 k:v to the dictionary
		_getSizePhoneBook.add(_dog, _0103);
		_getSizePhoneBook.add(_cat, _0102);
		_getSizePhoneBook.add(_banana, _0104);
		
		// use assertEquals to see if the size is 3
		assertEquals("Size is not 3", _getSizePhoneBook.getSize(), 3);
		
		// remove two values and check size
		_getSizePhoneBook.remove(_dog);
		_getSizePhoneBook.remove(_cat);
		assertEquals("Size is not 1", _getSizePhoneBook.getSize(), 1);
		
		// remove the last value and see if the size is 0
		_getSizePhoneBook.remove(_banana);
		assertEquals("Size is not 0", _getSizePhoneBook.getSize(), 0);
	}
	
	@Test
	public void clearTest() 
	{
		// creates a new phone book
		LinkedDictionaryADT<String, String> _clearPhoneBook
		= new LinkedDictionaryADT<String, String>();
		
		// add 3 k:v to the dictionary
		_clearPhoneBook.add(_dog, _0103);
		_clearPhoneBook.add(_cat, _0102);
		_clearPhoneBook.add(_banana, _0104);
		
		// use isEmpty to see if it is empty
		assertFalse("Dictionary is empty", _clearPhoneBook.isEmpty());
		
		// clear the dictionary
		_clearPhoneBook.clear();
		
		// use isEmpty to see if it is empty
		assertTrue("Dictionary is empty", _clearPhoneBook.isEmpty());
	}
	
	@Test
	public void toFormattedStringTest()
	{
		// creates a new phone book
		LinkedDictionaryADT<String, String> _TFSPhoneBook
		= new LinkedDictionaryADT<String, String>();
		String str = "";
		// add 3 k:v to the dictionary
		_TFSPhoneBook.add(_dog, _0103);
		_TFSPhoneBook.add(_cat, _0102);
		_TFSPhoneBook.add(_banana, _0104);
		assertEquals("Did not return type String", _TFSPhoneBook.toFormattedString().getClass(), str.getClass() );
	}
}
