import java.util.Scanner;

/*
 * Exception 은 버전별로계 속 추가되고, 
 * 	개발자들도 만들어서 사용할수 있기 때문에 다 외운다는건 불가능이다.
 */

// 코드상에서 막아낼수 익셉션은 RuntimeException , (필수 handle을 안해도 되는 익셉션)
class InvalidException extends RuntimeException {	
	// 하나라도 음수데이터가 있을때를 정의한 익셉션 
}
// 익셉션을 설계하는데, 이 익셉션도 RuntimeException 으로 extends 걸어서
// 익셉션 객체 설계 더 하고, 이 익셉션은
// Triangle 객체를 만들때, 세선가지고 삼각형이 안만들어지는 경우에 익셉션을 발생시키자.
class NotEnoughException extends RuntimeException {
	
}
//=============================================================
class Triangle {
	int x,y,z;
	
	Triangle(int x, int y, int z) {
		if(x<=0 || y<=0 || z <=0) {
			throw new InvalidException();
		}
		// 하나를 제외한 남은 두개의 합이 다 커야 됨.
		if( x+y<=z || x+z <= y ||  y+z <= x   )
			throw new NotEnoughException();
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Source03_Exception {
	public static void main(String[] args) {
		try {
			new Triangle(3, 4, 3);
		}catch(InvalidException e) {
			System.out.println("InvalidException .. ");
		}catch(NotEnoughException e) {
			System.out.println("NotEnoughException .. ");
		}
		//=======================================================
		
		try {
			new Triangle(3, 4, 1);
		}catch( InvalidException | NotEnoughException e  ) {
			System.out.println("InvalidException | NotEnoughException");
		}
		
		
		
		
		
		
	}
}


