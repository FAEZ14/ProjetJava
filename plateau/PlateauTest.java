package plateau;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlateauTest {

	@Test
	void testPlateau() {
		Plateau[] plateaux = new Plateau[100];
		for (int i = 0; i < plateaux.length; i++) {
			plateaux[i] = new Plateau(1000, 100);
			for (int j = 0; j < 100; j++)
				assertEquals(10, plateaux[i].getNbGrainesTrou(i));
		}
	}

	@Test
	void testViderTrou_etTrouVide() {
		Plateau plateau = new Plateau(48, 12);
		for (int i = 0; i < 12; i++)
			plateau.viderTrou(i);
		for (int i = 0; i < 12; i++)
			assertTrue(plateau.estTrouVide(i));

	}

	@Test
	void testPeutSemerDelautreCôté() {
		Plateau plateau = new Plateau(48, 12);
		assertTrue(plateau.peutSemerDeLautreCôté(5));
		assertTrue(plateau.peutSemerDeLautreCôté(11));
		assertFalse(plateau.peutSemerDeLautreCôté(0));
		assertFalse(plateau.peutSemerDeLautreCôté(6));
	}

	@Test
	void testAjouter() {
		Plateau plateau = new Plateau(48, 12);
		for (int i = 0; i < 12; i++) {
			assertEquals(4, plateau.getNbGrainesTrou(i));
			plateau.ajouter(i);
		}
		for (int i = 0; i < 12; i++)
			assertEquals(5, plateau.getNbGrainesTrou(i));

	}

}
