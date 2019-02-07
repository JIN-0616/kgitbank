
/*
 * Math 객체는
 * 	Wrapper용 객체는 아니지만, 수학에 관련된 기능을 모아둔 객체. 
 */
public class Source06_Math {
	public static void main(String[] args) {
		// new Math(); // 생성해서 사용하는 객체가 아니다.
		// public final class Math {
		//		private Math() {}     //생성자를 막아둠
		
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		// double abs{double}, float abs{float}, int abs{int}, long abs{long}
		
		int n = Math.abs(-3); // 절대값
		System.out.println(n);
		
		// double cell(double), double floor(double), double round(double)
		
		System.out.println(Math.ceil(3.7));  // 값 올림
		System.out.println(Math.floor(3.7)); // 값 내림
		System.out.println(Math.round(3.7)); // 반올림 
		
		// min, max
		int m = Math.min(3,5);
		System.out.println(m);
		System.out.println("------------------------------------");
		
		// 로그 관련 기능
		System.out.println(Math.log10(10000));
		System.out.println(Math.log(10000));
		
		// pow , sqrt, exp
		double t = Math.exp(4);
		
		System.out.println(t);
		System.out.println(Math.log(t));
		
		// 삼각함수 : sin, cos, tan, asin, acos, atan, toDegrees, toRadians
		double r30 = Math.toRadians(30);
		double sin30 = Math.sin(30);
		
		System.out.println(sin30);
		
		
	}
}
