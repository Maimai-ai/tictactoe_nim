package orchestration;

import java.util.Scanner;

import games.AbstractGame;

/**
	* La classe Orchestrator possède une methode playGame() qui fait jouer une partie de ce jeu
*/
public class Orchestrator{
	
	/**
		* La methode playGame() prend un objet de type AbstractGame
		* @param une partie
			* qui est de type AbstractGame
		* @return si la partie est termine le nom du joueur gagnant ou si la partie est nulle s'il n'y a aucun gagnant soit quand getWinner() = null
	*/
	public String playGame(AbstractGame partie){
		Scanner scanner = new Scanner(System.in);
		boolean c = false;
		while (partie.isOver() != true){
			System.out.println(" ############### C'est au tour de " + partie.currentPlayer() + " de jouer ! ###############\n");
			
			System.out.println(partie.situationToString());
			System.out.println("\n");
				
			int i = partie.currentPlayer().chooseMove(partie);
			System.out.println(partie.currentPlayer()+" a choisi de jouer : " + i + "\n");
			System.out.println(partie.moveToString(i) + "\n");
			partie.execute(i);
		}
		scanner.close();
		System.out.println(partie.situationToString());
		System.out.println('\n');
		System.out.println("------------ THE END ------------");
		System.out.println('\n');
		if(partie.getWinner() == null){
			return "PARTIE NULLE";
		}
		else{
			return "GAGNANT : " + partie.getWinner();
		}
	} 
}
