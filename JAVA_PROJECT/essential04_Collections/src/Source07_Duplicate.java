import java.util.LinkedHashSet;
import java.util.Set;

public class Source07_Duplicate {
	public static void main(String[] args) {
		/*
		 * Set 형 컬렉션은 중복객체를 저장하지 않는다.
		 *  (객체값이 달라도 어떤 조건을 만족하면, 같은 객체로 인식한다.)
		 *  : integer 객체는 그게 처리가 되어있어서 그렇다.
		 */
		Set<Integer> s = new LinkedHashSet<>();
		s.add(3);	//Boxing되서 Integer 객체가 저장된다.
		s.add(Integer.valueOf(3));
		s.add(new Integer(3));
		System.out.println(s.size());
		
		Integer i1 = new Integer(31);
		Integer i2 = new Integer(31);
		System.out.println(i1==i2);
		System.out.println(s.add(i1));
		System.out.println(s.add(i2)); // i2객체를 가지고 있다고 판단했음
		System.out.println(i1.equals(i2));
		// equals 한 결과가 같고 hashCode가 같아서 같은객체라고 인식함
		// hastCode는 객체가 생성될때 부여되는 절대고유값인데,
		// Integer 객체 같은 경우는 해시코드를 외부에서 확인할때,
		// 코드로 사용하게 해두었다  (Override) hashCode() ----> Object
		System.out.println(System.identityHashCode(i1)+ ", "+System.identityHashCode(i2));
		
		/* cf)
		
			먼저 hashCode()메소드를 호출해서 hashCode가 같은지 판별한다.
			
			만약 hashCode가 같으면 equals 메소드를 실행해보고 같은지 판별한다.
			
			만약 같지 않으면, 두 객체는 같지 않은것이므로 equals메소드를 실행하지 않는다.
			
		*/
		
		// 자바에서 만들어서 제공하는 객체들 같은 경우엔 이렇게 처리를 해둔것들이 많지만,
		// 개발자가 필요에 의해서 설계하는 객체의 경우엔 수동으로 처리를 해두어야 한다.
		// 어떻게..?
		
	}
}
