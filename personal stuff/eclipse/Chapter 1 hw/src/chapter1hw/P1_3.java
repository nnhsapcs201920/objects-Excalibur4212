package chapter1hw;

public class P1_3 {
	public static void main(String[] args) {
		double current = 0;
		int target = 314159;
		double currentNumAbs = 1;
		boolean pos = true;
		while(true) {
			if (pos) current = current + (1/currentNumAbs);
			else current = current - (1/currentNumAbs);
			if(Math.floor(current*100000*4)==target) break;
			currentNumAbs = currentNumAbs + 2;
			pos = !pos;
		}
		System.out.println("Success! "+current*4);
	}
}
