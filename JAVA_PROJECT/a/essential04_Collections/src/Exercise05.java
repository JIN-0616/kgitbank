import java.util.Scanner;

public class Exercise05 {
	public static void main(String[] args) {
		/*
		 * 베스킨라빈스 31 버전업
		 * 	- 사용자는 최대 3개까지 입력가능 (겹치면 안됨)
		 *  - 꼭 일렬의 숫자를 외칠 필요는 없음 
		 *  (첫번째 숫자가 그전 숫자의 +1 이기만 하면된다)
		 *  - 내가 외친 숫자나 상대방이 외친숫자를 기억이 안나서 또 외치면 안됨.
		 *  
		 *  - 내가 외칠 숫자가 더 이상 존재하지 않는다면, 상대방이 짐. 
		 *  
		 *  (범위가 1~15까지 만 유효)
		 */
		Scanner cin = new Scanner(System.in);
		
		while(true) {
			System.out.print("[system] ");
			String in = cin.nextLine();
			String[] ar = in.split(" ");
			System.out.println(ar.length);
			
		}
	}
}
