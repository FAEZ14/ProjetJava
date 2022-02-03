package VariantesAwal�;

public class Wali extends Awal� {

	/**
	 * Un constructeur qui n'a rien de diff�rent de l'awal�
	 */
	public Wali() {
		super();
	}

	/**
	 * Sp�cialisation de la m�thode manger selon les r�gles du Wali
	 */
	protected int manger(int indTrouDep, int indTrouArriv�e) {
		assert (getPlateau().indiceTrouEstCorrect(indTrouDep) && getPlateau().indiceTrouEstCorrect(indTrouArriv�e));
		int nbGrainesPrises = 0, i;
		if (getPlateau().getRang�e(indTrouDep) != getPlateau().getRang�e(indTrouArriv�e)) {
			for (i = indTrouArriv�e; i >= 0
					&& (getPlateau().getRang�e(i) == getPlateau().getRang�e(indTrouArriv�e)); i--) {
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
	 * Sp�cialisation de la mani�re de jouer selon les r�gles du Wali
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
	 * Une m�thode qui qui renvoie toujours vrai car la r�gle de toujours nourir
	 * l'adversaire n'est pas obligatoire
	 */
	public boolean siAdversaireEstNourri(int j, int i) {
		return true;
	}

	/**
	 * M�thode qui v�rifie la fin de partie si un joueur n'a plus de graines c'est �
	 * dire il pourra plus jouer donc la partie est finie
	 */
	public boolean partieFinie() {
		if (getNbGrainesJoueur(0) == 0 || getNbGrainesJoueur(1) == 0)
			return true;
		return false;
	}
}
