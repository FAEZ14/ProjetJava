package AppliAwal�;

import java.util.Scanner;

import jeu.FabriqueVarianteAwal�;
import jeu.Jeu;

public class Appli {
	public static void jouerUnePartie(Jeu jeu) {
		jeu.choisirJoueurQuiCommence();
		jeu.initialiser();
		while (true) {
			jeu.faireJouer();
			if (jeu.partieFinie() || jeu.partieQuitt�e())
				break;
		}
		jeu.resultatDeLaPartie();

	}

	public static int choisirVarianteAwal�() {
		// TODO Auto-generated method stub
		int choix;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"Choisissez la variante d'awal� que vous voulez jouer :" + "\nTaper le num�ro correspondant :"
							+ "\n-1- Aw�l�  " + "\n-2- Tamtam-Appachi" + "\n-3- Wali" + "\n-4- Owani"
									+ "\n-5- Chongkak");
			choix = sc.nextInt();
		} while (choix != 1 && choix != 2 && choix != 3 && choix != 4&&choix!=5);
		return choix;
	}

	public static void main(String[] args) {

		int choix;
		choix = choisirVarianteAwal�();
		new FabriqueVarianteAwal�();
		Jeu j = FabriqueVarianteAwal�.getVarianteAwal�(choix);
		jouerUnePartie(j);

	}
}
