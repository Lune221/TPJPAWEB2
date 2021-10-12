package ept.dic2.tpjpaweb2.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ept.dic2.tpjpaweb2.entities.Client;
import ept.dic2.tpjpaweb2.facades.ClientSessionBean;

/**
 * Session Bean implementation class ProduitSessionBeanFacade
 */
@Stateless(mappedName = "EJB3-SessionEJB")
public class ClientSessionBeanImpl implements ClientSessionBean {

    /**
     * Default constructor. 
     */
    public ClientSessionBeanImpl() {
    }
    
    @PersistenceContext(unitName = "TPJPAWEB2")
    EntityManager entityManager;

	@Override
	public ArrayList<Client> findAll() {
		ArrayList<Client> articles = new ArrayList<Client>();
		Query query = entityManager.createNamedQuery("Client.findAll");
		
		try {
			articles = (ArrayList<Client>) query.getResultList();
		} catch (Exception e) {
			System.out.println("ERROR WHILE GETTING THE CLIENTS LIST: " + e.getMessage());
		}
		
		return articles;
	}

	@Override
	public Client findOne(Client element) {
		Client article = null;
		try {
			Query query = entityManager.createQuery("SELECT Client a WHERE a.id=:id", Client.class);
			query.setParameter("id", element.getId());
			article = (Client) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return article;
	}

	@Override
	public boolean deleteOne(Client element) {
		try {
			entityManager.remove(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateOne(Client element) {
		try {
			entityManager.merge(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
