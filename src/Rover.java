import java.awt.Point;

public class Rover {
	private Point coordinates;
	private char direction;

	// Rover's empty constructor
	public Rover() {
		coordinates = new Point();
		coordinates.x = 0;
		coordinates.y = 0;
		direction = 0;
	}

	// Constructor with orientation
	public Rover(Point co, char dir) {
		coordinates = new Point();
		coordinates.x = co.x;
		coordinates.y = co.y;
		checkDirection(dir);
		direction = dir;
	}

	public void setCoordinates(int xCo, int yCo) { // set rover's coordinates
		coordinates.x = xCo;
		coordinates.y = yCo;
	}

	public void setDir(char dir) { // set the direction the rover faces
		checkDirection(dir);
		direction = dir;
	}

	public void increaseXCo() { // move rover East
		coordinates.x++;
	}

	public void increaseYCo() { // move rover North
		coordinates.y++;
	}

	public void decreaseXCo() { // move rover West
		coordinates.x--;
	}

	public void decreaseYCo() { // move rover South
		coordinates.y--;
	}

	public Point getCoordinates() { // get rover's coordinates
		return coordinates;
	}

	public char getDir() { // get the direction the rover faces
		return direction;
	}

	// check if rover's x coordinate is on map
	public void checkMapX(int roverMaxX) {
		if (coordinates.x > roverMaxX) {
			System.out.println("X coordinate off map\n");
			System.exit(0);
		}
	}

	// check if rover's y coordinate is on map
	public void checkMapY(int roverMaxY) {
		if (coordinates.y > roverMaxY) {
			System.out.println("Y coordinate off map\n");
			System.exit(0);
		}
	}

	// make sure the direction that is being set is valid
	public void checkDirection(char d) {
		if (d == 'N' || d == 'E' || d == 'S' || d == 'W') {
		} else {
			System.out.println("Invalid rover orientation\n");
			System.exit(0);
		}
	}

	// print function
	public void printRoverInfo() {
		System.out.println(coordinates.x + " " + coordinates.y + " "
				+ direction);
	}
}