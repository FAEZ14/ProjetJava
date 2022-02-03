package VariantesAwalé;

public class TamtamApachi extends Awalé {

	public TamtamApachi() {
		super();
	}
	/**
	 * un constructeur destiné à la variante Chongkak qui a les mêmes régles que le tamtam-apachi
	 * mais avec plus de graines et de trous
	 * utilisation du deuxième constructeu de l'awalé avec le nombre de graines et de trous passés en parametre
	 * @param nbGraines le nombraines total sur le plateau initialement
	 * @param nbTrous : le nombre de trous du plateau
	 */
	protected TamtamApachi(int nbGraines, int nbTrous) {
		super(nbGraines, nbTrous);
	}

	/**
	 * Spécialisation de la méthode manger selon les règles de cette variante
	 */
	protected int manger(int ci, int cf) {
		assert (getPlateau().indiceTrouEstCorrect(ci) && getPlateau().indiceTrouEstCorrect(cf));
		int nbGrainesPrises = 0;
		if (getPlateau().getRangée(ci) == getPlateau().getRangée(cf)) {
			if (getPlateau().getNbGrainesTrou(cf) == 1) {
				nbGrainesPrises = getPlateau().getNbGrainesTrou((getPlateau().getNbTrous() - 1 - cf));
				getPlateau().viderTrou((getPlateau().getNbTrous() - 1 - cf));
				return nbGrainesPrises;
			}
		}
		return nbGrainesPrises;
	}

	/**
	 * Spécialisation de la méthode jouer selon les règles de cette variante
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
	 * specialisation de la méthode getNomVariant pour spécifier le nom du variant
	 */
	public String getNomVariant() {
		return "Tamtam-Appachi";
	}

	/**
	 * Il est pas nécessaire de toujour nourir l'adversaire
	 */
	public boolean siAdversaireEstNourri(int j, int i) {
		return true;
	}

	/**
	 * la partie est finie si y'a un joueur qui n'a aucune graines sur sa rangée
	 */
	public boolean partieFinie() {
		if (getNbGrainesJoueur(0) == 0 || getNbGrainesJoueur(1) == 0)
			return true;
		return false;
	}

}
