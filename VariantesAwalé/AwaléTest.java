package VariantesAwalé;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AwaléTest {

	
	@Test
	void testInitialisationAwalé() {
		Awalé tab []=new Awalé[1000];
		
		for(int i=0;i<tab.length;i++) {
			tab[i]=new Awalé();
			assertEquals(0,tab[i].getScoreJoueur(0));
			assertEquals(0,tab[i].getScoreJoueur(1));
		for(int j=0;j<tab[i].getPlateau().getNbTrous();j++ ) {
			assertEquals(4,tab[i].getPlateau().getNbGrainesTrou(j));
			
		}
		
		}
	}
	@Test
	void testManger() {
		Awalé awalé=new Awalé();
		for(int i=awalé.getPlateau().getNbTrous()/2;i<awalé.getPlateau().getNbTrous();i++)
			awalé.getPlateau().setNbGrainesTrou(i, 2);
		int grainesPrises;
		for(int i=awalé.getPlateau().getNbTrous()/2;i<awalé.getPlateau().getNbTrous();i++) 
			assertEquals(2,awalé.getPlateau().getNbGrainesTrou(i));
		grainesPrises=awalé.manger(0, 11); // prises des graines de la rangée à par le dernier trou car on peut pas vider toute la rangée adverse
		for(int i=awalé.getPlateau().getNbTrous()/2+1;i<awalé.getPlateau().getNbTrous();i++)
			assertTrue(awalé.getPlateau().estTrouVide(i));
		assertEquals(2,awalé.getPlateau().getNbGrainesTrou(awalé.getPlateau().getNbTrous()/2));
		assertEquals(10,grainesPrises);
		
		
		
	}
	
	@Test
	void testNbGrainesJoueur() {
		Awalé awalé=new Awalé();
		for(int j=0;j<awalé.getNbJoueurs();j++)
			assertEquals(24,awalé.getNbGrainesJoueur(j));
		
	}
	@Test
	void testIdentitéJoueur() {
		Awalé awalé=new Awalé();
		for(int i=0;i<awalé.getPlateau().getNbTrous()/2;i++)
			assertEquals(0,awalé.identitéJoueur(i));
		for(int i=awalé.getPlateau().getNbTrous()/2;i<awalé.getPlateau().getNbTrous();i++)
			assertEquals(1,awalé.identitéJoueur(i));
	}
	@Test
	void testPartieFinie() {
		Awalé awalé=new Awalé();
		assertFalse(awalé.partieFinie());
		for(int i=2;i<awalé.getPlateau().getNbTrous();i++)
			awalé.getPlateau().viderTrou(i);
		assertTrue(awalé.partieFinie()); 
	}
	@Test
	void testEstCoupPossible() {
		Awalé awalé=new Awalé();
		int joueur=0,cellule=0;
		assertTrue(awalé.estCoupPossible(cellule, joueur));
		assertFalse(awalé.estCoupPossible(cellule+8, joueur));
		assertFalse(awalé.estCoupPossible(cellule+13, joueur));
		assertFalse(awalé.estCoupPossible(cellule, joueur+1));
		assertTrue(awalé.estCoupPossible(cellule+7, joueur+1));
		for(int i=awalé.getPlateau().getNbTrous()/2;i<awalé.getPlateau().getNbTrous();i++)
			awalé.getPlateau().viderTrou(i);
		assertTrue(awalé.getNbGrainesJoueur(1)==0);
		assertFalse(awalé.partieFinie());
		assertFalse(awalé.estCoupPossible(0, 0));
	assertTrue(awalé.estCoupPossible(5, 0));

		
	}
	@Test 
	void testJouer() {
		Awalé awalé=new Awalé();
		assertEquals(0,awalé.jouer(0)); // On a pris aucune graines car en debut de partie c'est impossible
		assertTrue(awalé.getPlateau().estTrouVide(0)); // le trou de départ est vide
		for(int i=1;i<=4;i++)
			assertEquals(5,awalé.getPlateau().getNbGrainesTrou(i));
		assertEquals(0,awalé.jouer(10)); // On a jouer en commancant au trou 10
		
			assertEquals(1,awalé.getPlateau().getNbGrainesTrou(0)); // on remarque qu'il fait le tour et alimenter le trou 
																	// 0 qui n'avait aucune graines
			assertEquals(2,awalé.jouer(8)); // la on voit qu'il a manger car le trou contenait une graine
		awalé.getPlateau().setNbGrainesTrou(0, 12);
		awalé.getPlateau().setNbGrainesTrou(1, 1);
		awalé.jouer(0); // en cas de tour complet le trou départ n'est pas alimenter
		assertTrue(awalé.getPlateau().estTrouVide(0)); 
		assertEquals(3,awalé.getPlateau().getNbGrainesTrou(1));
		
	}
	@Test 
	void testRepartitionDesGraines() {
		Awalé awalé=new Awalé();
		awalé.repartitionDesGraines();
		assertEquals(24,awalé.getScoreJoueur(0));
		assertEquals(24,awalé.getScoreJoueur(1));
	}
	
}
