package edu.snu.csne.ds;

/**
 * an interface for binary node
 */
public interface BinaryNodeInterface<T>
{
	/**
     * gets the data for a binary node
     * 
     * @return the data
     */
    public T getData();
    
    /**
     * sets the data for a binary node
     * 
     * @param new data
     */
    public void setData(T newData);
    
    /**
     * gets the left child node
     * 
     * @return the left node
     */
    public BinaryNodeInterface<T> getLeftChild();
    
    /**
     * gets the right child node
     * 
     * @return the right child node
     */
    public BinaryNodeInterface<T> getRightChild();
    
    /**
     * set the left child node
     * 
     * @param the new left child node reference
     */
    public void setLeftChild(BinaryNodeInterface<T> leftChild);
    
    /**
     *sets the right child node 
     *
     *@param the new right child node
     */
    public void setRightChild(BinaryNodeInterface<T> rightChild);
    
    /**
     * returns if there is a left child
     * 
     * @return a boolean
     */
    public boolean hasLeftChild();

    /**
     * returns if there is a right child
     * 
     * @return a boolean
     */
    public boolean hasRightChild();
    
    /**
     * checks to see if there is a leaf
     * 
     * @return a boolean
     */
    public boolean isLeaf();
    
    /**
     * gets the total number of nodes
     * 
     * @return an integer
     */
    public int getNumberOfNodes();
    
    /**
     * gets height of tree
     * 
     * @return an integer
     */
    public int getHeight();

    /**
     * copies a binary node
     * 
     * @return the copied node
     */
    public BinaryNodeInterface<T> copy();
}
