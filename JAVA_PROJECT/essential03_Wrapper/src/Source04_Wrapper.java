
public class Source04_Wrapper {
	public static void main(String[] args) {
		/*
		 * Wrapper 객체를 설계하면서, 실제 객체가 가지고 데이터를 토대로
		 * 	equals 나 compareTo 로 데이터를 비교할수 있는 기능들을 대부분 구현해둠
		 *  
		 *  데이터를 기반으로 작동하는 기능들은 그렇게 유용한 기능들이 많지는 않다.
		 *  
		 *  static으로 해당 타입의 데이터를 다룰때 사용할 기능들이 훨신 유용한 것들이 많다.
		 */
		Boolean b = new Boolean(true);
		//메소드 중에 아이콘에 S붙어있는것들은 static 붙어있음, 생성없이 바로접근가능
		
		Integer i = 44;
		i.doubleValue();
		boolean a = Boolean.logicalAnd(true, true);
		System.out.println(a);
		boolean aa = Boolean.logicalOr(true, false);
		System.out.println(aa);
		
		/*
		 * 이 Wrapper 객체에 구현된 중요한 기능들이 (공통기능)
		 *  
		 *  String 을 분석해서 해당 type의 데이터를 만들어내는 기능이다.
		 *  
		 *  ( valueOf 를 이제까지 써왔기 때문에, 그걸 써도 되긴 함 -> 객체생성 ->오토언박싱)
		 */
		
		// Boxing  VS Parsing분석
				
		boolean r1 = Boolean.parseBoolean("true"); // return value가 Boolean이 아닌 boolean값
			int r2 = Integer.parseInt("123"); // parsing 파싱 
			int r3 = Integer.valueOf("123"); // 객체생성 -> 언박싱
		 double r4 = Double.parseDouble("3.14");
		  float r5 = Float.parseFloat("1.4");
		
		 /*
		  *  ※ Wrapper 객체는 String ==> data로 분석할수 있는 parsing 기능이 존재한다. 
		  */

	}
}
