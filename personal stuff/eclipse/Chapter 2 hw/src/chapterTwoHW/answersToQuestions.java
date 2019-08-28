package chapterTwoHW;
import java.awt.Rectangle;
public class answersToQuestions {
	//R2.1 an object is an instance of a class, which is a collection of methods and variables
	//R2.3 public interfaces of classes are the variables and methods that you can invoke/change from outside of said class, while the implementation of the class is just the gneral use case of a class, as there could be private variables in a public class.
	//R2.7 the = symbol in java is the assignment operator, in which the jdk will assign the value of the second operand to the first.
	//R2.12 an object is assigned to a larger chunk of a computer's ram, but an object variable is much smaller and only contains the address of the location of an object
	@SuppressWarnings("unused")
	public static void rTwoThirteen() {
		Rectangle rect = new Rectangle();
		Rectangle ooo = rect;
	}
	/*
	 * R2.18:
	 * a: they forgot to insert the following: "new Rectangle"
	 * b: no object has been declared, thus getwidth wouldn't work
	 * c: r is not initialized
	 * d: translate takes a int input, not a string.
	 */
	/*
	 * R2.20
	 * a: "string1".concat("string2")
	 * b: String.trim();
	 * c:  
	 */
	
}
