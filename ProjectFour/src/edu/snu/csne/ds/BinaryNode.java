package edu.snu.csne.ds;


/**
 * a node class for a binary tree
 */
public class BinaryNode<T> implements BinaryNodeInterface<T>
{
    
    // global variables
	// stores the data
    private T _data;
    // store the left child reference
    private BinaryNode<T> _leftChild;
    // stores the right child reference
    private BinaryNode<T> _rightChild;
    
    /**
     * blank default constructor
     */
    public BinaryNode()
    {
 
    }
    
    /**
     * root binary node constructor
     */
    public BinaryNode(T dataPortion)
    {
        _data = dataPortion;
    }
    
    /**
     * binary node constructor
     */
    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, 
    				  BinaryNode<T> newRightChild)
    {
        _data = dataPortion;
        _leftChild = newLeftChild;
        _rightChild = newRightChild;
    }

    /**
     * gets the data for a binary node
     * 
     * @return the data
     */
    public T getData()
    {
        return _data;
    }

    /**
     * sets the data for a binary node
     * 
     * @param new data
     */
    public void setData(T newData)
    {
        _data = newData;
    }

    /**
     * gets the left child node
     * 
     * @return the left node
     */
    public BinaryNode<T> getLeftChild()
    {
        return _leftChild;
    }

    /**
     * set the left child node
     * 
     * @param the new left child node reference
     */
    public void setLeftChild(BinaryNodeInterface<T>newLeftChild)
    {
        _leftChild = (BinaryNode<T>)newLeftChild;
    }

    /**
     * returns if there is a left child
     * 
     * @return a boolean
     */
    public boolean hasLeftChild()
    {
        return _leftChild != null;
    }

    /**
     * gets the right child node
     * 
     * @return the right child node
     */
    public BinaryNode<T> getRightChild()
    {
        return _rightChild;
    }

    /**
     *sets the right child node 
     *
     *@param the new right child node
     */
    public void setRightChild(BinaryNodeInterface<T>newRightChild)
    {
        _rightChild = (BinaryNode<T>)newRightChild;
    }


    /**
     * returns if there is a right child
     * 
     * @return a boolean
     */
    public boolean hasRightChild()
    {
        return _rightChild != null;
    }


    /**
     * checks to see if there is a leaf
     * 
     * @return a boolean
     */
    public boolean isLeaf()
    {
    	// checks to see if the node has no references
        return (_leftChild == null) && (_rightChild == null);
    }

    /**
     * gets the total number of nodes
     * 
     * @return an integer
     */
    public int getNumberOfNodes()
    {
    	// stores right and left number of nodes
        int leftNumber = 0;
        int rightNumber = 0;
        
        // get all of the left nodes
        if (_leftChild != null)
        {
            leftNumber = _leftChild.getNumberOfNodes();
        }
        // get all of the right nodes
        if (_rightChild != null)
        {
            rightNumber = _rightChild.getNumberOfNodes();
        }
        // return the total (adds one to include the root node)
        return 1 + leftNumber + rightNumber;
    }
    
    /**
     * gets height of tree
     * 
     * @return an integer
     */
    public int getHeight()
    {
        return getHeight(this);
    }
    
    /**
    * returns the height of a tree
    * with a starting node
    * 
    * @param the specific node
    * @return an integer
    */
    private int getHeight(BinaryNode<T> Node)
    {
    	// stores height
        int height = 0;         
        // as long as there are nodes
        if (Node != null)
        {
        	// add it to the height
            height = 1 + Math.max(getHeight(Node._leftChild), getHeight(Node._rightChild));
        }
        // return the height
        return height;
    }

    /**
     * copies a binary node
     *  
     * @return the copied node
     */
    public BinaryNodeInterface<T> copy()
    {
    	// stores the new root node
        BinaryNode<T> newRoot = new BinaryNode<>(_data);
        // set the left child reference
        if (_leftChild != null)
        {
            newRoot.setLeftChild(_leftChild.copy());
        }
        // set the right child reference
        if (_rightChild != null)
        {
            newRoot.setRightChild(_rightChild.copy());
        }
        // return the copy
        return newRoot;
    }
}
