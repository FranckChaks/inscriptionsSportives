package client;

import commandLineMenus.*;

public class listEquipe {
    // If you have to manipulate data, use a private non static field.
    private java.util.List<String> equipe;

    listEquipe(java.util.List<String> equipe)
    {
        this.equipe = equipe;
        List<String> list = getCompetitionList();
        list.start();
    }

    // Returns the list to print
    private List<String> getCompetitionList()
    {
        List<String> liste = new List<>("Sélectionner une équipe: ",
                getListDataEquipe(),
                getOptionListeEquipe());
        liste.setAutoBack(false);
        liste.addQuit("q");
        return liste;
    }

    private ListData<String> getListDataEquipe()
    {
        return new ListData<String>()
        {
            @Override
            public java.util.List<String> getList()
            {
                return equipe;
            }
        };
    }

    private ListOption<String> getOptionListeEquipe()
    {
        return new ListOption<String>()
        {
            // Each person will become an option
            // The following method returns the option
            // associated with each one.
            public Option getOption(String UneEquipe)
            {
                return getUneEquipeMenu(UneEquipe);
            }
        };
    }

    // Creates an sub-menu for UneEquipe.
    private Option getUneEquipeMenu(final String UneEquipe)
    {
        Menu UneEquipeMenu = new Menu(UneEquipe);
        UneEquipeMenu.add(getDisplayUneEquipeOption(UneEquipe));
        UneEquipeMenu.add(getDeleteUneEquipeOption(UneEquipe));
        UneEquipeMenu.addBack("b");
        UneEquipeMenu.setAutoBack(true);
        return UneEquipeMenu;
    }

    // Returns the option to display UneEquipe
    private Option getDisplayUneEquipeOption(String UneEquipe)
    {
        return new Option("show", "s", new Action()
        {
            @Override
            public void optionSelected()
            {
                System.out.println("You must give the man a name : " + UneEquipe + ".");
            }
        });
    }

    // Returns the option to delete UneEquipe
    private Option getDeleteUneEquipeOption(String UneEquipe)
    {
        return new Option("delete", "d", new Action()
        {
            @Override
            public void optionSelected()
            {
                equipe.remove(UneEquipe);
                System.out.println(UneEquipe + " has been deleted.");
                System.out.println(equipe);
            }
        });
    }
}
