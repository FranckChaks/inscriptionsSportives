package menu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import inscriptions.Inscriptions;

import javax.swing.*;

public class FenetreCompetition extends JFrame implements ActionListener{
	
	JButton BoutonAdd = new JButton("Ajouter compétition");
	JButton BoutonModif = new JButton("Modifier compétition");
	JButton BoutonGestion = new JButton("Gestion Inscrits");
	JButton Retour = new JButton("Retour");
	private JLabel nomLabel;
	private JComboBox<String> CompetDeroulant = new JComboBox<>();
	private JLabel space;
		
	public FenetreCompetition()
	{
		this.setTitle("Maison des Ligues de Lorraine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panneau1 = new JPanel();
		JPanel panneau2 = new JPanel();
		JPanel panneau3 = new JPanel();
		nomLabel = new JLabel("Menu compétition");
		space = new JLabel(" 	");
		panneau1.setLayout(new GridLayout(5,3));
		panneau2.add(nomLabel);
		panneau1.add(BoutonAdd);
		panneau1.add(BoutonModif);
		panneau1.add(space);
		panneau1.add(BoutonGestion);
		panneau1.add(space);
		panneau1.add(Retour);
		panneau3.add(CompetDeroulant);
		CompetDeroulant.setPreferredSize(new Dimension(200, 100));
		CompetDeroulant.addItem("Mondial de fléchettes  07/06/2018");
		CompetDeroulant.addItem("Mondial de pétanques  04/07/2018");
		CompetDeroulant.addItem("Mondial de beachvolley 21/07/2018");
		this.add(panneau2, BorderLayout.NORTH);
		this.add(panneau1, BorderLayout.SOUTH);
		this.add(panneau3, BorderLayout.CENTER);
		BoutonAdd.addActionListener(this);
		BoutonModif.addActionListener(this);
		Retour.addActionListener(this);
		
		this.setBounds(10, 10, 500, 400);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == BoutonAdd);
	}
	
	public static void main(String [] args)
	{
		FenetreCompetition fenetre = new FenetreCompetition();
	}
}
