package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Entity
public class Personne extends Candidat
{
	private static Session getSession() throws HibernateException
	 {
	  Configuration configuration = new Configuration()
	    .configure("src/hibernate.cfg.xml");
	  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	    .applySettings(configuration.getProperties()).build();
	  SessionFactory sessionFactory = configuration
	    .buildSessionFactory(serviceRegistry);
	  return sessionFactory.openSession();
	 }
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_p")
	private int id_p;
	
	@Column(name = "prenom_p")
	private String prenom;

	@Column(name = "mail_p")
	private String mail;
	
	Personne(int id_p, String prenom, String mail)
	{
		this.id_p = id_p;
		this.prenom = prenom;
		this.mail = mail;

	}
}
