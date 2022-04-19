package application;

import javafx.beans.property.SimpleStringProperty;

public class Prodotto {

	 SimpleStringProperty Nome, CodProd, Desc, Quant, Prezzo, Scontato, Immagine, Categoria;
	
	public Prodotto(String n, String cp, String desc, String q, String pr, String Scon, String Imm, String Cat) 
	{
		Nome=new SimpleStringProperty(n);
		CodProd=new SimpleStringProperty(cp);
		Desc=new SimpleStringProperty (desc);
		Quant=new SimpleStringProperty (q);
		Prezzo=new SimpleStringProperty(pr);
		Scontato=new SimpleStringProperty(Scon);
		Immagine=new SimpleStringProperty(Imm);
		Categoria=new SimpleStringProperty(Cat);
	}
	public Prodotto(String[] n) 
	{
		CodProd=new SimpleStringProperty(n[0]);
		Nome=new SimpleStringProperty(n[1]);
		Desc=new SimpleStringProperty(n[2]);
		Quant=new SimpleStringProperty(n[3]);
		Prezzo=new SimpleStringProperty(n[4]);
		Scontato=new SimpleStringProperty(n[5]);
		Immagine=new SimpleStringProperty(n[6]);
		Categoria=new SimpleStringProperty(n[7]);
	}
	
	public String getCodProd()
	{
		return CodProd.get();
	}
	
	public String getNome()
	{
		return Nome.get();
	}
	
	public String getDesc()
	{
		return Desc.get();
	}
	public String getQuant()
	{
		return Quant.get();
	}
	
	public String getPrezzo()
	{
		return Prezzo.get();
	}
	
	public String getScontato()
	{
		return Scontato.get();
	}
	
	public String getImmagine()
	{
		return Immagine.get();
	}
	public String getCategoria()
	{
		return Categoria.get();
	}
	
}
