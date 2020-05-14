package edu.snu.csne.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDictionaryADT<K extends Comparable<? super K>, V> extends DefaultDictionaryADT<K, V>
		implements DictionaryADT<K, V>
{

	private Node firstNode;
	private int numberOfEntries = 0;
	private int capacity = 100;

	/*
	 * this is a sorted dictionary so we can't simply tack entries onto the end.
	 * iterate through to find correct position for the key
	 */
	@Override
	public V add(K key, V value)
	{
		if (numberOfEntries == capacity)
		{
			throw new IllegalStateException();
		}
		V result = null;
		Node currentNode = firstNode;
		Node nodeBefore = null;
		// if we haven't reached the index we're looking for in the sorted dictionary,
		while ((currentNode != null) && (key.compareTo(currentNode.getKey()) > 0))
		{
			nodeBefore = currentNode;
			// keep looking
			currentNode = currentNode.getNextNode();
		}
		// found entry w/ same key. replace it w passed value
		if ((currentNode != null) && key.equals(currentNode.getKey()))
		{
			result = currentNode.getData();
			currentNode.setData(value);
		}
		// no node exists for given key, so we need to make one
		else
		{
			Node newNode = new Node(key, value);
			if (nodeBefore == null)
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				newNode.setNextNode(currentNode);
				nodeBefore.setNextNode(newNode);
			}
		}
		numberOfEntries++;
		return result;
	}

	@Override
	public V remove(K key)
	{
		V result = null;
		Node currentNode = firstNode;
		Node nodeBefore;
		// empty dictionary or doesn't contain entry
		if (currentNode == null || !contains(key))
		{
			return result;
		}
		// if our key is less than the key that we're currently at,
		// we need to keep looking until we get there
		while (key.compareTo(currentNode.getKey()) > 0)
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
	 		// if the key of the next node is what we're looking for,
			if (key.compareTo(currentNode.getKey()) == 0)
			{
				// found it!
				result = currentNode.getData();
				// now remove by simply setting the reference of the last node
				// to the node after the entry we're looking for
				nodeBefore.setNextNode(currentNode.getNextNode());
			}
		}
		numberOfEntries--;
		// if node DNE for given key, fn will return null
		return result;
	}

	@Override
	public V getValue(K key)
	{
		V result = null;
		Node currentNode = firstNode;
		// if dict is empty or doesn't contain entry,
		if (currentNode == null || !contains(key))
		{
			// return null
			return result;
		}
		// if our key is less than the key that we're currently at,
		// we need to keep looking until we get there
		while (key.compareTo(currentNode.getKey()) > 0)
		{
			currentNode = currentNode.getNextNode();
		}
		if (key.compareTo(currentNode.getKey()) == 0)
		{
			// found it!
			result = currentNode.getData();
		} else
		{
			throw new IllegalStateException();
		}
		return result;
	}

	@Override
	public boolean contains(K key)
	{
		Node currNode = firstNode;
		boolean result = false;
		// while we haven't reached the end
		while (currNode != null)
		{
			// found entry w/ key
			if ( key.equals(currNode.key))
			{
				result = true;
			}
			// onto the next node
			currNode = currNode.getNextNode();
		}
		return result;
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
		return (firstNode == null);
	}

	@Override
	public boolean isFull()
	{
		return (getSize() == capacity);
	}

	@Override
	public int getSize()
	{
		return numberOfEntries;
	}

	@Override
	public void clear()
	{
		// to clear a linked structure we can just clear the first node
		// once first node is cleared there does not exist a reference to any
		// more data in the structure
		firstNode = null;
	}

	@Override
	public String toFormattedString()
	{
		String[] array = new String[numberOfEntries];
		Node currNode = firstNode;
		for ( int j = 0 ; j < numberOfEntries ; j ++ )
		{
			// at each node, print key and value in string and
			String tempString = "( " + currNode.getKey() + " , "
					+ currNode.getData() + " )";
			// stick string in array of strings
			array[j] = tempString;
		}
		// return formatted array
		return array.toString();
	}

	private class Node
	{
		private K key;
		private V data; // Entry in bag
		private Node _next; // Link to next node

		// constructor
		private Node(K keyPortion, V dataPortion)
		{
			this(keyPortion, dataPortion, null);
		}

		// constructor
		private Node(K keyPortion, V dataPortion, Node nextNode)
		{
			key = keyPortion;
			data = dataPortion;
			_next = nextNode;
		}

		/**
		 * gets data from node
		 * 
		 * @return the generic data in the node
		 */
		private K getKey() {
			return key;
		}

		/**
		 * sets data from node
		 * 
		 * @param the current entry
		 */
		private V getData()
		{
			return data;
		}

		private void setData(V newEntry)
		{
			data = newEntry;
		}

		/**
		 * gets the next node
		 * 
		 * @return the next node
		 */
		private Node getNextNode()
		{
			return _next;
		}

		/**
		 * sets the next node
		 * 
		 * @param the next node
		 */
		private void setNextNode(Node nextNode)
		{
			_next = nextNode;
		}
	}

	private class KeyIterator implements Iterator<K>
	{
		private Node nextNode;

		private KeyIterator()
		{
			nextNode = firstNode;
		}

		public boolean hasNext()
		{
			return nextNode != null;
		}

		public K next()
		{
			K result;
			if (hasNext())
			{
				result = nextNode.getKey();
				nextNode = nextNode.getNextNode();
			}
			else
			{
				throw new NoSuchElementException();
			}
			return result;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	private class ValueIterator implements Iterator<V>
	{
		private Node nextNode;

		private ValueIterator()
		{
			nextNode = firstNode;
		}

		public boolean hasNext()
		{
			return nextNode != null;
		}

		public V next()
		{
			V result;
			if (hasNext())
			{
				result = nextNode.getData();
				nextNode = nextNode.getNextNode();
			}
			else
			{
				throw new NoSuchElementException();
			}
			return result;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}
