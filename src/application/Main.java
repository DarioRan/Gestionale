package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlloaderPP= new FXMLLoader(getClass().getResource("PagPrincipale.fxml"));
			Pane root = (Pane)fxmlloaderPP.load();
			Scene scene = new Scene(root,670,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			PPrincipaleController ppc=fxmlloaderPP.getController();
			ppc.stage=primaryStage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
