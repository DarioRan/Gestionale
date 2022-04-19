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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RichiesteController {
	
	
	 @FXML TableView<Richiesta> RichiesteTable;
	 @FXML TextField CodRichiesta;
	 @FXML Button IndietroBt;
	 Stage stage=null;
	 ObservableList<Richiesta> richieste= FXCollections.observableArrayList();
	 
	 
	
	public void Inizio() 
	{
		
		TableColumn<Richiesta, String> CodRichiesta =new TableColumn<>("CodRichiesta");
		CodRichiesta.setCellValueFactory(new PropertyValueFactory<>("CodRichiesta"));
		 
		 TableColumn<Richiesta, String> Utente =new TableColumn<>("Utente");
		 Utente.setCellValueFactory(new PropertyValueFactory<>("Utente"));
		 
		 TableColumn<Richiesta, String> Prodotto =new TableColumn<>("Prodotto");
		 Prodotto.setCellValueFactory(new PropertyValueFactory<>("Prodotto"));
		 
		 TableColumn<Richiesta, String> Motivo =new TableColumn<>("Motivo");
		 Motivo.setCellValueFactory(new PropertyValueFactory<>("Motivo"));
		 
		 TableColumn<Richiesta, String> Descrizione =new TableColumn<>("Descrizione");
		 Descrizione.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));
		 
		 TableColumn<Richiesta, String> Data =new TableColumn<>("Data");
		 Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
		 
		 

		 //Aggiustare colonne e fare classe Acquisto
		 RichiesteTable.getColumns().clear();
		 RichiesteTable.getColumns().addAll(CodRichiesta, Utente, Prodotto, Motivo, Descrizione);
		 
		
		AggiornaRichieste();
		


	}
	
	public void AggiornaRichieste() 
	{
		
		QueryManager q=new QueryManager();
		String[] Chiavi={"CodRichiesta","Utente","Prodotto","Motivo","Descrizione", "Data"};
		ArrayList<String[]> Risultato = null;
		try {
			Risultato=q.Query("SELECT CodRichiesta, Utente, Nome AS Prodotto, Motivo, Richieste.Descrizione, Data FROM (richieste INNER JOIN prodotti ON richieste.codprodotto=prodotti.codprodotto)", Chiavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		for(int i=0;i<Risultato.size();i++) 
		{	
			String[] ric=new String[Risultato.get(i).length];
			for(int j=0; j<Risultato.get(i).length; j++) 
			{
				
				ric[j]=Risultato.get(i)[j];
			}
			Richiesta richiesta=new Richiesta(ric);
			richieste.add(richiesta);
			
			
			
		}
		
		RichiesteTable.setItems(richieste);
		
		 
	      
	}
	
	public void Indietro() throws IOException 
	{
		FXMLLoader fxmlloaderPP= new FXMLLoader(getClass().getResource("PagPrincipale.fxml"));
		Pane root = (Pane)fxmlloaderPP.load();
		Scene scene = new Scene(root,670,350);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		PPrincipaleController ppc=fxmlloaderPP.getController();
		ppc.stage=stage;
	}
	
	
	public void Visualizza() throws IOException 
	{
		String CodR=CodRichiesta.getText();
		
		FXMLLoader fxmlloaderRC2= new FXMLLoader(getClass().getResource("Richieste2.fxml"));
		Pane root = (Pane)fxmlloaderRC2.load();
		Scene scene = new Scene(root,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		RichiesteController2 RC2=fxmlloaderRC2.getController();
		RC2.stage=stage;
		RC2.CodRichiesta=CodR;
		RC2.Inizio();
		
	}
	
	
	
	
	
	
	
		
	
	
	
}
