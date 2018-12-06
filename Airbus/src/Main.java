import java.io.File;

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
		
		File dossier = new File("src/images");
		String[] images = dossier.list();
		
		ImageView av= new ImageView(new Image("images/" + images[150]));

		this.root.getChildren().add(av);
		this.stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
