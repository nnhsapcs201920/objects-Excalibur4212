package chapter1hw;
import java.util.Scanner;
public class P1_5 {
	public static void main(String[] args) {
		Scanner kbreader = new Scanner(System.in);
		int length = 0;
		int height = 0;
		while(true) {
			System.out.println("Length?");
			try {
				length = Integer.parseInt(kbreader.nextLine());
				break;
			} catch(Exception e) {}
		}
		while(true) {
			System.out.println("Height?");
			try {
				height = Integer.parseInt(kbreader.nextLine());
				if(height%2 == 1) break;
			} catch(Exception e) {}
		}
		int[][] out = new int[length][height];
		for(int i = 0; i < length; i++) {
			if(i == 0 || i == length-1) {
				for(int j = 0; j < height; j++) out[i][j] = 1;
			} else if (length % 2 == 0 && (i == length/2-1 || i == length/2)) {
				out[i][0]=1;
				out[i][height-1]=1;
				out[i][(int)Math.floor(height/2)]=1;
			} else if (length % 2 == 1 && (i == Math.floor(length/2)+1||i == Math.floor(length/2)||i == Math.floor(length/2)-1)) {
				out[i][0]=1;
				out[i][height-1]=1;
				out[i][(int)Math.floor(height/2)]=1;
			} else {
				out[i][0]=1;
				out[i][height-1]=1;
			}
		}
		utilities.twoDArrayPrint(out);
		kbreader.close();
	}
}
