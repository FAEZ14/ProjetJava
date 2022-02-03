package joueur;

public class Joueur {

	private int scoreJoueur;
	private String nom;
	/**
	 * Constructeur pour cr�er un joueur avec en parametre le nom du joueur 
	 * et son score initialement � 0
	 * @param nom : le nom de joueur
	 */
	public Joueur(String nom) {
		this.nom = nom;
		scoreJoueur = 0;

	}
	/**
	 * un geteur  qui renvoie le nom
	 * @return le nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * un geteur qui renvoie le score du joueur
	 * @return le score du joueur
	 */
	public int getScoreJoueur() {
		return scoreJoueur;
	}
	/**
	 * Une m�thode pour ajouter le score avec le score � ajouter en parametre
	 * @param s le nouveau score du joueur
	 */
	public void addScore(int s) {
		scoreJoueur += s;
	}
	/**
	 * pour initialiser le score � 0
	 */
	public void initialisterScore() {
		scoreJoueur = 0;
	}

}
