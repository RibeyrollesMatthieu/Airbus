import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Algo {

	final static int SMALLIMAGESIZE = 40;
	final static int MARGE = 7;
	
	public void createImage(String strImg, Image img, Correspondance[] corresp) throws IOException {
		
		Image baseBW = new Traitement(img).getImage();	// Transforme l'image en noir et blanc
		int baseBWHeight 	= (int) baseBW.getHeight();
		int baseBWWidth 	= (int) baseBW.getWidth();
		
		PixelReader pixelReader = baseBW.getPixelReader();
		
		BufferedImage base 		= ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\" + strImg));
		BufferedImage result 	= new BufferedImage(baseBWWidth, baseBWHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = result.getGraphics();
		
		int x = 0, y = 0;

		for (int readY = 0; readY < baseBWHeight/SMALLIMAGESIZE; readY++) {
			for (int readX = 0; readX < baseBWWidth/SMALLIMAGESIZE; readX++) {
                Color color = pixelReader.getColor(readX * SMALLIMAGESIZE, readY * SMALLIMAGESIZE);
                int gris 	= 0;
                boolean find = false;
                
                for(int k=0; k<SMALLIMAGESIZE; k++) {
                	for(int l=0; l<SMALLIMAGESIZE; l++ ) {
                		gris += baseBW.getPixelReader().getColor(readX * SMALLIMAGESIZE + k, readY * SMALLIMAGESIZE + l).getRed() * 255;
                	}
                }
                
                gris = gris/(SMALLIMAGESIZE * SMALLIMAGESIZE);
                
                for(int k=0; k<SMALLIMAGESIZE; k++) {
                	for(int l=0; l<SMALLIMAGESIZE; l++ ) {
                		int rgb = gris;
                		rgb = (rgb << 8) + gris;
                		rgb = (rgb << 8) + gris;
                		base.setRGB(readX * SMALLIMAGESIZE + k, readY * SMALLIMAGESIZE + l, rgb);
                	}
                }
                
                for (int i = 0; i < corresp.length && !find; i++) {
                	if(corresp[i].getAverageValue() < ((color.getRed() * 255) + MARGE) && corresp[i].getAverageValue() > ((color.getRed() * 255) - MARGE)) { // Marge +-5
	            		find = true;
                		String pathToImg = System.getProperty("user.dir") + "\\src\\images\\" + corresp[i].getImage();
                		BufferedImage bi = resize(toGray(ImageIO.read(new File(pathToImg))), SMALLIMAGESIZE, SMALLIMAGESIZE);
                		g.drawImage(bi, x, y, null);
                	}
				}
                if (!find) { // Si on trouve pas d'image remplissant les conditions ...
                	BufferedImage b_img = new BufferedImage(SMALLIMAGESIZE, SMALLIMAGESIZE, BufferedImage.TYPE_INT_RGB);
        			Graphics2D    graphics = b_img.createGraphics();
        			graphics.setColor(new java.awt.Color(255, 255, 255)); // On la remplace par une image toute blanche de meme taille 
        			graphics.fillRect ( 0, 0, b_img.getWidth(), b_img.getHeight() );
        			g.drawImage(b_img, x, y, null);
                }
                x += SMALLIMAGESIZE;
        		if(x >= result.getWidth()){
     	           x = 0;
     	           y += SMALLIMAGESIZE;
        		}
                find = false;
            }
        }
		ImageIO.write(result, "bmp", new File("result.bmp"));
	}
	
	private BufferedImage toGray(BufferedImage img) {
		try {
            BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY );

            Graphics2D g = gray.createGraphics();
            g.drawImage(img, 0, 0, null);

            HashSet<Integer> colors = new HashSet<>();
            int color = 0;
            for (int y = 0; y < gray.getHeight(); y++) {
                for (int x = 0; x < gray.getWidth(); x++) {
                    color = gray.getRGB(x, y);
                    colors.add(color);
                }
            }
    		return gray;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    java.awt.Image tmp = img.getScaledInstance(newW, newH, java.awt.Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
}
