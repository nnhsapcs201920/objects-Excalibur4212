package chapter1hw;

public class Answerstoquestions {
	// R1.5: java is better over machine code because machine code is convoluted and hard to read compared to java due to the fact that machine language and even assembler is very hard for humans to read. Also, as a platform-independent language, Java also allows one to compile the program once and get it to work on any machine
	/*
	 * R1.7:
	 * 39 + 3
	 * 42
	 */
	/*
	 * R1.8:
	 * HelloWorld
	 */
	/*
	 * R1.9:
	 * System.out.println only has one input, so some sort of invalid input thing. To fix it: change the , to a +
	 */
	// R1.11: Syntax errors will lead to your IDE (BlueJ, IntelliJ, Eclipse) highlighting the statement, logic errors are caught when the program runs and the desired output doesn't happen.
	/*
	 * take some integer a
	 * current guess = a/2
	 * next guess
	 * required distance = whatever needed
	 * while(true){
	 * 	(current guess + a/current guess)/2 = next guess
	 *  if (abs(current guess - next guess) <= required distance) break 
	 *  else
	 * }
	 * print next guess
	 */
	/*
	 * p1.8
	 * 
	 * while true:
	 * 	if robot.view == exit, move forward, break
	 * 	if robot.view == nothing, move forward
	 * 	if robot.view == wall:
	 * 		turn right
	 * 		if robot.view == wall: 
	 * 			turn right twice
	 * 			if robot.view == wall, turn left, move forward
	 * 			else move forward
	 */
	/*
	 * p1.11
	 * 
	 * String[][] x = matrix.getcolors
	 * int redxsum =0;
	 * int redysum =0;
	 * int redcount = 0;
	 * int blackxsum =0;
	 * int blackysum =0;
	 * int blackcount = 0;
	 * int redxcoord;
	 * int redycoord;
	 * int blackcoord;
	 * int blackycoord;
	 * for i=0 i<rows i++:
	 * 	for j=0 j<columns j++:
	 * 		if x[i][j] is red, increment redxsum by i, increment redysum by j, increment redcount by 1
	 * 		if x[i][j] is black, increment blackxsum by i, increment blackysum by j, increment blackcount by 1
	 * redxcoord = round redxsum/redcount
	 * redycoord = round redysum/redcount
	 * blackxcoord = round blackxsum/blackcount
	 * blackycoord = round blackysum/blackcount
	 * if redxcoord == blackxcoord and redycoord = blackycoord, return yes
	 * else return no	
	 */
}
