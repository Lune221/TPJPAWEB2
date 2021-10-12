package ept.dic2.tpjpaweb2.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ept.dic2.tpjpaweb2.entities.Article;
import ept.dic2.tpjpaweb2.facades.ArticleSessionBean;

/**
 * Session Bean implementation class ProduitSessionBeanFacade
 */
@Stateless(mappedName = "EJB3-SessionEJB")
public class ArticleSessionBeanImpl implements ArticleSessionBean {

    /**
     * Default constructor. 
     */
    public ArticleSessionBeanImpl() {
    }
    
    @PersistenceContext(unitName = "TPJPAWEB2")
    EntityManager entityManager;

	@Override
	public ArrayList<Article> findAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		Query query = entityManager.createNamedQuery("Article.findAll");
		
		try {
			articles = (ArrayList<Article>) query.getResultList();
		} catch (Exception e) {
			System.err.println("ERROR WHILE GETTING THE ARTICLES LIST: " + e.getMessage());
		}
		
		return articles;
	}

	@Override
	public Article findOne(Article element) {
		Article article = null;
		try {
			Query query = entityManager.createQuery("SELECT Article a WHERE a.id=:id", Article.class);
			query.setParameter("id", element.getId());
			article = (Article) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return article;
	}

	@Override
	public boolean deleteOne(Article element) {
		try {
			entityManager.remove(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateOne(Article element) {
		try {
			entityManager.merge(element);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
