package sample;

import java.util.Scanner;

public class LineBingoMain {
	public static void main(String[] args) {
		/**
		 * LineBingo 객체 여러개 만들어서 사용자로부터 입력받아가면서 이 객체를 제어해야되는데
		 */
		// System.console.readLine(); // 이클립스 결과캡쳐출력==> 에러
		// Console c = System.console();
		// c.readLine();

		// Eclipse에서도 testing 가능한 입력처리를 알아야한다.
		// Scanner cin = new Scanner(System.in); // 객체 생성한번 시켜두고,

		// String in1 = cin.nextLine(); // 객체.nextLine();
		// System.out.println(in1);
		// String in2 = cin.nextLine(); // 여러번 생성시킬필요없이, 한번만 생성해서 사용
		// System.out.println(in2); // readLine() 기능과 마찬가지로 String으로 return된다.
		// Integer.valueOf(); 처리

		// 사용자의 빙고 + 상대방의 빙고 둘다, toHiddenString 출력

		// 둘중에 하나라도 revealed 완료되면 둘다 toString

		LineBingo user1 = new LineBingo();
		LineBingo user2 = new LineBingo();

		System.out.println("=====LineBingo START=====");
		Scanner cin = new Scanner(System.in);
		while (!user1.isRevealed() && !user2.isRevealed()) {
			System.out.println("user1 = " + user1.toHiddenString());
			System.out.println("user2 = " + user2.toHiddenString());
			String u1 = cin.nextLine();
			user1.mark(Integer.valueOf(u1));
			user2.mark(1 + (int) (Math.random() * 10));
			//중복처리.. 인트배열만들어서 넣고
			System.out.println("");
		}
		
		System.out.println("======== GAME SET ========");
		System.out.println("user1 = " + user1.toString());
		System.out.println("user2 = " + user2.toString());

		if (user1.isRevealed() && !user2.isRevealed()) {
			System.out.println("======= user1 승리 =======");
		} else if (!user1.isRevealed() && user2.isRevealed()) {
			System.out.println("======= user2 승리 =======");
		} else {
			System.out.println("========= 무승부 =========");
		}
		cin.close();
	}
}
