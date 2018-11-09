//import java.util.Math;
public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture picture;
	int wid;
	int hgt;
	public SeamCarver(Picture picture) {
		this.picture = picture;
		if (picture == null) {
			System.out.println("picture is null");
			return;
		}
		this.wid = picture.width();
		this.hgt = picture.height();
	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return wid;
	}

	// height of current picture
	public int height() {
		return hgt;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || x == wid - 1) {
			return 1000;
		} else if (y == 0 || y == hgt - 1) {
			return 1000;
		}
		int redx = picture.get(x, y - 1).getRed() - picture.get(x, y + 1).getRed();
		int greenx = picture.get(x, y - 1).getGreen() - picture.get(x, y + 1).getGreen();
		int bluex = picture.get(x, y - 1).getBlue() - picture.get(x, y + 1).getBlue();
		int redy = picture.get(x - 1, y).getRed() - picture.get(x + 1, y).getRed();
		int greeny = picture.get(x - 1, y).getGreen() - picture.get(x + 1, y).getGreen();
		int bluey = picture.get(x - 1, y).getBlue() - picture.get(x + 1, y).getBlue();
		double column = (redx * redx) + (greenx * greenx) + (bluex * bluex);
		double row = (redy * redy) + (greeny * greeny) + (bluey * bluey);
		double result = Math.sqrt(column + row);
		return result;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}