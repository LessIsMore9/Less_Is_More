package edu.snu.csne.ds;

import java.util.Iterator;

/**
 * An interface for a search tree
 */
public interface SearchTreeInterface<T extends Comparable<? super T>> 
    extends TreeInterface<T>
{
	/**
	 * searches to see if an entry is inside the tree
	 * 
	 * @return a boolean
	 */
    public boolean contains(T entry);
    
    /**
     * retrieves the value of an entry in a tree
     *
     * @return the entry 
     */
    public T getEntry(T entry);
    
    /**
     * adds a new entry to the tree
     * 
     * @return the previous entry if there was a duplicate
     */
    public T add(T newEntry);
    
    /**
     * removes an entry from a tree
     * 
     * @return the entry 
     */
    public T remove(T entry);
    
    /**
     * produces an in order iterator
     * 
     * @return Iterator<T>
     */
    public Iterator<T> getInorderIterator();
    
    
}
