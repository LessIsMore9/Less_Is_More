package edu.snu.csne.ds;

/**
 * An interface for a basic tree
*/ 
public interface TreeInterface<T>
{
	/**
	 * gets the root value
	 * 
	 * @return a generic entry
	*/
	public T getRootData();
	
	/**
	 * retrieves the height of a tree
	 * 
	 * @return an integer
	*/
	public int getHeight();
	
	/**
	 * gets the total number of nodes in a tree
	 * 
	 * @return an integer
	*/
	public int getNumberOfNodes();
	
	
	/**
	 * checks to see if a tree has any entries
	 * 
	 * @return a boolean
	*/
	public boolean isEmpty();
	
	/**
	 * clears all entries in a tree
	*/
	public void clear();
}
