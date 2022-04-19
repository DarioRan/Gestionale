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

public class OrdiniController {
	
	
	 @FXML TableView<Ordine> OrdiniTable;
	 @FXML TextField OrdineText;
	 @FXML Label TotaleLabel;
	 Stage stage=null;
	 float Totale=0;
	 
	
	public void Inizio() 
	{
		
		TableColumn<Ordine, String> CodOrdine =new TableColumn<>("CodOrdine");
		CodOrdine.setCellValueFactory(new PropertyValueFactory<>("CodOrdine"));
		 
		 TableColumn<Ordine, String> Utente =new TableColumn<>("Utente");
		 Utente.setCellValueFactory(new PropertyValueFactory<>("Utente"));
		 
		 TableColumn<Ordine, String> Pagamento =new TableColumn<>("Pagamento");
		 Pagamento.setCellValueFactory(new PropertyValueFactory<>("Pagamento"));
		 
		 TableColumn<Ordine, String> Importo =new TableColumn<>("Importo");
		 Importo.setCellValueFactory(new PropertyValueFactory<>("Importo"));
		 
		 TableColumn<Ordine, String> Data =new TableColumn<>("Data");
		 Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
		 

		 //Aggiustare colonne e fare classe Acquisto
		 OrdiniTable.getColumns().clear();
		 OrdiniTable.getColumns().addAll(CodOrdine, Utente, Pagamento, Importo, Data);
		 
		
		AggiornaOrdini();
		


	}
	
	public void AggiornaOrdini() 
	{
		
		QueryManager q=new QueryManager();
		ObservableList<Ordine> ordini= FXCollections.observableArrayList();
		String[] Chiavi={"CodOrdine","Utente","Importo","Pagamento","Data"};
		ArrayList<String[]> Risultato = null;
		try {
			Risultato=q.Query("SELECT * FROM Ordini", Chiavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		for(int i=0;i<Risultato.size();i++) 
		{	
			String[] ord=new String[Risultato.get(i).length];
			for(int j=0; j<Risultato.get(i).length; j++) 
			{
				
				ord[j]=Risultato.get(i)[j];
			}
			Ordine ordine=new Ordine(ord);
			ordini.add(ordine);
			Totale+=Float.valueOf(ordine.getImporto());
			
			
		}
		TotaleLabel.setText(String.valueOf(Totale));
		OrdiniTable.setItems(ordini);
		
		 
	      
	}
	
	public void ViusalizzaOrdine() throws IOException 
	{
		Stage primaryStage= new Stage();
		FXMLLoader fxmlloaderAC= new FXMLLoader(getClass().getResource("Acquisti.fxml"));
		Pane root = (Pane)fxmlloaderAC.load();
		Scene scene = new Scene(root,680,540);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		AcquistiController ac=fxmlloaderAC.getController();
		ac.CodOrdine=OrdineText.getText();
		ac.Inizio();
		
		
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
	
	
	
	
	
		
	
	
	
}
