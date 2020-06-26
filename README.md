# tictactoe_nim

AZOUI Zineb - Licence Informatique (2eme Année)
BOUDET Maëlys - Licence Informatique (2eme Année)
LEPETIT Lucie - Licence Informatique (2eme Année)
YANG Tatiana - Licence Informatique (2eme Année)


	Pour jouer au jeu : 
		- Ouvrir un terminal(invite de commande) dans le dossier ou se trouve le README ainsi que le repertoire "src".
		- Tapez "cd src" pour accéder au fichier du jeu
		- Puis créer un repertoir "build" en écrivant la commande : "mkdir build"
		- Tapez la ligne de commande: "javac -d build games/*.java orchestration/*.java players/*.java" pour compiler.
	
	Il y a 2 façons d'exécuter notre jeu :
	
		- Pour executer le programme: "java -cp build/ orchestration.Jeu <nom_du_Jeu> <type_du_premier_joueur> <type_du_second_joueur>" 
    $en remplaçant par le jeu auquel vous souhaitez jouer "Nim" ou "TicTacToe", et les deux autres arguments par le type de joueur que vous voulez faire jouer c'est à dire "Human", "Random" ou "MinMaxPlayer" les majuscules n'ont pas leur importance mais sont conseillées.
		
		- Pour exécuter le programme avec le jar, on  se place dans le fichier build en écrivant la ligne de commande "cd build"
			- Puis écrire la ligne de commande: "jar cfe <nom_du_fichier>.jar orchestration.Jeu ."
			- Et pour terminer écrire la commande "java -jar <nom_du_fichier>.jar <nom_du_Jeu> <type_du_premier_joueur> <type_du_second_joueur>" 
			en remplaçant par le jeu auquel vous souhaitez jouer "Nim" ou "TicTacToe", et les deux autres arguments par le type de joueur que vous voulez faire jouer c'est à dire "Human", "Random" ou "MinMaxPlayer" les majuscules n'ont pas leur importance mais sont conseillées.
		
		
	Ensuite après avoir inséré les différents types de joueurs, si les deux joueurs sont de type "Human", après avoir saisi la commande, la console demandera d'entrer le nom du premier joueur, et ensuite le nom du second joueur.
	S'il n'y a qu'un seul joueur de type "Human" alors, elle demandera le nom de ce joueur. 
	
	Après cela, si le jeu souhaité jouer est Nim :
		- La console demandera le nombre d'allumette que contiendra notre tas initial
		- Puis le nombre d'allumette maximum que l'on peut retirer
		- Lorsque tout a été inséré, la partie commence avec le premier joueur, c'est a dire le premier type de joueur inséré en argument.
		- Si le joueur est de type "Human", la console demandera le nombre d'allumette que l'on veut enlever
		- Le joueur doit entrer son coup
		- Il affiche ensuite ce que le joueur a choisi de jouer et ensuite le nombre d'allumette dans le tas courant
		- Et puis nous changeons de joueur
		- Et ainsi de suite jusqu'à ce que le tas actuel ne contient pls aucune allumette
		- Lorsque la partie est finie, le terminal affiche le nom du gagnant
	
	Si le jeu souhaité est le TicTacToe :
		- La partie commence par un affichage de la grille actuelle ainsi qu'une indication
		- Puis le terminal affiche les coups que le joueur peut jouer
		- Vous devez ensuite insérer votre coup, s'il n'est pas valide, le terminal vous redemandera d'insérer votre coup
		- Puis ce sera au tour de l'autre joueur
		- Et ainsi de suite jusqu'à que la grille soit rempli, et affiche s'il y a un gagnant, son nom, sinon il affichera que la partie est nulle 
		
		
	Pour générer la documentation de toutes les classes des nos packages et le placer dans un répertoire il suffit d'écrire en ligne de commande : 
		-"javadoc -d <nom_du_repertoire> games/*.java orchestration/*.java players/*.java"
