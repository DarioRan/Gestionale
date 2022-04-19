package application;

import javafx.beans.property.SimpleStringProperty;

public class Richiesta {
	
	SimpleStringProperty CodRichiesta,Utente,Prodotto, Motivo, Descrizione, Data;
	
	public Richiesta(String xcr, String xm, String xd, String xDate, String xU, String xP) 
	{
		CodRichiesta=new SimpleStringProperty(xcr);
		Utente=new SimpleStringProperty(xU);
		Prodotto=new SimpleStringProperty(xP);
		Motivo=new SimpleStringProperty(xm);
		Descrizione=new SimpleStringProperty(xd);
		Data=new SimpleStringProperty(xDate);
		
	}
	
	public Richiesta(String[] n) 
	{

		CodRichiesta=new SimpleStringProperty(n[0]);
		Utente=new SimpleStringProperty(n[1]);
		Prodotto=new SimpleStringProperty(n[2]);
		Motivo=new SimpleStringProperty(n[3]);
		Descrizione=new SimpleStringProperty(n[4]);
		Data=new SimpleStringProperty(n[5]);
	}
	
	public String getCodRichiesta() 
	{
		return CodRichiesta.getValue();
	}
	
	public String getUtente() 
	{
		return Utente.getValue();
	}
	public String getProdotto() 
	{
		return Prodotto.getValue();
	}
	public String getMotivo() 
	{
		return Motivo.getValue();
	}
	public String getDescrizione() 
	{
		return Descrizione.getValue();
	}
	public String getData() 
	{
		return Data.getValue();
	}

}
