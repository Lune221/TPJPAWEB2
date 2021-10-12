package ept.dic2.tpjpaweb2.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@Table(name="commande")
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numero")
	private int numero;

	@Temporal(TemporalType.DATE)
	@Column(name="date_commande")
	private Date dateCommande;

	@Temporal(TemporalType.DATE)
	@Column(name="date_livraison")
	private Date dateLivraison;

	@Column(name="statut")
	private String statut;

	//bi-directional many-to-one association to ArticleCommande
	@OneToMany(mappedBy="commande")
	private List<ArticleCommande> articleCommandes;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Vendeur
	@ManyToOne
	@JoinColumn(name="vendeur_id")
	private Vendeur vendeur;

	public Commande() {
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public List<ArticleCommande> getArticleCommandes() {
		return this.articleCommandes;
	}

	public void setArticleCommandes(List<ArticleCommande> articleCommandes) {
		this.articleCommandes = articleCommandes;
	}

	public ArticleCommande addArticleCommande(ArticleCommande articleCommande) {
		getArticleCommandes().add(articleCommande);
		articleCommande.setCommande(this);

		return articleCommande;
	}

	public ArticleCommande removeArticleCommande(ArticleCommande articleCommande) {
		getArticleCommandes().remove(articleCommande);
		articleCommande.setCommande(null);

		return articleCommande;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vendeur getVendeur() {
		return this.vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

}