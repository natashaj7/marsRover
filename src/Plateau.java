import java.awt.Point;
import java.util.ArrayList;

public class Plateau {
	private Point maxDimensions;
	public ArrayList<Rover> rovers;

	// Plateau's empty constructor
	public Plateau() {
		maxDimensions = new Point();
		maxDimensions.x = 0;
		maxDimensions.y = 0;
		rovers = new ArrayList<Rover>();
	}

	// constructor with coordinates
	public Plateau(Point dim) {
		maxDimensions = new Point();
		maxDimensions.setLocation(dim.x, dim.y);
		rovers = new ArrayList<Rover>();
	}

	// method to add a rover to the plateau
	public void addRover(Rover r) {
		rovers.add(r);
		r.checkMapX(maxDimensions.x);
		r.checkMapY(maxDimensions.y);
	}

	// set plateau's coordinates
	public void setMax(Point dims) {
		maxDimensions.x = dims.x;
		maxDimensions.y = dims.y;
	}

	// get plateau's coordinates
	public Point getMax() {
		return maxDimensions;
	}

	// changes the direction of a particular rover on the plateau 90 degrees
	// left based on current rover direction
	public void turnLeft(int rover) {
		if (rovers.get(rover).getDir() == 'N')
			rovers.get(rover).setDir('W');
		else if (rovers.get(rover).getDir() == 'E')
			rovers.get(rover).setDir('N');
		else if (rovers.get(rover).getDir() == 'S')
			rovers.get(rover).setDir('E');
		else if (rovers.get(rover).getDir() == 'W')
			rovers.get(rover).setDir('S');
	}

	// changes the direction of a particular rover on the plateau 90 degrees
	// right based on current rover direction
	public void turnRight(int roverNum) {
		if (rovers.get(roverNum).getDir() == 'N')
			rovers.get(roverNum).setDir('E');
		else if (rovers.get(roverNum).getDir() == 'E')
			rovers.get(roverNum).setDir('S');
		else if (rovers.get(roverNum).getDir() == 'S')
			rovers.get(roverNum).setDir('W');
		else if (rovers.get(roverNum).getDir() == 'W')
			rovers.get(roverNum).setDir('N');
	}

	// moves rover one space forward based on current direction the rover is
	// facing
	public void move(int x, int roverNum) {
		if (rovers.get(roverNum).getDir() == 'N') {
			// before moving, make sure rover isn't trying to move off map, and
			// if so, do not allow
			if (rovers.get(roverNum).getCoordinates().y >= maxDimensions.y) {
				System.out
						.println("Rover " + (roverNum+1) + " did not execute instruction " + x + " in order to maintain the rover within the plateau boundaries");
			} else { // else move rover one space forward
				rovers.get(roverNum).increaseYCo();
			}
		} else if (rovers.get(roverNum).getDir() == 'E') {
			if (rovers.get(roverNum).getCoordinates().x >= maxDimensions.x) {
				System.out
						.println("Rover " + (roverNum+1) + " did not execute instruction " + x + " in order to maintain the rover within the plateau boundaries");
			} else {
				rovers.get(roverNum).increaseXCo();
			}
		} else if (rovers.get(roverNum).getDir() == 'S')
			if (rovers.get(roverNum).getCoordinates().y == 0) {
				System.out
						.println("Rover " + (roverNum+1) + " did not execute instruction " + x + " in order to maintain the rover within the plateau boundaries");
			} else {
				rovers.get(roverNum).decreaseYCo();
			}
		else if (rovers.get(roverNum).getDir() == 'W') {
			if (rovers.get(roverNum).getCoordinates().x == 0) {
				System.out
						.println("Rover " + (roverNum+1) + " did not execute instruction " + x + " in order to maintain the rover within the plateau boundaries");
			} else {
				rovers.get(roverNum).decreaseXCo();
			}
		}
	}

	// print function
	public void printRovers() {
		for (int y = 0; y < rovers.size(); y++) {
			rovers.get(y).printRoverInfo();
		}
	}
}
