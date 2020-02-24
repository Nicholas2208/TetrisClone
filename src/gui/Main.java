package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		URL location = getClass().getClassLoader().getResource("gameLayout.fxml");
		ResourceBundle resource = null;
		FXMLLoader fxmlLoader = new FXMLLoader(location, resource);
		Parent root = fxmlLoader.load();
		GuiController c = fxmlLoader.getController();
		
		primaryStage.setTitle("TetrisFX");
		Scene scene = new Scene(root, 400, 510);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new GameController(c);
	}

}
