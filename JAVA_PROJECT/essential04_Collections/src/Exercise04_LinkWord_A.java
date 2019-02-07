import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise04_LinkWord_A {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		// Set, List, Queue- Deque 를 사용하던 상황처리에 유리한 컬렉션 객체를 선택
	
		/*
		 * 두명의 사용자로부터 번갈아가면서 문자열을 입력받는데,
		 * 이미 입력한 문자열을 재입력한다거나
		 * 마지막으로 입력된 문자열의 마지막 문자와 다르게 시작하면
		 * 해당 사용자를 패배 처리,(10턴내에 안되면 
		 */
		List<String> li = new ArrayList<>();
		for(int cnt=1; cnt<=10; cnt++) {
			String user = cnt%2 ==0 ? "블루" : "레드";
			System.out.print("[시스템] " + user +"님 차례 > ");
			String in = cin.nextLine();
			if(li.contains(in)) {
				System.out.println("[시스템] " + in +" 은/는 이미 나온 단어입니다.");
				System.out.println("[시스템] " + user+" 의 패배!");
				break;
			}
			if(li.isEmpty()) {
				li.add(in);
				continue;
			}
			
			int last = li.size()-1;
			String recent = li.get(last);
			char c = recent.charAt(recent.length()-1);
			if(in.startsWith(String.valueOf(c)) ) {	// in.charAt(0) == c
				li.add(in);
			}else {
				System.out.println("[시스템] " + in +" 은/는 단어가 이어지지 않습니다.");
				System.out.println("[시스템] " + user+" 의 패배!");
				break;
			}
			
		}
		
		
		
	}
	
}
