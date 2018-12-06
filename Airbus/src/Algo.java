import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Algo {
	
	public Image createImage(Image img, Correspondance[] corresp) {
		Traitement tr = new Traitement();
		Image baseBW = tr.setAsBW(img);
		ImageView baseIV = new ImageView(baseBW);
		int baseBWHeight = (int) baseBW.getHeight();
		int baseBWWidth = (int) baseBW.getWidth();
		
		PixelReader pixelReader = baseBW.getPixelReader();
//        System.out.println("Image Width: "+img.getWidth());
//        System.out.println("Image Height: "+img.getHeight());
//        System.out.println("Pixel Format: "+pixelReader.getPixelFormat());
		
		for (int readY = 0; readY < baseBWHeight; readY++) {
            for (int readX = 0; readX < baseBWWidth; readX++) {
                Color color = pixelReader.getColor(readX, readY);
//                System.out.println("\nPixel color at coordinates (" + readX + "," + readY + ") " + color.toString());
//                System.out.println("R = " + color.getRed());
//                System.out.println("G = " + color.getGreen());
//                System.out.println("B = " + color.getBlue());
//                System.out.println("Opacity = " + color.getOpacity());
//                System.out.println("Saturation = " + color.getSaturation());
                for (int i = 0; i < corresp.length; i++) {
					// marge +-5
                	if(corresp[i].getAverageValue() < color.getRed()) {
                		
                	}
				}
            }
        }
		
		return null;
	}
	
}
