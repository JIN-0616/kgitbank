import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//컬렉션 다루기 좋은 예제...?

public class Exercise05 {
	public static void main(String[] args) {
		/*
		 * 베스킨라빈스 31 버전업
		 * 	- 사용자는 최대 3개까지 입력가능 (공백기준 갯수처리, 겹치면 안됨)
		 * 
		 *  - 꼭 일렬의 숫자를 입력할 필요는 없음 (첫번째 숫자가 그전 숫자의 +1이면 가능)
		 *  
		 *  - 나 , 상대방이 외친 숫자를 다시 입력하면 패배
		 *  
		 *  - 내가 외친 숫자의 마지막숫자 +1이미 contains면 진다. 
		 *  
		 *  - 범위설정 : 1 ~ 15  
		 *  
		 */
		Scanner cin	= new Scanner(System.in);
		Set<String> s1 = new LinkedHashSet<>();
		List<String> s2 = new ArrayList();
		g: while(true) {
			System.out.print("[SYSTEM] ");
			String in = cin.nextLine();
			String[] ar = in.split(" ");
			if(ar.length>3) {
				System.out.println("Error : type(3 over input)");
				break g;
			}
			System.out.println(ar.length);
			for (int i = 0; i < ar.length; i++) {
				if(!s1.contains(ar[i])) {
					s1.add(ar[i]);
				}
				if(!s2.contains(ar[i])) {
					s2.add(ar[i]);
				}
			}			
		}
		cin.close();
	}
}
