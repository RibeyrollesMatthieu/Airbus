import javafx.scene.image.Image;

public class Correspondance {
	
	private Image image;
	private int averageValue;
	
	public Correspondance(Image img, int val) {
		this.image = img;
		this.averageValue = val;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(int averageValue) {
		this.averageValue = averageValue;
	}

}
