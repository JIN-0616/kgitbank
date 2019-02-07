
/*
 *  Exception 은 버전별로 계속 추가되고,
 *   개발자들도 만들어서 사용할수 있기 때문에 다 외운다는건 불가능이다.
 */

// 코드상에서 막아낼수 있는 익셉션 RuntimeException, (필수 handle을 안해도 되는 익셉션)
class InvalidException extends RuntimeException{		
	// 하나라도 음수데이터가 있을때를 정의한 익셉션
}

// 익셉션을 설계하는데, 이 익셉션도 RuntimeException 으로 extends 걸어서
// 익셉션 객체 설계 더 하고, 이 익셉션은
// triangle 객체를 만들때, 세 선가지고 삼각형이 안만들어지는 경우에 익셉션을 발생시켜라

class NonTriangleException extends RuntimeException{
	
	/*
		a, b, c 가 변의 길이이고 c가 제일 긴 길이라고 한다면
		c < a + b 이면 삼각형이 성립됨.
    */
}

//==================================================================
class Triangle{
	int x,y,z;
	
	Triangle(int x, int y, int z) {
		if(x<=0 || y<=0 || z<=0 ) {
			throw new InvalidException();
		}
		
		// 하나를 제외한 남은 두개의 합이 다 커야됨
		
		// 최적화 공식
		//if( x+y<=z || x+z<=y || y+z<=x) 
		
		if ((x>y && x>z && x>= y+z)||(y>x && y>z && y>= x+z)||(z>x && z>y && z>= x+y)) {
			throw new NonTriangleException();
		}
		this.x=x;
		this.y=y;
		this.z=z;			
	}
}

public class Source03_Exception {
	public static void main(String[] args) {
		try {
			new Triangle(1, 2, -3);
		} catch (InvalidException e) {
			System.out.println("InvalidException...");
		} catch (NonTriangleException e) {
			System.out.println("NonTriangleException...");
		}
		//------------------------------------------------------
		try {
			new Triangle(3, 4, 1);
			
				//여러가지 예외를 통합해서 표현하는 방법
		} catch (InvalidException | NonTriangleException e) { 
			System.out.println("InvalidException | NonTriangleException");
		}
		
		
	}
}
