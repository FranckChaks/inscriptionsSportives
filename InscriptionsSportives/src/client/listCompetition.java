package client;

import commandLineMenus.*;

public class listCompetition {
    // If you have to manipulate data, use a private non static field.
    private java.util.List<String> competition;

    listCompetition(java.util.List<String> competition)
    {
        this.competition = competition;
        List<String> list = getCompetitionList();
        list.start();
    }

    // Returns the list to print
    private List<String> getCompetitionList()
    {
        List<String> liste = new List<>("Sélectionner la compétition",
                getListDataCompetition(),
                getOptionListeCompetition());
        liste.setAutoBack(false);
        liste.addQuit("q");
        return liste;
    }

    private ListData<String> getListDataCompetition()
    {
        return new ListData<String>()
        {
            @Override
            public java.util.List<String> getList()
            {
                return competition;
            }
        };
    }

    private ListOption<String> getOptionListeCompetition()
    {
        return new ListOption<String>()
        {
            // Each person will become an option
            // The following method returns the option
            // associated with each one.
            public Option getOption(String UneCompetition)
            {
                return getUneCompetitionMenu(UneCompetition);
            }
        };
    }

    // Creates an sub-menu for UneCompetition.
    private Option getUneCompetitionMenu(final String UneCompetition)
    {
        Menu UneCompetitionMenu = new Menu(UneCompetition);
        UneCompetitionMenu.add(getDisplayUneCompetitionOption(UneCompetition));
        UneCompetitionMenu.add(getDeleteUneCompetitionOption(UneCompetition));
        UneCompetitionMenu.addBack("b");
        UneCompetitionMenu.setAutoBack(true);
        return UneCompetitionMenu;
    }

    // Returns the option to display UneCompetition
    private Option getDisplayUneCompetitionOption(String UneCompetition)
    {
        return new Option("show", "s", new Action()
        {
            @Override
            public void optionSelected()
            {
                System.out.println("You must give the man a name : " + UneCompetition + ".");
            }
        });
    }

    // Returns the option to delete UneCompetition
    private Option getDeleteUneCompetitionOption(String UneCompetition)
    {
        return new Option("delete", "d", new Action()
        {
            @Override
            public void optionSelected()
            {
                competition.remove(UneCompetition);
                System.out.println(UneCompetition + " has been deleted.");
                System.out.println(competition);
            }
        });
    }
}

