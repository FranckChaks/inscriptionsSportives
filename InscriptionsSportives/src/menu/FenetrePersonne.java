package menu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import inscriptions.Inscriptions;

import javax.swing.*;

public class FenetrePersonne extends JFrame implements ActionListener{
	
	JButton BoutonAdd = new JButton("Ajouter personne");
	JButton BoutonModif = new JButton("Modifier personne");
	JButton Retour = new JButton("Retour");
	private JLabel nomLabel;
	private JComboBox<String> PersonneDeroulant = new JComboBox<>();
	private JLabel space;
		
	public FenetrePersonne()
	{
		this.setTitle("Maison des Ligues de Lorraine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panneau1 = new JPanel();
		JPanel panneau2 = new JPanel();
		JPanel panneau3 = new JPanel();
		nomLabel = new JLabel("Menu personne");
		space = new JLabel(" 	");
		panneau1.setLayout(new GridLayout(4,3));
		panneau2.add(nomLabel);
		panneau1.add(BoutonAdd);
		panneau1.add(BoutonModif);
		panneau1.add(space);
		panneau1.add(Retour);
		panneau3.add(PersonneDeroulant);
		PersonneDeroulant.setPreferredSize(new Dimension(200, 100));
		PersonneDeroulant.addItem("Nom  Prénom  Mail");
		PersonneDeroulant.addItem("Nom  Prénom  Mail");
		PersonneDeroulant.addItem("Nom  Prénom  Mail");
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
		FenetrePersonne fenetre = new FenetrePersonne();
	}
}
