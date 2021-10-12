package ept.dic2.tpjpaweb2.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ept.dic2.tpjpaweb2.entities.Marque;
import ept.dic2.tpjpaweb2.facades.MarqueSessionBean;

/**
 * Session Bean implementation class ProduitSessionBeanFacade
 */
@Stateless(mappedName = "EJB3-SessionEJB")
public class MarqueSessionBeanImpl implements MarqueSessionBean {

    /**
     * Default constructor. 
     */
    public MarqueSessionBeanImpl() {
    }
    
    @PersistenceContext(unitName = "TPJPAWEB2")
    EntityManager entityManager;

	@Override
	public ArrayList<Marque> findAll() {
		ArrayList<Marque> articles = new ArrayList<Marque>();
		Query query = entityManager.createNamedQuery("Marque.findAll");
		
		try {
			articles = (ArrayList<Marque>) query.getResultList();
		} catch (Exception e) {
			System.err.println("ERROR WHILE GETTING THE BRANDS LIST: " + e.getMessage());
		}
		
		return articles;
	}

	@Override
	public Marque findOne(Marque element) {
		Marque article = null;
		try {
			Query query = entityManager.createQuery("SELECT Marque a WHERE a.id=:id", Marque.class);
			query.setParameter("id", element.getId());
			article = (Marque) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return article;
	}

	@Override
	public boolean deleteOne(Marque element) {
		try {
			entityManager.remove(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateOne(Marque element) {
		try {
			entityManager.merge(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
