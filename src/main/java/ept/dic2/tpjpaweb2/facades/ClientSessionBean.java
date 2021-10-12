package ept.dic2.tpjpaweb2.facades;

import java.util.ArrayList;

import javax.ejb.Remote;

import ept.dic2.tpjpaweb2.entities.Article;
import ept.dic2.tpjpaweb2.entities.Client;


@Remote
public interface ClientSessionBean{
	
	public ArrayList<Client> findAll();
	
	public Client findOne(Client element);
	
	public boolean deleteOne(Client element);
	
	public boolean updateOne(Client element);
}
