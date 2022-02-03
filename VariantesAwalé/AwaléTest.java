package VariantesAwal�;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Awal�Test {

	
	@Test
	void testInitialisationAwal�() {
		Awal� tab []=new Awal�[1000];
		
		for(int i=0;i<tab.length;i++) {
			tab[i]=new Awal�();
			assertEquals(0,tab[i].getScoreJoueur(0));
			assertEquals(0,tab[i].getScoreJoueur(1));
		for(int j=0;j<tab[i].getPlateau().getNbTrous();j++ ) {
			assertEquals(4,tab[i].getPlateau().getNbGrainesTrou(j));
			
		}
		
		}
	}
	@Test
	void testManger() {
		Awal� awal�=new Awal�();
		for(int i=awal�.getPlateau().getNbTrous()/2;i<awal�.getPlateau().getNbTrous();i++)
			awal�.getPlateau().setNbGrainesTrou(i, 2);
		int grainesPrises;
		for(int i=awal�.getPlateau().getNbTrous()/2;i<awal�.getPlateau().getNbTrous();i++) 
			assertEquals(2,awal�.getPlateau().getNbGrainesTrou(i));
		grainesPrises=awal�.manger(0, 11); // prises des graines de la rang�e � par le dernier trou car on peut pas vider toute la rang�e adverse
		for(int i=awal�.getPlateau().getNbTrous()/2+1;i<awal�.getPlateau().getNbTrous();i++)
			assertTrue(awal�.getPlateau().estTrouVide(i));
		assertEquals(2,awal�.getPlateau().getNbGrainesTrou(awal�.getPlateau().getNbTrous()/2));
		assertEquals(10,grainesPrises);
		
		
		
	}
	
	@Test
	void testNbGrainesJoueur() {
		Awal� awal�=new Awal�();
		for(int j=0;j<awal�.getNbJoueurs();j++)
			assertEquals(24,awal�.getNbGrainesJoueur(j));
		
	}
	@Test
	void testIdentit�Joueur() {
		Awal� awal�=new Awal�();
		for(int i=0;i<awal�.getPlateau().getNbTrous()/2;i++)
			assertEquals(0,awal�.identit�Joueur(i));
		for(int i=awal�.getPlateau().getNbTrous()/2;i<awal�.getPlateau().getNbTrous();i++)
			assertEquals(1,awal�.identit�Joueur(i));
	}
	@Test
	void testPartieFinie() {
		Awal� awal�=new Awal�();
		assertFalse(awal�.partieFinie());
		for(int i=2;i<awal�.getPlateau().getNbTrous();i++)
			awal�.getPlateau().viderTrou(i);
		assertTrue(awal�.partieFinie()); 
	}
	@Test
	void testEstCoupPossible() {
		Awal� awal�=new Awal�();
		int joueur=0,cellule=0;
		assertTrue(awal�.estCoupPossible(cellule, joueur));
		assertFalse(awal�.estCoupPossible(cellule+8, joueur));
		assertFalse(awal�.estCoupPossible(cellule+13, joueur));
		assertFalse(awal�.estCoupPossible(cellule, joueur+1));
		assertTrue(awal�.estCoupPossible(cellule+7, joueur+1));
		for(int i=awal�.getPlateau().getNbTrous()/2;i<awal�.getPlateau().getNbTrous();i++)
			awal�.getPlateau().viderTrou(i);
		assertTrue(awal�.getNbGrainesJoueur(1)==0);
		assertFalse(awal�.partieFinie());
		assertFalse(awal�.estCoupPossible(0, 0));
	assertTrue(awal�.estCoupPossible(5, 0));

		
	}
	@Test 
	void testJouer() {
		Awal� awal�=new Awal�();
		assertEquals(0,awal�.jouer(0)); // On a pris aucune graines car en debut de partie c'est impossible
		assertTrue(awal�.getPlateau().estTrouVide(0)); // le trou de d�part est vide
		for(int i=1;i<=4;i++)
			assertEquals(5,awal�.getPlateau().getNbGrainesTrou(i));
		assertEquals(0,awal�.jouer(10)); // On a jouer en commancant au trou 10
		
			assertEquals(1,awal�.getPlateau().getNbGrainesTrou(0)); // on remarque qu'il fait le tour et alimenter le trou 
																	// 0 qui n'avait aucune graines
			assertEquals(2,awal�.jouer(8)); // la on voit qu'il a manger car le trou contenait une graine
		awal�.getPlateau().setNbGrainesTrou(0, 12);
		awal�.getPlateau().setNbGrainesTrou(1, 1);
		awal�.jouer(0); // en cas de tour complet le trou d�part n'est pas alimenter
		assertTrue(awal�.getPlateau().estTrouVide(0)); 
		assertEquals(3,awal�.getPlateau().getNbGrainesTrou(1));
		
	}
	@Test 
	void testRepartitionDesGraines() {
		Awal� awal�=new Awal�();
		awal�.repartitionDesGraines();
		assertEquals(24,awal�.getScoreJoueur(0));
		assertEquals(24,awal�.getScoreJoueur(1));
	}
	
}
