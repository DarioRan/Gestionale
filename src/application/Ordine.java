package application;

import java.sql.Date;

import javafx.beans.property.SimpleStringProperty;

public class Ordine {
	
	SimpleStringProperty CodOrdine, Utente, Pagamento, Importo, Data;
	
	
	public Ordine (String xco, String xu, String xI, String xp, String xd) 
	{
		CodOrdine= new SimpleStringProperty(xco);
		Utente=new SimpleStringProperty(xu);
		Importo= new SimpleStringProperty(xI);
		Pagamento=new SimpleStringProperty(xp);
		Data=new SimpleStringProperty(xd);
	}
	
	public Ordine(String[] n) 
	{
		CodOrdine= new SimpleStringProperty(n[0]);
		Utente=new SimpleStringProperty(n[1]);
		Importo= new SimpleStringProperty(n[2]);
		Pagamento=new SimpleStringProperty(n[3]);
		Data=new SimpleStringProperty(n[4]);
		
	}
	
	public String getCodOrdine()
	{
		return CodOrdine.get();
	}
	
	public String getUtente()
	{
		return Utente.get();
	}
	public String getImporto()
	{
		return Importo.get();
	}
	public String getData()
	{
		return Data.get();
	}
	public String getPagamento()
	{
		return Pagamento.get();
	}
	

}
