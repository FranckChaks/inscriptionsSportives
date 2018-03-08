package hibernate;

import javax.persistence.*;
import org.hibernate.*;

@Entity
public class Candidat
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cand")
	private int id_cand;

	@Column(name = "nom_cand")
	private String nom;
	
	Candidat(int id_cand, String nom)
	{
		this.id_cand = id_cand;
		this.nom= nom;
	}
}
