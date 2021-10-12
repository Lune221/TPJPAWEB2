package ept.dic2.tpjpaweb2.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ept.dic2.tpjpaweb2.entities.Categorie;
import ept.dic2.tpjpaweb2.facades.CategorieSessionBean;

/**
 * Session Bean implementation class ProduitSessionBeanFacade
 */
@Stateless(mappedName = "EJB3-SessionEJB")
public class CategorieSessionBeanImpl implements CategorieSessionBean {

    /**
     * Default constructor. 
     */
    public CategorieSessionBeanImpl() {
    }
    
    @PersistenceContext(unitName = "TPJPAWEB2")
    EntityManager entityManager;

	@Override
	public ArrayList<Categorie> findAll() {
		ArrayList<Categorie> articles = new ArrayList<Categorie>();
		Query query = entityManager.createNamedQuery("Categorie.findAll");
		
		try {
			articles = (ArrayList<Categorie>) query.getResultList();
		} catch (Exception e) {
			System.err.println("ERROR WHILE GETTING THE ARTICLES LIST: " + e.getMessage());
		}
		
		return articles;
	}

	@Override
	public Categorie findOne(Categorie element) {
		Categorie article = null;
		try {
			Query query = entityManager.createQuery("SELECT Categorie a WHERE a.id=:id", Categorie.class);
			query.setParameter("id", element.getId());
			article = (Categorie) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return article;
	}

	@Override
	public boolean deleteOne(Categorie element) {
		try {
			entityManager.remove(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateOne(Categorie element) {
		try {
			entityManager.merge(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
