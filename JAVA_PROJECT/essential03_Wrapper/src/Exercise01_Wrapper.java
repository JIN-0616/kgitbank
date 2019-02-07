/*
 * 	Wrapper 객체가 어떤식으로 활용되는지?
 * 
 */
import java.util.LinkedHashSet;

public class Exercise01_Wrapper {
	public static void main(String[] args) {
		/*
		 *  LinkedHashSet 은 Collection(=객체값 관리하는 용도) 객체중 하나로,
		 *   같은객체값(혹은 equals 결과 true)을 저장을 안하게 설계가 되어있다.
		 */
		
		// 바로 생성하지 말고, 이 객체를 통해 어떤 객체값을 처리할껀지 설정을 해야한다.
		// < > 안에 객체타입 설정, 
		// 기본데이터 저장불가, 객체값만 저장가능, 배열 기반
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		
		for (int cnt = 0; cnt <= 15; cnt++) {
			int n = 1+(int)(Math.random()*15);
			System.out.print(cnt + " 's pick = "+n);
			//boolean b = set.add(n); // 저장성공여부가 나옴, 오토박싱으로 Integer로 변환되어 들어감
			// boolean b = set.add(Integer.valueOf(n));
			boolean b = set.add(new Integer(n));
			System.out.println(" / add result = " +b);
			// 모든 객체마다 equals를 때려서 
			//  같은값의 경우는 거부false, 아니면 저장true
		}
		System.out.println(set.toString()); //저장된 순서대로 출력
		// 가지고 있는 데이터를 문자열로 만들어줌
		
		// 이 외에도 더 추가적인 기능이 있는데, Collection 형 객체를 다룰때 보게될 예정
		
		// 지금은 Wrapper 객체가 어떻게 사용이 되는지 보고 넘어가면 된다. 
	}
}
/*
 *  어제 만든 HangmanWordMain 에
 *   char의 객체타입을 관리할수 있는 LinkedHashSet을 생성시켜서
 *   사용자가 입력한 문자를 mark돌리기 전에, add 시켜서 true 가 뜨면 mark 시키고
 *   false가 뜨면 이미 입력한 문자라고 알려주고, 이때까지 입력한 문자들을 전부 다 출력
 *   문자객체를 저장할 LinkedHashSet 생성 
 */ 
