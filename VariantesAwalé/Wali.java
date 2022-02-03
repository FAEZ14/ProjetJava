package VariantesAwalé;

public class Wali extends Awalé {

	/**
	 * Un constructeur qui n'a rien de différent de l'awalé
	 */
	public Wali() {
		super();
	}

	/**
	 * Spécialisation de la méthode manger selon les régles du Wali
	 */
	protected int manger(int indTrouDep, int indTrouArrivée) {
		assert (getPlateau().indiceTrouEstCorrect(indTrouDep) && getPlateau().indiceTrouEstCorrect(indTrouArrivée));
		int nbGrainesPrises = 0, i;
		if (getPlateau().getRangée(indTrouDep) != getPlateau().getRangée(indTrouArrivée)) {
			for (i = indTrouArrivée; i >= 0
					&& (getPlateau().getRangée(i) == getPlateau().getRangée(indTrouArrivée)); i--) {
				if (getPlateau().getNbGrainesTrou(i) == 2 || getPlateau().getNbGrainesTrou(i) == 3) {
					nbGrainesPrises += getPlateau().getNbGrainesTrou(i);
					getPlateau().viderTrou(i);
				} else
					break;
			}
		}
		return nbGrainesPrises;
	}

	/**
	 * Spécialisation de la manière de jouer selon les régles du Wali
	 */
	public int jouer(int indTrouDep) {

		assert (getPlateau().indiceTrouEstCorrect(indTrouDep));
		int nbGraines = getPlateau().getNbGrainesTrou(indTrouDep), i;
		getPlateau().viderTrou(indTrouDep);
		for (i = (indTrouDep + 1) % getPlateau().getNbTrous(); i < getPlateau().getNbTrous() &&

				nbGraines != 0; i = (i + 1) % getPlateau().getNbTrous()) {

			getPlateau().ajouter(i);
			nbGraines--;
			if (nbGraines == 0)
				break;
		}
		return manger(indTrouDep, i);
	}

	/**
	 * Renvoie le nom de la variante
	 */
	public String getNomVariant() {
		return "Wali";
	}

	/**
	 * Une méthode qui qui renvoie toujours vrai car la régle de toujours nourir
	 * l'adversaire n'est pas obligatoire
	 */
	public boolean siAdversaireEstNourri(int j, int i) {
		return true;
	}

	/**
	 * Méthode qui vérifie la fin de partie si un joueur n'a plus de graines c'est à
	 * dire il pourra plus jouer donc la partie est finie
	 */
	public boolean partieFinie() {
		if (getNbGrainesJoueur(0) == 0 || getNbGrainesJoueur(1) == 0)
			return true;
		return false;
	}
}
