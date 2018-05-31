package menu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FenetreMain extends JFrame implements ActionListener{
	
	JButton BoutonCompet = new JButton("Gérer Competition");
	JButton BoutonEquipe = new JButton("Gérer Equipe");
	JButton BoutonPersonne = new JButton("Gérer Personne");
	private JLabel nomLabel;
	private JLabel space;
		
	public FenetreMain()
	{
		this.setTitle("Maison des Ligues de Lorraine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panneau1 = new JPanel();
		nomLabel = new JLabel("Menu principal");
		panneau1.setLayout(new GridLayout(4,3));
		panneau1.add(nomLabel);
		panneau1.add(BoutonCompet);
		panneau1.add(BoutonEquipe);
		panneau1.add(BoutonPersonne);
		
		this.add(panneau1, BorderLayout.NORTH);
		
		BoutonCompet.addActionListener(this);
		BoutonEquipe.addActionListener(this);
		BoutonPersonne.addActionListener(this);
		
		this.setBounds(10, 10, 500, 400);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == BoutonCompet);
	}
	
	public static void main(String [] args)
	{
		FenetreMain fenetre = new FenetreMain();
	}
}
