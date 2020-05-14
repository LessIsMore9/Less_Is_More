package edu.snu.csne.ds;

import java.util.HashMap;

public class BoardDictionary
{
	/*
	 * dictionary that contains entries (String[] arrayBoard, int index)
	 * where board is the current game state and index is the 
	 * index of the 1d arrayBoard where the player should mointe next
	 */
	HashMap< ArrayToeBoard, Integer > boardDict =
				new HashMap< ArrayToeBoard, Integer >();
	
	
	public BoardDictionary()
	{
		
	}
	
	public ArrayToeBoard addEntry( ArrayToeBoard board, int bestMove )
	{
		boardDict.put( board, bestMove );
		return board;
	}
	
	public void addAllBoards()
	{
		// method to construct all valid ToeBoards
	}
	
	public void buildToeDictionary()
	{
		// addAllBoards
	}
}
