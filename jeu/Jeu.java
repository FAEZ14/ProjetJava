package jeu;

public interface Jeu {

	void choisirJoueurQuiCommence();

	void initialiser();

	int getNbJoueurs();

	void faireJouer();

	boolean partieFinie();

	int getGagnant();
	
	boolean partieQuittée();

	void resultatDeLaPartie();
}
