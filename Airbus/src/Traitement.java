import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

class Traitement {
	private Image image;
	private Correspondance[] liste;
	private File dossier;
	private String[] images;
	
	Traitement(Image image) {
		this.image = image;
		this.dossier = new File("src/images");
		this.images = this.dossier.list();
		this.liste = new Correspondance[this.images.length];
		
		this.setAsBW();
		this.listBW();
	}
	
	Correspondance[] getList() {
		return this.liste;
	}
	
	Image getImage() {
		return this.image;
	}
	
	int moyenneGris(Image image) {
		int somme = 0;
		for (int i = 0; i < image.getWidth(); i ++) {
			for (int j = 0; j < image.getHeight(); j ++) {
				somme += image.getPixelReader().getColor(i, j).getRed() * 255.;
			}
		}
		somme /= (image.getWidth() * image.getHeight());
		return somme;
	}
	
	Image setAsBW (Image image) {
		int width = (int)(image.getWidth());
		int height = (int)(image.getHeight());

		WritableImage toReturn = new WritableImage(width, height);
		PixelWriter pw = toReturn.getPixelWriter();
		
		for (int i = 0; i < width; i ++) {
			for (int j = 0; j < height; j ++) {
				double somme = 	image.getPixelReader().getColor(i, j).getRed()*255. + 
								image.getPixelReader().getColor(i, j).getGreen()*255. + 
								image.getPixelReader().getColor(i, j).getBlue()*255.;
				int gris = (int)(somme/3);
				
				pw.setColor(i, j, Color.rgb(gris, gris, gris));
			}
		}
		
		return toReturn;
	}
	
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
	
	void listBW() {
		for (int i = 0; i < this.images.length; i ++) {
			Image image = new Image("images/" + images[i]);
			image = setAsBW(image);			

			this.liste[i] = new Correspondance(images[i], moyenneGris(image));
		}
	}
}
