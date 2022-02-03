package AppliAwalé;

import java.util.Scanner;

import jeu.FabriqueVarianteAwalé;
import jeu.Jeu;

public class Appli {
	public static void jouerUnePartie(Jeu jeu) {
		jeu.choisirJoueurQuiCommence();
		jeu.initialiser();
		while (true) {
			jeu.faireJouer();
			if (jeu.partieFinie() || jeu.partieQuittée())
				break;
		}
		jeu.resultatDeLaPartie();

	}

	public static int choisirVarianteAwalé() {
		// TODO Auto-generated method stub
		int choix;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"Choisissez la variante d'awalé que vous voulez jouer :" + "\nTaper le numéro correspondant :"
							+ "\n-1- Awélé  " + "\n-2- Tamtam-Appachi" + "\n-3- Wali" + "\n-4- Owani"
									+ "\n-5- Chongkak");
			choix = sc.nextInt();
		} while (choix != 1 && choix != 2 && choix != 3 && choix != 4&&choix!=5);
		return choix;
	}

	public static void main(String[] args) {

		int choix;
		choix = choisirVarianteAwalé();
		new FabriqueVarianteAwalé();
		Jeu j = FabriqueVarianteAwalé.getVarianteAwalé(choix);
		jouerUnePartie(j);

	}
}
