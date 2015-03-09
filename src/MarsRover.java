import java.util.Scanner;

public class MarsRover {
	final static String FILENAME = "input.txt";

	public static void main(String[] args) {
		int count = 0;
		// Parse the first line of the text to get the plateau boundaries
		Scanner scanRover = InputParser.validateFile(FILENAME);
		// initialize Plateau with first line of file indicating Plateau boundaries
		Plateau marsPlateau = new Plateau(
				InputParser.parsePlateauBoundaries(
						scanRover.nextLine()
				)
		);
		
		// entering of rover data is in a loop to allow as many Rover objects to be added to plateau as desired
		Boolean moreRovers = true;
		while (moreRovers) {
			// add new Rover object to Plateau with next line of file indicating its orientation
			marsPlateau.addRover(InputParser.parseRoverPosition(scanRover.nextLine()));
			// get rover path information and execute
			String path = scanRover.nextLine();
			String[] roverPath = path.split("");
			for (int x = 1; x < roverPath.length; x++) {
				if (roverPath[x].equals("L")) {
					marsPlateau.turnLeft(count); // if L is found in path, call Rover object's turnLeft() function
				} else if (roverPath[x].equals("R")) {
					marsPlateau.turnRight(count); // if R is found in path, call Rover object's turnRight() function
				} else if (roverPath[x].equals("M")) {
					marsPlateau.move(x, count); // if M is found in path, call Rover object's move() function
				} else {
					// if any of the instructions are invalid do not perform and display invalid instruction
					System.out.println("Invalid input for rover " + (count + 1) + "'s path. Instruction number " + x
							+ " did not execute\n"); 
				}
			}
			//check if there are move Rovers to be added to Plateau
			if (!scanRover.hasNextLine()) {
				moreRovers = false;
			} else {
				count++;
			}
		}
		marsPlateau.printRovers(); //print the final rover orientations
	}
}