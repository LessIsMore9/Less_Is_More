package edu.snu.csne.ds;

import static org.junit.Assert.*;
import org.junit.Test;

public class BSTDictionaryADTTest<K, V> 
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
		// creates a new phone book
		 BSTDictionaryADT<String, String> _addPhoneBook 
		= new BSTDictionaryADT<String, String>();
		
		// add a key and value to the dictionary
		// use assertEquals and getValue to see if it made it
		_addPhoneBook.add(_cat, "0102");
		assertTrue("haley's name and/or phone number did "
					 + "not make it into the dictionary correctly",
				     _addPhoneBook.contains(_cat));
		
		// add another key and value to the dictionary
		// use assertEquals and getValue to see if it made it
		_addPhoneBook.add(_dog, "0103");
		assertTrue("sam's name and/or phone number did "
					 + "not make it into the dictionary correctly",
				     _addPhoneBook.contains(_dog));
		
		//_addPhoneBook.clear();
		// add a dupli_cate key with a different value to the dictionary
		// use assertEquals to see if the old phone number was returned correctly
		//_addPhoneBook.add(_dog, "0103");
		assertEquals("did not return the old phone number", 
				     _addPhoneBook.add(_dog, "0103"), "0103");

	}
	
	@Test
	public void removeTest() 
	{
		// creates a new phone book
		BSTDictionaryADT<String, String> _removePhoneBook 
		= new BSTDictionaryADT<String, String>();
		
		// add a k:v to the dictionary
		_removePhoneBook.add(_cat, "0102");
		
		// remove the k:v, use assertNotEquals and contains to see if it is still in there
		assertEquals("did not remove haley's number", _removePhoneBook.remove(_cat), "0102");
		
		// repeat with a different k:v
		_removePhoneBook.add(_dog, "0103");
		assertEquals("did not remove sam's number", _removePhoneBook.remove(_dog), "0103");
	}

	@Test
	public void getValueTest() 
	{
		// creates a new phone book
		BSTDictionaryADT<String, String> _getValuePhoneBook 
		= new BSTDictionaryADT<String, String>();
		
		// add a k:v to the dictionary
		_getValuePhoneBook.add(_cat, "0102");
		
		// use assertEquals to see if the returned the correct value
		assertEquals("did not return haley's #", _getValuePhoneBook.getValue(_cat), "0102");
		
		// repeat with a different k:v
		_getValuePhoneBook.add(_dog, "0103");
		assertEquals("did not return sam's #", _getValuePhoneBook.getValue(_dog), "0103");
		
		// replace the value and see if it will return the new value
		_getValuePhoneBook.add(_dog, "0103");
		assertEquals("did not return sam's #", _getValuePhoneBook.getValue(_dog), "0103");
	}
	
	@Test
	public void containsTest() 
	{
		// creates a new phone book
		BSTDictionaryADT<String, String> _containsPhoneBook 
		= new BSTDictionaryADT<String, String>();
		// Add 3 k:v’s, use contains and assertEquals to see if the dictionary contains the k:v’s
		_containsPhoneBook.add(_dog, "0103");
		_containsPhoneBook.add(_cat, "0102");
		_containsPhoneBook.add(_banana, "0103");
		assertTrue("did not contain sam", _containsPhoneBook.contains(_dog));
		assertTrue("did not contain haley", _containsPhoneBook.contains(_cat));
		assertTrue("did not contain home", _containsPhoneBook.contains(_banana));
	}

	
	@Test
	public void isEmptyTest() 
	{
		// creates a new phone book
		BSTDictionaryADT<String, String> _isEmptyPhoneBook 
		= new BSTDictionaryADT<String, String>();
		
		// use assertTrue to see if the phone book is empty
		assertTrue("phonebook is not empty", _isEmptyPhoneBook.isEmpty());
		
		// add something to the dictionary 
		_isEmptyPhoneBook.add(_dog, "0103");
		// use assertFalse to see if the phone book is empty
		assertFalse("phonebook is empty", _isEmptyPhoneBook.isEmpty());
	}
	
	@Test
	public void isFullTest()
	{
		// creates a new phone book with the size of 3
		BSTDictionaryADT<String, String> _isFullPhoneBook 
		= new BSTDictionaryADT<String, String>();
		
		// add 2 k:v to the dictionary
		_isFullPhoneBook.add(_dog, "0103");
		_isFullPhoneBook.add(_cat, "0102");
		
		// use assertFalse to see if phone book is full
		assertFalse("phone book is full", _isFullPhoneBook.isFull());
		
		// add another k:v to the dictionary and see if it is full
		// should resize itself
		_isFullPhoneBook.add(_banana, "0103");
		assertFalse("phone book is not full", _isFullPhoneBook.isFull());
	}
	
	@Test
	public void getSizeTest() 
	{
		// creates a new phone book
		BSTDictionaryADT<String, String> _getSizePhoneBook 
		= new BSTDictionaryADT<String, String>();
		
		// add 3 k:v to the dictionary
		_getSizePhoneBook.add(_dog, "0103");
		_getSizePhoneBook.add(_cat, "0102");
		_getSizePhoneBook.add(_banana, "0103");
		
		// use assertEquals to see if the size is 3
		assertEquals("size is not 3", _getSizePhoneBook.getSize(), 3);
		
		// remove two values and check size
		_getSizePhoneBook.remove(_dog);
		_getSizePhoneBook.remove(_cat);
		assertEquals("size is not 1", _getSizePhoneBook.getSize(), 1);
		
		// remove the last value and see if the size is 0
		_getSizePhoneBook.remove(_banana);
		assertEquals("size is not 0", _getSizePhoneBook.getSize(), 0);
	}
	
	@Test
	public void clearTest() 
	{
		// creates a new phone book
		BSTDictionaryADT<String, String> _clearPhoneBook
		= new BSTDictionaryADT<String, String>();
		
		// add 3 k:v to the dictionary
		_clearPhoneBook.add(_dog, "0103");
		_clearPhoneBook.add(_cat, "0102");
		_clearPhoneBook.add(_banana, "0103");
		
		// use isEmpty to see if it is empty
		assertFalse("dictionary is empty", _clearPhoneBook.isEmpty());
		
		// clear the dictionary
		_clearPhoneBook.clear();
		
		// use isEmpty to see if it is empty
		assertTrue("dictionary is empty", _clearPhoneBook.isEmpty());
	}
}