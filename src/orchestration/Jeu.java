package orchestration;

import java.util.Scanner;
import java.util.Random;

import games.*;
import players.*;

/**
	* Jeu est la classe executable qui permet de lancer une partie, qui prend un premier argument qui correspond au jeu que nous voulons jouer, puis d'un second argument qui prend le type du premier joueur et pour finir d'un dernier argument qui prend le type de joueur du second joueur
*/
public class Jeu{
	
	public static void main (String [] args){
		Scanner scanner = new Scanner(System.in);
		if(args.length!=3){
			System.out.println("Vous n'avez pas mis le nombre d'arguments souhaite \n");
			throw new IllegalArgumentException("Mauvais usage des arguments");
		}
		String jeu = args[0];
		String type1 = args[1];
		String type2 = args[2];
		
		GamePlayer premjoueur = Jeu.type(type1, scanner);
		GamePlayer secjoueur = Jeu.type(type2, scanner);
		
		/**
			* Si le premier argument ecrit est Nim alors la classe va executer un jeu Nim
		*/
		if(jeu.equals("Nim") || jeu.equals("nim")){
			System.out.println('\n');
			System.out.println("------------ COMMENCEZ ------------");
			System.out.println('\n');
			System.out.print("Entrez le nombre d'allumette au depart : ");
			int n = scanner.nextInt();
			System.out.print("Entrez le nombre d'allumette maximum que l'on peut retirer : ");
			int k = scanner.nextInt();
			
			while(n < k){
				System.out.println("Le nombre d'allumette maximum que l'on peut retirer est trop grand !");
				System.out.print("Entrez de nouveau : ");
				k = scanner.nextInt();
			}
			System.out.println('\n');
			Nim partie = new Nim(n,k,premjoueur, secjoueur);
			Orchestrator orchestrator = new Orchestrator();
			System.out.println(orchestrator.playGame(partie));
		}
		/**
			* Si le premier argument ecrit ne correspond pas a Nim, alors la classe Jeu va executer un jeu d'instance TicTacToe
		*/
		else{
			System.out.println('\n');
			System.out.println("------------ COMMENCEZ ------------");
			System.out.println('\n');
			TicTacToe partie = new TicTacToe(premjoueur, secjoueur);
			Orchestrator orchestrator = new Orchestrator();
			System.out.println(orchestrator.playGame(partie));
		}		
		scanner.close();
	}
	/**
		* Une methode static qui permet d'executer le jeu en fonction des differents types de joueur
		* @return une instance qui correspond au type de joueur
	*/
	public static GamePlayer type(String a,Scanner scanner){
		if(a.equals("Random") || a.equals("random")){
			return new RandomPlayer(new Random());
		}
		else if(a.equals("Human") || a.equals("human")){
			System.out.println("Entrez le nom du joueur:");
			String Playera = scanner.nextLine();
			return new Human(Playera, scanner);
		}
		else{
			return new MinMaxPlayer(new Random());
		}
	}
}
