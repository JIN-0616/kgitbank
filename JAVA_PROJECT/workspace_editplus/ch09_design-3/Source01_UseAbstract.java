/*
	exer01_에서 chess game을 만드는데 있어서 필요한 객체들을 설계해보았는데,

	Piece의 역활..? 이게 없었다면..?
	실제로 생성시켜 사용할 객체들을 제어하기 위해서, 기본틀을 잡을 용도로 설계한 것
	(Piece 객체를 직접 생성시켜서 사용하겠다 이런 건 아니었음)

	이런 용도일때 자바에서는 추상클래스 (abstract) 형태의 설계를 할수 있게 해두었다.
	이 타입으로 설계했을때는 해당 타입의 객체가 생성이 막히게 되고,
	실제 사용할 객체들쪽에서 오버라이드시킨걸 호출하기 위해서 만들어두었던
	무의미한 함수설계들을 abstract 처리해둘수 있다.


*/
abstract class Piece {
	int x;
	int y;
	Piece(){

	}
	Piece(int x, int y){
		this.x = x;
		this.y = y;
	}
	void confirm(int dx, int dy){
		x = dx;
		y = dy;
	}
	/*
	boolean check(int dx, int dy){
		return true;
	}
	*/
	abstract boolean check(int dx, int dy);
	// 선언만 필요한것들 -> abstract 처리하고 선언만하고 pass
	// class 자체가 abstract 이어야만 내부 메소드를 abstract 처리할수 있다.
	// 틀잡는 용도로 사용시에 적절한 설계방식
	abstract String shape();
}
//==================================================================================

class Rook extends Piece {
	String shape(){
		return "ⓡ";
	}
	boolean check(int dx, int dy){
		return dx == dy;
	}
}
//==================================================================================
/*
	일반 extends 랑은 다르게 abstract type을 extends를 하게되면,

	부모클래스 쪽에서 abstract 처리해둔 기능들을,
	자식클래스 객체에서 실제로 작동될수 있게 구현해두어야만 

	컴파일이 되고, 객체설계가 완성된다.
*/

class Queen extends Piece{
	String shape(){
		return "r";
	}
	boolean check(int dx, int dy){ 
		return dx == dy;
	}
	//위에서 abstract 붙인 메소드는 -> shape, ckeck 설계 필수사항
}

//==================================================================================
class Source01_UseAbstract {
	public static void main(String[] args)	{
		// abstract 처리해둔 타입의 객체들은 생성이 불가능하다. cannot be instantiated
		// new Piece(); --> Error
		// 타입으로써 무의미하다는 것은 아니다.

		Piece p = new Rook(); // 객체 제어를 하는데 문제가 없음
		
		System.out.println(p.shape());
		System.out.println(p.check(3,3));
	}
}
