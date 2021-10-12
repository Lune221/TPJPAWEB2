package ept.dic2.tpjpaweb2.facades;

import java.util.ArrayList;

import javax.ejb.Remote;

import ept.dic2.tpjpaweb2.entities.Article;
import ept.dic2.tpjpaweb2.entities.Marque;


@Remote
public interface MarqueSessionBean{
	
	public ArrayList<Marque> findAll();
	
	public Marque findOne(Marque element);
	
	public boolean deleteOne(Marque element);
	
	public boolean updateOne(Marque element);
}
