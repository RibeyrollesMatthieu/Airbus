import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

class Traitement {
	private Image image;
	
	Traitement(Image image) {
		this.image = image;
	}
	
	Image getImage() {
		return this.image;
	}
	
	// resize

	void resize() {
		
	}
	
	// Return black and white image
	void setAsBW () {
		int width = (int)(this.image.getWidth());
		int height = (int)(this.image.getHeight());

		WritableImage toReturn = new WritableImage(width, height);
		PixelWriter pw = toReturn.getPixelWriter();
		
		for (int i = 0; i < width; i ++) {
			for (int j = 0; j < height; j ++) {
				double somme = 	this.image.getPixelReader().getColor(i, j).getRed()*255. + 
								this.image.getPixelReader().getColor(i, j).getGreen()*255. + 
								this.image.getPixelReader().getColor(i, j).getBlue()*255.;
				int gris = (int)(somme/3);
				
				pw.setColor(i, j, Color.rgb(gris, gris, gris));
			}
		}
		
		this.image = toReturn;
	}
}
