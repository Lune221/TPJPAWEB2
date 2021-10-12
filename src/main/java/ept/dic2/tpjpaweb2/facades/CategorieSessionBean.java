package ept.dic2.tpjpaweb2.facades;

import java.util.ArrayList;

import javax.ejb.Remote;

import ept.dic2.tpjpaweb2.entities.Article;
import ept.dic2.tpjpaweb2.entities.Categorie;


@Remote
public interface CategorieSessionBean{
	
	public ArrayList<Categorie> findAll();
	
	public Categorie findOne(Categorie element);
	
	public boolean deleteOne(Categorie element);
	
	public boolean updateOne(Categorie element);
}
