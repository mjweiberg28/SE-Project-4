package application;

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
 * @version 12-15-19
 * Project 4
 */
public class Main extends Application {
	
	/** Information label giving instructions to the user */
	private Label info;
	
	/** TextField for naming the new List */
	private TextField tf;
	
	/** Button for adding a new StringList */
	private Button addSL;
	
	/** Button for adding a new NumberList */
	private Button addNL;
	
	/** ListViewer object for new List window */
	private ListViewer lv;
	
	@Override
	public void start(Stage primaryStage) {
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
				newWindow("String");
			});
			root.add(addSL, 0, 2);
			
			addNL = new Button("Add Number List");
			addNL.setOnMouseClicked(e -> {
				newWindow("Number");
			});
			root.add(addNL, 0, 3);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	/**
	 * Creates a new Stage window for the specified list type
	 * @param listType String or Number
	 */
	private void newWindow(String listType) {
		try {
			if (tf.getText().isEmpty()) {
				throw new Exception("New list must have a name");
			}
			lv = new ListViewer(tf.getText()); // create new ListViewer
			tf.clear();
			AddNewList newList = new AddNewList(lv, listType);
			newList.execute();
			lv.start(new Stage());
		} catch (Exception e1) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}