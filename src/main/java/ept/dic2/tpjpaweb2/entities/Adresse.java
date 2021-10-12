package ept.dic2.tpjpaweb2.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adresses
 *
 */
@Embeddable
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	public Adresse() {
		super();
	}
	
	private String adresse;
	private String codeZip;
	private String etat;
	private String ville;
	
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the codeZip
	 */
	public String getCodeZip() {
		return codeZip;
	}

	/**
	 * @param codeZip the codeZip to set
	 */
	public void setCodeZip(String codeZip) {
		this.codeZip = codeZip;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	
}
