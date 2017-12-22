package client;

import java.util.ArrayList;
import commandLineMenus.*;


public class listPersonne {
    // If you have to manipulate data, use a private non static field.
    private java.util.List<String> personne;

    listPersonne(java.util.List<String> personne)
    {
        this.personne = personne;
        List<String> list = getPersonneList();
        list.start();
    }

    // Returns the list to print
    private List<String> getPersonneList()
    {
        List<String> liste = new List<>("Sélectionner quelqu'un",
                getListDataPeople(),
                getOptionListePeople());
        liste.setAutoBack(false);
        liste.addQuit("q");
        return liste;
    }

    private ListData<String> getListDataPeople()
    {
        return new ListData<String>()
        {
            @Override
            public java.util.List<String> getList()
            {
                return personne;
            }
        };
    }

    private ListOption<String> getOptionListePeople()
    {
        return new ListOption<String>()
        {
            // Each person will become an option
            // The following method returns the option
            // associated with each one.
            public Option getOption(String someone)
            {
                return getSomeoneMenu(someone);
            }
        };
    }

    // Creates an sub-menu for someone.
    private Option getSomeoneMenu(final String someone)
    {
        Menu someoneMenu = new Menu(someone);
        someoneMenu.add(getDisplaySomeoneOption(someone));
        someoneMenu.add(getDeleteSomeoneOption(someone));
        someoneMenu.setAutoBack(true);
        return someoneMenu;
    }

    // Returns the option to display someone
    private Option getDisplaySomeoneOption(String someone)
    {
        return new Option("show", "s", new Action()
        {
            @Override
            public void optionSelected()
            {
                System.out.println("You must give the man a name : " + someone + ".");
            }
        });
    }

    // Returns the option to delete someone
    private Option getDeleteSomeoneOption(String someone)
    {
        return new Option("delete", "d", new Action()
        {
            @Override
            public void optionSelected()
            {
                personne.remove(someone);
                System.out.println(someone + " has been deleted.");
                System.out.println(personne);
            }
        });
    }
}