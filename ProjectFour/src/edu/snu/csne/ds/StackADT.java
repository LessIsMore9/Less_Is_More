package edu.snu.csne.ds;

/**
 * StackADT
 *
 * This interface describes the client interface to a stack abstract
 * data type.
 *
 * @author Brent Eskridge
 */
public interface StackADT<T>
{
    /**
     * Adds a new entry to the top of this stack.
     *
     * @param entry The entry to be added to the top of this stack
     */
    public void push( T entry );

    /**
     * Removes and returns the entry at the top of the stack.
     *
     * @return Returns the entry at the top of the stack if the stack
     *         is not empty, otherwise, <code>null</code>
     */
    public T pop();

    /**
     * Retrieves the entry at the top of the stack.
     *
     * @return Returns the entry at the top of the stack if the stack
     *         is not empty, otherwise, <code>null</code>
     */
     public T peek();

    /**
     * Determines if the stack is empty.
     *
     * @return Returns <code>true</code> if the stack is empty,
     *         otherwise, <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Removes all entries from the stack.
     */
    public void clear();

    /**
     * Returns a formatted description of this stack.  The description
     * contains all of the entries in the stack in first to last order.
     *
     * @return A formatted description of this stack
     */
    public String toFormattedString();

}
