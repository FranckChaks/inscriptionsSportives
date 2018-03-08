package hibernate;

import javax.persistence.*;
import org.hibernate.*;

@Entity
public class Equipe extends Candidat
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_e")
	private int id_e;
	
	Equipe(int id_e)
	{
		this.id_e = id_e;
	}
}