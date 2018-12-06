import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Tuto extends Application{
	private Scene scene;
	private Pane root;
	private Image lena = new Image("https://cdn-media.rtl.fr/cache/ahUtr5Tk5Zyz_-yI7J0Zfw/880v587-0/online/image/2018/1003/7795024265_000-19p7gy.jpg");
	private ImageView iv;
	
	public void start(Stage stage) {
		this.root = new Pane();
		this.scene = new Scene(this.root, 900, 700);
		
		this.iv = new ImageView(this.lena);
		System.out.println("yoyoyyyo");
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
