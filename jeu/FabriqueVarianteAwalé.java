package jeu;

import VariantesAwal�.*;

public class FabriqueVarianteAwal� {
	/**
	 * Une fabrique de variante avec en parametre un num�ro qui correspond � la variante choisie 
	 * 1 pour la variante de base l'aw�le
	 * 2 pour le Tamtam-Apachi
	 * 3 pour pour le wali
	 * 4 pour l'owani
	 * sinon la variante de base
	 * @param num le num�ro de la variante choisie
	 * @return la variante choisie
	 */
	public static Jeu getVarianteAwal�(int num) {
		if (num == 1)
			return new Awal�();
		else if (num == 2)
			return new TamtamApachi();
		else if (num == 3)
			return new Wali();
		else if (num == 4)
			return new Owani();
		else if(num==5)
			return new Chongkak();
		return new Awal�(); 
	}

}
