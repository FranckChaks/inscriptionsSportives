package inscriptions;

import java.io.Serializable;
import java.time.LocalDate;
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
 * Représente une compétition, c'est-à-dire un ensemble de candidats 
 * inscrits à un événement, les inscriptions sont closes à la date dateCloture.
 *
 */

@Entity
public class Competition implements Comparable<Competition>, Serializable
{
	private static final long serialVersionUID = -2882150118573759729L;
	private Inscriptions inscriptions;
	public LocalDate dateSystem = LocalDate.now();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_comp")
	private int id_comp;
	
	@Column(name = "nom_comp")
	private String nom;

	@Column(name = "enEquipe")
	private boolean enEquipe = false;
	
	@Column(name = "dateCloture")
	private LocalDate dateCloture;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "inscription",
	joinColumns = {@JoinColumn(name = "id_comp")},
	inverseJoinColumns = {@JoinColumn(name = "id_cand")})
	private Set<Candidat> candidats;
	
	Competition(Inscriptions inscriptions, String nom, LocalDate dateCloture, boolean enEquipe)
	{
		this.enEquipe = enEquipe;
		this.inscriptions = inscriptions;
		this.nom = nom;
		this.dateCloture = dateCloture;
		candidats = new TreeSet<>();
	}
	
	/**
	 * Retourne le nom de la compétition.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom de la compétition.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom ;
	}
	
	/**
	 * Retourne vrai si les inscriptions sont encore ouvertes, 
	 * faux si les inscriptions sont closes.
	 * @return
	 */

	
	public boolean inscriptionsOuvertes()
	{
		// TODO retourner vrai si et seulement si la date système est antérieure à la date de clôture.
		if(dateCloture.isAfter(dateSystem))
			return true;
		else
			return false;
	}
	
	/**
	 * Retourne la date de cloture des inscriptions.
	 * @return
	 */
	
	public LocalDate getDateCloture()
	{
		return dateCloture;
	}
	
	/**
	 * Est vrai si et seulement si les inscriptions sont réservées aux équipes.
	 * @return
	 */
	
	public boolean estEnEquipe()
	{
		return enEquipe;
	}
	
	/**
	 * Modifie la date de cloture des inscriptions. Il est possible de la reculer 
	 * mais pas de l'avancer.
	 * @param dateCloture
	 */
	
	public void setDateCloture(LocalDate dateCloture) throws handleExceptionCompetition
	{
		// TODO vérifier que l'on avance pas la date.
		if(this.dateCloture.isBefore(dateCloture)){
			this.dateCloture = dateCloture;
		}else {
			throw new handleExceptionCompetition();
		}
	}
	
	/**
	 * Retourne l'ensemble des candidats inscrits.
	 * @return
	 */
	
	public Set<Candidat> getCandidats()
	{
		return Collections.unmodifiableSet(candidats);
	}
	
	/**
	 * Inscrit un candidat de type Personne à la compétition. Provoque une
	 * exception si la compétition est réservée aux équipes ou que les 
	 * inscriptions sont closes.
	 * @param personne
	 * @return
	 */
	
	public boolean add(Personne personne)
	{
		// TODO vérifier que la date de clôture n'est pas passée
		if(dateCloture.isAfter(LocalDate.now())) {
		if (enEquipe)
			throw new RuntimeException();
		personne.add(this);
		return candidats.add(personne);
		}
		else 
			return false;
	}

	/**
	 * Inscrit un candidat de type Equipe à la compétition. Provoque une
	 * exception si la compétition est réservée aux personnes ou que 
	 * les inscriptions sont closes.
	 * @param personne
	 * @return
	 */

	public boolean add(Equipe equipe) 
	{
		// TODO vérifier que la date de clôture n'est pas passée
			if(dateCloture.isAfter(dateSystem)) {
			if (!enEquipe)
				throw new RuntimeException();
			equipe.add(this);
			return candidats.add(equipe);
			}
			else
				return false;

	}

	/**
	 * Désinscrit un candidat.	
	 * @param candidat
	 * @return
	 */
	
	public boolean remove(Candidat candidat)
	{
		candidat.remove(this);
		return candidats.remove(candidat);
	}
	
	/**
	 * Supprime la compétition de l'application.
	 */
	
	public void delete()
	{
		for (Candidat candidat : candidats)
			remove(candidat);
		inscriptions.remove(this);
	}

	@Override
	public int compareTo(Competition o)
	{
		return getNom().compareTo(o.getNom());
	}

	@Override
	public String toString()
	{
		return getNom();
	}
	
	class handleExceptionCompetition extends RuntimeException{
		/**
		 * 
		 */
		private static final long serialVersionUID = -2928887103262954985L;

		@Override
		public String toString()
		{
			return "Vous ne pouvez pas avancer la date";
		}
	}
	
}



