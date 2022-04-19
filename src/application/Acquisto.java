package application;

import java.sql.Date;

import javafx.beans.property.SimpleStringProperty;

public class Acquisto {
	
	SimpleStringProperty CodOrdine, Prodotto, Quantita, Prezzo;
	
	
	public Acquisto (String xo, String xcp, String xq, String xp) 
	{
		CodOrdine=new SimpleStringProperty(xo);
		Prodotto= new SimpleStringProperty(xcp);
		Quantita= new SimpleStringProperty(xq);
		Prezzo=new SimpleStringProperty(xp);
	}
	
	public Acquisto(String[] n) 
	{
		CodOrdine=new SimpleStringProperty(n[0]);
		Prodotto=new SimpleStringProperty(n[1]);
		Quantita=new SimpleStringProperty(n[2]);
		Prezzo=new SimpleStringProperty(n[3]);
		
		
	}
	
	public String getProdotto()
	{
		return Prodotto.get();
	}
	
	public String getCodOrdine()
	{
		return CodOrdine.get();
	}
	public String getQuantita()
	{
		return Quantita.get();
	}
	public String getPrezzo()
	{
		return Prezzo.get();
	}
	

}
