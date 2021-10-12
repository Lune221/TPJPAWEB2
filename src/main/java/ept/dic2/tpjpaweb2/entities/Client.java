package ept.dic2.tpjpaweb2.entities;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client extends Personne {
	private static final long serialVersionUID = 1L;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="adresse", column = @Column(name="ADRESSE")),
		@AttributeOverride(name = "codeZip", column = @Column(name="CODE_ZIP")),
		@AttributeOverride(name = "etat", column = @Column(name="ETAT")),
		@AttributeOverride(name = "ville", column = @Column(name="VILLE"))
	})
	private Adresse adresse;


	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="client")
	private List<Commande> commandes;

	public Client() {
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setClient(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setClient(null);

		return commande;
	}
}