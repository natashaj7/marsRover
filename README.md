# marsRoverSecond

Natasha Jimenez
ThoughtWorks Application
January 13, 2015

Problem Three: Mars Rover

Design and Assumptions
For the Mars rover navigation system design, I decided the best way to solve this problem in an Object Oriented Programming manner, was to create three different types of objects to be used by the main function. The first object is an input parser that encapsulates the redundancy of parsing and validating each file line into reusable functions. Calling its functions allows the main() to pass each file line as an argument, and returning the necessary parts of the line back to the main in neat variables or objects, meanwhile also validating the input. The second and third objects created are Plateau and Rover objects. The Plateau object holds the x and y coordinates of the landing plateau for the rover in the form of a Point variable, and an ArrayList of Rovers that can roam the plateau. The Rover object holds a Point variable for the rover’s x y coordinates, and the direction of the Rover at any given time. The user is able to get and set each of the Rover and Plateau’s variables with its getter and setter functions. 
In the main() thread the Scanner is first set to read the input.txt file, ensuring the file is valid using InputParser’s validateFile() function. Then the Plateau object named marsPlateau is initialized, by reading and parsing the first line of the input file and then setting the Plateau coordinates, thus creating boundaries for the rover to tread. Next a while loop is created to allow as many Rovers as desired to be added to the Plateau sequentially. The Scanner reads the next file line with the rover’s initial orientation, and the InputParser is called which parses, validates, and sets the x, y coordinates and direction using the Rover object’s constructor. The Rover object is returned to the main and added to the ArrayList of Rovers in the Plateau. The program then reads the next file line which contains the Rover’s path. This line is split into an array, and for each instruction, one of three of the Plateau object’s functions are called. If the instruction reads ‘L’, the turnLeft() function is called. This changes the direction variable of the Rover 90 degrees left based on what the current Rover object direction is set to. ‘R’ will call the turnRight() function, which changes the direction variable of the Rover 90 degrees right based on the same logic. ‘M’ calls the Rover’s move() function, which will look at the current direction variable, and based on this either increase or decrease the x or y coordinate by 1. For example if the Rover’s direction is set to East and move() is called, the function will increase the Rover’s x coordinate by 1. The move() function also does a check with the Plateau’s coordinates before changing the position of the Rover object to ensure that it is not moved out of the bounds of the plateau. If there are more Rovers to be added, the program checks for additional lines and loops back up to read and parse the instructions again. If no more lines exist in the file, the program ends with printing the final orientations of all the Rovers.

Assumptions
Since there is only one test input example available in the problem it was not clear whether there will always be only two rovers or if in other test inputs the number of rovers might change. Therefore I assumed that there may be a need for more or less than two rovers to be inputted, and allowed for as many additional rovers as desired to be navigated on the platform. Additionally, I coded the actual moving of the Rovers within the Plateau object in order to create an extensible design, foreseeing that in the future there may need to be multiple rovers moving at the same time or intermittently. Controlling the movement of Rovers from the Plateau allows more easily for one Rover to be moved, then another, then back to the first by keeping track of Rover numbers in the Plateau’s Rover ArrayList. I also made the assumption that the rover should not be allowed to move beyond the bounds of the plateau. If instructions for the rover to move beyond bounds are input, it will simply ignore that particular move, but continue executing the rest of the instructions as long as they are valid and in bounds.

Run Instructions
Using Terminal
Unzip the .zip file supplied and save the java and txt files in one directory together
Change the input.txt file if different rover orientations directions, or platform dimensions are desired.
In terminal, navigate to the directory containing my java and txt files, using cd [directory with saved files]
Type the command: javac MarsRover.java to compile the main java file
Type the command  java MarsRover
The expected output should appear in the command prompt

Using an IDE
Do the same steps 1. and 2. above
Create a new java project in your IDE and create four new java classes under this project for the four java files attached respectively. Paste the file contents into the four class files in the project. 
Save the input.txt file in the same directory as your java project (but not in a source file)
Save and run these, and you will see the expected outputs in the console.


