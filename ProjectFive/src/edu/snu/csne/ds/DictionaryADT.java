package edu.snu.csne.ds;

import java.util.Iterator;

/**
 * DictionaryADT
 *
 * This interface describes the client interface to a dictionary
 * abstract data type.  Keys in this dictionary are unique.
 */
public interface DictionaryADT<K, V>
{
    /**
     * Adds a new entry, or key/value pair, to this dictionary.  If
     * the given key already exists in the dictionary, this method
     * replaces the corresponding value with the given value.
     *
     * @param key The unique search key of the new entry
     * @param value The value associated with the search key
     * @return Returns the value being replaced if the key already
     *         exists in this dictionary, otherwise, <code>null</code>
     */
    public V add( K key, V value );

    /**
     * Removes the entry with the given search key.
     *
     * @param key The unique search key of the entry to remove
     * @return Returns the value that was associated with the search
     *         key, or <code>null</code> the key did not exist in
     *         this dictionary
     */
    public V remove( K key );

    /**
     * Retrieves the value associated with the given search key.
     *
     * @param key The unique search key of the entry to retrieve
     * @return Returns the value that is associated with the search
     *         key, or <code>null</code> the key does not exist in
     *         this dictionary
     */
    public V getValue( K key );

    /**
     * Determines if the given search key is in this dictionary.
     *
     * @param key The unique search key
     * @return <code>true</code> if the key is associated with an
     *         entry in this dictionary, otherwise,
     *         <code>false</code>
     */
    public boolean contains( K key );

    /**
     * Returns an iterator that traverses all the search keys in
     * this dictionary.
     *
     * @return An iterator that provides sequential access to all
     *         the search keys in this dictionary
     */
    public Iterator<K> getKeyIterator();

    /**
     * Returns an iterator that traverses all the values in this
     * dictionary.
     *
     * @return An iterator that provides sequential access to all
     *         the values in this dictionary
     */
    public Iterator<V> getValueIterator();

    /**
     * Determines if the dictionary is empty.
     *
     * @return Returns <code>true</code> if the dictionary is empty,
     *         otherwise, <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Determines if the dictionary is full.
     *
     * @return Returns <code>true</code> if the dictionary is full,
     *         otherwise, <code>false</code>
     */
    public boolean isFull();

    /**
     * Returns the number of key/value pairs in this dictionary.
     *
     * @return The number of key/value pairs in this dictionary
     */
    public int getSize();

    /**
     * Removes all entries from the dictionary.
     */
    public void clear();

    /**
     * Returns a formatted description of this dictionary.  The
     * description contains all of the key/value pairs in this
     * dictionary.
     *
     * @return A formatted description of this dictionary
     */
    public String toFormattedString();
}
