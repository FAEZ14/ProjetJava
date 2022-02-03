package jeu;

public interface Jeu {

	void choisirJoueurQuiCommence();

	void initialiser();

	int getNbJoueurs();

	void faireJouer();

	boolean partieFinie();

	int getGagnant();
	
	boolean partieQuitt�e();

	void resultatDeLaPartie();
}
