package client;

import java.time.LocalDate;

import inscriptions.Competition;
import inscriptions.Inscriptions;

public class ExceptionsInscription {
	
	private LocalDate ld = LocalDate.now();
	private Inscriptions i = Inscriptions.getInscriptions();
	private Competition c = new Competition(i, "nom", ld, false);
	
	public void handleExceptionCompetition() {
		try {
			c.setDateCloture(c.dateCloture);
		} catch (Exception e) {
			System.out.println("Vous ne pouvez pas avancer la date de clôture.");
		}
	}
}
