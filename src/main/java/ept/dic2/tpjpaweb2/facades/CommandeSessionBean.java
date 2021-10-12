package ept.dic2.tpjpaweb2.facades;

import java.util.ArrayList;

import javax.ejb.Remote;

import ept.dic2.tpjpaweb2.entities.Article;
import ept.dic2.tpjpaweb2.entities.Commande;


@Remote
public interface CommandeSessionBean{
	
	public ArrayList<Commande> findAll();
	
	public Commande findOne(Commande element);
	
	public boolean deleteOne(Commande element);
	
	public boolean updateOne(Commande element);
}
