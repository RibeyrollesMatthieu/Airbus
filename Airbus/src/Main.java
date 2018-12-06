import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{
	private Scene scene;
	private Pane root;
	private Image lena = new Image("images/Lena.png");
	private ImageView iv;
	
	public void start(Stage stage) {
		this.root = new Pane();
		this.scene = new Scene(this.root, 900, 700);
		
		this.iv = new ImageView(this.lena);
		System.out.println("yo");
		this.setup();
		stage.setScene(this.scene);
		stage.show();
	}
	
	private void setup() {
		Rectangle r = new Rectangle(100.,  100.);
			r.setFill(Color.ALICEBLUE);
			
		this.root.getChildren().addAll(r, this.iv);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
