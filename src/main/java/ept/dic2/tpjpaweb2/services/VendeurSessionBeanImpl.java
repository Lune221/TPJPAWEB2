package ept.dic2.tpjpaweb2.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ept.dic2.tpjpaweb2.entities.Vendeur;
import ept.dic2.tpjpaweb2.facades.VendeurSessionBean;

/**
 * Session Bean implementation class ProduitSessionBeanFacade
 */
@Stateless(mappedName = "EJB3-SessionEJB")
public class VendeurSessionBeanImpl implements VendeurSessionBean {

    /**
     * Default constructor. 
     */
    public VendeurSessionBeanImpl() {
    }
    
    @PersistenceContext(unitName = "TPJPAWEB2")
    EntityManager entityManager;

	@Override
	public ArrayList<Vendeur> findAll() {
		ArrayList<Vendeur> articles = new ArrayList<Vendeur>();
		Query query = entityManager.createNamedQuery("Vendeur.findAll");
		
		try {
			articles = (ArrayList<Vendeur>) query.getResultList();
		} catch (Exception e) {
			System.err.println("ERROR WHILE GETTING THE BRANDS LIST: " + e.getMessage());
		}
		
		return articles;
	}

	@Override
	public Vendeur findOne(Vendeur element) {
		Vendeur article = null;
		try {
			Query query = entityManager.createQuery("SELECT Vendeur a WHERE a.id=:id", Vendeur.class);
			query.setParameter("id", element.getId());
			article = (Vendeur) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return article;
	}

	@Override
	public boolean deleteOne(Vendeur element) {
		try {
			entityManager.remove(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateOne(Vendeur element) {
		try {
			entityManager.merge(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
