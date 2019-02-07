
/*
 * Math 객체는
 * 	Wrapper용 객체는 아니지만, 수치 계산에 관련된 기능을 모아둔 객체이다. 
 */
public class Source06_Math {
	public static void main(String[] args) {
		// new Math();	// 생성해서 사용하는 객체가 아니다.
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		// double abs(double ) , float abs(float ) , int abs(int ) , long abs(long )
		int n =Math.abs(-3);
		System.out.println(n);
		
		// double ceil(double) , double floor(double) , double round(double)
		System.out.println(Math.ceil(3.7));
		System.out.println(Math.floor(3.7));
		System.out.println(Math.round(3.7));
		
		// min , max 
		int m = Math.min(3, 5);
		System.out.println(m);
		System.out.println("=======================");
		
		// 지수 로그 관련 기능
		System.out.println(Math.log10(10000));
		System.out.println(Math.log(10000));
		// pow , sqrt , exp
		double t = Math.exp(4);
		System.out.println(t);
		System.out.println(Math.log(t));
		
		// 삼각함수 , sin, cos, tan, asin, acos, atan,  toDegrees  toRadians
		
		double r30 = Math.toRadians(30);
		double sin30 = Math.sin(r30);
		System.out.println(sin30);
		
		
		
		
		
	}
}
