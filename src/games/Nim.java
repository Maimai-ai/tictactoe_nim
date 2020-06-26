package games;

import java.util.List;
import java.util.ArrayList;

import players.GamePlayer;

/**
	* Nim est la classe representant notre jeu Nim, un jeu d'allumettes, qui herite de la classe AbstractGame
*/

public class Nim extends AbstractGame{
	private int tas;
	private int maxAllumette;
	private int tasCurrent;
	public Nim(int tas, int maxAllumette, GamePlayer Playera, GamePlayer Playerb){
		super(Playera,Playerb);
		this.tas = tas;
		this.maxAllumette = maxAllumette;
		this.tasCurrent = tas;
	}
	/**
		* @return une instance du tas initial
	*/
	public int getInitialNbMatches(){
		return this.tas;
	}
	
	/**
		* Il s'agit d'une redefinition de la situation actuel
		* @return une chaine de caractere indiquant le nombre d'allumette dans le tas courant
	*/
	@Override
	public String situationToString(){
		return "Il y a : " + this.tasCurrent + " allumettes";
	}
	
	/**
		* Il s'agit d'une redefinition du coup jouer
		* @param le nombre d'allumette
			* Le nouveau nombre d'allumette dans le tas courant
	*/
	@Override
	public void movePlay(int nbAllumette){
		if(nbAllumette<0 || nbAllumette > this.maxAllumette){
			throw new IllegalArgumentException("Coup invalide");
		} else {
			this.tasCurrent = this.tasCurrent - nbAllumette;
		}
	}
	
	/**
		* Il s'agit d'une redefinition des mouvement valides
		* @return une liste contenant les mouvements valides
	*/
	@Override
	public List<Integer> validMoves(){
		List<Integer> list = new ArrayList<> ();
		for(int i = 1; i<= this.tasCurrent; i++){
			if(i <= this.maxAllumette){
				list.add(i);
			}
		}
		return list;
	}
	/**
		* Retourne si le nombre d'allumette que l'on souhaite retirer est valide ou non
		* @return un booleen
	*/
	public boolean valide(int nbAllumette){
		if (nbAllumette > this.maxAllumette || nbAllumette<=0 || nbAllumette > this.tasCurrent){ //IMPORTANCE DES ARGUMENTS
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
		* Redefinition de la methode isOver()
		* @return un booleen
	*/
	@Override
	public boolean isOver(){
		if (this.tasCurrent == 0){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
		* Redefinition de la methode getWinner()
		* @return le joueur courant, soit le joueur gagnant
	*/
	@Override
	public GamePlayer getWinner(){
		if (isOver() == true){
			return this.currentPlayer;
		}
		else{
			return null;
		}
	}
	
	/**
		* Redefinition de la methode moveToString()
		* @return une chaine de caractere qui indique le nombre d'allumette que le joueur a choisi d'enlever
	*/
	@Override
	public String moveToString(int n){
		return "Vous avez choisis d'enlever "+ n + " allumettes";
	}
	
	/**
		* Redefinition de la methode getCopy()
		* @return une copie du jeu Nim
	*/
	@Override
	public AbstractGame getCopy(){
		Nim res = new Nim(this.tas, this.maxAllumette, this.Playera, this.Playerb);
		res.tasCurrent = this.tasCurrent;
		res.currentPlayer = this.currentPlayer;
		return res;
	}
}
