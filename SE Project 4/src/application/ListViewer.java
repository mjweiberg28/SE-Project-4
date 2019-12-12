package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/* consists of display area that shows a single String
 * or Number List, and buttons representing the
 * commands associated w/ that list
 * (commands now triggered by buttons)
 * 
 * don't want special case code that treats
 * 2 diff types of lists differently
 * since they have unified interface, treat them
 * as just a list rather than a NumberList or
 * StringList as much as possible
 */
public class ListViewer extends Stage implements PropertyChangeListener {
	
	private GridPane root;
	private String listTitle;
	private TextArea ta;
	private ArrayList<Button> buttons;
	private ArrayList<MenuItem> menuOptions;
	
	public ListViewer(String listTitle) {
		this.listTitle = listTitle;
	}
	
	/**
	 * Adds incoming new MenuItem elements to existing menuOptions ArrayList
	 * @param newOptions ArrayList of MenuItems to add to menuOptions
	 */
	public void addMenuOptions(ArrayList<MenuItem> newOptions) {
		for (int i = 0; i < newOptions.size(); i++) {
			menuOptions.add(newOptions.get(i));
		}
	}
	
	public void start(Stage primaryStage) {
		root = new GridPane();
		root.setPadding(new Insets(5, 5, 5, 5));
		Scene scene = new Scene(root, 400, 400);
		
		for (int i = 0; i < menuOptions.size(); i++) {
			final int yeet = i;
			Button button = new Button(menuOptions.get(i).toString());
			button.setOnAction(e -> menuOptions.get(yeet).execute());
			root.add(button, 0, i + 1);
		}
		
		primaryStage.setTitle(listTitle);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		ta.setText("yeet");
	}
}