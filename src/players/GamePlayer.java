package players;

import games.AbstractGame;

/**
	* GamePlayer est une interface qui déclare une methode chooseMove()
*/
public interface GamePlayer{
	
	/**
		* Declaractiond de la methode chooseMove()
		* @param prend en argument une instance de type AbstractGame
	*/
	public int chooseMove(AbstractGame n);
}
