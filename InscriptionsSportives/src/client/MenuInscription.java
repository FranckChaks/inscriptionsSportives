package client;

import commandLineMenus.*;
import inscriptions.*;

public class MenuInscription {
	
	public static Menu getHelloMenu() {
		Menu helloMenu = new Menu("Inscriptions Sportives");
		
		Menu equipeMenu = new Menu("Menu des équipes", "Equipe", "e");
		Menu personneMenu = new Menu("Menu des personnes", "Personne", "p");
		helloMenu.add(getCompetitionMenu()); 
		helloMenu.add(equipeMenu);
		helloMenu.add(personneMenu);
		helloMenu.addQuit("q");
		return helloMenu;
	}
//--------------MENU COMPETITION-------------\\
//--------------------------------------------\\
	static Menu getCompetitionMenu() {
		Menu competitionMenu = new Menu("Menu des compétition", "Competition", "c");
		competitionMenu.add(getAddCompOption());
		competitionMenu.add(getDisplayCompOption());
		competitionMenu.add(getGestionCompetitionMenu());
		competitionMenu.addBack("4");
		return competitionMenu;
	}
	
/////////---AJOUTER COMPETITION---\\\\\\\\\\\\
	
	static Option getAddCompOption()
	{
		Option addComp = new Option("Ajouter une compétition", "1", 
				getAddCompetition());
		return addComp;
	}
	
	static Action getAddCompetition() {
		return new Action()
		{
			public void optionSelected()
			{
				competitionMenu.add(createCompetition);	//TODO
			}
		};
	}

/////////---AFFICHER COMPETITION---\\\\\\\\\\\\
	
	static Option getDisplayCompOption()
	{
		Option displayComp = new Option("Afficher les compétitions", "2", 
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
	//-----------Menu gestion compétition----------\\
	static Menu getGestionCompetitionMenu() {
		Menu gestionCompetition = new Menu("Gestion des compétitions", "Gestion des compétitions","3");
		gestionCompetition.add(getDeleteCompOption);
		gestionCompetition.add(getRemoveCompOption);
		gestionCompetition.addBack("3");
		return gestionCompetition;
	}
	
	//------Supprimer Compétition-------\\
	static Option getDeleteCompOption()
	{
		Option deleteComp = new Option("Supprimer une compétition","1",
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
	
	//------Modifier Compétition-------\\
	static Option getRemoveCompOption()
	{
		Option removeComp = new Option("Modifier une compétition","2",
				getRemoveCompetition());
		return removeComp;
	}
	
	static Action getRemoveCompetition() {
		return new Action()
		{
			public void optionSelected()
			{
				gestionCompetition.add(removeCompetition);	//TODO
			}
		};
	}
	
	///--------FIN MENU COMPETITION-----------\\\

	//-------------------------------------------\\
	
	
	//--------------MENU EQUIPE----------------\\\
	
		static Menu getEquipeMenu() {
			Menu equipeMenu = new Menu("Menu des équipes", "Equipes", "e");
			equipeMenu.add(getAddEquipeOption());
			equipeMenu.add(getDisplayEquipeOption());
			equipeMenu.add(getGestionEquipeMenu());
			equipeMenu.addBack("4");
			return equipeMenu;
		}
		
/////////---AJOUTER EQUIPE---\\\\\\\\\\\\
		
	static Option getAddEquipeOption()
	{
		Option addEquipe = new Option("Ajouter une équipe", "1", 
				getAddEquipe());
		return addEquipe;
	}
	
	static Action getAddEquipe() {
		return new Action()
		{
			public void optionSelected()
			{
				equipeMenu.add(createEquipe);	//TODO
			}
		};
	}

/////////---AFFICHER EQUIPE---\\\\\\\\\\\\
	
	static Option getDisplayEquipeOption()
	{
		Option displayEquipe = new Option("Afficher les équipes", "2", 
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
	//-----------Menu gestion équipe----------\\
	static Menu getGestionEquipeMenu() {
		Menu gestionEquipe = new Menu("Gestion des équipes", "Gestion des équipes","3");
		gestionEquipe.add(getDeleteEquipeOption());
		gestionEquipe.add(getRemoveEquipeOption());
		gestionEquipe.addBack("3");
		return gestionEquipe;
	}
	
	//------Supprimer Equipe-------\\
	static Option getDeleteEquipeOption()
	{
		Option deleteEquipe = new Option("Supprimer une équipe","1",
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
	static Option getRemoveEquipeOption()
	{
		Option removeEquipe= new Option("Modifier une équipe","2",
				getRemoveEquipe());
		return removeEquipe;
	}
	
	static Action getRemoveEquipe() {
		return new Action()
		{
			public void optionSelected()
			{
				gestionEquipe.add(removeEquipe);	//TODO
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
					persMenu.add(createPersonne);	//TODO
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
			Menu gestionPers = new Menu("Gestion des équipes", "Gestion des équipes","3");
			gestionPers.add(getDeleteEquipeOption());
			gestionPers.add(getRemoveEquipeOption());
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
		static Option getRemovePersOption()
		{
			Option removePers = new Option("Modifier une personne","2",
					getRemoveEquipe());
			return removePers;
		}
		
		static Action getRemovePers() {
			return new Action()
			{
				public void optionSelected()
				{
					gestionPers.add(removePers);	//TODO
				}
			};
		}
	
}
