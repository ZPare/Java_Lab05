package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//Viewing the BookstoreDB window
			Parent root =FXMLLoader.load(getClass().getResource("BookstoreDB.fxml"));  // Here it must be name of fxml document you created and added
			Scene scene = new Scene(root,450,350);                                    // WelcomeApp.fxml file should be added under the package-application
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		

	}
	
}
