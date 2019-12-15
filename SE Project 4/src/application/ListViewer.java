package application;

import java.util.ArrayList;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * New window to be opened by main, displaying list options and taking user interaction
 * @author Micah Weiberg
 * @version 12-15-19
 * Project 4
 */
public class ListViewer extends Stage {
	
	/** Holds the GUI window for a single StringList or NumberList and its commands */
	private GridPane root;
	
	/** List/Window title set by user in Main */
	private String listTitle;
	
	/** Display area for selected List */
	private TextArea ta;
	
	/** Dialog box for entering a new element to List */
	private TextInputDialog dialog;
	
	/** Button for a List's concrete commands */
	private Button button;
	
	/** List of concrete commands to be executed by user */
	private ArrayList<MenuItem> menuOptions;
	
	/** List of concrete command to print the List */
	private ArrayList<MenuItem> refreshList;
	
	/** Row to add to GridPane */
	private static int row = 1;
	
	/**
	 * Constructor
	 * @param listTitle List/Window title
	 */
	public ListViewer(String listTitle) {
		this.listTitle = listTitle;
	}
	
	/**
	 * Adds incoming new MenuItem elements to existing menuOptions ArrayList
	 * @param newOptions ArrayList of MenuItems to add to menuOptions
	 */
	public void addMenuOptions(ArrayList<MenuItem> newOptions) {
		this.menuOptions = new ArrayList<MenuItem>();
		this.refreshList = new ArrayList<MenuItem>();
		for (int i = 0; i < newOptions.size(); i++) {
			if (i == 1) {
				refreshList.add(newOptions.get(i)); // add PrintList command to refreshList
			} else {
				menuOptions.add(newOptions.get(i)); // add other commands to menuOptions
			}
		}
	}
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle(listTitle);
		try {
			root = new GridPane();
			root.setPadding(new Insets(5, 5, 5, 5));
			Scene scene = new Scene(root, 400, 400);
			
			ta = new TextArea();
			ta.setEditable(false);
			root.add(ta, 0, 0);
			
			for (int i = 0; i < menuOptions.size(); i++) {
				final int index = i; // set index to final int
				button = new Button(menuOptions.get(i).toString()); // button displays command's toString
				
				// if instructions() is not empty, open dialog box for entering element
				if (!menuOptions.get(index).instructions().isEmpty()) {					
					button.setOnAction(e -> 
					{
						dialog = new TextInputDialog(); // open new Dialog box
						dialog.setContentText(menuOptions.get(index).promptElement());
						
						try {
							Optional<String> result = dialog.showAndWait();
							// result of dialog entry is entered as element
							result.ifPresent(input -> menuOptions.get(index).enterElement(input));
							executeCommand(index); // execute command & display List
						} catch (Exception e1) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setTitle("Error");
							alert.setContentText(e1.getMessage());
							alert.showAndWait();
						}
					});
					root.add(button, 0, row);
					row += 1;

				} else {
					button.setOnAction(e -> {
						executeCommand(index); // execute command & display List
					});
					root.add(button, 0, row);
				}
				row += 1;
			}
			
			primaryStage.setTitle(listTitle);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	/**
	 * Executes a concrete command and displays the List to the TextArea
	 * @param index Command to be executed
	 */
	private void executeCommand(final int index) {
		try {
			ta.setText(menuOptions.get(index).execute()); // execute command
			ta.appendText("\n" + refreshList.get(0).execute()); // display List
		} catch (Exception e1) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		}
	}
}