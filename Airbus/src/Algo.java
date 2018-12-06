import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Algo {

	final static int SMALLIMAGESIZE = 480;

	public Image createImage(Image img, Correspondance[] corresp) throws IOException {
		Image baseBW = new Traitement(img).getImage();	// Transforme l'image en noir et blanc
//		ImageView baseIV = new ImageView(baseBW);
		int baseBWHeight = (int) baseBW.getHeight();
		int baseBWWidth = (int) baseBW.getWidth();
		
		PixelReader pixelReader = baseBW.getPixelReader();
		
		BufferedImage result = new BufferedImage(baseBWWidth * SMALLIMAGESIZE, baseBWHeight * SMALLIMAGESIZE, BufferedImage.TYPE_INT_RGB);
		Graphics g = result.getGraphics();
		
		int x = 0;
		int y = 0;
		
		for (int readY = 0; readY < baseBWHeight; readY++) {
            for (int readX = 0; readX < baseBWWidth; readX++) {
                Color color = pixelReader.getColor(readX, readY);
                for (int i = 0; i < corresp.length; i++) {
					// marge +-5
                	if(corresp[i].getAverageValue() < color.getRed() + 5 && corresp[i].getAverageValue() > color.getRed() - 5) {
                		BufferedImage bi = ImageIO.read(new File(corresp[i].getImage()));
                		g.drawImage(bi, x, y, null);
	            		x += SMALLIMAGESIZE;
	            		if(x > result.getWidth()){
	         	           x = 0;
	         	           y += SMALLIMAGESIZE;
	            		}
                	}
				}
            }
        }
		ImageIO.write(result,"png",new File("result.png"));
		return null;
	}
	
}
