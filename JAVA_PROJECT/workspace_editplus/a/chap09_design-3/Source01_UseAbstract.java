/*
	exer01_에서 chess game을 만드는데 있어서 필요한 객체들을 설계해보앗는데,

	Piece 의 역할..? 이게 없었다면..?
	실제로 생성시켜 사용할 객체들을 제어하기 위해서, 기본틀을 잡을 용도로 설계한 것. 
	(Piece 객체를 직접 생성시켜서 사용하겠다 이런 건 아니였음.)

	이런 용도일때 자바는 추상클래스(abstract ) 형태의 설계를 할수 있게 해두었다.
	이 타입으로 설계했을때는 해당 타입의 객체가 생성이 막히게 되고,
	실제 사용할 객체들의 기능을 호출하기 위해서 만들어두었던 무의미한 함수설계들을
	abstract 처리해둘수 있다.
*/
abstract class Piece {
	int x;
	int y;
	Piece() {
	}
	Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	void confirm(int dx, int dy) {
		x = dx;
		y = dy;
	}
	abstract boolean check(int dx, int dy);
	abstract String shape();
}
//==================================================================================
class Rook extends Piece {
	String shape() {
		return "ⓡ";
	}
	boolean check(int dx, int dy) {
		return dx == dy;
	}
}
//==================================================================================
// 일반 extends 랑은 다르게 abstract type을 extends 를 하게 되면,
// 원본쪽에서 abstract 처리해둔 기능들을 실제로 작동될수 있게 구현해두어야만 컴파일이 되고,
// 객체설계가 완성된다.
class Queen extends Piece {
	String shape() {
		return "ⓡ";
	}
	boolean check(int dx, int dy) {
		return dx * dy >=3;
	}
}


//=====================================================================================
class Source01_UseAbstract {
	public static void main(String[] args) 	{
		// Abstract 처리해둔 타입의 객체들은 생성이 불가능하다. cannot be instantiated
	//	new Piece();
		Piece p = new Rook();	// 객체 제어를 하는데 문제가 없음.
		System.out.println(p.shape());
		System.out.println(p.check(3, 3));
	}
}
