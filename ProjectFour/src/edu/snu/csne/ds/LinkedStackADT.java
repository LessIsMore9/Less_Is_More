package edu.snu.csne.ds;

public class LinkedStackADT <T> implements StackADT<T>
{
	// global variables
	private Node _topNode; // stores the top node
	private int _size; // keeps track of size
	
	 /**
     * Adds a new entry to the top of this stack.
     *
     * @param entry The entry to be added to the top of this stack
     */
	public void push(T entry)
	{
		// if the entry is valid
		if (!(entry == null))
		{
			// create a new node
			Node newNode = new Node (entry, _topNode);
			// add the value into the new node
			_topNode = newNode;
			// update the size
			_size++;
		}
	}

	 /**
     * Removes and returns the entry at the top of the stack.
     *
     * @return Returns the entry at the top of the stack if the stack
     *         is not empty, otherwise, <code>null</code>
     */
	public T pop() 
	{
		// store the top value
		T top = peek();
		// if the top node is not null
		if (_topNode != null)
		{
			// pop the value
			_topNode = _topNode.getNextNode();
		}
		// update the size
		_size--;
		// return the value
		return top;
	}

	/**
     * Retrieves the entry at the top of the stack.
     *
     * @return Returns the entry at the top of the stack if the stack
     *         is not empty, otherwise, <code>null</code>
     */
	public T peek() 
	{
		// if the stack is empty, do nothing
		if (isEmpty())
		{
			return null;
		}
		else
		{
			// return the top node's data
			return _topNode.getData();
		}
	}

	/**
     * Determines if the stack is empty.
     *
     * @return Returns <code>true</code> if the stack is empty,
     *         otherwise, <code>false</code>
     */
	public boolean isEmpty() 
	{
		// see if there are values in the stack
		return _topNode == null;
	}

	 /**
     * Removes all entries from the stack.
     */
	public void clear() 
	{
		// clear all references
		_topNode = null;
	}
	
	/**
     * Returns a formatted description of this stack.  The description
     * contains all of the entries in the stack in first to last order.
     *
     * @return A formatted description of this stack
     */
	public String toFormattedString() 
	{
		// start the string
	    String str = "{";
	    // look through the pQueue
	    for (int i = 0; i < _size; i++) 
	    {
	    	// add each index to the string
	        str = str + _topNode._data;
	        // if the index is not the last index
	        if (i != _size - 1) 
	        {
	        	// use grammatical spacing
	            str += ", ";
	        }
	    }
	    // end the string
	    str = str + "}";
	    return str;
	}
	
	/**
	 * Node
	 * 
	 * Stores and references data in a linked chain.
	 * 
	 * @author Sam
	 *
	 */
	private class Node
	{
		private T _data; //Entry in bag
		private Node _next; //Link to next node

		//constructor
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		}

		//constructor
		private Node(T dataPortion, Node nextNode)
		{
			_data = dataPortion;
			_next = nextNode;
		}
		
		/**
		 * gets data from node
		 * 
		 * @return the generic data in the node
		 */
		private T getData() {

			return _data;
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
	}
}