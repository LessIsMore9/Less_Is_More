package edu.snu.csne.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * a class for a binary tree
 */
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
	// global variable
	// stores the root node
	private BinaryNode<T> _root;

	/**
	 * default constructor
	 */
	public BinaryTree()
	{
		_root = null;
	}

	/**
	 * custom constructor with only root data
	 * 
	 * @param root data
	 */
	public BinaryTree(T rootData)
	{
		_root = new BinaryNode<>(rootData);
	}

	/**
	 * custom constructor for a bt with root data
	 * and left/right tree references
	 * 
	 * @param root data, left tree, right tree
	 */
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) 
	{
		privateSetTree(rootData, leftTree, rightTree);                                                                                                                                                                                                                                                                                                                                                                                     
	}

	/**
	 * sets a non-binary tree
	 * 
	 * @param rootData
	 */
	public void setTree(T rootData)
	{
		_root = new BinaryNode<>(rootData);
	}

	/**
	 * sets a tree's root data, and right/left node references
	 * 
	 * @param root data, left tree, right tree
	 */
	public void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	}

	/**
	 * sets a private tree's root data, and right/left node references
	 * 
	 * @param root data, left tree, right tree
	 */
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		// store the root node
		_root = new BinaryNode<>(rootData);

		// if the left tree is valid
		if ((leftTree != null) && !leftTree.isEmpty())
		{
			// update the root's left child
			_root.setLeftChild(leftTree._root.copy());
		}
		// if the right tree is valid
		if ((rightTree != null) && !rightTree.isEmpty())
		{
			// update the root's right child
			_root.setRightChild(rightTree._root.copy());
		}
	}

	/**
	 * sets the root node
	 * 
	 * @param the root node
	 */
	public void setRootNode(BinaryNode<T> rootNode)
	{
		_root = rootNode;
	} 

	/**
	 * get the root node
	 * 
	 * @return the root node
	 */
	public BinaryNode<T> getRootNode()
	{
		return _root;
	} 

	/**
	 * gets the root's data
	 * 
	 * @return the root data
	 */
	public T getRootData()
	{
		// stores the root data
		T rootData = null;
		// if the root is valid
		if (_root != null)
		{
			// get the data 
			rootData = _root.getData();
		}
		// return it
		return rootData;
	}

	/**
	 * gets the height of the binary tree
	 * 
	 * @return an integer
	 */
	public int getHeight()
	{
		return _root.getHeight();
	}

	/**
	 * returns the number of nodes
	 * 
	 * @return an integer
	 */
	public int getNumberOfNodes()
	{
		int total = 0;
		// if the root is valid
		if (_root != null)
		{
			// get the total
			total = _root.getNumberOfNodes();
		}
		// return it
		return total;
	}

	/**
	 * checks to see if the binary tree is empty
	 * 
	 * @return a boolean
	 */
	public boolean isEmpty()
	{
		return _root == null;
	}

	/**
	 * clears the binary tree
	 */
	@Override
	public void clear()
	{
		_root = null;

	}

	/**
	 * returns an iterator that searches using a preorder method
	 * 
	 * is not used for this implementation
	 */
	@Override
	public Iterator<T> getPreorderIterator()
	{
		return null;
	}

	/**
	 * returns an iterator that searches using a post order method
	 * 
	 * is not used for this implementation
	 */
	@Override
	public Iterator<T> getPostorderIterator()
	{
		return null;
	}

	/**
	 * returns an iterator that searches using a in order method
	 */
	@Override
	public Iterator<T> getInorderIterator()
	{
		return new InorderIterator();
	}
	/**
	 * returns an iterator that searches using a get level order method
	 * 
	 * is not used for this implementation
	 */
	@Override
	public Iterator<T> getLevelOrderIterator()
	{
		return null;
	}

	/**
	 * set tree method
	 * 
	 * is not used for this implementation
	 */
	public void setTree( T rootData,
			BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree )
	{
		// not implemented
	}

	/**
	 * a class for an in order iterator
	 * 
	 * uses linked stack and binary node to store the values
	 */
	private class InorderIterator implements Iterator<T>
	{
		// global variables
		// creates a stack
		private LinkedStackADT<BinaryNodeInterface<T>> _stack;
		// stores the current node
		private BinaryNodeInterface<T> _currentNode;

		/**
		 * constructor
		 */
		public InorderIterator()
		{
			_stack = new LinkedStackADT<BinaryNodeInterface<T>>();
			_currentNode = _root;
		}

		/**
		 * searches if a binary tree has a next value
		 * 
		 * @return boolean
		 */
		public boolean hasNext() 
		{
			// if the stack is empty or there is not a current node
			// there is no next node
			return !_stack.isEmpty() || (_currentNode != null);
		} 

		/**
		 * searches for the next value and retrieves it
		 * 
		 * @return the generic value
		 */
		public T next()
		{
			// stores the next node
			BinaryNodeInterface<T> nextNode = null;
			// while there are still nodes to check
			while (_currentNode != null)
			{
				// push the current node onto the stack
				_stack.push( _currentNode);
				// update the current node to the 
				// current node's left child
				_currentNode = _currentNode.getLeftChild();
			} 

			// if the stack is not empty, get leftmost node 
			// then go to the right 
			if (!_stack.isEmpty())
			{
				// take the node
				nextNode = _stack.pop();
				assert nextNode != null; 
				_currentNode = nextNode.getRightChild();
			}
			// otherwise there is no node
			else
			{
				throw new NoSuchElementException();
			}
			// return the next node
			return nextNode.getData();

		} 
		//Iterator should not be able to remove, so throw an exception
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}
