package ept.dic2.tpjpaweb2.facades;

import java.util.ArrayList;

import javax.ejb.Remote;

import ept.dic2.tpjpaweb2.entities.Vendeur;


@Remote
public interface VendeurSessionBean {
	
	public ArrayList<Vendeur> findAll();
	
	public Vendeur findOne(Vendeur element);
	
	public boolean deleteOne(Vendeur element);
	
	public boolean updateOne(Vendeur element);
}
