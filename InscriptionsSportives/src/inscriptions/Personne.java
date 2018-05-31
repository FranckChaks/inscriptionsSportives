package inscriptions;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import org.hibernate.*;

/**
 * Représente une personne physique pouvant s'inscrire à une compétition.
 */

@Entity
public class Personne extends Candidat
{
	private static final long serialVersionUID = 4434646724271327254L;
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_p")
	private int id_p;
	
	@Column(name = "prenom_p")
	private String prenom;
	
	@Column(name = "nom_p")
	private String nom;

	@Column(name = "mail_p")
	private String mail;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	 @JoinTable(
	name = "Rattacher",
	joinColumns = { @JoinColumn(name = "id_p") },
	inverseJoinColumns = { @JoinColumn(name = "id_e") })
	private Set<Equipe> equipes;
	
	Personne(Inscriptions inscriptions, String nom, String prenom, String mail)
	{
		super(inscriptions, nom);
		this.prenom = prenom;
		this.mail = mail;
		equipes = new TreeSet<>();
	}

	/**
	 * Retourne le prénom de la personne.
	 * @return
	 */
	
	public String getPrenom()
	{
		return prenom;
	}

	/**
	 * Modifie le prénom de la personne.
	 * @param prenom
	 */
	
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne l'adresse électronique de la personne.
	 * @return
	 */
	
	public String getMail()
	{
		return mail;
	}

	/**
	 * Modifie l'adresse électronique de la personne.
	 * @param mail
	 */
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}

	/**
	 * Retoure les équipes dont cette personne fait partie.
	 * @return
	 */
	
	public Set<Equipe> getEquipes()
	{
		return Collections.unmodifiableSet(equipes);
	}
	
	boolean add(Equipe equipe)
	{
		return equipes.add(equipe);
	}

	boolean remove(Equipe equipe)
	{
		return equipes.remove(equipe);
	}
	
	@Override
	public void delete()
	{
		super.delete();
		for (Equipe e : equipes)
			e.remove(this);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " membre de " + equipes.toString();
	}
}
