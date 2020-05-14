/*
 * COPYRIGHT
 */
package edu.snu.csne.ds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * DefaultDictionaryADT
 *
 * TODO Class description
 *
 * @author Brent Eskridge
 * @version $Revision$ ($Author$)
 */
public class DefaultDictionaryADT<K, V> implements DictionaryADT<K, V>
{
    /** A standard Java Map is used for implementation */
    protected Map<K, V> _map = new HashMap<K, V>();

    /**
     * Adds a new entry, or key/value pair, to this dictionary.  If
     * the given key already exists in the dictionary, this method
     * replaces the corresponding value with the given value.
     *
     * @param key The unique search key of the new entry
     * @param value The value associated with the search key
     * @return Returns the value being replaced if the key already
     *         exists in this dictionary, otherwise, <code>null</code>
     * @see edu.snu.csne.ds.DictionaryADT#add(java.lang.Object, java.lang.Object)
     */
    @Override
    public V add( K key, V value )
    {
        return _map.put( key, value );
    }

    /**
     * Removes the entry with the given search key.
     *
     * @param key The unique search key of the entry to remove
     * @return Returns the value that was associated with the search
     *         key, or <code>null</code> the key did not exist in
     *         this dictionary
     * @see edu.snu.csne.ds.DictionaryADT#remove(java.lang.Object)
     */
    @Override
    public V remove( K key )
    {
        return _map.remove( key );
    }

    /**
     * Retrieves the value associated with the given search key.
     *
     * @param key The unique search key of the entry to retrieve
     * @return Returns the value that is associated with the search
     *         key, or <code>null</code> the key does not exist in
     *         this dictionary
     * @see edu.snu.csne.ds.DictionaryADT#getValue(java.lang.Object)
     */
    @Override
    public V getValue( K key )
    {
        return _map.get( key );
    }

    /**
     * Determines if the given search key is in this dictionary.
     *
     * @param key The unique search key
     * @return <code>true</code> if the key is associated with an
     *         entry in this dictionary, otherwise,
     *         <code>false</code>
     * @see edu.snu.csne.ds.DictionaryADT#contains(java.lang.Object)
     */
    @Override
    public boolean contains( K key )
    {
        return _map.containsKey( key );
    }

    /**
     * Returns an iterator that traverses all the search keys in
     * this dictionary.
     *
     * @return An iterator that provides sequential access to all
     *         the search keys in this dictionary
     * @see edu.snu.csne.ds.DictionaryADT#getKeyIterator()
     */
    @Override
    public Iterator<K> getKeyIterator()
    {
        return _map.keySet().iterator();
    }

    /**
     * Returns an iterator that traverses all the values in this
     * dictionary.
     *
     * @return An iterator that provides sequential access to all
     *         the values in this dictionary
     * @see edu.snu.csne.ds.DictionaryADT#getValueIterator()
     */
    @Override
    public Iterator<V> getValueIterator()
    {
        return _map.values().iterator();
    }

    /**
     * Determines if the dictionary is empty.
     *
     * @return Returns <code>true</code> if the dictionary is empty,
     *         otherwise, <code>false</code>
     * @see edu.snu.csne.ds.DictionaryADT#isEmpty()
     */
    @Override
    public boolean isEmpty()
    {
        return _map.isEmpty();
    }

    /**
     * Determines if the dictionary is full.
     *
     * @return Returns <code>true</code> if the dictionary is full,
     *         otherwise, <code>false</code>
     * @see edu.snu.csne.ds.DictionaryADT#isFull()
     */
    @Override
    public boolean isFull()
    {
        return false;
    }

    /**
     * Returns the number of key/value pairs in this dictionary.
     *
     * @return The number of key/value pairs in this dictionary
     * @see edu.snu.csne.ds.DictionaryADT#getSize()
     */
    @Override
    public int getSize()
    {
        return _map.size();
    }

    /**
     * Removes all entries from the dictionary.
     *
     * @see edu.snu.csne.ds.DictionaryADT#clear()
     */
    @Override
    public void clear()
    {
        _map.clear();
    }

    /**
     * Returns a formatted description of this dictionary.  The
     * description contains all of the key/value pairs in this
     * dictionary.
     * @see edu.snu.csne.ds.DictionaryADT#toFormattedString()
     */
    @Override
    public String toFormattedString()
    {
        return "ToDo";
    }

}
