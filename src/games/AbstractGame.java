package games;

import java.util.List;
import java.util.ArrayList;

import players.GamePlayer;

/**
	* AbstractGame est une classe abstraite ayant pour attribut deux joueurs ainsi que le joueur courant
*/
public abstract class AbstractGame {
	protected GamePlayer Playera;
	protected GamePlayer Playerb;
	protected GamePlayer currentPlayer;
	
	public AbstractGame(GamePlayer Playera, GamePlayer Playerb){
		this.Playera = Playera;
		this.Playerb = Playerb;
		this.currentPlayer = Playera;
	}
	
	/**
		* movePlay() est une methode abstraite permettant d'executer un coup
		* @param un entier
			* qui correspond au coup jouer
	*/
	public abstract void movePlay(int n);
	
	/**
		* execute() est une methode qui permet d'executer un coup et de changer le joueur courant
		* @param un entier
			* qui correspond le coup jouer
	*/
	public void execute(int n){
		movePlay(n);
		if(this.currentPlayer == Playera){
			this.currentPlayer = Playerb;
		}
		else {
			this.currentPlayer = Playera;
		}
	}
	
	/**
		* currentPlayer() qui permet de retourner le joueur courant
		* @return le joueur courant
	*/
	public GamePlayer currentPlayer(){
		return this.currentPlayer;
	}
	
	/**
		* moveToString() est une methode abstraite de type String
		* @param prend un entier
			* qui correspond au coup jouer
	*/
	public abstract String moveToString(int n);
	
	/**
		* validMoves() est une methode abstraite de type List
	*/
	public abstract List<Integer> validMoves();
	/**
		* situationToString() est une methode abstraite de type String
	*/
	public abstract String situationToString();
	/**
		* getWinner() est une methode abstraite de type GamePlayer
	*/
	public abstract GamePlayer getWinner();
	/**
		* isOver() est une methode abstraite de type boolean
	*/
	public abstract boolean isOver();
	/**
		* getCopy() est une methode abstraite de type AbstractGame
	*/
	public abstract AbstractGame getCopy();
}
