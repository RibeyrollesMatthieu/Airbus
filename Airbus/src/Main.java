import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		Image image = new Image("https://i0.wp.com/www.4ubodyfitness.com.au/wp-content/uploads/2017/01/You-can-do-it-.jpg?ssl=1\"");
		Traitement t = new Traitement(image);
		t.setAsBW();
		ImageView av = new ImageView(t.getImage());		

		
		this.root.getChildren().add(av);
	
		this.stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
