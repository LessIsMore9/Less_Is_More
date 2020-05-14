package edu.snu.csne.ds;

import java.util.Iterator;

/**
 * An interface for a tree iterator
 */
public interface TreeIteratorInterface<T>
{
	/**
	 * an iterator that traverses the tree by a pre order search
	 * 
	 * @return an Iterator<T>
	 */
    public Iterator<T> getPreorderIterator();
    
    /**
     * an iterator that traverses the tree by a post order search
     * 
     * @return an Iterator<T>
     */
    public Iterator<T> getPostorderIterator();
    
    /**
     * an iterator that traverses the tree by a in order search
     * 
     * @return an Iterator<T>
     */
    public Iterator<T> getInorderIterator();
    
    /**
     * an iterator that traverses the tree by a get level order search
     * 
     * @return an Iterator<T>
     */
    public Iterator<T> getLevelOrderIterator();
}
