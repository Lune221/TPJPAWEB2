package ept.dic2.tpjpaweb2.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the article_commande database table.
 * 
 */
@Entity
@Table(name="article_commande")
@NamedQuery(name="ArticleCommande.findAll", query="SELECT a FROM ArticleCommande a")
public class ArticleCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	public ArticleCommande() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="prix")
	private BigDecimal prix;


	@Column(name="quantite")
	private int quantite;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="numero_commande", referencedColumnName = "numero", insertable=false, updatable=false)
	private Commande commande;
	
	@Column(name = "articleid")
	private int articleid;

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the prix
	 */
	public BigDecimal getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	/**
	 * @return the articleid
	 */
	public int getArticleid() {
		return articleid;
	}

	/**
	 * @param articleid the articleid to set
	 */
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	
}