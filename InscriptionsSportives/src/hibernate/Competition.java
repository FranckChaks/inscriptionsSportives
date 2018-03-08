package hibernate;

import javax.persistence.*;
import org.hibernate.*;
import java.time.LocalDate;

@Entity
public class Competition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_comp")
	private int id_comp;
	
	@Column(name = "nom_comp")
	private String nom_comp;

	@Column(name = "enEquipe")
	private boolean enEquipe;
	
	@Column(name = "dateClosure")
	private LocalDate dateClosure;
	
	Competition(int id_comp, String nom_comp, boolean enEquipe, LocalDate dateClosure)
	{
		this.id_comp = id_comp;
		this.nom_comp = nom_comp;
		this.enEquipe = enEquipe;
		this.dateClosure = dateClosure;

	}
}
