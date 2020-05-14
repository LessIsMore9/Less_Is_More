package edu.snu.csne.ds;

/**
 * DequeADT
 *
 * This interface describes the client interface to a deque abstract
 * data type.
 *
 * @author Brent Eskridge
 */
public interface DequeADT<T>
{
    /**
     * Adds a new entry to the front of this deque.
     *
     * @param entry The entry to add to the front of this deque
     */
    public void addToFront( T entry );

    /**
     * Adds a new entry to the back of this deque.
     *
     * @param entry The entry to add to the back of this deque
     */
    public void addToBack( T entry );

    /**
     * Removes and returns the entry at the front of this deque.
     *
     * @return Returns the entry at the front of the deque if the
     *         deque is not empty, otherwise, <code>null</code>
     */
    public T removeFront();

    /**
     * Removes and returns the entry at the back of this deque.
     *
     * @return Returns the entry at the back of the deque if the
     *         deque is not empty, otherwise, <code>null</code>
     */
    public T removeBack();

    /**
     * Retrieves the entry at the front of the deque.
     *
     * @return Returns the entry at the front of the deque if the
     *         deque is not empty, otherwise, <code>null</code>
     */
    public T getFront();

    /**
     * Retrieves the entry at the back of the deque.
     *
     * @return Returns the entry at the back of the deque if the
     *         deque is not empty, otherwise, <code>null</code>
     */
    public T getBack();

    /**
     * Determines if the deque is empty.
     *
     * @return Returns <code>true</code> if the deque is empty,
     *         otherwise, <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Removes all entries from the deque.
     */
    public void clear();

    /**
     * Returns a formatted description of this deque.  The description
     * contains all of the entries in the deque in front to back order.
     *
     * @return A formatted description of this deque
     */
    public String toFormattedString();

}

