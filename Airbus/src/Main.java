import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * @author matthieu ribeyrolles
 */

public class Main extends Application{
	private Stage stage;
	private Scene scene;
	private Pane root;
	
	public void start(Stage stage) {
		this.stage = stage;
		this.stage.setScene(this.scene = new Scene(this.root = new Pane(), 900, 900));
		
		this.stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
