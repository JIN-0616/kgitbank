
public class Source03_Wrapper {
	public static void main(String[] args) {
		// 특정 데이터를 가진 Wrapper 객체를 만들어내는 법은
		// 생성이 전부가 아니다.
		
		// 모든 Wrapper 객체는 valueOf 라는 기능이 있는데, 이걸 통해서도 만들어낼수가 있다.
		// 매개변수로 설정가능한건, 각 객체의 데이터 타입이나, String 이다.
		Boolean b1 = new Boolean(true);
		Boolean b2 = Boolean.valueOf(true);
		Boolean b3  = Boolean.valueOf("true");
		
		System.out.println(Boolean.TRUE == b2);
		
		Integer i1 = new Integer(41);
		Integer i2 = Integer.valueOf(41);
		Integer i3 = Integer.valueOf("41");	// 해본 패턴..
		System.out.println(i2 == i3);
		/*
			String d = "135000";
			int v = Integer.valueOf(d);		// 이처리는 실제 언박싱된 int값을 확보하게 된다.
		*/
		// b1 == b2  같은객체 ?  / b2 == b3 같은객체?
		// i1 == i2  같은객체 ?  / i2 == i3 같은객체?
		/*
		 * valueOf를 이용해서 확보하는 Wrapper객체는 미리 만들어진 객체를 준다.
		 * 	(Boolean 은 true 가지고 있는 객체랑, false 가진 객체를 미리 만들어두고 둘중에 하나를 리턴)
		 * 수치형 Wrapper 같은 경우는 , -128 ~ 127 까지만 만들어두고, 그사이객체는 만들어진걸 리턴
		 * 	범위밖은 새로 만듬.
		 * 
		 * 자동 Boxing  일어날때 , valueOf()로 객체를 확보한다
		 */
		
		Double d1 = Double.valueOf(3.14);
		Double d2 = 3.14;
		System.out.println(d1 == d2);
		
		
		
	}
}
