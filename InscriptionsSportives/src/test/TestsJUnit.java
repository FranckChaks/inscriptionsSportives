package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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
	Equipe equipe = inscriptions.createEquipe("Les Manouches");
	Personne personne = inscriptions.createPersonne("Lopez", "Joe","lopezjoe@manouche.fr");
	
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
		assertEquals("Nom de la personne", "Lopez","");
		assertEquals("Prénom de la personne", "Joe", personne.getPrenom());
		assertEquals("Email de la personne","lopezjoe@manouche.fr", personne.getMail());
	}
	
	@Test
	void testDelete() {
		fail("Erreur");
	}

	@Test
	void testAddEquipe() {
		fail("Erreur");
	}

	@Test
	void testRemoveEquipe() {
		fail("Erreur");
	}

}
