package edu.snu.csne.ds;

/*
 * interface for the NiceListADT
 * 
 * NiceListADT contains entries of type < name , list >
 * 
 * further description of each method is in the implementation class
 * 
 * @author Josh Lessner
 */
public interface NiceListADT
{
	/*
	 * adds (name, list) to the end of the unsorted linked NiceListADT
	 * 
	 * precondition - user must pass arguments of type String, ArrayList<String>
	 * postcondition - method adds entry to the NiceListADT
	 * 
	 * @param newName - the name (key) to be added
	 * 					must be of type String
	 * 					must not be null
	 * @param newList - the list to be added, associated with newName
	 * 					must be of type ListADT<String>
	 * 					may be null
	 * @throws IllegalArgumentException if parameter conditions not met
	 * @return void
	 */
	public void add( String newName, ListADT<String> newList );
	
	/*
	 * removes (name, list) from the NiceListADT
	 * 
	 * preconditions - user must pass string, dictionary must not be empty
	 * postconditions - method removes name/corresponding list and returns the name,
	 * 					or returns null if name is not contained in the dictionary
	 * 
	 * @param name - identifying key for entry to be removed
	 * 				 may not be null
	 * @throws IllegalArgumentException if name is null,
	 * 									name is not String type,
	 * 									or name is not in dictionary
	 * @return ListADT<String> list associated with name
	 */
	public ListADT<String> remove( String name );
	
	/*
	 * clears dicitonary by eleminating firstNode's nextNode reference,
	 * setting firstNode to null and reverts dictionary size back to zero
	 * 
	 * preconditions - none
	 * postconditions - empty dictionary
	 * 
	 * @return void
	 */
	public void clear();
	
	/*
	 * replace specified entry with new entry
	 * 
	 * preconditions - name cannot be null, newList must be of type ListADT<String> or be null,
	 * 					and NiceListADT must contain newName index
	 * postconditions - List w/ given name will be replaced with the newList
	 * 
	 * @param newName - replace entry w given newName
	 *					cannot be null
	 * @param newList - replace current list with newList
	 * 					may be null
	 * @throws IllegalArgumentException if newName is not string or is null, or
	 * 									if newList is not of type ListADT<String>
	 * @return newName
	 */
	public String replace( String newName , ListADT<String> newList );
	
	/*
	 * returns list entry associated with givenName
	 * 
	 * preconditions - givenName cannot be null and NiceListADT must contain an
	 * 					entry for the given name
	 * postconditions - returns type ListADT<String> or null if no list exists at desired node
	 * 
	 * @param givenName - name (key) to identify list to retrieve
	 * 					  cannot be null
	 * @throws IllegalArgumentException if name is null or not String type
	 * @return ListADT<String> list associated with givenName
	 */
	public ListADT<String> getList( String givenName );
	
	/*
	 * determines if entry w name is in dictionary
	 * 
	 * preconditions - name is type String
	 * postconditions - returns boolean
	 * 
	 * @param name - type String to ID entry
	 * @throws IllegalArgumentException if name is not type String
	 * @return boolean based on whether dict. contains name entry
	 */
	public boolean contains( String name );
	
	/*
	 * returns number of entries (not size) of dictionary
	 * 
	 * preconditions - none
	 * postconditions - returns int
	 * 
	 * @return int numberOfEntries
	 */
	public int getLength();
	
	/*
	 * returns whether dicitonary has at least one entry
	 * 
	 * preconditions - none
	 * postconditions - returns boolean
	 * 
	 * @return boolean true if no entries, false otherwise
	 */
	public boolean isEmpty();
	
	/*
	 * returns formatted string of dictionary
	 * 
	 * preconditions - none
	 * postconditions - returns String
	 * 
	 * @returns String of dicitionary
	 */
	public String toFormattedString();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}