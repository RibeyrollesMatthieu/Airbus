import java.io.IOException;

import javafx.scene.image.Image;

public class Main {
	
	public static void main (String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();
		
		Image image 	= new Image("imagelune/lune_4k.jpg"); 
		
		Traitement t 	= new Traitement(image);
		Algo a 			= new Algo();
		
		a.createImage("imagelune\\lune_4k.jpg", image, t.getList());
		
		long stopTime 		= System.currentTimeMillis();
	    long elapsedTime 	= stopTime - startTime;
	    System.out.println(elapsedTime+"ms");
	}

}
