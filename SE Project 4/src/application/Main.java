package application;
	
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Main extends Application implements PropertyChangeListener, EventHandler<ActionEvent> {

	private Label info;
	private TextField tf;
	private AddNewList stringList;
	private AddNewList numberList;
	private Button addSL;
	private Button addNL;
	private ListViewer lv;
	private GridPane root;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			root = new GridPane();
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
			addSL.setOnMouseClicked(e -> {
				try {
					generateWindow("String", "title");
				} catch (Exception e1) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText(e1.getMessage());
					alert.showAndWait();
				}
			});
			root.add(addSL, 0, 2);
			addNL = new Button("Add Number List");
			addNL.setOnAction(this);
			addNL.setOnMouseClicked(e -> {
				try {
					generateWindow("Number", "title");
				} catch (Exception e1) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText(e1.getMessage());
					alert.showAndWait();
				}
			});
			root.add(addNL, 0, 3);

			// TODO: set contents of tf to ListViewer title when button is clicked to add new list
			// TODO: When add new list button clicked, create ListViewer(type) as separate window
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ListViewer generateWindow(String listType, String listTitle) {
		ListViewer lv = new ListViewer(listTitle);
		AddNewList nL = new AddNewList(lv, listType);
		//lv.handle(event);
		return lv;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void handle(ActionEvent event) {
		if (event.getSource() == addSL) {
			generateWindow("String", "title");
		} else if (event.getSource() == addNL) {
			generateWindow("Number", "title");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == "newList") {
			
		}
	}
}
