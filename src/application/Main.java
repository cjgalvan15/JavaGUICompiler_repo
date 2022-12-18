package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			Image icon = new Image("/Mini-compiler_logo.PNG");
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			String css = this.getClass().getResource("application.css").toExternalForm();			
			primaryStage.setTitle("MINI-COMPILER");
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setResizable(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);	
	}
}
