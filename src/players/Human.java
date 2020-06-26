package players;

import java.util.Scanner;

import games.AbstractGame;

/**
	* Human est une classe implementant l'interface GamePlayer
*/
public class Human implements GamePlayer{
	private String name;
	private Scanner scanner;
	public Human(String name, Scanner scanner){
		this.name=name;
		this.scanner=scanner;
	}
	/**
		* Redefinition de la methode chooseMove()
			* Si le coup que le joueur veut jouer n'est pas dans le validMoves() alors la methode redemandera le coup que le joueur veut jouer
		* @param qui prends en argument une instance de type AbstractGame
		* @return le coup que le joueur de type Humain veut jouer
	*/
	@Override
	public int chooseMove(AbstractGame n){
		System.out.println("Vous pouvez jouer : "+ n.validMoves() + "\n");
		boolean c = false;
		
		
			
		boolean bool=false;
		String reponse = "";
		int rep = -1;
		
		while (bool==false){
			try{
				System.out.print("Votre coup : ");
				reponse = scanner.nextLine();
				rep=Integer.parseInt(reponse);
				if(n.validMoves().contains(rep)){
					bool=true;
				}
				else{
					System.out.println("Le coup n'est pas valide, inserez de nouveau");	
				}
			}
			catch(NumberFormatException marchePas){
				System.out.print("Votre coup : ");
				
				
				}
		}
		
		return rep;
	}
	
	/**
		* Redefinition de la methode toString()
		* @return une chaine de caractere qui affiche le nom du joueur
	*/
	@Override
	public String toString(){
		return this.name;
	}

}
	
