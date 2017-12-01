//package client;
//
//import java.time.LocalDate;
//
//import inscriptions.Competition;
//import inscriptions.Inscriptions;
//
//public class ExceptionsInscription extends RuntimeException {
//	
//	private LocalDate ld = LocalDate.now();
//	private Inscriptions i = Inscriptions.getInscriptions();
//	private Competition c = new Competition(i, "nom", ld, false);
//	
//	public ExceptionsInscription() {}
//	
//	public void handleExceptionCompetition() throws RuntimeException {
//		try {
//			c.setDateCloture(c.dateCloture);
//		} catch (Exception e) {
//			System.out.println("Vous ne pouvez pas avancer la date de clôture.");
//		}
//	}
//}
