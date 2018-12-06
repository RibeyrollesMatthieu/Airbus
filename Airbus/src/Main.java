import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage stage;
	private Scene scene;
	private Pane root;
	
	public void start(Stage stage) {
		this.stage = stage;
		this.root = new Pane();
		this.scene = new Scene(this.root, 900., 900.);

		this.stage.setScene(this.scene);
		
		this.stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
