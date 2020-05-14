package edu.snu.csne.ds;

import java.util.Iterator;

public class ArrayOpenDictionaryADT<K, V> implements DictionaryADT<K, V>
{
	private Entry<K, V>[] hashTable;
	private int tableSize;
	private static final int def_capacity = 5;
	private static final int max_capacity = 1000;
	private static final double max_load_factor = 0.5;
    private int numberOfEntries;
    
    public ArrayOpenDictionaryADT() 
    { 
    	this(def_capacity);
    }
    
    public ArrayOpenDictionaryADT(int capacity) 
    { 
    	numberOfEntries = 0;
    	int tableSize = nextPrime(capacity);
    	checkSize(tableSize);
    	// once valid capacity is ensured, create hash table
    	@SuppressWarnings("unchecked")
    	Entry<K, V>[] temp = (Entry<K, V>[]) new Entry[tableSize];
    	hashTable = temp;
    	
    }
    
    // method to ensure valid table size,
    // throws exception if not
    public void checkSize(int n)
    {
    	if (n > max_capacity)
    	{
    		throw new IllegalStateException();
    	}
    }
    
    public static int nextPrime(int integer)
    {
    	// start w value greater than result
    	// so we don't return result
        int result = integer + 1;
        for (int i = 2; i < result; i++)
        {
        	// loop checks if number is even first
        	// by defn of not prime,
        	if (result % i == 0)
        	{
        		// try another number w fresh set of divisors
        		result++;
        		i=2;
        	}
        }
        return result;
     }
    
	@Override
	public V add(K key, V value)
	{
		// if k,v is null, no point in adding, throw exception
		if ( key == null || value == null )
		{
			throw new IllegalArgumentException();
		}
		V oldValue;
		// find hashCode for key
		int index = getHashIndex(key);
		// find correct placement for k,v using hashCode for key
		index = probe(index, key);
		// ensure valid index value
		assert ( (index >= 0) && (index < hashTable.length) );
		// if slot is available for entry,
		if ( (hashTable[index] == null) || hashTable[index].isNotIn() )
		{
			// create entry w key and value
			hashTable[index] = new Entry<>(key, value);
			hashTable[index].setToIn();
			numberOfEntries++;
			// reset old value
			oldValue = null;
		}
		// if entry already exists for given key,
		else
		{
			// set oldValue to newValue but retrieve oldValue for return
			oldValue = hashTable[index].getValue();
			hashTable[index].setValue(value);
		}
		if (isHashTableTooFull())
		{
			enlargeHashTable();
		}
		return oldValue;
	}

	@Override
	public V remove(K key)
	{
		if ( key == null )
		{
			throw new IllegalArgumentException();
		}
		V removedValue = null;
		int index = getHashIndex(key);
		index = locate(index, key);
		if (index >= 0)
		{
			removedValue = hashTable[index].getValue();
			hashTable[index].setToOut();
			numberOfEntries--;
		}
		return removedValue;
	}

	@Override
	public V getValue(K key)
	{
		if ( key == null )
		{
			throw new IllegalArgumentException();
		}
		V result = null;
		int index = getHashIndex(key);
		index = locate(index, key);
		if (index >= 0)
		{
			result = hashTable[index].getValue();
		}
		return result;
	}

	@Override
	public boolean contains(K key)
	{
		if ( key == null )
		{
			throw new IllegalArgumentException();
		}
		// get hash index
		int index = getHashIndex(key);
		index = locate(index, key);
		// if key is found, only return true if value exists
		if ( index >= 0 )
		{
			return ( hashTable[index].getValue() != null  );
		}
		else
		{
			return false;
		}
	}

	@Override
	public Iterator<K> getKeyIterator()
	{
		return new KeyIterator();
	}

	@Override
	public Iterator<V> getValueIterator()
	{
		return new ValueIterator();
	}

	@Override
	public boolean isEmpty()
	{
		return ( numberOfEntries == 0 );
	}

	@Override
	public boolean isFull()
	{
		return ( numberOfEntries == tableSize );
	}

	@Override
	public int getSize()
	{
		return numberOfEntries;
	}

	@Override
	public void clear()
	{
		/*
		 * can't use numberOfEntries as there will be gaps, more so when using
		 * other types of probing methods. however there still could be gaps
		 * as we could wrap around end of dictionary s.t. there's a gap b/w
		 * last entry that lies before the first entry
		 */
		for ( int j = 0 ; j < tableSize ; j ++ )
		{
			hashTable[j] = null;
		}
		numberOfEntries = 0;
	}

	@Override
	public String toFormattedString()
	{
		return ( "{ " + hashTable.toString() + " }" );
	}
    
	
	@SuppressWarnings("hiding")
	private class Entry<K, V>
	{
		// stores key and value variables
		private K _key;
		private V _value;
		/*
		 * attribute indicating if entry has been removed. necessary as
		 * we don't pull entries from the table to avoid probing errors
		 */
		public boolean in = false;
		
		private Entry(K key, V value)
		{
			// update the k:v 
			_key = key;
			_value = value;
		}
		
		// returns key
		private K getKey()
		{
			return _key;
		}
		
		// returns value
		private V getValue()
		{
			return _value;
		}
		
		// sets value
		private V setValue(V value)
		{
			_value = value;
			return _value;
		}
		
		public boolean isIn()
		{
			return in;
		}
		
		public boolean isNotIn()
		{
			return !in;
		}
		
		public void setToIn()
		{
			in = true;
		}
		
		public void setToOut()
		{
			in = false;
		}
	}
	
	private boolean isHashTableTooFull()
	{
		if ( tableSize == 0 )
		{
			return false;
		}
		float load = numberOfEntries / tableSize;
		return ( load > max_load_factor );
	}
	
	private int locate(int index, K key)
	{
		boolean found = false;
		while( !found && (hashTable[index] != null) )
		{
			if (key.equals(hashTable[index].getKey())
					&& hashTable[index].isIn())
			{
				found = true;
			}
			else
			{
				// if not found given hash index, try the next one
				// via linear probing
				index = (index + 1) % hashTable.length;
			}
		}
		int result = -1;
		if (found)
		{
			result = index;
		}
		return result;
	}
	
	public void enlargeHashTable()
	{
		int oldSize = tableSize;
		Entry<K,V>[] oldTable = hashTable;
		int newSize = tableSize * 2;
		@SuppressWarnings("unchecked")
		Entry<K, V>[] temp1 = (Entry<K, V>[]) new Entry[newSize];
		hashTable = temp1;
		numberOfEntries = 0;
		for ( int j = 0 ; j < oldSize ; j ++ )
		{
			if ( ( oldTable[j] != null ) && oldTable[j].isIn() )
			{
				add( oldTable[j].getKey() , oldTable[j].getValue() );
			}
		}
	}
	
	/*
	 * probe utility function looks for available slot along the probe path. 
	 * this function can easily be rewritten to conform to any type of OA
	 * probing scheme
	 */
	private int probe( int index, K key )
	{
		boolean found = false;
		// index of first removed element
		int removedStateIndex = -1;
		while ( !found && (hashTable[index] != null) )
		{
			// if specified element is in table (has not been removed),
			if ( hashTable[index].isIn() )
			{
				// find out if passed key matches this key. if so,
				if ( key.equals( hashTable[index].getKey()))
				{
					found = true;
				}
				// if not,
				else
				{
					// linear probe
					index = (index + 1) % hashTable.length;
				}
			}
			// if specified element has been removed,
			else
			{
				if ( removedStateIndex  == -1 )
				{
					// save index
					removedStateIndex = index;
				}
				// linear probe
				index = (index + 1) % hashTable.length;
			}
		}
		// index of either key or null
		if (found || (removedStateIndex == -1))
		{
			return index;
		}
		// index of available location
		else
		{
			return removedStateIndex;
		}
	}
	
	private int getHashIndex(K key)
	{
		int hashIndex = key.hashCode() % hashTable.length;
		if (hashIndex < 0)
		{
			hashIndex = hashIndex + hashTable.length;
		}
		return hashIndex;
	}
	
	private class KeyIterator implements Iterator<K>
	{
		// store the next index
		private int _nextIndex = 1;
		
		public KeyIterator()
		{
			_nextIndex = 1;
		}
		
		// is there another index?
		@Override
		public boolean hasNext() 
		{
			return _nextIndex <= numberOfEntries;
		}

		// moves to next index and returns key
		@Override
		public K next() 
		{
			// if there is another key
			if (hasNext())
			{
				// retrieve the key
				K nextEntry =  hashTable[_nextIndex].getKey();
				// update the index counter
				_nextIndex++;
				// return the key
				return nextEntry;
			}
			// if not, return nothing
			else
			{
				return null;
			}
		}
	}
	

	private class ValueIterator implements Iterator<V>
	{
		// store the next index
		private int _nextIndex = 1;
		
		// default constructor
		public ValueIterator()
		{
			_nextIndex = 1;
		}
		
		// is there another index?
		@Override
		public boolean hasNext() 
		{
			return _nextIndex <= numberOfEntries;
		}

		// moves to next index, returns value
		@Override
		public V next() 
		{
			// if there is another key
			if (hasNext())
			{
				// retrieve the key
				V nextEntry =  hashTable[_nextIndex].getValue();
				// update the index counter
				_nextIndex++;
				// return the value
				return nextEntry;
			}
			// if not, do nothing
			else
			{
				return null;
			}
		}
	}
}
