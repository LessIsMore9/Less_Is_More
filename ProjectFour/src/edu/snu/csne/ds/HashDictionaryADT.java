package edu.snu.csne.ds;
import java.util.ArrayList;
import java.util.Iterator; 

/**
 * a class for hash dictionary that uses an array list implementation
 */
public class HashDictionaryADT<K, V> extends DefaultDictionaryADT<K, V>
        implements DictionaryADT<K, V>
{
	// global variables
	// creates a new array list
	private ArrayList<Entry<K, V>> hash;
    // stores the capacity of the array list
    private int _capacity; 
    // stores the total entries
    private int _totalEntries; 
  
    /**
     * default constructor
     */
    public HashDictionaryADT() 
    { 
    	// default variables
        hash = new ArrayList<>(); 
        _capacity = 69;
        _totalEntries = 0;
        // for every index
        for (int i = 0; i < _capacity; i++) 
        {
        	// add blank linked chains
            hash.add(null); 
        }
    } 
    
    /**
     * custom constructor
     */
    public HashDictionaryADT(int capacity) 
    { 
    	// custom variables
        hash = new ArrayList<>(); 
        _capacity = capacity; 
        _totalEntries = 0; 
  
        // for every index 
        for (int i = 0; i < _capacity; i++) 
        {
        	// add blank linked chains
            hash.add(null); 
        }
    }
	
    /**
     * gets an array index using a hash function
     * 
     * @param a key
     * @return an int
     */
    private int getArrayIndex(K key) 
    { 
    	// get the hash code 
        int hashCode = key.hashCode(); 
        // use the modulus operator make sure it is within the array bounds
        int index = hashCode % _capacity;
        // extra safeguard for errors. if index < 0, just add length to
        // keep consistent with modulo arithmetic
        if ( index < 0 )
        {
        	index = index + _capacity;
        }
        // if we somehow get here, throw exception
        else if ( index > _capacity + 1 )
        {
        	throw new IllegalStateException();
        }
        // return the index
        return index; 
    }
    

    
    
    // Adds a key value pair to hash 
    public V add(K key, V value) 
    { 
    	// if the key or value is null, do nothing
    	if (key == null || value == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	// resize hashTable based on load factor efficiency
    	if ((_totalEntries/ _capacity) >= 0.5) 
	    { 
    		resize();
	    }
    	// store the result
    	V returnValue = null;
        // get the hashed index from the key
        int index = getArrayIndex(key);
        // store the current entry for the index we just found
        Entry<K, V> currentEntry = hash.get(index);
        // check for duplicates
        // while there are still entries
        while (currentEntry != null) 
        { 
        	// if the entry is found
            if (currentEntry._searchKey.equals(key)) 
            { 
            	// return the old value
                returnValue = currentEntry._value;
            	// update
                currentEntry._value = value; 
                // exit out of the loop, no need to travel to end of chain
                break;
            } 
            // else, keep looking until we reach end of chain
            currentEntry = currentEntry.next; 
        } 
        // if there are no duplicates
        if (currentEntry == null)
        {
	        // find the index to insert the new key
	        currentEntry = hash.get(index); 
	        // create a new node with the new key value pair
	        Entry<K, V> node = new Entry<K, V>(key, value); 
	        // make the new node the head of the chain
	        node.next = currentEntry; 
	        // set the new node
	        hash.set(index, node); 
	        // update size
	        _totalEntries++; 
	        // return the old value if there is one
        }
        return returnValue;
    } 
    
    /**
	 * resizes the array based on load factor
	 */
    public void resize()
    {
    	// create a new array to copy the values
        ArrayList<Entry<K, V>> tempHashArray = hash; 
        hash = new ArrayList<>(); 
        // increase the capacity of the new array
        _capacity = 2 * _capacity; 
        // update the size to start over
        _totalEntries = 0; 
        // go through each index
        for (int i = 0; i < _capacity; i++) 
        {
        	// start the blank linked chains again
            hash.add(null); 
        }
        // add the other nodes for each array index
        for (Entry<K, V> currentNode : tempHashArray) 
        { 
        	// while there are nodes to add
            while (currentNode != null) 
            { 
            	// add it to the linked chain
                add(currentNode._searchKey, currentNode._value); 
                currentNode = currentNode.next; 
            } 
        }  
    }
    
    /**
	 * removes k,v entry from dictionary
	 */
    public V remove(K key) 
    { 
    	// if the key is null, do nothing
    	if (key == null)
    	{
    		return null;
    	}
        // get the index
        int index = getArrayIndex(key); 
        // stores the removed value
        V removedValue = null;
        // if the index is in bounds
        if (index > 0)
        {
        	// store the entry in hash array
	        Entry<K, V> currentEntry = hash.get(index); 
	        // stores the entry before the removed one
	        Entry<K, V> previousEntry = null; 
	        // while the linked chain is not empty
	        while (currentEntry != null) 
	        { 
	            // if the key is found
	            if (currentEntry._searchKey.equals(key))
	            {
	            	// break out
	                break; 
	            }
	            else
	            {
		            // else, keep looking
		            previousEntry = currentEntry; 
		            currentEntry = currentEntry.next; 
	            }
	        } 
	        // if the key searched for was not there
	        if (currentEntry == null)
	        {
	        	// return null
	            return null; 
	        }
	        // if it was
	        else
	        {
		        // if there was a previous node that was valid
		        if (previousEntry != null) 
		        {
		        	// update the reference
		            previousEntry.next = currentEntry.next; 
		        }
		        else
		        {
		        	// set the reference to the new value
		            hash.set(index, currentEntry.next); 
		        }
	        }
	        // update the value
	        removedValue = currentEntry._value; 
        }
        // update the number of entries
        _totalEntries--; 
        // return the value
        return removedValue;
    }
    
    /**
	 * retrieves k,v from dictionary
	 */
    public V getValue(K key) 
    { 
    	// if the key is not valid, do nothing
    	if (key == null)
    	{
    		return null;
    	}
        // get the index
        int index = getArrayIndex(key); 
        // store the returned value
        V returnValue = null;
        // if the index is in bounds
        if (index > 0)
        {
        	// store the current entry given the index
	        Entry<K, V> currentEntry = hash.get(index); 
	        // while there are still entries to check
	        while (currentEntry != null) 
	        { 
	        	// if the keys are =
	            if (currentEntry._searchKey.equals(key)) 
	            {
	            	// update the value and exit the loop
	                returnValue = currentEntry._value;
	                break;
	            }
	            // if not, keep searching
	            else
	            {
	            	currentEntry = currentEntry.next; 
	            }
	        } 
        }
        // return the value
        return returnValue; 
    } 
	
    /**
	 * clears a dictionary
	 */
    public void clear()
    {
    	// go through each index
    	for (int i = 0; i < _capacity; i++) 
        {
    		// set them all to null
            hash.set(i, null); 
    	}
    	// update the total entries
    	_totalEntries = 0;
    }
    
    /**
	 * returns the total size
	 */
    public int getSize() 
    { 
    	return _totalEntries; 
    } 
    
    /**
	 * checks to see if the dictionary is empty
	 */
    public boolean isEmpty() 
    { 
    	return _totalEntries == 0; 
    } 
    
    /**
	 * checks to see if the dictionary contains a key
	 */
    public boolean contains(K key)
    {
    	// if the key is not valid, do nothing
    	if (key == null)
    	{
    		return false;
    	}
    	// store if it contains
    	boolean doesContain = false;
    	// get the index
        int index = getArrayIndex(key); 
        // if the index is valid
        if (index > 0)
        {
        	// store the current entry
	        Entry<K, V> currentEntry = hash.get(index); 
	        
	        // while there are still entries
	        while (currentEntry != null) 
	        { 
	        	// if the keys are =
	            if (currentEntry._searchKey.equals(key)) 
	            {
	            	// it contains it
	                doesContain = true;
	                // break out
	                break;
	            }
	            // if not, keep searching
	            else
	            {
	            	currentEntry = currentEntry.next; 
	            }
	        } 
        }
        // return if it contains the value
    	return doesContain;
    }
    
    /**
	 * checks to see if the dictionary is full
	 */
    public boolean isFull()
    {
    	// stores if it is full
    	boolean result = false;
    	// if the total = the size
    	if (_totalEntries == _capacity)
    	{
    		// it is full
    		result = true;
    	}
    	return result;
    }
	
    /**
	 * prints the dictionary out in the form of a string
	 */
    public String toFormattedString() 
	{
    	// start the string
    	String string = "(";
    	// go through the dictionary and print the entries
        for(@SuppressWarnings("rawtypes") Entry entry : hash) 
        {
            string += entry + ",";
        }
        // return a formatted string
        return string = (String) string.subSequence(0, 
        				 string.length() - 1) + ")";
	}
    
    public Iterator<K> getKeyIterator()
    {
    	return new KeyIterator();
    }
    
    public Iterator<V> getValueIterator()
    {
    	return new ValueIterator();
    }
    
    /**
	 * a class that creates a key iterator
	 */
    private class KeyIterator implements Iterator<K>
	{
    	// global variables
    	// stores the current index
		private int _currentIndex;
		// stores how many entries are left to check
		private int _numberLeft;
		// stores an entry
		private Entry<K, V> _entry;
		
		/**
		 * default constructor
		 */
		private KeyIterator()
		{
			_currentIndex = 0;
			_numberLeft = _totalEntries;
		}
		
		/**
		 * searches if the dictionary has a next entry
		 * 
		 * @return boolean
		 */
		public boolean hasNext()
		{
			return _numberLeft > 0;
		}
		
		/**
		 * searches for the next key and retrieves it
		 * 
		 * @return the generic value
		 */
		public K next()
		{
			// stores the result
			K key = null;
			// if there is another entry
			if (hasNext())
			{
				// look through the dictionary
				for (int i = 0; i < _capacity;i++)
				{
					// while the entries are not null
					while (hash.get(i) == null)
					{
						// increase the index
						_currentIndex++;
					}
					// get the key
					_entry = hash.get(_currentIndex);
					key = _entry.getKey();
					// update how many entries are left to check
					_numberLeft--;
					// update the index
					_currentIndex++;
				}
			}
			// return the key
			return key;
		}
	}

    /**
	 * a class that creates a key iterator
	 */
    private class ValueIterator implements Iterator<V>
	{
    	// global variables
    	// stores the current index
		private int _currentIndex;
		// stores how many entries are left to check
		private int _numberLeft;
		// stores an entry
		private Entry<K, V> _entry;
		
		/**
		 * default constructor
		 */
		private ValueIterator()
		{
			_currentIndex = 0;
			_numberLeft = _totalEntries;
		}
		
		/**
		 * searches if the dictionary has a next entry
		 * 
		 * @return boolean
		 */
		public boolean hasNext()
		{
			return _numberLeft > 0;
		}
		
		/**
		 * searches for the next value and retrieves it
		 * 
		 * @return the generic value
		 */
		public V next()
		{
			// stores the result
			V value = null;
			// if there is another entry
			if (hasNext())
			{
				// look through the dictionary
				for (int i = 0; i < _capacity;i++)
				{
					// while the entries are not null
					while (hash.get(i) == null)
					{
						// increase the index
						_currentIndex++;
					}
					// get the key
					_entry = hash.get(_currentIndex);
					value = _entry.getValue();
					// update how many entries are left to check
					_numberLeft--;
					// update the index
					_currentIndex++;
				}
			}
			// return the value
			return value;
		}
	}

    
    /**
	 * a class that creates an entry used in hash dictionary
	 */
	private class Entry<S, T> 
	{ 
		// global variables
		// stores the search key
	    S _searchKey; 
	    // stores the value
	    T _value; 
	    // stores the next entry
	    Entry<K, V> next; 
	  
	    /**
		 * constructor
		 * 
		 * @param a search key and a value
		 */
	    public Entry(S searchKey, T value) 
	    { 
	        _searchKey = searchKey; 
	        _value = value; 
	    } 
	    
	    /**
		 * gets the key in an entry
		 * 
		 * @return a key
		 */
	    public S getKey()
	    {
	    	return _searchKey;
	    }
	    
	    /**
		 * gets the value in an entry
		 * 
		 * @return a value
		 */
	    public T getValue()
	    {
	    	return _value;
	    }
	} 
	
}
