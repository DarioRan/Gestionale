package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AcquistiController {
	
	
	 @FXML TableView<Acquisto> AcquistiTable;
	 String CodOrdine;
	
	 
	 
	
	public void Inizio() 
	{
		
		TableColumn<Acquisto, String> CodOrdine =new TableColumn<>("CodOrdine");
		CodOrdine.setCellValueFactory(new PropertyValueFactory<>("CodOrdine"));
		 
		 TableColumn<Acquisto, String> Prod =new TableColumn<>("Prodotto");
		 Prod.setCellValueFactory(new PropertyValueFactory<>("Prodotto"));
		 
		 TableColumn<Acquisto, String> Quantita =new TableColumn<>("Quantita");
		 Quantita.setCellValueFactory(new PropertyValueFactory<>("Quantita"));
		 
		 TableColumn<Acquisto, String> Prezzo =new TableColumn<>("Prezzo");
		 Prezzo.setCellValueFactory(new PropertyValueFactory<>("Prezzo"));
		 
			 

		 //Aggiustare colonne e fare classe Acquisto
		 AcquistiTable.getColumns().clear();
		 AcquistiTable.getColumns().addAll( CodOrdine, Prod, Quantita, Prezzo);
		 
		
		AggiornaAcquisti();
		


	}
	
	public void AggiornaAcquisti() 
	{
		System.out.println(CodOrdine);
		
		QueryManager q=new QueryManager();
		ObservableList<Acquisto> Acquisti= FXCollections.observableArrayList();
		String[] Chiavi={"CodOrdine","Prodotto","Quantita","Prezzo"};
		ArrayList<String[]> Risultato = null;
		try {
			Risultato=q.Query("SELECT CodOrdine, Prodotti.Nome as Prodotto, Acquisti.Quantita as Quantita, Acquisti.Prezzo as Prezzo FROM (Acquisti INNER JOIN PRODOTTI on Acquisti.CodProdotto=Prodotti.CodProdotto ) WHERE CodOrdine='"+CodOrdine+"'", Chiavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		for(int i=0;i<Risultato.size();i++) 
		{	
			String[] acq=new String[Risultato.get(i).length];
			for(int j=0; j<Risultato.get(i).length; j++) 
			{
				
				acq[j]=Risultato.get(i)[j];
			}
			Acquisto acquisto=new Acquisto(acq);
			Acquisti.add(acquisto);
			
			
			
		}
		
		AcquistiTable.setItems(Acquisti);
		
		 
	      
	}
	
	
	
	
	
		
	
	
	
}
