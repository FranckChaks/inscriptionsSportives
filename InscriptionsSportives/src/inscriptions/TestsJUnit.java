package inscriptions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestsJUnit {
	
	private LocalDate ld = LocalDate.now();
	private Inscriptions inscriptions = Inscriptions.getInscriptions();
	private Competition comp = new Competition(inscriptions, "ESL Tour", ld, true );
	private Equipe equipe = new Equipe(inscriptions, "Les Manouches");
	private Personne personne = new Personne(inscriptions,"Lopez", "Joe","lopezjoe@manouche.fr");
	
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

}
