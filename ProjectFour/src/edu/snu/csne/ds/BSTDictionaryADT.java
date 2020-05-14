package edu.snu.csne.ds;

import java.util.Iterator;

/**
 * a class that creates a dictionary using a binary search tree
 */
public class BSTDictionaryADT<K extends Comparable<? super K>, V> 
	implements DictionaryADT<K, V> 
{
	// global variables
	// creates a new binary search tree
	private SearchTreeInterface<Entry<K, V>> _binarySearchTree; 

	/**
	 * default constructor
	 */
	public BSTDictionaryADT()
	{
		_binarySearchTree = new BinarySearchTree<>();
	}
	
	/**
	 * adds a value into the dictionary
	 * 
	 * @param a k:v pair
	 * @return a value if the key was a duplicate
	 */
	@Override
	public V add(K key, V value)
	{
		// if the k:v pair was not valid, do nothing
		if (key == null || value == null)
		{
			return null;
		}
		// store the returned value
		V returnedValue = null;
		// use add to recursively add the value to the dictionary
		Entry <K, V> newEntry = new Entry<>(key, value);
		Entry <K, V> returnedEntry = _binarySearchTree.add(newEntry);
		// result must be null for recursion to start
		returnedValue = null;
		// if the returned entry is found
		if (returnedEntry != null)
		{
			// update the returned value
			returnedValue = returnedEntry.getValue();
		}
		// return the value
		return returnedValue;
	}

	/**
	 * removes a value from the dictionary
	 * 
	 * @param a key
	 * @return a value
	 */
	@Override
	public V remove(K key)
	{
		// stores the returned value
		V returnedValue = null;
		// if the key was not valid, do nothing
		if (key == null)
		{
			return null;
		}
		// use remove to recursively remove the value from the dictionary
		Entry<K, V> findEntry = new Entry<>(key, null);
		Entry<K, V> returnedEntry = _binarySearchTree.remove( findEntry);
		// result must be null for recursion to start
		returnedValue = null;
		// if the returned entry is found
		if (returnedEntry != null)
		{
			// update the returned value
			returnedValue = returnedEntry.getValue();
		}
		// return the value
		return returnedValue;
	}

	/**
	 * retrieves a value from the dictionary
	 * 
	 * @param a key
	 * @return a value
	 */
	@SuppressWarnings("unused")
	public V getValue( K key )
	{
		/* conceptually should work like remove except it should call getEntry()
		 * however I was not able to get it to work like this
		 * 
		 * new solution removes the value, then adds it back
		 */
		// stores the result
		V value = null;
		// if the key was not valid, do nothing
		if (key == null)
		{
			return null;
		}
		// use remove to recursively remove the value from the dictionary
		Entry<K, V> findEntry = new Entry<>(key, null);
		Entry<K, V> returnedEntry = _binarySearchTree.remove( findEntry );
		// result must be null for recursion to start
		value = null;
		// if the returned entry is found
		if (returnedEntry != null)
		{
			// update the returned value
			value = returnedEntry.getValue();
			// now add it back
			Entry <K, V> newEntry = new Entry<>(key, value);
			Entry <K, V> addedEntry = _binarySearchTree.add(newEntry);
			V result2 = null;
		}
	// return the value
	return value;
	}


	/**
	 * checks to see if the dictionary contains a key
	 * 
	 * @param a key
	 * @return a boolean
	 */
	@Override
	//tests if the given key exists in dictionary
	public boolean contains( K key )
	{
		// stores if it contains the key
		boolean doesContain = false;
		// use the iterator to search for the key
		Iterator<K> keyIterator = getKeyIterator();
		// look through the dictionary
		for (int i = 0; i < _binarySearchTree.getNumberOfNodes(); i++)
		{
			// if the key entered = a key in the dictionary
			if (key == keyIterator.next())
			{
				// we have found it
				doesContain = true;
			}
		}
		//return the value
		return doesContain;
	}

	/**
	 * gets a key iterator
	 * @return a key iterator
	 */
	@Override
	public Iterator<K> getKeyIterator()
	{
		return new KeyIterator();
	}

	/**
	 * gets a value iterator
	 * @return a value iterator
	 */
	@Override
	//Value Iterator getter
	public Iterator<V> getValueIterator()
	{
		return new ValueIterator();
	}

	/**
	 * checks to see if the bst is empty
	 * @return a boolean
	 */
	@Override
	public boolean isEmpty()
	{
		return _binarySearchTree.isEmpty();
	}

	/**
	 * checks to see if the bst is full
	 * 
	 * will always be false because a bst
	 * can never be full 
	 * 
	 * @return false
	 */
	@Override
	public boolean isFull()
	{
		return false;
	}

	/**
	 * gets the size of the bst
	 * 
	 * @return an integer
	 */
	@Override
	public int getSize()
	{
		return _binarySearchTree.getNumberOfNodes();
	}

	/**
	 * clears the dictionary
	 */
	@Override
	public void clear()
	{
		_binarySearchTree.clear();

	}

	/**
	 * prints out the dictionary as a string
	 * 
	 * @return a string
	 */
	@Override
	public String toFormattedString()
	{
		// stores the value iterator
		Iterator<V> valueIterator = getValueIterator();
		// stores the key iterator
		Iterator<K> keyIterator = getKeyIterator();
		// beginning of the string
		String string = "";
		// while there are still k:v pairs
		while (valueIterator.hasNext())
		{
			// add it to the string
			string = string + " " + keyIterator.next() + " " + valueIterator.next();
		}
		// return the string
		return string;

	}

	/**
	 * a class that creates a value iterator
	 */
	private class ValueIterator implements Iterator<V>
	{
		// global variable
		// stores the iterator
		Iterator<Entry<K, V>> _iterator;
		
		/**
		 * a default constructor
		 */
		public ValueIterator()
		{
			_iterator = _binarySearchTree.getInorderIterator();
		}
		
		/**
		 * searches if a binary tree has a next value
		 * 
		 * @return boolean
		 */
		@Override
		public boolean hasNext()
		{
			return _iterator.hasNext();
		}

		/**
		 * searches for the next value and retrieves it
		 * 
		 * @return the generic value
		 */
		@Override
		public V next()
		{
			Entry<K, V> nextEntry = _iterator.next();
			return nextEntry.getValue();
		}
	}
	
	/**
	 * a class that creates a key iterator
	 */
	private class KeyIterator implements Iterator<K>
	{
		// global variable
		// stores the iterator
		Iterator<Entry<K, V>> _iterator;
		
		/**
		 * a default constructor
		 */
		public KeyIterator()
		{
			_iterator = _binarySearchTree.getInorderIterator();
		}
		
		/**
		 * searches if a binary tree has a next key
		 * 
		 * @return boolean
		 */
		@Override
		public boolean hasNext()
		{
			return _iterator.hasNext();
		}

		/**
		 * searches for the next key and retrieves it
		 * 
		 * @return the generic value
		 */
		@Override
		public K next()
		{
			Entry<K, V> nextEntry = _iterator.next();
			return nextEntry.getKey();
		}
	}
	
	/**
	 * a class that creates an entry that stores a search key and a value
	 */
	private class Entry<S extends Comparable<? super S>, T> implements Comparable<Entry<S, T>>
	{
		// global variables
		// stores the search key
		private S _searchKey;
		// stores the value
		private T _value;

		/**
		 * default constructor
		 */
		private Entry( S searchKey, T dataValue )
		{
			_searchKey = searchKey;
			_value = dataValue;
		}

		/**
		 * gets the key from an entry
		 * 
		 * @return the search key
		 */
		private S getKey()
		{
			return _searchKey;
		}

		/**
		 * gets the value from an entry
		 * 
		 * @return the generic value
		 */
		private T getValue()
		{
			return _value;
		}

		/**
		 * allows for comparable to be used on objects
		 * 
		 * @return an integer
		 */
		@Override
		public int compareTo(Entry<S, T> object)
		{
			return _searchKey.compareTo(object._searchKey);
		}
	}
}
