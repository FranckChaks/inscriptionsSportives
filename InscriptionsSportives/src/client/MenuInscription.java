package client;

import java.time.LocalDate;
import java.util.Scanner;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.*;

public class MenuInscription {
	
	static Scanner sc = new Scanner(System.in);

	
	public static Menu getHelloMenu() {
		Menu helloMenu = new Menu("Inscriptions Sportives");
		helloMenu.add(getCompetitionMenu()); 
		helloMenu.add(getEquipeMenu());
		helloMenu.add(getPersonneMenu());
		helloMenu.addQuit("q");
		return helloMenu;
	}
//--------------MENU COMPETITION-------------\\
//--------------------------------------------\\
	static Menu getCompetitionMenu() {
		Menu competitionMenu = new Menu("Menu des comp�titions", "Competition", "c");
		competitionMenu.add(getAddCompOption());
		competitionMenu.add(getDisplayCompOption());
		competitionMenu.add(getGestionCompetitionMenu());
		competitionMenu.addBack("4");
		return competitionMenu;
	}
	
/////////---AJOUTER COMPETITION---\\\\\\\\\\\\
	
	static Option getAddCompOption()
	{
		Option addComp = new Option("Ajouter une comp�tition", "1", 
				getAddCompetition());
		return addComp;
	}
	
	static Action getAddCompetition() {
		return new Action()
		{
			public void optionSelected()
			{
				String a = InOut.getString("Nom de la comp�tition: ");
				System.out.println("Date de cloture \n");
				int jour = InOut.getInt("Jour: ");
				int mois = InOut.getInt("Mois: ");
				int annee = InOut.getInt("Ann�e: ");
				int c = InOut.getInt("En �quipe (0 pour Non, 1 pour oui)? ");
				boolean d = false;
				if(c == 1)
					d = true;
				else if(c != 0 && c != 1 )
					System.out.println("Erreur de saisie, veuillez entrer 1 ou 0.");
				LocalDate dateCloture = LocalDate.of(annee, mois, jour);
				Inscriptions.getInscriptions().createCompetition(a, dateCloture, d);	
			}
		};
	}

/////////---AFFICHER COMPETITION---\\\\\\\\\\\\
	
	static Option getDisplayCompOption()
	{
		Option displayComp = new Option("Afficher les comp�titions", "2", 
				getDisplayCompetition());
		return displayComp;
	}
	
	static Action getDisplayCompetition() {
		return new Action()
		{
			public void optionSelected()
			{
				competitionMenu.add(displayCompetition);	//TODO
			}
		};
	}
	//-----------Menu gestion comp�tition----------\\
	static Menu getGestionCompetitionMenu() {
		Menu gestionCompetition = new Menu("Gestion des comp�titions", "Gestion des comp�titions","3");
		gestionCompetition.add(getDeleteCompOption());
		gestionCompetition.add(getModifyCompOption());
		gestionCompetition.addBack("3");
		return gestionCompetition;
	}
	
	//------Supprimer Comp�tition-------\\
	static Option getDeleteCompOption()
	{
		Option deleteComp = new Option("Supprimer une comp�tition","1",
				getDeleteCompetition());
		return deleteComp;
	}
	
	static Action getDeleteCompetition() {
		return new Action()
		{
			public void optionSelected()
			{
				gestionCompetition.add(deleteCompetition);	//TODO
			}
		};
	}
	
	//------Modifier Comp�tition-------\\
	static Option getModifyCompOption()
	{
		Option modifyComp = new Option("Modifier une comp�tition","2",
				getModifyCompetition());
		return modifyComp;
	}
	
	static Action getModifyCompetition() {
		return new Action()
		{
			public void optionSelected()
			{
				gestionCompetition.add(modifyCompetition);	//TODO
			}
		};
	}
	
	///--------FIN MENU COMPETITION-----------\\\

	//-------------------------------------------\\
	
	
	//--------------MENU EQUIPE----------------\\\
	
		static Menu getEquipeMenu() {
			Menu equipeMenu = new Menu("Menu des �quipes", "Equipes", "e");
			equipeMenu.add(getAddEquipeOption());
			equipeMenu.add(getDisplayEquipeOption());
			equipeMenu.add(getGestionEquipeMenu());
			equipeMenu.addBack("4");
			return equipeMenu;
		}
		
/////////---AJOUTER EQUIPE---\\\\\\\\\\\\
		
	static Option getAddEquipeOption()
	{
		Option addEquipe = new Option("Ajouter une �quipe", "1", 
				getAddEquipe());
		return addEquipe;
	}
	
	static Action getAddEquipe() {
		return new Action()
		{
			public void optionSelected()
			{
				String a = InOut.getString("Nom de l'�quipe: ");
				Inscriptions.getInscriptions().createEquipe(a);	//TODO
			}
		};
	}

/////////---AFFICHER EQUIPE---\\\\\\\\\\\\
	
	static Option getDisplayEquipeOption()
	{
		Option displayEquipe = new Option("Afficher les �quipes", "2", 
				getDisplayEquipe());
		return displayEquipe;
	}
	
	static Action getDisplayEquipe() {
		return new Action()
		{
			public void optionSelected()
			{
				equipeMenu.add(displayEquipe);	//TODO
			}
		};
	}
	//-----------Menu gestion �quipe----------\\
	static Menu getGestionEquipeMenu() {
		Menu gestionEquipe = new Menu("Gestion des �quipes", "Gestion des �quipes","3");
		gestionEquipe.add(getDeleteEquipeOption());
		gestionEquipe.add(getModifyEquipeOption());
		gestionEquipe.addBack("3");
		return gestionEquipe;
	}
	
	//------Supprimer Equipe-------\\
	static Option getDeleteEquipeOption()
	{
		Option deleteEquipe = new Option("Supprimer une �quipe","1",
				getDeleteEquipe());
		return deleteEquipe;
	}
	
	static Action getDeleteEquipe() {
		return new Action()
		{
			public void optionSelected()
			{
				gestionEquipe.add(deleteEquipe);	//TODO
			}
		};
	}
	
	//------Modifier Equipe-------\\
	static Option getModifyEquipeOption()
	{
		Option modifyEquipe= new Option("Modifier une �quipe","2",
				getModifyEquipe());
		return modifyEquipe;
	}
	
	static Action getModifyEquipe() {
		return new Action()
		{
			public void optionSelected()
			{
				gestionEquipe.add(modifyEquipe);	//TODO
			}
		};
	}
	
	//-------------------------------------------\\
	
	
		//--------------MENU PERSONNE----------------\\\
		
		static Menu getPersonneMenu() {
			Menu personneMenu = new Menu("Menu des personnes", "Personnes", "p");
			personneMenu.add(getAddPersOption());
			personneMenu.add(getDisplayPersOption());
			personneMenu.add(getGestionPersMenu());
			personneMenu.addBack("4");
			return personneMenu;
		}
			
	/////////---AJOUTER EQUIPE---\\\\\\\\\\\\
			
		static Option getAddPersOption()
		{
			Option addPers = new Option("Ajouter une personne", "1", 
					getAddPers());
			return addPers;
		}
		
		static Action getAddPers() {
			return new Action()
			{
				public void optionSelected()
				{
					String a = InOut.getString("Nom de la personne: ");
					String b = InOut.getString("Pr�nom de la personne: ");
					String c = InOut.getString("Adresse e-mail de la personne: ");
					Inscriptions.getInscriptions().createPersonne(a, b, c);	
				}
			};
		}

	/////////---AFFICHER PERSONNE---\\\\\\\\\\\\
		
		static Option getDisplayPersOption()
		{
			Option displayPers = new Option("Afficher les personnes", "2", 
					getDisplayPers());
			return displayPers;
		}
		
		static Action getDisplayPers() {
			return new Action()
			{
				public void optionSelected()
				{
					persMenu.add(displayPers);	//TODO
				}
			};
		}
		//-----------Menu gestion personne----------\\
		static Menu getGestionPersMenu() {
			Menu gestionPers = new Menu("Gestion des personnes", "Gestion des personnes","3");
			gestionPers.add(getDeletePersOption());
			gestionPers.add(getModifyPersOption());
			gestionPers.addBack("3");
			return gestionPers;
		}
		
		//------Supprimer Equipe-------\\
		static Option getDeletePersOption()
		{
			Option deletePers = new Option("Supprimer une personne","1",
					getDeletePers());
			return deletePers;
		}
		
		static Action getDeletePers() {
			return new Action()
			{
				public void optionSelected()
				{
					gestionPers.add(deletePers);	//TODO
				}
			};
		}
		
		//------Modifier Personne-------\\
		static Option getModifyPersOption()
		{
			Option modifyPers = new Option("Modifier une personne","2",
					getModifyEquipe());
			return modifyPers;
		}
		
		static Action getModifyPers() {
			return new Action()
			{
				public void optionSelected()
				{
					gestionPers.add(modifyPers);	//TODO
				}
			};
		}
	
}
