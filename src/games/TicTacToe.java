package games;

import java.util.List;
import java.util.ArrayList;

import players.GamePlayer;

/**
	* TicTacToe est une classe qui herite de la classe AbstractGame
	* Il s'agit du jeu du morpion
*/
public class TicTacToe extends AbstractGame{
	private GamePlayer[][] currentGrid;
	
	public TicTacToe(GamePlayer Playera, GamePlayer Playerb){
		super(Playera,Playerb);
		this.currentGrid = new GamePlayer[3][3];
	}
	
	/** 
		* Methode qui permet d'initialiser la grille
		* @return une grille vide
	*/
	public GamePlayer[][] Initialiser(){
		for(int i = 0; i< this.currentGrid.length; i++){
			for(int j = 0; j< this.currentGrid[i].length;j++){
				this.currentGrid[i][j]=null;
			}
		} return this.currentGrid;
	}
	
	/** Creation d'une methode qui retourne le numero qui correspont a la case
		* @return un entier
		* @param Deux entiers
			* Qui correspond au numero de la ligne et de la colonne
	*/
	public int entiercase(int i, int j){
		return i*3+j+1;
	}	
	
	/** 
		* Puis creation de la methode inverse qui prend en argument un entier qui retourne la case qui correspond
		* @return chaine de caractere avec le numero de la ligne et de la colonne
	*/
	public String casecorresp(int n){
		return "(" + (n-1)/3 +" ; " + (n-1)%3 + ")";
	}
	
	/**
		* Methode qui permet de tester si un joueur a jouer sur la meme ligne, ou colonne ou diagonale
		* @return un booleen
	*/
	public boolean tester(int firstRow, int firstColumn, int deltaRow, int deltaColumn, GamePlayer joueur){
		for(int n =0; n <3; n++){
			int ligne = firstRow + deltaRow*n;
			int column = firstColumn + deltaColumn*n;
			if(joueur != currentGrid[ligne][column]){
				return false;
			}
		}
		return true;
	}
	
	/**
		* Redefinition de la methode getWinner() qui parcours si un joueur a jouer sur la meme ligne, ou colonne ou diagonale
		* si cele est le cas il a gagne
		* @return le joueur gagnant
	*/
	@Override
	public GamePlayer getWinner(){
		GamePlayer winner = null;
		if(currentPlayer == Playera){
			winner = Playerb;
		} else {
			winner = Playera;
		}
		
		for(int l = 0; l < 3; l++){ //Verifier toutes les ligne
			if(tester(l,0,0,1,winner)){
				return winner;
			}
		}
		for(int c = 0; c < 3; c++){ // Verifier toutes les colonnes
			if(tester(0,c,1,0,winner)){
				return winner;
			}
		}
		// Verifie la diagonale
		if(tester(0,0,1,1,winner)){
			return winner;
		}
		// Verifie l'anti-diagonale
		if(tester(0,2,1,-1,winner)){
			return winner;
		}
		return null;
	}
	
	/** 
		* Redefinition de la methode isOver() qui permet de savoir si la partie est termine ou non
		* @return un booleen
	*/
	@Override
	public boolean isOver(){
		if (getWinner() != null){
			return true;
		}
		else if(validMoves().isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
		* Redefinition de la methode movePlay()
		* @param qui prend un entier
			* Le coup que le joueur veut jouer
	*/
	@Override
	public void movePlay(int n){
		if (this.currentPlayer == Playera){
			this.currentGrid[(n-1)/3][(n-1)%3]=Playera;
		} 
		else if (this.currentGrid[(n-1)/3][(n-1)%3] != null){
			throw new IllegalArgumentException("Coup invalide");
		}
		else {
			this.currentGrid[(n-1)/3][(n-1)%3]=Playerb;
		}
	}
	
	/**
		* Redefinition de la methode validMoves()
		* @return une liste contenant les coups valides
	*/
	@Override
	public List<Integer> validMoves(){
		List<Integer> list = new ArrayList<> ();
		for(int i = 0; i< this.currentGrid.length; i++){
			for(int j = 0; j< this.currentGrid[i].length;j++){
				if(this.currentGrid[i][j] == null){
					list.add(entiercase(i,j));
				}
			}
		}
		return list;
	}
	
	/**
		* Redefinition de la methode moveToString()
		* @param un entier
			* le coup jouer
		* @return une chaine de caractere indiquant a quoi correspond le coup
	*/
	@Override
	public String moveToString(int n){
		return "Votre coup correspond a : " + casecorresp(n);
	}
	
	/**
		* Redefinition de la methode situationToString()
		* @return une chaine de caractere qui represente la grille actuelle
	*/
	@Override
	public String situationToString(){
		String phrase="Grille actuelle : \n" ;
		for(int i = 0; i< this.currentGrid.length; i++){
			for(int j = 0; j< this.currentGrid[i].length;j++){
				if(currentGrid[i][j] == null){
					phrase += " ";
					
				}
				else if (currentGrid[i][j]==Playera){
					phrase = phrase +"X";
				} else {
					phrase = phrase +"O";
				}
				if(j<2){ phrase += " | ";}
			}
			phrase = phrase + System.lineSeparator();
		}
		
		System.out.println("Indication : \n 1 | 2 | 3 \n 4 | 5 | 6 \n 7 | 8 | 9 \n");
		return phrase;
	}
	
	/**
		* Redefinition de la methode getCopy()
		* @return une copie du jeu
	*/
	@Override
	public AbstractGame getCopy(){
		TicTacToe copy =new TicTacToe(Playera, Playerb);
		copy.currentPlayer=this.currentPlayer;
		for ( int i =0; i<3; i++){
			for ( int j =0; j<3; j++){
			copy.currentGrid[i][j]=this.currentGrid[i][j];
			}
		}
		return copy;
	}
}
