package chapter1hw;

public class R1_10b {
	public static void main(String[] args) {
		//runtime error:
		String x = "Hello World!";
		char[] y = x.toCharArray();
		//iterates through and prints y, causes an error due to an ArrayIndexOutofBounds error
		for(int i = 0; i<=y.length; i++) {
			System.out.print(y[i]);
		}
	}
}
