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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PPrincipaleController {
	
	
	@FXML Button MagazzinoBt;
	public Stage stage;
	
	
	
	
	public void Magazzino() throws IOException {
		FXMLLoader fxmlloaderMC= new FXMLLoader(getClass().getResource("Magazzino.fxml"));
		Pane root = (Pane)fxmlloaderMC.load();
		Scene scene = new Scene(root,750,540);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		MagazzinoController mc=fxmlloaderMC.getController();
		mc.stage=stage;
		mc.Inizio();
	}
	
	public void Ordini() throws IOException {
		FXMLLoader fxmlloaderOC= new FXMLLoader(getClass().getResource("Ordini.fxml"));
		Pane root = (Pane)fxmlloaderOC.load();
		Scene scene = new Scene(root,670,540);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		OrdiniController oc=fxmlloaderOC.getController();
		oc.stage=stage;
		oc.Inizio();
	}
	
	public void Richieste() throws IOException {
		FXMLLoader fxmlloaderRC= new FXMLLoader(getClass().getResource("Richieste.fxml"));
		Pane root = (Pane)fxmlloaderRC.load();
		Scene scene = new Scene(root,790,540);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		RichiesteController rc=fxmlloaderRC.getController();
		rc.stage=stage;
		rc.Inizio();
	}
	
	
	
	
	
}
