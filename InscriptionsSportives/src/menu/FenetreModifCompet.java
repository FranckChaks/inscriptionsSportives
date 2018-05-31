package menu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import inscriptions.Inscriptions;

import javax.swing.*;

public class FenetreModifCompet extends JFrame implements ActionListener{
	
	JButton BoutonAdd = new JButton("Supprimer");
	JButton BoutonModif = new JButton("Modifier");
	private JTextField jtf; 
	private JTextField jtf2; 
	JButton Retour = new JButton("Retour");
	private JLabel nomLabel;
	private JLabel nomCompet = new JLabel("Nom de la compétition");
	private JLabel DateLabel = new JLabel("Date de cloture");
	private JLabel space;
		
	public FenetreModifCompet()
	{
		this.setTitle("Maison des Ligues de Lorraine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panneau1 = new JPanel();
		JPanel panneau2 = new JPanel();
		JPanel panneau3 = new JPanel();
		nomLabel = new JLabel("Modifier une compétition");
		space = new JLabel("                                   ");
		jtf = new JTextField();
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf2 = new JTextField();
		jtf2.setPreferredSize(new Dimension(150, 30));
		panneau1.setLayout(new GridLayout(5,3));
		panneau2.add(nomLabel);
		panneau1.add(BoutonAdd);
		panneau1.add(BoutonModif);
		panneau1.add(space);
		panneau1.add(Retour);
		panneau3.add(nomCompet);
		panneau3.add(jtf);
		panneau3.add(space);
		panneau3.add(DateLabel);
		panneau3.add(jtf2);
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
		FenetreModifCompet fenetre = new FenetreModifCompet();
	}
}