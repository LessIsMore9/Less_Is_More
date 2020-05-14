package edu.snu.csne.ds;

/**
 * an interface for a binary tree
 */
public interface BinaryTreeInterface<T>
        extends TreeInterface<T>, TreeIteratorInterface<T>
{
	/**
	 * sets a tree's root data 
	 */
	public void setTree(T rootData);
	
	/**
	 * sets a tree's root data, and right/left node references
	 */
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
