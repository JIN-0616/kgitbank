/*
 * 	Wrapper 객체가 어떤식으로 활용되는지..?
 * 
 */
import java.util.LinkedHashSet;

public class Exercise01_Wrapper {
	public static void main(String[] args) {
		/*
		 * LinkedHashSet 은 Collection(=객체값관리하는용도) 객체중 하나로, 
		 * 	같은객체값(혹은 equals 결과 true)을 저장을 안하게 설계되어있다. 
		 */
		// 바로 생성하지 말고, 이 객체를 통해 어떤 객체값을 처리할껀지 설정을 해야 한다.
		
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		LinkedHashSet<String> set1 = new LinkedHashSet<String>();
		LinkedHashSet<Double> set2 = new LinkedHashSet<Double>();
		
		for(int cnt=1; cnt<=15; cnt++) {
			int n = 1+(int)(Math.random()*15);
			System.out.print(cnt + " 's pick = " +n );
			// boolean b = set.add(n);	// 저장성공여부가 나옴.
			// boolean b = set.add( Integer.valueOf(n) );	// 저장성공여부가 나옴.
			boolean b = set.add( new Integer(n) );	// 저장성공여부가 나옴.
			System.out.println("  / add result = "  + b);
		}
		System.out.println(set.toString());	// 가지고 있는 데이터를 문자열로 만들어줌.
		// 이 외에도 더 추가적인 기능이 있는데, Collection 형 객체를 다룰때 보게 될꺼임. 
		// 지금은 Wrapper 객체가 어떨때 사용이 되는지 보고 넘어가면 된다.
	}
}

/*
 * 어제 만든 HangmanWordMain 에 
 * char 의 객체타입을 관리할 LinkedHashSet 객체를 생성시켜서
 * 사용자가 입력한 문자를 mark 돌리기 전에, add 시켜서 true 가 뜨면 mark를 시키고
 * false 가 뜨면 이미 입력한 문자다고 알려주고, 이때까지 입력한 문자들을 전부 다 출력
 *    
 * 
 */










