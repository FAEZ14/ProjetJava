package plateau;

public class Plateau {

	private enum CôtésPlateau {
		SUD, NORD
	};

	private int plateau[];
	private String nomCôté1, nomCôté2;
	private int nbGraines, nbTrous;

	/**
	 * Constructeur du plateau en parametres le nombre de graines et de trous du
	 * plateau
	 * 
	 * @param nbGraines : le nombre de graines qui sera repartie de façon equitable
	 * @param nbTrous   : le nombre de trous du tableau
	 */
	public Plateau(int nbGraines, int nbTrous) {
		assert (nbTrous > 0 && nbGraines >= nbTrous && nbGraines % nbTrous == 0);
		this.nbGraines = nbGraines;
		this.nbTrous = nbTrous;
		plateau = new int[nbTrous];
		nomCôté2 = CôtésPlateau.NORD.name();
		nomCôté1 = CôtésPlateau.SUD.name();
		initialiserPlateau();
	}

	/**
	 * Méthode pour initialiser le plateau en mettant le nombre de graines qu'il
	 * faut dans chaque trou
	 */
	public void initialiserPlateau() {
		int nbGrainesTrous = nbGraines / nbTrous;
		for (int i = 0; i < nbTrous; i++)
			plateau[i] = nbGrainesTrous;
	}

	/**
	 * Méthode qui permet d'ajouter une graine dans un trou dont l'indice est passé
	 * est passé en paramètre
	 * 
	 * @param i : l'indice du trou
	 */
	public void ajouter(int i) {
		assert (indiceTrouEstCorrect(i));
		plateau[i]++;
	}

	/**
	 * Méthode qui permet d'obtenir le nombre de graines dans trou avec l'indice du
	 * trou passé en paramètre
	 * 
	 * @param i : l'indice du trou
	 * @return : le nombre de graines
	 */
	public int getNbGrainesTrou(int i) {
		return plateau[i];
	}

	/**
	 * Méthode qui permet de vider un trou
	 * 
	 * @param i : indice du trou
	 */
	public void viderTrou(int i) {
		assert (indiceTrouEstCorrect(i));
		plateau[i] = 0;
	}

	/**
	 * Vérifie si un trou un vide ou pas
	 * 
	 * @param i : indice du trou
	 * @return vrai si le trou est vide faux si non
	 */
	public boolean estTrouVide(int i) {
		assert (indiceTrouEstCorrect(i));
		return plateau[i] == 0;
	}

	/**
	 * Une méthode que en fonction de l'indice passé en paramétre il renvoie 0 si
	 * c'est la pémière rangée ( SUD ) et 1 si c'est la deuxième rangée (NORD)
	 * 
	 * @param i l'indice du trou
	 * @return 0 ou 1 en fonction de l'indice
	 */
	public int getRangée(int i) {
		assert (indiceTrouEstCorrect(i));
		if (i >= 0 && i < nbTrous / 2)
			return 0;
		return 1;

	}

	public void setNbGrainesTrou(int i, int graines) {
		plateau[i] = graines;
	}

	/**
	 * Vérifie si un trou a assez de graines pour sèmer dans l'autre rangée
	 * 
	 * @param i : L'indice du trou
	 * @return vrai si c'est le cas faux sinon
	 */
	public boolean peutSemerDeLautreCôté(int i) {
		assert (indiceTrouEstCorrect(i));
		int n = (plateau[i] + i) % nbTrous;
		if (getRangée(i) != getRangée(n))
			return true;
		return false;
	}

	/**
	 * Vérifie si l'indice du trou est correcte
	 * 
	 * @param i : indice trou
	 * @return vrai si c'est le cas, faux si non
	 */
	public boolean indiceTrouEstCorrect(int i) {
		return (i >= 0 && i < nbTrous);
	}

	/**
	 * Obtenir le nombre total de graines se trouvant d'un trou jusqu'à un autre
	 * 
	 * @param indd l'indice du trou de depart
	 * @param indf : l'indice du trou d'arrivéé
	 * @return le nombre de graines totale
	 */
	public int getNbGrainePlateau(int indd, int indf) {
		assert (0 <= indd && indd < indf && indf <= nbTrous);
		int nbTotalGraines = 0;
		for (int i = indd; i < indf; i++)
			nbTotalGraines += plateau[i];
		return nbTotalGraines;
	}

	/**
	 * Renvoie le nombre de graines initialement sur le plateau
	 * 
	 * @return le nombre de graines de base
	 */
	public int getNbGraines() {
		return nbGraines;
	}

	/**
	 * Renvoie le nombre de trou
	 * 
	 * @return le nombre du trou du plateau
	 */
	public int getNbTrous() {
		return nbTrous;
	}

	/**
	 * Affiche le plateau et le nombre de graines prises par chaque joueur
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		int n = (nbTrous / 2);
		s.append(nomCôté2 + " :");
		for (int i = nbTrous; i > n; i--)
			s.append("\t  " + i);
		s.append("\n\n\t");
		for (int i = nbTrous - 1; i >= n; i--)
			s.append("[ " + plateau[i] + " ]\t");
		s.append("\n\n\t");
		for (int i = 0; i < n; i++)
			s.append("[ " + plateau[i] + " ]\t");
		s.append("\n\n" + nomCôté1 + " :");
		for (int i = 1; i < n + 1; i++)
			s.append("\t  " + i);
		return s.toString();
	}

	/**
	 * Renvoie le nom du Côté1 qui est Nord
	 * 
	 * @return Nord
	 */
	public String getNomCôté1() {
		return nomCôté1;
	}

	/**
	 * Renvoie le nom du côté2 qui est Sud
	 * 
	 * @return Sud
	 */
	public String getNomCôté2() {
		return nomCôté2;
	}

}
