import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercise04_LinkWord {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		// Set, List, Queue, Deque 를 사용하면 상황처리에 유용한 컬랙션 객체를 선택
		
		/*
		 * 두명의 사용자로부터 번갈아가면서 문자열을 입력받는데,
		 * 이미 입력된 문자열을 재입력한다거나
		 * 마지막으로 입력된 문자열의 마지막 문자와 다르게 시작하면
		 * 해당 사용자의 패배처리,(10턴 내에 안되면)
		 */
		
		//이클립스한글입력 콘솔오류 => 한글입력시 맨끝에 입력, end키 혹은 아래로 키
		
		//######### 미완성본 ################################################
		Deque<String> d = new ArrayDeque<>();
	
		for (int cnt = 1; cnt <=10; cnt++) {
			String user = cnt%2 ==0 ? "블루" : "레드";
			if(cnt==1) {
				System.out.print(user+"님 차례 > ");
				d.push(cin.nextLine());
			}else {
				System.out.println("\n이전번 단어:"+d.peek());					
				System.out.print(user+"님 차례 > ");
				String a = cin.nextLine();	
				if(a.indexOf(0)==d.peek().charAt(d.peek().length()-1)) {
					if(!d.contains(a)) {
						d.push(a);						
					}
					break;
				}							
				System.out.println("패배!");
			}
		}
		//###################################################################
	}
}
/*
	컬렉션형 객체 (객체관리를 쉽고 편리하게 할수 있는 객체)
	-Collection
		-Set
		-List
		-Queue
			-Deque
			
	-Map

*/
