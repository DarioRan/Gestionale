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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RichiesteController2 {
	
	
	 Richiesta Richiesta;
	 String CodRichiesta;
	 Stage stage=null;
	 @FXML Button IndietroBt;
	 @FXML TextArea DescrizioneText, CorpoText;
	 @FXML TextField OggettoText;
	 Richiesta richiesta;
	 
	
	public void Inizio() 
	{
		
		QueryManager q=new QueryManager();
		String[] Chiavi={"CodRichiesta","Utente","Prodotto","Motivo","Descrizione", "Data"};
		ArrayList<String[]> Risultato = null;
		try {
			Risultato=q.Query("SELECT CodRichiesta, Utente, Nome AS Prodotto, Motivo, Richieste.Descrizione, Data FROM (richieste INNER JOIN prodotti ON richieste.codprodotto=prodotti.codprodotto) WHERE CodRichiesta="+CodRichiesta, Chiavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			String[] ric=new String[Risultato.get(0).length];
			for(int j=0; j<Risultato.get(0).length; j++) 
			{
				
				ric[j]=Risultato.get(0)[j];
			}
			richiesta=new Richiesta(ric);
			////////////////////////////////
			DescrizioneText.setText(richiesta.getDescrizione());
			OggettoText.setText("Richiesta su "+richiesta.getProdotto());
			CorpoText.setText("Buongiorno, La contattiamo in merito alla sua richiesta del "+ richiesta.getData()+" su "+richiesta.getProdotto()+", ");
	      
	}
	
	public void Indietro() throws IOException 
	{
		FXMLLoader fxmlloaderRC= new FXMLLoader(getClass().getResource("Richieste.fxml"));
		Pane root = (Pane)fxmlloaderRC.load();
		Scene scene = new Scene(root,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		RichiesteController rc=fxmlloaderRC.getController();
		rc.stage=stage;
		rc.Inizio();
	}
	
	public void Invia() 
	{
		EmailManager em=new EmailManager();
		em.inviaMail(richiesta.getUtente(), OggettoText.getText(),CorpoText.getText());
		//em.inviaMail("ranieri.dario@panettipitagora.edu.it", OggettoText.getText(), CorpoText.getText());
	}
	
	
	
	
	
	
	
	
	
	
		
	
	
	
}
