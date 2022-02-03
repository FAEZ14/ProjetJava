package VariantesAwal�;

public class Owani extends Awal� {

	public Owani() {
		super();
	}

	/**
	 * Sp�cialisation de la m�thode manger selon les r�gles de cette variante
	 */
	protected int manger(int ci, int cf) {
		assert (getPlateau().indiceTrouEstCorrect(ci) && getPlateau().indiceTrouEstCorrect(cf));
		int nbGrainesPrises = 0;
		if (getPlateau().getRang�e(ci) != getPlateau().getRang�e(cf)) {
			if (getPlateau().getNbGrainesTrou(cf) == 2 || getPlateau().getNbGrainesTrou(cf) == 3) {
				nbGrainesPrises = getPlateau().getNbGrainesTrou(cf);
				getPlateau().viderTrou(cf);
			} else
				return nbGrainesPrises;
		}
		return nbGrainesPrises;
	}

	/**
	 * Sp�cialisation de la m�thode jouer avec les r�gles du jeu
	 */
	public int jouer(int indTrouDep) {

		assert (getPlateau().indiceTrouEstCorrect(indTrouDep) && !getPlateau().estTrouVide(indTrouDep));
		int nbGraines = getPlateau().getNbGrainesTrou(indTrouDep), i, j = indTrouDep;
		getPlateau().viderTrou(indTrouDep);
		for (i = (indTrouDep + 1) % getPlateau().getNbTrous(); i < getPlateau().getNbTrous()
				&& nbGraines != 0; i = (i + 1) % getPlateau().getNbTrous()) {
			if (i == j) { 
				getPlateau().ajouter(i); 
				nbGraines--;
				if (nbGraines == 0) 
					break;
				i = (i < getPlateau().getNbTrous() % 2) ? getPlateau().getNbTrous() % 2 : 0;
			}
			getPlateau().ajouter(i);
			nbGraines--;
			if (nbGraines == 0) {
				if (getPlateau().getNbGrainesTrou(i) >= 2
						&& getPlateau().getRang�e(i) == getPlateau().getRang�e(indTrouDep)) {
					nbGraines = getPlateau().getNbGrainesTrou(i);
					getPlateau().viderTrou(i);
					j = i; // actualise l'indice de d�part
				} else
					break;
			}
		}
		return manger(indTrouDep, i);
	}

	/**
	 * specialisation de la m�thode getNomVariant pour sp�cifier le nom de la
	 * variante
	 */
	public String getNomVariant() {
		return "Owani";
	}

	/**
	 * Avec cette variante on est pas oblig� de nourir l'adversaire
	 */
	public boolean siAdversaireEstNourri(int j, int i) {
		return true;
	}

	/**
	 * Si y'a un joueur qui n'a pas pas de graines sur sa rang�e alors la partie est
	 * finie
	 */
	public boolean partieFinie() {
		if (getNbGrainesJoueur(0) == 0 || getNbGrainesJoueur(1) == 0)
			return true;
		return false;
	}
}
