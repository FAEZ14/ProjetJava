package joueur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JoueurTest {

	@Test
	void testJoueur() {
		Joueur joueur = new Joueur("FAEZ");
		assertEquals("FAEZ", joueur.getNom());
		assertEquals(0, joueur.getScoreJoueur());
		joueur.addScore(100);
		assertEquals(100, joueur.getScoreJoueur());
		joueur.initialisterScore();
		assertEquals(0, joueur.getScoreJoueur());

	}

}
