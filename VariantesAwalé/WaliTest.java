package VariantesAwalé;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WaliTest {

	@Test
	void testInitialisationWali() {
		Wali tab[] = new Wali[1000];

		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Wali();
			assertEquals(0, tab[i].getScoreJoueur(0));
			assertEquals(0, tab[i].getScoreJoueur(1));
			for (int j = 0; j < tab[i].getPlateau().getNbTrous(); j++)
				assertEquals(4, tab[i].getPlateau().getNbGrainesTrou(j));

		}
	}

	@Test
	void testJouer() {
		Wali wali = new Wali();
		assertEquals(0, wali.jouer(0)); // On a pris aucune graines car en debut de partie c'est impossible
		assertTrue(wali.getPlateau().estTrouVide(0)); // le trou de départ est vide
		for (int i = 1; i <= 4; i++)
			assertEquals(5, wali.getPlateau().getNbGrainesTrou(i));
		assertEquals(0, wali.jouer(10)); // On a jouer en commancant au trou 10

		assertEquals(1, wali.getPlateau().getNbGrainesTrou(0)); // on remarque qu'il fait le tour et alimenter le trou
																// 0 qui n'avait aucune graines
		assertEquals(2, wali.jouer(8)); // la on voit qu'il a manger car le trou contenait une graine
	}

	@Test
	void testPartieFinie() {
		Wali wali = new Wali();
		assertFalse(wali.partieFinie());
		for (int i = 0; i < wali.getPlateau().getNbTrous() / 2; i++)
			wali.getPlateau().viderTrou(i);
		assertTrue(wali.partieFinie());
	}

}
