package players;

import java.util.Random;

import games.AbstractGame;

/**
	* MinMaxPlayer est une classe implementant l'interface GamePlayer
*/

public class MinMaxPlayer implements GamePlayer{
	private Random randomGenerator;
	
	public MinMaxPlayer(Random randomGenerator){
		this.randomGenerator=randomGenerator;
	}
	
	/**
		* Redefinition de la methode chooseMove()
			* qui fait une fait une copie du jeu jouer et choisi le meilleur coup
		* @param qui prends en argument une instance de type AbstractGame
		* @return le coup que le joueur de type MinMaxPlayer veut jouer
	*/
	@Override
	public int chooseMove (AbstractGame jeu){
		int bestValue = -2;
		int bestMove = -1;
		
		int v = 0;
		
		for(int move : jeu.validMoves()){
			AbstractGame situation = jeu.getCopy();
			situation.execute(move);
			GamePlayer Player2 = situation.currentPlayer();
			v= -evaluer(situation, Player2);
			if(v > bestValue){
				bestValue = v;
				bestMove = move;
			}
		}
		return bestMove;
	}
	
	/**
		* Methode evaluer qui evalue le jeu
		* @param qui prend une instance de type AbstractGame et une seconde instance de type GamePlayer
		* @return des entiers
	*/
	public int evaluer(AbstractGame jeu, GamePlayer currentPlayer){
		if(jeu.isOver() == true){
			/*System.out.print("Il a evaluer le jeu a "+ jeu.situationToString());*/
			if(jeu.getWinner() == currentPlayer){
				/*System.out.println("1");*/
				return +1;
			}
			else if (jeu.getWinner() == null){
				/*System.out.println("0");*/
				return 0;
			}
			else{
				/*System.out.println("-1");*/
				return -1;
			}
		}
		else{
			int res = -1;
			int v = 0;
			for( int move : jeu.validMoves()){
				AbstractGame situation = jeu.getCopy();
				situation.execute(move);
				GamePlayer Player2 = situation.currentPlayer();
				v= -evaluer(situation, Player2);
				res = Math.max(res, v);
			}
			return res;
		}
	}
	
	/**
		* Redefinition de la methode toString()
		* @return une chaine de caractere qui affiche "IA" et un "hash code" qui permet de distinguer plusieurs éventuels joueur MinMax
	*/
	@Override
	public String toString(){
		return "IA #"+this.hashCode();
	}

}
