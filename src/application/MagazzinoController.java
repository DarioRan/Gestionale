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

public class MagazzinoController {
	
	
	 @FXML TableView<Prodotto> ProdottiTable;
	 @FXML TextField CodEliminaText,CodProdText;
	// @FXML ChoiceBox<String> CodBox,CodBox2;
	 public Stage stage=null;
	 
	 
	
	public void Inizio() 
	{
		
		
		TableColumn<Prodotto, String> CodProd =new TableColumn<>("CodProd");
		 CodProd.setCellValueFactory(new PropertyValueFactory<>("CodProd"));
		 
		 TableColumn<Prodotto, String> Nome =new TableColumn("Nome");
		 Nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		 
		 TableColumn<Prodotto, String> Desc =new TableColumn("Desc");
		 Desc.setCellValueFactory(new PropertyValueFactory<>("Desc"));
		 
		 TableColumn<Prodotto, String> Quantita =new TableColumn("Quant");
		 Quantita.setCellValueFactory(new PropertyValueFactory<>("Quant"));
		 
		 TableColumn<Prodotto, String> Prezzo =new TableColumn("Prezzo");
		 Prezzo.setCellValueFactory(new PropertyValueFactory<>("Prezzo"));
		 
		 TableColumn<Prodotto, String> Scontato =new TableColumn("Scontato");
		 Scontato.setCellValueFactory(new PropertyValueFactory<>("Scontato"));
		 
		 TableColumn<Prodotto, String> Immagine =new TableColumn("Immagine");
		 Immagine.setCellValueFactory(new PropertyValueFactory<>("Immagine"));
		 
		 TableColumn<Prodotto, String> Categoria =new TableColumn("Categoria");
		 Categoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
		 
		 ProdottiTable.getColumns().clear();
		 ProdottiTable.getColumns().addAll(CodProd, Nome, Desc, Quantita,Prezzo, Scontato, Immagine, Categoria);
		 
		
		AggiornaMagazzino();
		


	}
	
	public void AggiornaMagazzino() 
	{
		ObservableList<String> CodProd=FXCollections.observableArrayList();
		QueryManager q=new QueryManager();
		ObservableList<Prodotto> prodotti= FXCollections.observableArrayList();
		String[] Chiavi={"CodProdotto","Nome","Descrizione","Quantita","Prezzo", "Scontato", "Immagine", "Categoria"};
		ArrayList<String[]> Risultato = null;
		try {
			Risultato=q.Query("SELECT * FROM Prodotti", Chiavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		for(int i=0;i<Risultato.size();i++) 
		{	
			String[] prod=new String[Risultato.get(i).length];
			for(int j=0; j<Risultato.get(i).length; j++) 
			{
				
				prod[j]=Risultato.get(i)[j];
			}
			CodProd.add((String)Risultato.get(i)[0]);
			//System.out.println(Risultato.get(i)[7]);
			Prodotto prodotto=new Prodotto(prod);
			prodotti.add(prodotto);
			
			
			
		}
		//CodBox2.setItems(CodProd);
	//	CodBox.setItems(CodProd);
		 ProdottiTable.setItems(prodotti);
		 
	      
	}
	
	public void AggiungiProd() throws IOException 
	{
		Stage primaryStage=new Stage();
		FXMLLoader fxmlloaderAP= new FXMLLoader(getClass().getResource("AggiungiProd.fxml"));
		Pane root = (Pane)fxmlloaderAP.load();
		Scene scene = new Scene(root,700,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		AggiungiProdController APC=fxmlloaderAP.getController();
		APC.stage=primaryStage;
		APC.MC=this;
		
		//AggiungiProdController mc=fxmlloaderMC.getController();
	}
	
	
	public void EliminaProd() 
	{
		QueryManager q=new QueryManager();
		String CodProd=CodEliminaText.getText();
		String query="DELETE FROM Prodotti WHERE CodProdotto="+ CodProd;
		q.Query(query);
		Inizio();
	}
	
	public void ModificaProd() throws IOException 
	{
		String CodProd=CodProdText.getText();
		Stage primaryStage=new Stage();
		FXMLLoader fxmlloaderMP= new FXMLLoader(getClass().getResource("ModificaProd.fxml"));
		Pane root = (Pane)fxmlloaderMP.load();
		ModificaProdController MPC=fxmlloaderMP.getController();
		MPC.stage=primaryStage;
		MPC.MC=this;
		MPC.CodProd=CodProd;
		Scene scene = new Scene(root,700,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		MPC.Inizialize();
		
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
