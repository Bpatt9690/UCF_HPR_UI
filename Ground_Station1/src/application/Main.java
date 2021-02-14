package application;
	
import Interface.GSBackgroundController;
import controllers.ButtonController;
import controllers.DataController;
import controllers.UIController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.scene.image.Image;


public class Main extends Application {

	private static UIController uiController;
	private DataController dataController;
	private GSBackgroundController backgroundController;
	private ButtonController buttonController;
	@FXML private Pane OrientationPane;
	@FXML Rectangle rect;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			Parent root = loader.load();
			
			uiController = (UIController)loader.getController();//in case controller need to be passed
			backgroundController = new GSBackgroundController();
			buttonController = new ButtonController(backgroundController);
			uiController.setBackGroundController(backgroundController);

			backgroundController.addListener(uiController);
			backgroundController.addListener(buttonController);
					
	        primaryStage.setScene(new Scene(root, 865, 448));
	        primaryStage.centerOnScreen();
	        primaryStage.setMaximized(true);
	        primaryStage.show();
	                   
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
