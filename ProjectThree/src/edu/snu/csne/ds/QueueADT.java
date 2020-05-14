package edu.snu.csne.ds;

/**
 * QueueADT
 *
 * This interface describes the client interface to a queue abstract
 * data type.
 *
 * @author Brent Eskridge
 */
public interface QueueADT<T>
{
    /**
     * Adds a new entry to the back of this queue.
     *
     * @param entry The entry to add to the back of this queue
     */
    public void enqueue( T entry );

    /**
     * Removes and returns the entry at the front of the queue.
     *
     * @return Returns the entry at the front of the queue if the
     *         queue is not empty, otherwise, <code>null</code>
     */
    public T dequeue();

    /**
     * Retrieves the entry at the front of the queue.
     *
     * @return Returns the entry at the front of the queue if the
     *         queue is not empty, otherwise, <code>null</code>
     */
    public T getFront();

    /**
     * Determines if the queue is empty.
     *
     * @return Returns <code>true</code> if the queue is empty,
     *         otherwise, <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Removes all entries from the queue.
     */
    public void clear();

    /**
     * Returns a formatted description of this queue.  The description
     * contains all of the entries in the queue in first to last order.
     *
     * @return A formatted description of this queue
     */
    public String toFormattedString();
}
