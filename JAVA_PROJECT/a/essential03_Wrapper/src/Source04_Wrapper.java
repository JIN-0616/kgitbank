
public class Source04_Wrapper {
	public static void main(String[] args) {
		/*
		 * Wrapper 객체를 설계하면서,실제 객체가 가지고 데이터를 토대로
		 *	 equals 나 compareTo 로 데이터를 비교할수 있는 기능들을 대부분 구현해두었다.
		 * 
		 * 데이터를 기반으로 작동하는 기능들은 유용한 기능들이 많지는 않다.
		 * 
		 * static 으로 해당 타입의 데이터를 다룰때 사용할 기능들이 훨씬 유용한 것들이 많다. 
		 */
		Boolean b = new Boolean(true);
		Integer i = 44;
		i.doubleValue();
		boolean a = Boolean.logicalOr(true, false);
		System.out.println(a);
		
		/*
		 * 이 Wrapper 에 구현된 중요한 기능이 
		 * String 을 분석해서 해당 type의 데이터를 만들어내는 기능이다.
		 * (valueOf 를 이제까지 써왔기 때문에, 그걸 써도 되긴 함)
		 */
		boolean r1 = Boolean.parseBoolean("true");
			int r2 = Integer.parseInt("123");
			int r3 = Integer.valueOf("123");
		double r4 = Double.parseDouble("3.144");
			float r5 = Float.parseFloat("1.4");
			
		/*
		 *  ※ Wrapper 객체는 String ==> data 로 분석할수 있는 parsing 기능이 존재한다! 	
		 */
			
			
			
	}
}


