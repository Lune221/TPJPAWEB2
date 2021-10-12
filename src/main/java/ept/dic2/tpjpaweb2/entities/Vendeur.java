package ept.dic2.tpjpaweb2.entities;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vendeur database table.
 * 
 */
@Entity
@Table(name="vendeur")
@NamedQuery(name="Vendeur.findAll", query="SELECT v FROM Vendeur v")
public class Vendeur extends Personne {
	private static final long serialVersionUID = 1L;

	@Column(name="actif")
	private byte actif;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="vendeur")
	private List<Commande> commandes;

	public Vendeur() {
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setVendeur(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setVendeur(null);

		return commande;
	}

}