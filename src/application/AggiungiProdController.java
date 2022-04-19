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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AggiungiProdController {
	
	
	@FXML TextField NomeText, QuantitaText, PrezzoText, ScontatoText, ImmagineText, CategoriaText;
	@FXML TextArea DescText;
	@FXML Label ErrLabel;
	public Stage stage;
	public MagazzinoController MC;
	
	
	
	public void AggiungiBt() throws IOException 
	{
		String Nome= NomeText.getText();
		String Quantita=QuantitaText.getText();
		String Prezzo=PrezzoText.getText();
		String Scontato=ScontatoText.getText();
		String Immagine=ImmagineText.getText();
		String Categoria=CategoriaText.getText();
		String Desc= DescText.getText();
		Boolean result=false;
		QueryManager qm= new QueryManager();
		
		if(Desc.indexOf("'")!=-1) 
		{
			//Desc.charAt(Desc.indexOf("'"));
			Desc.replace("'", "\'");
		}
		
		if(Nome.isEmpty() || Desc.isEmpty() || Quantita.isEmpty() || Prezzo.isEmpty() || Categoria.isEmpty()) 
		{
			ErrLabel.setVisible(true);
		}
		else 
		{
			Desc='"'+Desc+'"';
			Nome='"'+Nome+'"';
			
			if(!Scontato.isEmpty()) 
			{
				if(Float.valueOf(Scontato)<Float.valueOf(Prezzo)) {
				String query="INSERT INTO Prodotti (Nome, Descrizione ,Quantita, Prezzo, Scontato, Immagine, Categoria) VALUES ("+Nome+","+Desc+","+"'"+Quantita+"',"
						+""+Float.valueOf(Prezzo)+","+"'"+Float.valueOf(Scontato)+"',"+"'"+Immagine+"',"+"'"+Categoria+"')";
				System.out.println(query);
				result=qm.Query(query);}
				else 
				{ErrLabel.setVisible(true); result=true;}
			}
			else 
			{
				String query="INSERT INTO Prodotti (Nome, Descrizione ,Quantita, Prezzo, Immagine, Categoria) VALUES ("+Nome+","+Desc+","+"'"+Quantita+"',"
						+""+Float.valueOf(Prezzo)+","+"'"+Immagine+"',"+"'"+Categoria+"')";
				System.out.println(query);
				result=qm.Query(query);
			}

			if(!result) 
			{
				MC.AggiornaMagazzino();
				stage.close();
			}
			else 
			{
				System.out.println("Errore");
			}
		}
		
		
		
		
	
	}
		
	
	
	
}
