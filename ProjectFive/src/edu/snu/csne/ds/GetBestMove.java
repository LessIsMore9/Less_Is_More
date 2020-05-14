package edu.snu.csne.ds;

public class GetBestMove implements BestMove
{
	
	/*
	 * method to find best move for given game state
	 */

	@Override
	public int getBestMove(ArrayToeBoard board)
	{
		return board.getNullIndex();
	}

}
