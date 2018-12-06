import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Traitement {
	private Image test = new Image("Lena.png");
	
	Traitement() {
		
	}
	
	ImageView blackAndWhite (Image image) {
		
		return new ImageView(image);
	}
}
