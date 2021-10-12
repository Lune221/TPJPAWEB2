package ept.dic2.tpjpaweb2.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ept.dic2.tpjpaweb2.entities.Commande;
import ept.dic2.tpjpaweb2.facades.CommandeSessionBean;

/**
 * Session Bean implementation class ProduitSessionBeanFacade
 */
@Stateless(mappedName = "EJB3-SessionEJB")
public class CommandeSessionBeanImpl implements CommandeSessionBean {

    /**
     * Default constructor. 
     */
    public CommandeSessionBeanImpl() {
    }
    
    @PersistenceContext(unitName = "TPJPAWEB2")
    EntityManager entityManager;

	@Override
	public ArrayList<Commande> findAll() {
		ArrayList<Commande> articles = new ArrayList<Commande>();
		Query query = entityManager.createNamedQuery("Commande.findAll");
		
		try {
			articles = (ArrayList<Commande>) query.getResultList();
		} catch (Exception e) {
			System.out.println("ERROR WHILE GETTING THE CLIENTS LIST: " + e.getMessage());
		}
		
		return articles;
	}

	@Override
	public Commande findOne(Commande element) {
		Commande article = null;
		try {
			Query query = entityManager.createQuery("SELECT Commande a WHERE a.numero=:numero", Commande.class);
			query.setParameter("numero", element.getNumero());
			article = (Commande) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return article;
	}

	@Override
	public boolean deleteOne(Commande element) {
		try {
			entityManager.remove(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateOne(Commande element) {
		try {
			entityManager.merge(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
