package ept.dic2.tpjpaweb2.facades;

import java.util.ArrayList;

import javax.ejb.Remote;

import ept.dic2.tpjpaweb2.entities.Article;


@Remote
public interface ArticleSessionBean{
	
	public ArrayList<Article> findAll();
	
	public Article findOne(Article element);
	
	public boolean deleteOne(Article element);
	
	public boolean updateOne(Article element);
}
