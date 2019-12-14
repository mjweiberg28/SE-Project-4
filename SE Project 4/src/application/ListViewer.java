package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class ListViewer extends Stage implements PropertyChangeListener, EventHandler<ActionEvent> {
	
	private GridPane root;
	private String listTitle;
	private TextArea ta;
	private TextField tf;
	private ArrayList<Button> buttons;
	private ArrayList<MenuItem> menuOptions;
	private ArrayList<MenuItem> bigboi;
	private static int row = 1;
	
	public ListViewer() {
	}
	
	/**
	 * Adds incoming new MenuItem elements to existing menuOptions ArrayList
	 * @param newOptions ArrayList of MenuItems to add to menuOptions
	 */
	public void addMenuOptions(ArrayList<MenuItem> newOptions) {
		this.menuOptions = new ArrayList<MenuItem>();
		this.bigboi = new ArrayList<MenuItem>();
		for (int i = 0; i < newOptions.size(); i++) {
			if (i == 1) {
				bigboi.add(newOptions.get(i));
			} else {
				menuOptions.add(newOptions.get(i));
			}
		}
	}
	
	public void start(Stage primaryStage) {
		try {
			root = new GridPane();
			root.setPadding(new Insets(5, 5, 5, 5));
			Scene scene = new Scene(root, 400, 400);
			ta = new TextArea();
//			ta.setDisable(true);
			root.add(ta, 0, 0);
			for (int i = 0; i < menuOptions.size(); i++) {
				final int yeet = i;
				Button button = new Button(menuOptions.get(i).toString());
				System.out.println("am i here");
				button.setOnAction(this);
				if (!menuOptions.get(yeet).instructions().isEmpty()) {
					tf = new TextField();
					root.add(tf, 0, row + 1);
					button.setOnAction(e -> 
					{
						try {
							if (tf.getText().isEmpty()) {
								throw new Exception("Please enter something");
							}
							menuOptions.get(yeet).enterElement(tf.getText());
							menuOptions.get(yeet).execute();
							ta.setText(bigboi.get(0).execute());
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
						menuOptions.get(yeet).execute();
						System.out.println("in the right spot");
						ta.setText(bigboi.get(0).execute());
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
			e.printStackTrace();
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		System.out.println("REEE");
	}

	@Override
	public void handle(ActionEvent arg0) {
		for (int i = 0; i < bigboi.size(); i++) {
			System.out.println("hahah");
			ta.setText(bigboi.get(i).execute());
		}
	}
}