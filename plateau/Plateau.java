package plateau;

public class Plateau {

	private enum C�t�sPlateau {
		SUD, NORD
	};

	private int plateau[];
	private String nomC�t�1, nomC�t�2;
	private int nbGraines, nbTrous;

	/**
	 * Constructeur du plateau en parametres le nombre de graines et de trous du
	 * plateau
	 * 
	 * @param nbGraines : le nombre de graines qui sera repartie de fa�on equitable
	 * @param nbTrous   : le nombre de trous du tableau
	 */
	public Plateau(int nbGraines, int nbTrous) {
		assert (nbTrous > 0 && nbGraines >= nbTrous && nbGraines % nbTrous == 0);
		this.nbGraines = nbGraines;
		this.nbTrous = nbTrous;
		plateau = new int[nbTrous];
		nomC�t�2 = C�t�sPlateau.NORD.name();
		nomC�t�1 = C�t�sPlateau.SUD.name();
		initialiserPlateau();
	}

	/**
	 * M�thode pour initialiser le plateau en mettant le nombre de graines qu'il
	 * faut dans chaque trou
	 */
	public void initialiserPlateau() {
		int nbGrainesTrous = nbGraines / nbTrous;
		for (int i = 0; i < nbTrous; i++)
			plateau[i] = nbGrainesTrous;
	}

	/**
	 * M�thode qui permet d'ajouter une graine dans un trou dont l'indice est pass�
	 * est pass� en param�tre
	 * 
	 * @param i : l'indice du trou
	 */
	public void ajouter(int i) {
		assert (indiceTrouEstCorrect(i));
		plateau[i]++;
	}

	/**
	 * M�thode qui permet d'obtenir le nombre de graines dans trou avec l'indice du
	 * trou pass� en param�tre
	 * 
	 * @param i : l'indice du trou
	 * @return : le nombre de graines
	 */
	public int getNbGrainesTrou(int i) {
		return plateau[i];
	}

	/**
	 * M�thode qui permet de vider un trou
	 * 
	 * @param i : indice du trou
	 */
	public void viderTrou(int i) {
		assert (indiceTrouEstCorrect(i));
		plateau[i] = 0;
	}

	/**
	 * V�rifie si un trou un vide ou pas
	 * 
	 * @param i : indice du trou
	 * @return vrai si le trou est vide faux si non
	 */
	public boolean estTrouVide(int i) {
		assert (indiceTrouEstCorrect(i));
		return plateau[i] == 0;
	}

	/**
	 * Une m�thode que en fonction de l'indice pass� en param�tre il renvoie 0 si
	 * c'est la p�mi�re rang�e ( SUD ) et 1 si c'est la deuxi�me rang�e (NORD)
	 * 
	 * @param i l'indice du trou
	 * @return 0 ou 1 en fonction de l'indice
	 */
	public int getRang�e(int i) {
		assert (indiceTrouEstCorrect(i));
		if (i >= 0 && i < nbTrous / 2)
			return 0;
		return 1;

	}

	public void setNbGrainesTrou(int i, int graines) {
		plateau[i] = graines;
	}

	/**
	 * V�rifie si un trou a assez de graines pour s�mer dans l'autre rang�e
	 * 
	 * @param i : L'indice du trou
	 * @return vrai si c'est le cas faux sinon
	 */
	public boolean peutSemerDeLautreC�t�(int i) {
		assert (indiceTrouEstCorrect(i));
		int n = (plateau[i] + i) % nbTrous;
		if (getRang�e(i) != getRang�e(n))
			return true;
		return false;
	}

	/**
	 * V�rifie si l'indice du trou est correcte
	 * 
	 * @param i : indice trou
	 * @return vrai si c'est le cas, faux si non
	 */
	public boolean indiceTrouEstCorrect(int i) {
		return (i >= 0 && i < nbTrous);
	}

	/**
	 * Obtenir le nombre total de graines se trouvant d'un trou jusqu'� un autre
	 * 
	 * @param indd l'indice du trou de depart
	 * @param indf : l'indice du trou d'arriv��
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
		s.append(nomC�t�2 + " :");
		for (int i = nbTrous; i > n; i--)
			s.append("\t  " + i);
		s.append("\n\n\t");
		for (int i = nbTrous - 1; i >= n; i--)
			s.append("[ " + plateau[i] + " ]\t");
		s.append("\n\n\t");
		for (int i = 0; i < n; i++)
			s.append("[ " + plateau[i] + " ]\t");
		s.append("\n\n" + nomC�t�1 + " :");
		for (int i = 1; i < n + 1; i++)
			s.append("\t  " + i);
		return s.toString();
	}

	/**
	 * Renvoie le nom du C�t�1 qui est Nord
	 * 
	 * @return Nord
	 */
	public String getNomC�t�1() {
		return nomC�t�1;
	}

	/**
	 * Renvoie le nom du c�t�2 qui est Sud
	 * 
	 * @return Sud
	 */
	public String getNomC�t�2() {
		return nomC�t�2;
	}

}
