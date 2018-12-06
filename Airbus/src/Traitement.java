import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Traitement {
	private Image test = new Image("Lena.png");
	private int[][][] imageMatrix;
	
	Traitement() {
		
	}
	
	
	// Return black and white image
	ImageView setAsBW (Image image) {
		return new ImageView(image);
	}
}
