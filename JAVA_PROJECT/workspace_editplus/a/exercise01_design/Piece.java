/*
	Chess (8 x 8) 를 구현하는데 있어서 객체들을 만들어보고, 테스트를 해보자.

	- Pawn / Bishop / Knight / Rook / Queen / King 
	- 이객체들을 다 따로 설계를 하려고 하는데, 공통적인 부분들도 있고 , 기능들도 있을거다.
	이걸 상속구조를 이용해서 설계해보자.
*/
abstract class Piece {
	int x;	// 말의 x 좌표를 저장시킬 변수
	int y;	// 말의 y 좌표를 저장시킬 변수
	boolean whiteFlag;	// 흰색인지 아닌지를 저장시킬 변수
	
	Piece() {
		this.x = (int)(Math.random()*8);
		this.y = (int)(Math.random()*8);
		this.whiteFlag = Math.random()>0.5;
	}

	Piece(int x, int y, boolean whiteFlag) {
		this.x = x;
		this.y = y;
		this.whiteFlag = whiteFlag;
	}

	boolean checkMove(int dx, int dy) {	
		// 이 객체의 x,y를 기준으로 해당 좌표로 이동가능한지 확인해주는 기능	
		// 이기능 무의미하게 작동함.
		return Math.random()>0.7;
	}

	void confirmMove(int dx, int dy) {
		this.x = dx;
		this.y = dy;
	}

	String shape() {
		// 이기능 무의미하게 작동함.
		return "not used";
	}
	/*
		checkMove(int, int) , shape()  이 두 기능은 일단 대충 만들어둔건데, (어떤 목적을 수행하지 않는다.)
		이걸 지우면 안되고, 이렇게 대충이라도 만들어둬야 되는 이유가 무엇인가..?

		만약 이 객체가 이 기능이 없다면(지우면..?)..
	*/
}
