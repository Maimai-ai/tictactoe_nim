package players;

import java.util.Random;

import games.AbstractGame;

/**
	* RandomPlayer est une classe implementant l'interface GamePlayer
*/
public class RandomPlayer implements GamePlayer{
	private Random randomGenerator;
	
	public RandomPlayer(Random randomGenerator){
		this.randomGenerator=randomGenerator;
	}
	
	/**
		* Redefinition de la methode chooseMove()
		* @param qui prends en argument une instance de type AbstractGame
		* @return le coup que le joueur de type Random veut jouer
	*/
	@Override
	public int chooseMove(AbstractGame n){		
		int position = this.randomGenerator.nextInt(n.validMoves().size());
		return  n.validMoves().get(position);
	}
	
	/**
		* Redefinition de la methode toString()
		* @return une chaine de caractere qui affiche "Joueur aleatoire" et un "hash code" qui permet de distinguer plusieurs éventuels joueur aléatoires
	*/
	@Override
	public String toString(){
		return "Joueur aleatoire #"+this.hashCode();
	}
}
