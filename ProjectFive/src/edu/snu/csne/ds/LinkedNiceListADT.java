package edu.snu.csne.ds;

/*
 * linked implementation of ListADT to construct a NiceListADT
 * 
 * NiceListADT contains entries containing a name and the corresponding wish list
 * 
 * @author Josh Lessner
 */

public class LinkedNiceListADT implements NiceListADT
{
	private Node firstNode;
	private int numberOfEntries;
	
	// default constructor
	public LinkedNiceListADT()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	private class Node
	{
		private String name;
		private ListADT<String> list;
		private Node _next; // Link to next node

		// constructor
		private Node(String namePortion, ListADT<String> listPortion)
		{
			this(namePortion, listPortion, null);
		}

		// constructor
		private Node(String namePortion, ListADT<String> listPortion, Node nextNode)
		{
			name = namePortion;
			list = listPortion;
			_next = nextNode;
		}

		/**
		 * gets data from node
		 * 
		 * @return the generic data in the node
		 */
		private String getName()
		{
			return name;
		}

		/**
		 * sets data from node
		 * 
		 * @param the current entry
		 */
		private ListADT<String> getList()
		{
			return list;
		}
		
		@SuppressWarnings("unused")
		private void setName(String newName)
		{
			name = newName;
		}
		
		@SuppressWarnings("unused")
		private void setList(ListADT<String> newList)
		{
			list = newList;
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
	
	/*
	 * utility method for finding node at given index
	 */
	private Node getNodeAtIndex( int index )
	{
		Node nodeAt = firstNode;
		for ( int j = 0 ; j < index ; j ++ )
		{
			nodeAt = nodeAt.getNextNode();
		}
		return nodeAt;
	}
	
	/*
	 * utility method for finding node using given name
	 * 
	 * if name not found, return null
	 * 
	 * method ended up having an unresolvable bug so I commented it out
	 */
	private Node getNodeAtName( String name )
	{
		Node currNode = null;
		// keep track of number of nodes searched
		int index = 0;
		// serach through list
		while ( index < numberOfEntries )
		{
			currNode = getNodeAtIndex( index );
			// node found
			if ( currNode.getName().equals( name ) )
			{
				return currNode;
			}
			// if not found, continue until we run out of nodes
			index++;
		}
		return currNode;
	}
	
	private int getIndexAtName( String name )
	{
		int result = -1;
		Node currNode = firstNode;
		for ( int i = 0 ; i < numberOfEntries ; i ++ )
		{
			// if found
			if ( currNode.getName().equals(name) )
			{
				return i;
			}
			// if not found, onto the next node
			currNode = currNode.getNextNode();
		}
		return result;
	}

	/*
	 * adds (name, list) to the end of the unsorted linked NiceListADT
	 * 
	 * precondition - user must pass arguments of type String, ArrayList<String>
	 * postcondition - method adds entry to the NiceListADT
	 */
	@Override
	public void add(String newName, ListADT<String> newList)
	{
		// create node for entry
		Node newNode = new Node(newName, newList);
		// if list is empty,
		if ( isEmpty() )
		{
			// set newNode as firstNode
			firstNode = newNode;
		}
		// if list contains newName, replace list at node
		else if ( contains( newName ) )
		{
			replace( newName, newList );
		}
		// list does not contain newName
		else
		{
			Node lastNode = getNodeAtIndex( numberOfEntries - 1 );
			// set newNode to the next node at last node
			lastNode.setNextNode(newNode);
		}
		numberOfEntries++;
	}

	/*
	 * removes (name, list) from the NiceListADT
	 * 
	 * preconditions - user must pass string, dictionary must not be empty
	 * postconditions - method removes name/corresponding list and returns the name,
	 * 					or returns null if name is not contained in the dictionary
	 */
//	@Override
//	public String remove(String name)
//	{
//		String result = null;
//		// dictionary must not be empty
//		assert !isEmpty();
//		// case of entry found at firstNode,
//		if ( name.equals( firstNode.getName() ) )
//		{
//			result = firstNode.getName();
//			// remove first entry by setting the firstNode to the second entry
//			firstNode.setNextNode( getNodeAtIndex( 1 ) );
//			// decrement numberOfEntries
//			numberOfEntries--;
//			return result;
//		}
//		// if entry is not at the first node, lets search the chain
//		for ( int j = 1 ; j < numberOfEntries ; j ++ )
//		{
//			Node nodeBefore = getNodeAtIndex(j - 1);
//			Node currNode = getNodeAtIndex(j);
//			String currName = currNode.getName();
//			// if found,
//			if ( name.equals( currName ) )
//			{
//				// remove
//				result = currName;
//				Node nextNode = currNode.getNextNode();
//				// set the reference of the previous node's _next over the desired/removed node
//				nodeBefore.setNextNode(nextNode);
//				// decrement numberOfEntries
//				numberOfEntries--;
//				return result;
//			}
//			// if not found, keep looking until end is reached in which case we return null
//		}
//		return result;
//	}

	
	@Override
	public ListADT<String> remove( String name )
	{
		ListADT<String> result = null;
		// get position of desired node
		int position = getIndexAtName( name ) + 1;
		// if list contains the name, we can operate
		if ( contains( name ) && ( name != null ) )
		{
			assert !isEmpty();
			// special case: remove first node
			if (position == 1)
			{
				result = firstNode.getList();
				// only operation needed to remove first node
				// is to set second node as first node
				firstNode = firstNode.getNextNode();
			}
			// if entry is somewhere in the middle/end,
			else
			{
				// store node before removal node and desired node
				Node nodeBefore = getNodeAtIndex( position - 1 );
				Node nodeToRemove = nodeBefore.getNextNode();
				// store desired list for return 
				result = nodeToRemove.getList();
				Node nodeAfter = nodeToRemove.getNextNode();
				/*
				 * set nextNode reference of node before
				 * desired node to the node after the desired
				 * node such that there is now no existing
				 * reference to the newly removed node
				 */
				nodeBefore.setNextNode(nodeAfter);
			}
			numberOfEntries--;
			return result;
		}
		// list does not contain name or name is null
		else
		{
			throw new IllegalArgumentException
						("Name not found in the Nice List");
		}
	}
	
	
	/*
	 * clear NiceListADT
	 */
	@Override
	public void clear()
	{
		// clear by removing reference to rest of chain
		firstNode.setNextNode(null);
		firstNode = null;
		numberOfEntries = 0;
	}

	/*
	 * replace specified entry with new entry
	 * 
	 * preconditions - name cannot be null, newList must be of type ListADT<String> or be null,
	 * 					and NiceListADT must contain newName index
	 * postconditions - List w/ given name will be replaced with the newList
	 */
	@Override
	public String replace(String newName, ListADT<String> newList)
	{
		assert newName != null;
		assert contains( newName );
		// if NiceListADT contains newName, replace it
		remove( newName );
		add( newName, newList );
		return newName;
	}

	/*
	 * returns list entry associated with givenName
	 * 
	 * preconditions - givenName cannot be null and NiceListADT must contain an
	 * 					entry for the given name
	 * postconditions - returns type ListADT<String> or null if no list exists at desired node
	 */
	@Override
	public ListADT<String> getList(String givenName)
	{
		assert contains( givenName );
		// use utility function to find desired node
		Node desiredNode = getNodeAtName( givenName );
		// return list at node
		return desiredNode.getList();
	}

	@Override
	public boolean contains(String name)
	{
		boolean result = false;
		Node currNode = firstNode;
		// search through chain
		for ( int i = 0 ; i < numberOfEntries ; i ++)
		{
			// found
			if ( currNode.getName().equals( name ) )
			{
				return true;
			}
			// if not found, skip to next node
			currNode = currNode.getNextNode();
		}
		return result;
	}

	@Override
	public int getLength()
	{
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty()
	{
		return ( firstNode == null );
	}

	@Override
	public String toFormattedString()
	{
		String str = "";
		for ( int i = 0 ; i < numberOfEntries ; i ++ )
		{
			Node currNode = getNodeAtIndex(i);
			String newString = "{ " + currNode.getName() + 
					currNode.getList().toString() + " }";					
			str.concat(newString);
		}
		return str;
	}
	
}
