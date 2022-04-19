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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ModificaProdController {
	
	
	@FXML TextField NomeText, QuantitaText, PrezzoText, ScontatoText, ImmagineText, CategoriaText;
	@FXML TextArea DescText;
	public Stage stage;
	public MagazzinoController MC;
	public String CodProd;
	
	public void Inizialize() 
	{
		QueryManager q=new QueryManager();
		String[] Chiavi={"CodProdotto","Nome","Descrizione","Quantita","Prezzo", "Scontato", "Immagine", "Categoria"};
		ArrayList<String[]> Risultato = null;
		try {
			Risultato=q.Query("SELECT * FROM Prodotti WHERE CodProdotto="+CodProd, Chiavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NomeText.setText(Risultato.get(0)[1]);
		DescText.setText(Risultato.get(0)[2]);
		QuantitaText.setText(Risultato.get(0)[3]);
		PrezzoText.setText(Risultato.get(0)[4]);
		ScontatoText.setText(Risultato.get(0)[5]);
		ImmagineText.setText(Risultato.get(0)[6]);
		CategoriaText.setText(Risultato.get(0)[7]);
		
		
		
	}
	
	public void ModificaBt() throws IOException 
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
		System.out.println(Scontato);
		//qm.Query("DELETE FROM Prodotti WHERE CodProdotto="+CodProd);
		
		if(Scontato!=null) 
		{
			String query="UPDATE PRODOTTI SET Quantita="+Quantita+", Prezzo="+Prezzo+", Scontato="+Scontato+", Immagine='"+Immagine+"' , Categoria='"+Categoria+"' WHERE CodProdotto="+CodProd;
			/*String query="INSERT INTO Prodotti (CodProdotto,Nome, Descrizione ,Quantita, Prezzo, Scontato, Immagine, Categoria) VALUES ("+"'"+CodProd+"',"+"'"+Nome+"',"+"'"+Desc+"',"+"'"+Quantita+"',"
					+""+Float.valueOf(Prezzo)+","+"'"+Float.valueOf(Scontato)+"',"+"'"+Immagine+"',"+"'"+Categoria+"')";
			System.out.println(query);*/
			result=qm.Query(query);
		}
		else 
		{
			String query="UPDATE PRODOTTI SET Quantita="+Quantita+", Prezzo="+Prezzo+", Immagine='"+Immagine+"' , Categoria='"+Categoria+"' WHERE CodProdotto="+CodProd;
			/*String query="INSERT INTO Prodotti (CodProdotto ,Nome, Descrizione ,Quantita, Prezzo, Immagine, Categoria) VALUES ("+"'"+CodProd+"',"+"'"+Nome+"',"+"'"+Desc+"',"+"'"+Quantita+"',"
					+""+Float.valueOf(Prezzo)+","+"'"+Immagine+"',"+"'"+Categoria+"')";*/
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
