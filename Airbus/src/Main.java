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
//		Image image = new Image("images/autumn-84714__340.jpg");
//		Traitement t = new Traitement(image);
//		ImageView av = new ImageView(t.getImage());		
//		ImageView av = new ImageView(image);

//		this.root.getChildren().add(av);
		this.stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
