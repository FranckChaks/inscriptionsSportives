package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

class TestsJUnit {
	
	LocalDate ld = LocalDate.now();
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition comp = inscriptions.createCompetition("ESL Tour", ld, true );
	Equipe equipe = inscriptions.createEquipe("Les Manouches"),
			roms = inscriptions.createEquipe("Les Roms");
	Personne personne = inscriptions.createPersonne("Lopez", "Joe","lopezjoe@manouche.fr"),
			 Michel = inscriptions.createPersonne("Latour", "Michel", "michmich@rom.fr"),
			 Bebert = inscriptions.createPersonne("LaVillardiere", "Bebert", "bebert@rom.com");
	
	public void classTest() {
		equipe.add(personne);	
	}
	
	@Test
	public void testCompetition() {
		assertEquals("Nom de la compétition", "ESL Tour", comp.getNom());
		assertEquals("Date de cloture de la compétition", ld, comp.getDateCloture());
	}
	
	@Test
	public void testEquipe() {
		assertEquals("Nom de l'équipe", "Les Manouches", equipe.getNom());
	}
	
	@Test
	public void testPersonne( ) {
		assertEquals("Nom de la personne", "Lopez", personne.getNom());
		assertEquals("Prénom de la personne", "Joe", personne.getPrenom());
		assertEquals("Email de la personne","lopezjoe@manouche.fr", personne.getMail());
	}
	
	@Test
	void testGetEquipes() {
		Set<Equipe> equipe = new TreeSet<>();
		Equipe lesManouches = inscriptions.createEquipe("Les Manouches");
		lesManouches.add(personne);
		equipe.add(lesManouches);
		
		assertEquals(equipe, personne.getEquipes());
	}
	
	@Test
	void testGetCompetitions() {
		classTest();
		assertEquals("Les Manouches", personne.getCompetitions());
	}
	
	@Test
	public void testAddEquipe() {
		
		Equipe lesManouches = inscriptions.createEquipe("Les Manouches");
		Equipe lesRoms= inscriptions.createEquipe("Les Roms");
		Set<Equipe> eq = new TreeSet<Equipe>();
		eq.add(lesManouches);
		eq.add(lesRoms);
		
		assertEquals("AddEquipes : " + eq + " , " + inscriptions.getEquipes(), eq, inscriptions.getEquipes());
	}
	
	@Test
	public void testDelete() {
		
		Equipe lesRoms = inscriptions.createEquipe("Les Roms");
		Set<Equipe> eq = new TreeSet<Equipe>();
		eq.add(lesRoms);
		lesRoms.add(Michel);
		lesRoms.add(Bebert);
		
		Bebert.delete();
		
		assertEquals("Delete Equipe: " + eq + " , " + Bebert.getEquipes(), eq, Michel.getEquipes());
	}


	@Test
	public void testRemoveEquipe() {
		
		Equipe lesManouches = inscriptions.createEquipe("Les Manouches");
		Equipe lesRoms = inscriptions.createEquipe("Les Roms");
		Set<Equipe> eq = new TreeSet<Equipe>();
		eq.add(lesManouches);
		eq.add(lesRoms);
		eq.remove(lesManouches);
		// RENDRE METHODE REMOVE EN PUBLIC//
//		inscriptions.remove(lesManouches);

		assertEquals("Remove Equipe: " + eq + " , " + inscriptions.getEquipes(), eq, inscriptions.getEquipes());
	}

}
