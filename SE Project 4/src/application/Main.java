package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Main class, acting as the driver for the GUI and project as a whole
 * @author Micah Weiberg
 * @version 12-11-19
 *
 */
public class Main extends Application {
	
	private StringList stringList;
	private NumberList numberList;
	private Label info;
	private TextField tf;
	private Button addSL;
	private Button addNL;
	
	@Override
	public void start(Stage primaryStage) {
		stringList = new StringList(new ArrayList<String>(), "words", "String");
		numberList = new NumberList(new ArrayList<Number>(), "numbers", "Number");
		ListViewer lvString = new ListViewer();
		ListViewer lvNumber = new ListViewer();
		
		stringList.addPropertyChangeListener(lvString);
		numberList.addPropertyChangeListener(lvNumber);
		
		try {
			GridPane root = new GridPane();
			root.setPadding(new Insets(5, 5, 5, 5));
			Scene scene = new Scene(root, 400, 400);
			
			primaryStage.setTitle("String and Number List Menu");
			info = new Label("Click the respective buttons to generate a new String "
					+ "or Number List. Creating a new list will generate a new window "
					+ "revealing their corresponding actions, allowing one to edit the "
					+ "list in various ways.\nName the new list using the text field below.\n");
			info.setFont(Font.font(14));
			info.setWrapText(true);
			info.setPadding(new Insets(5, 5, 5, 5));
			root.add(info, 0, 0);
			
			tf = new TextField();
			
			tf.setDisable(false);
			root.add(tf, 0, 1);
			
			addSL = new Button("Add String List");
			addSL.setOnAction(e -> {
				try {
//					if (tf.getText().isEmpty()) {
//						throw new Exception("New list must have a name");
//					}
					lvString.setTitle(tf.getText());
					AddNewList yooo = new AddNewList(lvString, "String");
					yooo.execute();
					lvString.start(new Stage());
				} catch (Exception e1) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText(e1.getMessage());
					alert.showAndWait();
				}
			});
			root.add(addSL, 0, 2);
			addNL = new Button("Add Number List");
			addNL.setOnMouseClicked(e -> {
				try {
//					if (tf.getText().isEmpty()) {
//						throw new Exception("New list must have a name");
//					}
					lvNumber.setTitle(tf.getText());
					AddNewList yooo = new AddNewList(lvNumber, "Number");
					yooo.execute();
					lvNumber.start(new Stage());
				} catch (Exception e1) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText(e1.getMessage());
					alert.showAndWait();
				}
			});
			root.add(addNL, 0, 3);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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