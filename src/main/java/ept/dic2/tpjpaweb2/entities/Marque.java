package ept.dic2.tpjpaweb2.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marque database table.
 * 
 */
@Entity
@Table(name="marque")
@NamedQuery(name="Marque.findAll", query="SELECT m FROM Marque m")
public class Marque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="label")
	private String label;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="marque")
	private List<Article> articles;

	public Marque() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setMarque(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setMarque(null);

		return article;
	}

}