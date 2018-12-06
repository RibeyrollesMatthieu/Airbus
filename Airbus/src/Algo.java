import java.awt.Color;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;

public class Algo {
	
	public Image createImage(Image img, Correspondance[] corresp) {
		ImageView baseIV = new ImageView();
		baseIV.setImage(img);
		
		PixelReader pixelReader = img.getPixelReader();
        System.out.println("Image Width: "+img.getWidth());
        System.out.println("Image Height: "+img.getHeight());
        System.out.println("Pixel Format: "+pixelReader.getPixelFormat());
		
		for (int readY = 0; readY < img.getHeight(); readY++) {
            for (int readX = 0; readX < img.getWidth(); readX++) {
                Color color = pixelReader.getColor(readX, readY);
                System.out.println("\nPixel color at coordinates ("
                        + readX + "," + readY + ") "
                        + color.toString());
                System.out.println("R = " + color.getRed());
                System.out.println("G = " + color.getGreen());
                System.out.println("B = " + color.getBlue());
                System.out.println("Opacity = " + color.getOpacity());
                System.out.println("Saturation = " + color.getSaturation());
            }
        }
		
		return null;
	}
	
}
