package sample;

import java.util.Scanner;

public class SquareBingoTest {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		SquareBingo sb = new SquareBingo(4);
		System.out.println(sb.toString());
		
	
		for(int cnt=1; cnt<=13; cnt++) {
			System.out.println(sb.toHiddenString());
			System.out.print("call Number! ");
			int in = Integer.valueOf(cin.nextLine());
			boolean t = sb.mark(in);
			System.out.println("mark " +in +" ? " + t);
			int rc = sb.revealedCount();
			System.out.println("revealed Count = "+ rc);
			
		}
	}
}
