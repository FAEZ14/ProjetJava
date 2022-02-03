package jeu;

import VariantesAwalé.*;

public class FabriqueVarianteAwalé {
	/**
	 * Une fabrique de variante avec en parametre un numéro qui correspond à la variante choisie 
	 * 1 pour la variante de base l'awéle
	 * 2 pour le Tamtam-Apachi
	 * 3 pour pour le wali
	 * 4 pour l'owani
	 * sinon la variante de base
	 * @param num le numéro de la variante choisie
	 * @return la variante choisie
	 */
	public static Jeu getVarianteAwalé(int num) {
		if (num == 1)
			return new Awalé();
		else if (num == 2)
			return new TamtamApachi();
		else if (num == 3)
			return new Wali();
		else if (num == 4)
			return new Owani();
		else if(num==5)
			return new Chongkak();
		return new Awalé(); 
	}

}
