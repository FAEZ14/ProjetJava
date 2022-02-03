package VariantesAwal�;

import java.util.Random;
import java.util.Scanner;

import jeu.Jeu;
import joueur.Joueur;
import plateau.Plateau;

public class Awal� implements Jeu {

	private final int NBJOUEURS=2;
	private Joueur joueurs[];
	private int indJoueur;
	private Plateau plateau;
	private boolean quitter;

	/**
	 * Un constructeur dont les nombres de graines, de trous sont pass�s en
	 * param�tre  pour les sous-classes
	 * 
	 * @param nbGraines : le nombre de graines
	 * @param nbTrous   : le nombre de trous
	 */
	protected Awal�(int nbGraines, int nbTrous) {
		plateau = new Plateau(nbGraines, nbTrous);
		joueurs = new Joueur[NBJOUEURS];
		joueurs[1] = new Joueur(plateau.getNomC�t�2());
		joueurs[0] = new Joueur(plateau.getNomC�t�1());
		indJoueur = 0; // joueur qui commence par d�faut
	}

	/**
	 * constructeur de l'awal�
	 */
	public Awal�() {
		this(48, 12);
	}

	protected Plateau getPlateau() {
		return plateau;
	}

	/**
	 * une m�thode pour obtenir le nom du variant de l'awal�
	 * 
	 * @return le nom du variant
	 */
	public String getNomVariant() {
		return "Awal� (aw�l�)";
	}

	/**
	 * Pour avoir le nombre de joueurs
	 * 
	 * @return le nombre de joueurs
	 */
	public  int getNbJoueurs() {
		return NBJOUEURS;
	}

	/**
	 * M�thode pour initialiser le plateau en mettant le nombre de graines qu'il
	 * faut dans chaque trou
	 */
	public void initialiser() {
		plateau.initialiserPlateau();
		joueurs[0].initialisterScore();
		joueurs[1].initialisterScore();
	}

	/**
	 * Obtient le nombre de graines d'un joueur sur le plateau
	 * 
	 * @param j : l'indice du joueur
	 * @return le nombre de graines
	 */
	public int getNbGrainesJoueur(int j) {
		assert (j >= 0 && j < NBJOUEURS);
		if (j == 0) {
			return plateau.getNbGrainePlateau(0, plateau.getNbTrous() / 2);
		} else if (j == 1) {
			return plateau.getNbGrainePlateau(plateau.getNbTrous() / 2, plateau.getNbTrous());
		} else
			return 0;
	}

	/**
	 * M�thode qui permet de savoir le c�t� du joueur � partir d'un trou pass� en
	 * param�tre
	 * 
	 * @param i : indice du trou
	 * @return le c�t� du joueur
	 */
	protected int identit�Joueur(int i) {
		assert (plateau.indiceTrouEstCorrect(i));
		return plateau.getRang�e(i); // 0 � (NbTrous / 2)-1 c'est le JOUEUR1 // NbTrous / 2 � NbTrous / 2 le JOUEUR2
	}

	/**
	 * V�rifie si la partie est finie c'est � dire aucun est possible sur le plateau
	 * 
	 * @return vrai si c'est le cas, faux si non
	 */
	public boolean partieFinie() {
		if (getNbGrainesJoueur((indJoueur + 1) % NBJOUEURS) == 0) { // si l'adversaire n'a aucune graines et qu'on peut
																	// pas le nourir
			int n,premierInd,dernierInd;
			premierInd=(indJoueur==0)? 0:plateau.getNbTrous() / 2;
			dernierInd=(indJoueur==0)? plateau.getNbTrous() / 2:plateau.getNbTrous();
			for (int i = premierInd; i < dernierInd; i++) {
				n = (i + plateau.getNbGrainesTrou(i)) % plateau.getNbTrous();
				if (plateau.getRang�e(i) != plateau.getRang�e(n))
					return false;
			}
			return true;
		}
		return false;

	}

	/**
	 * verifie si y'a un des joueurs qui veut quitter la partie si c'est le cas y'a
	 * repartition des graines
	 */
	public boolean partieQuitt�e() {
		if (quitter)
			repartitionDesGraines();
		return quitter;
	}

	/**
	 * V�rifie si le joueur nourrit le joueur adverse s'il n'a aucune graines dans
	 * sa rang�e
	 * 
	 * @param j : indice du joueur qui joue
	 * @param i : l'indice du trou depart
	 * @return vrai si c'est le cas faux si non
	 */
	protected boolean siAdversaireEstNourri(int j, int i) {
		assert (plateau.indiceTrouEstCorrect(i) && (j >= 0 && j < NBJOUEURS));
		if (getNbGrainesJoueur((j + 1) % NBJOUEURS) == 0 && !partieFinie() && !plateau.peutSemerDeLautreC�t�(i))
			return false;
		return true;
	}

	/**
	 * Verifie si c'est un coup possible
	 * 
	 * @param i : l'indice du trou de d�part
	 * @param j : l'indice du joueur
	 * @return vrai si le coup est possible, faux sinon
	 */
	protected boolean estCoupPossible(int i, int j) {
		if (!plateau.indiceTrouEstCorrect(i)) {
			System.out.println("Donner un num�ro qui se trouve sur le plateau !!");
			return false;
		} else if (identit�Joueur(i) != j) {
			System.out.println("Donner un num�ro correspondant � votre rang�e !!");
			return false;
		} else if (plateau.estTrouVide(i)) {
			System.out.println("Ce trou est vide, jouer dans un autre !!");
			return false;
		} else if (!siAdversaireEstNourri(j, i)) {
			System.out.println("Faut nourir l'adversaire !!");
			return false;
		} else
			return true;
	}

	/**
	 * Permet au joueur de manger dans le camp adverse
	 * 
	 * @param indTrouDep     : l'indice du trou de depart
	 * @param indTrouArriv�e : l'indice du trou d'arriv�e
	 * @return le nombre de graines prises
	 */
	protected int manger(int indTrouDep, int indTrouArriv�e) {
		assert (plateau.indiceTrouEstCorrect(indTrouDep) && plateau.indiceTrouEstCorrect(indTrouArriv�e));
		int nbGrainesPrises = 0, i, derni�resGrainesPrises = 0;
		if (plateau.getRang�e(indTrouDep) != plateau.getRang�e(indTrouArriv�e)) {
			for (i = indTrouArriv�e; i >= 0 && plateau.getRang�e(i) == plateau.getRang�e(indTrouArriv�e); i--) {
				if (plateau.getNbGrainesTrou(i) == 2 || plateau.getNbGrainesTrou(i) == 3) {
					nbGrainesPrises += plateau.getNbGrainesTrou(i);
					derni�resGrainesPrises = plateau.getNbGrainesTrou(i);
					plateau.viderTrou(i);
				} else
					break;
			}
			if (getNbGrainesJoueur((identit�Joueur(indTrouDep) + 1) % NBJOUEURS) == 0) {
				plateau.setNbGrainesTrou(i + 1, derni�resGrainesPrises);
				nbGrainesPrises -= derni�resGrainesPrises;
			}
		}
		return nbGrainesPrises;
	}

	/**
	 * M�thode qui permet � un joueur de jouer
	 * 
	 * @param l'indice du trou dont le joueur commence � jouer
	 * @return le nombre de graines ramass�es
	 */
	protected int jouer(int indTrouDep) {

		assert (plateau.indiceTrouEstCorrect(indTrouDep) && !plateau.estTrouVide(indTrouDep));
		int nbGraines = plateau.getNbGrainesTrou(indTrouDep), i;
		plateau.viderTrou(indTrouDep);
		for (i = (indTrouDep + 1) % plateau.getNbTrous(); i < plateau.getNbTrous(); i = (i + 1)
				% plateau.getNbTrous()) {
			if (indTrouDep == i) // en cas de tour complet le trou de d�part n'est pas aliment�
				++i;
			plateau.ajouter(i);
			nbGraines--;
			if (nbGraines == 0)
				break;
		}
		return manger(indTrouDep, i);
	}

	/**
	 * Une m�thode pour avoir le score du joueur avec l'indice du joueur cette
	 * m�thode m'est utile pour les test unitaire
	 * 
	 * @param j indice du joueur
	 * @return le score du joueur
	 */
	public int getScoreJoueur(int j) {
		return joueurs[j].getScoreJoueur();
	}

	/**
	 * Affiche le plateau et le nombre de graines prises par chaque joueur
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("**********************---" + getNomVariant() + "---***************************\n\n");
		s.append(plateau.toString());
		s.append("\n\n" + joueurs[1].getNom() + " a " + joueurs[1].getScoreJoueur() + " bille(s)");
		s.append("\n\n" + joueurs[0].getNom() + " a " + joueurs[0].getScoreJoueur() + " bille(s)");

		return s.toString();
	}

	@Override
	/**
	 * Pour choisir le joueur qui commmence
	 */
	public void choisirJoueurQuiCommence() {
		// TODO Auto-generated method stub
		int choix;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Choisissez le joueur qui commence : " + "\nTapez le num�ro correspondand :"
					+ "\n-1- Joueur 1 (SUD) " + "\n-2- Joueur 2 (NORD)\n-0- Pour laisser l'ordinateur choisir");

			choix = sc.nextInt();
		} while (choix != 1 && choix != 2 && choix != 0);
		if (choix == 1)
			indJoueur = 0;
		else if (choix == 2)
			indJoueur = 1;
		else {
			Random r = new Random();
			indJoueur = r.nextInt(getNbJoueurs());
		}
	}

	/**
	 * Pour faire jouer un joueur tout en respectant les r�gles du jeu
	 */
	@Override
	public void faireJouer() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int cellule, nbGramass�s;
		do {
			System.out.println(this);
			System.out.println(
					"\nA " + joueurs[indJoueur].getNom() + " de jouer: (Taper 0 si vous voulez arr�ter la partie)");
			cellule = sc.nextInt() - 1;
			if (cellule == -1) {
				quitter = true;
				return;
			}

		} while (!estCoupPossible(cellule, indJoueur));
		nbGramass�s = jouer(cellule);
		joueurs[indJoueur].addScore(nbGramass�s);
		System.out.println(joueurs[indJoueur].getNom() + " a ramass� " + nbGramass�s + " bille(s)\n");
		joueurSuivant();
	}

	/**
	 * Elle permet de passer le tour au joueur suivant
	 */
	protected void joueurSuivant() {
		indJoueur = (indJoueur + 1) % NBJOUEURS;
	}

	@Override
	/**
	 * renvoie l'indice du joueur gagnant si y'a un gagnant ou -1 sinon
	 */
	public int getGagnant() {
		// TODO Auto-generated method stub

		if (joueurs[0].getScoreJoueur() < joueurs[1].getScoreJoueur())
			indJoueur = 1;
		else if (joueurs[0].getScoreJoueur() > joueurs[1].getScoreJoueur())
			indJoueur = 0;
		else
			return -1;
		return indJoueur;

	}

	/**
	 * chaque joueur prends les graines qui se trouve sur sa partie
	 */
	protected void repartitionDesGraines() {
		joueurs[0].addScore(getNbGrainesJoueur(0));
		joueurs[1].addScore(getNbGrainesJoueur(1));

	}

	@Override
	/**
	 * affiche si y'a un gagnant, le gagnant sinon matche nul
	 */
	public void resultatDeLaPartie() {
		// TODO Auto-generated method stub
		System.out.println(this);
		if (getGagnant() == -1)
			System.out.println("\nMatch nul !!!!!!!!");
		else {
			System.out.println(
					joueurs[getGagnant()].getNom() + " gagne la partie " + getNomVariant() + ", felicitations !!!!!!");
		}
	}
}
