package VariantesAwal�;

public class TamtamApachi extends Awal� {

	public TamtamApachi() {
		super();
	}
	/**
	 * un constructeur destin� � la variante Chongkak qui a les m�mes r�gles que le tamtam-apachi
	 * mais avec plus de graines et de trous
	 * utilisation du deuxi�me constructeu de l'awal� avec le nombre de graines et de trous pass�s en parametre
	 * @param nbGraines le nombraines total sur le plateau initialement
	 * @param nbTrous : le nombre de trous du plateau
	 */
	protected TamtamApachi(int nbGraines, int nbTrous) {
		super(nbGraines, nbTrous);
	}

	/**
	 * Sp�cialisation de la m�thode manger selon les r�gles de cette variante
	 */
	protected int manger(int ci, int cf) {
		assert (getPlateau().indiceTrouEstCorrect(ci) && getPlateau().indiceTrouEstCorrect(cf));
		int nbGrainesPrises = 0;
		if (getPlateau().getRang�e(ci) == getPlateau().getRang�e(cf)) {
			if (getPlateau().getNbGrainesTrou(cf) == 1) {
				nbGrainesPrises = getPlateau().getNbGrainesTrou((getPlateau().getNbTrous() - 1 - cf));
				getPlateau().viderTrou((getPlateau().getNbTrous() - 1 - cf));
				return nbGrainesPrises;
			}
		}
		return nbGrainesPrises;
	}

	/**
	 * Sp�cialisation de la m�thode jouer selon les r�gles de cette variante
	 */
	public int jouer(int indTrouDep) {

		assert (getPlateau().indiceTrouEstCorrect(indTrouDep) && !getPlateau().estTrouVide(indTrouDep));
		int nbGraines = getPlateau().getNbGrainesTrou(indTrouDep), i;
		getPlateau().viderTrou(indTrouDep);
		for (i = (indTrouDep + 1) % getPlateau().getNbTrous(); i < getPlateau().getNbTrous(); i = (i + 1)
				% getPlateau().getNbTrous()) {
			getPlateau().ajouter(i);
			nbGraines--;
			if (nbGraines == 0) {
				if (getPlateau().getNbGrainesTrou(i) >= 2) {
					nbGraines = getPlateau().getNbGrainesTrou(i);
					getPlateau().viderTrou(i);
				} else
					break;
			}
		}
		return manger(indTrouDep, i);
	}

	/**
	 * specialisation de la m�thode getNomVariant pour sp�cifier le nom du variant
	 */
	public String getNomVariant() {
		return "Tamtam-Appachi";
	}

	/**
	 * Il est pas n�cessaire de toujour nourir l'adversaire
	 */
	public boolean siAdversaireEstNourri(int j, int i) {
		return true;
	}

	/**
	 * la partie est finie si y'a un joueur qui n'a aucune graines sur sa rang�e
	 */
	public boolean partieFinie() {
		if (getNbGrainesJoueur(0) == 0 || getNbGrainesJoueur(1) == 0)
			return true;
		return false;
	}

}
