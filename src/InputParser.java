import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputParser {

	// Empty constructor so an InputParser object doesn't need to be initialized.
	private InputParser() {
	}

	// put file path together and make sure it is valid (make sure text file is in current directory)
	public static Scanner validateFile(String FILE) {
		Scanner scanFile = null;
		String fullPath = System.getProperty("user.dir") + "/" + FILE;
		try {
			scanFile = new Scanner(new FileReader(fullPath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Incorrect file directory\n");
			System.exit(0);
		}
		return scanFile;
	}

	// parses input line for plateau coordinates
	public static Point parsePlateauBoundaries(String s) {
		Point p = new Point();
		String[] boundaries = s.split(" ");
		p.x = InputParser.parseIntAndValidate(boundaries[0]);
		p.y = InputParser.parseIntAndValidate(boundaries[1]);
		return p;
	}

	// parses input line for rover orientation
	public static Rover parseRoverPosition(String rovPosition) {
		String[] xyRov = rovPosition.split(" ");
		Point roverCo = new Point();
		roverCo.x = parseIntAndValidate(xyRov[0]);
		roverCo.y = parseIntAndValidate(xyRov[1]);
		Rover rov = new Rover(roverCo, parseCharAndValidate(xyRov[2]));
		return rov;
	}

	// exception handling to ensure input is correctly formatted for integers
	public static int parseIntAndValidate(String s) {
		int validInt = 0;
		try {
			validInt = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("Incorrect input format\n");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Incorrect input format\n");
			System.exit(0);
		}
		return validInt;
	}

	// exception handling to ensure input is correctly formatted for characters
	public static char parseCharAndValidate(String x) {
		char orientation = 0;
		try {
			orientation = x.charAt(0);
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input format\n");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Incorrect input format\n");
			System.exit(0);
		}
		return orientation;
	}
}
