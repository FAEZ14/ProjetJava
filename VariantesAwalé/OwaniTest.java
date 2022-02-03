package VariantesAwalé;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OwaniTest {

	@Test
	void testInitialisationOwani() {
		Owani tab[] = new Owani[1000];

		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Owani();
			assertEquals(0, tab[i].getScoreJoueur(0));
			assertEquals(0, tab[i].getScoreJoueur(1));
			for (int j = 0; j < tab[i].getPlateau().getNbTrous(); j++)
				assertEquals(4, tab[i].getPlateau().getNbGrainesTrou(j));

		}
	}
	@Test
	void testJouer() {
		Owani owani = new Owani();
		owani.jouer(0);
		assertTrue(owani.getPlateau().estTrouVide(0));
		assertTrue(owani.getPlateau().estTrouVide(4));
		for(int i=1;i<=3;i++)
			assertEquals(5, owani.getPlateau().getNbGrainesTrou(i));
		for(int i=5;i<=8;i++)
			assertEquals(5, owani.getPlateau().getNbGrainesTrou(i));
		
			
		
		
	}
	@Test
	void testPartieFinie() {
		Owani owani = new Owani();
		assertFalse(owani.partieFinie());
		for (int i = 0; i < owani.getPlateau().getNbTrous() / 2; i++)
			owani.getPlateau().viderTrou(i);
		assertTrue(owani.partieFinie());
	}

}
