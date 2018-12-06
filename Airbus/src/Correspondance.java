public class Correspondance {
	private String image;
	private int averageValue;
	
	public Correspondance(String img, int val) {
		this.image = img;
		this.averageValue = val;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(int averageValue) {
		this.averageValue = averageValue;
	}

}
