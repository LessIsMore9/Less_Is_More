package edu.snu.csne.ds;

/**
 * a class that creates a binary search tree
 */
public class BinarySearchTree<T extends Comparable<? super T>>
        extends BinaryTree<T> implements SearchTreeInterface<T>
{
    /**
     * default constructor
     */
    public BinarySearchTree()
    {
        super();
    }
    
    /**
     * custom constructor
     */
    public BinarySearchTree(T rootEntry)
    {
        super();
        setRootNode(new BinaryNode<T>(rootEntry));
    }
    
    /**
     * sets a trees data
     * 
     * @throws UnsupportedOperationException()
     */
    public void setTree(T rootData)
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * sets a trees data
     * 
     * @throws UnsupportedOperationException()
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        throw new UnsupportedOperationException();
    }
    

    /**
     * checks to see if the bst contains an entry
     */
    public boolean contains(T entry)
    {
        return getEntry(entry) != null;
    }

    /**
     * retrieves an entry
     * 
     * @return an entry
     */
    @Override
    public T getEntry( T entry )
    {
    	// find the entry and return it
        return findEntry(getRootNode(), entry);
    }
    
    /**
    * finds an entry in a bst
    * 
    * @return an entry
    */
    private T findEntry(BinaryNodeInterface<T> rootNode, T entry)
    {
    	// stores the result
    	T returnedResult = null;
    	// if the root node is null, do nothing
    	if (rootNode == null)
    	{
    		return null;
    	}
    	// stores the root entry
    	T rootEntry = rootNode.getData();
    	// if the root entry = the entry
    	if (entry.equals(rootEntry))
    	{
    		// return it
    		returnedResult = rootEntry;
    	}
    	// if the entry is less than the root
    	else if (entry.compareTo( rootEntry) < 0)
    	{
    		// search left and try again
    		returnedResult = findEntry(rootNode.getLeftChild(), entry);
    	}
    	// if the entry is greater than the root
    	else
    	{
    		// search right and try again
    		returnedResult = findEntry(rootNode.getRightChild(), entry);
    	}
    	// return the result
    	return returnedResult;
    }
	

    /**
     * helper function to add an entry to the bst
     * 
     * @param the node to start at and the entry
     * @return a duplicated entry
     */
    private T addEntry(BinaryNode<T> rootNode, T newEntry)
    {
    	// if the starting node is null, do nothing
    	if (rootNode == null)
    	{
    		return null;
    	}
    	// store the result
        T result = null;
        // compares the node and new entry data and stores it as an integer
        int comparison = newEntry.compareTo( rootNode.getData());
        
        // if they are the same
        if (comparison == 0)
        {
        	// return the root node's data
            result = rootNode.getData();
            // update the root node with the new entry
            rootNode.setData(newEntry);
        }
        // if the new entry is < the root node
        else if (comparison < 0)
        {
        	// if the root node has a left child
            if (rootNode.hasLeftChild())
            {
            	// update the result 
            	// repeat again comparing the left child to the entry
                result = addEntry(rootNode.getLeftChild(), newEntry);
            }
            else
            {
            	// add the entry
                rootNode.setLeftChild( new BinaryNode<>(newEntry) );
            }
        }
        // if the new entry is > the root node
        else
        {
            assert comparison > 0;
            // if the root node has a left child
            if (rootNode.hasRightChild())
            {
            	// update the result 
            	// repeat again comparing the right child to the entry
                result = addEntry(rootNode.getRightChild(), newEntry);
            }
            else
            {
            	// add the entry
                rootNode.setRightChild(new BinaryNode<>(newEntry));
            }
        }
        // return the result
        return result;
        
    }
    
    /**
     * uses addEntry to recursively add an entry to the bst
     * 
     * @param the node to start at and the entry
     * @return a duplicated entry
     */
    @Override
    public T add( T newEntry )
    {
        // stores the result
        T result = null;
        // if the tree is empty, start to build one
        if (isEmpty())
        {
            setRootNode(new BinaryNode<>(newEntry));
        }
        // else, add the entry
        else
        {
            result = addEntry(getRootNode(), newEntry);
        }
        // return the result
        return result;
    }
    
    /**
     * removes an entry from the BST
     * 
     * @param the root node, an entry, and the old entry
     * @return the removed node
     */
    private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, ReturnObject oldEntry)
    {
    	// if the starting node is null, do nothing
    	if (rootNode == null)
    	{
    		return null;
    	}
            // store the root value
            T rootData = rootNode.getData();
            // compares the node and new entry data and stores it as an integer
            int comparison = entry.compareTo( rootData );
            
            // if they are equal
            if (comparison == 0)
            {
            	// update the reference and remove
                oldEntry.setObject(rootData);
                rootNode = removeFromRoot(rootNode);
            }
            // if the entry is less than the root
            else if (comparison < 0)
            {
            	// move left then try to remove again
                BinaryNode<T> leftChild = rootNode.getLeftChild();
                BinaryNode<T> subtreeRoot = removeEntry(leftChild,entry, oldEntry);
                rootNode.setLeftChild(subtreeRoot);
            }
            // if the entry is greater than the root
            else
            {
            	// move right then try to remove again
                BinaryNode<T> rightChild = rootNode.getRightChild();
                rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
            }
        return rootNode;
    }
    /**
     * removes an entry in the root of a subtree
     * 
     * @param the root node
     * @return the node from the revised tree
     */
    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
    {
        // if there are two children
        if(rootNode.hasLeftChild() && rootNode.hasRightChild())
        {
            // find the largest entry in the left subtree
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
            // replace the entry
            rootNode.setData(largestNode.getData());
            // remove the largest node
            rootNode.setLeftChild( removeLargest(leftSubtreeRoot) );
        }
        // if it has only one child or less
        else if (rootNode.hasRightChild()) 
        {
        	// return the right child node
            rootNode = rootNode.getRightChild();
        }
        else
        {
        	// return the left child node
            rootNode = rootNode.getLeftChild();
        }
        // return the result
        return rootNode;
    }
    /**
     * finds the largest value when comparing nodes
     * by finding the rightmost node
     * 
     * @param the root node
     * @return the largest value as a node
     */
    private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
    {
    	// if the root has a right child
        if (rootNode.hasRightChild())
        {
        	// move right
            rootNode = findLargest(rootNode.getRightChild());
        }
        // return the rightmost child
        return rootNode;
    }
    
    /**
     * removes the largest value
     * 
     * @param the root node
     * @return the largest node
     */
    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
    {
    	// if there is a right child
        if (rootNode.hasRightChild())
        {
        	// move right and keep searching
            BinaryNode<T> rightChild = rootNode.getRightChild();
            rightChild = removeLargest(rightChild);
            rootNode.setRightChild(rightChild);
        }
        // if not get the left child
        else
        {
            rootNode = rootNode.getLeftChild();
        }
        // return the largest node
        return rootNode;
    }
    
    /**
     * removes an entry from the bst by 
     * Recursively calling the other remove method
     * 
     * @param the root node
     * @return the node from the revised tree
     */
    @Override
    public T remove(T entry)
    {
        // store the old entry
        ReturnObject oldEntry = new ReturnObject(null);
        // recursively attempt to remove the node
        BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
        // update the reference
        setRootNode(newRoot);
        // return the removed entry
        return oldEntry.getObject();
    }
    
    /**
	 * a class that returns an object
	 */
    @SuppressWarnings("serial")
	private class ReturnObject implements java.io.Serializable
    {
    	// stores a generic objecet
        private T _genericObject;
        
        /**
    	 * custom constructor
    	 */
        private ReturnObject(T entry)
        {
            _genericObject = entry;
        }
        
        /**
    	 * gets the object
    	 */
        public T getObject()
        {
        	// return the object
            return _genericObject;
        }
        
        /**
    	 * sets an object
    	 */
        public void setObject(T entry)
        {
        	// set the object 
            _genericObject = entry;
        }
    }
}
