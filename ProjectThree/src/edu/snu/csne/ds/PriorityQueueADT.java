package edu.snu.csne.ds;

/**
 * PriorityQueueADT
 *
 * This interface describes the client interface to a priority queue
 * abstract data type.
 *
 * @author Brent Eskridge
 */
public interface PriorityQueueADT<T extends Comparable<? super T>>
{
    /**
     * Adds a new entry to the priority queue.
     *
     * @param entry The entry to be added to the priority queue
     */
    public void add( T entry );

    /**
     * Removes and returns the entry with the highest priority.
     *
     * @return Returns the entry with the highest priority if
     *         the priority queue is not empty, otherwise,
     *         <code>null</code>.
     */
    public T remove();

    /**
     * Retrieves the entry with the highest priority.
     *
     * @return Returns the entry with the highest priority if
     *         the priority queue is not empty, otherwise,
     *         <code>null</code>.
     */
    public T peek();

    /**
     * Determines if the priority queue is empty.
     *
     * @return Returns <code>true</code> if the priority queue is
     *         empty, otherwise, <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Returns the number of entries in this priority queue.
     *
     * @return The number of entries in this priority queue
     */
    public int getSize();

    /**
     * Removes all entries from the priority queue.
     */
    public void clear();

    /**
     * Returns a formatted description of this priority queue.  The 
     * escription contains all of the entries in the priority queue
     * in first to last order.
     *
     * @return A formatted description of this priority queue
     */
    public String toFormattedString();

}

