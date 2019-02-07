/*
	Chess (8x8) 를 구현하는데 있어서 객체들을 만들어보고, 테스트를 해보자

	- Pawn / Bishop / Knight / Rock / Queen / King
	- 이 객체들을 다 따로 설계를 하려고 하는데, 공통적인 부분들도 있고, 기능들도 있음
	이걸 상속구조를 이용해서 설계해보자.
*/

class Piece {
	/*
		왼쪽위 0,0 - 오른 아래 7.7 (배열구조- 후에 편하게)
	*/
	int x;	// 말의 x 좌표를 저장시킬 변수
	int y;  // 말의 y 좌표를 저장시킬 변수
	boolean whiteFlag; // 흰색인지 아닌지를 저장시킬 변수

	Piece(int x , int y , boolean whiteFlag ){
		this.x = x;
		this.y = y;
		this.whiteFlag = whiteFlag;
	}

	boolean checkMove(int dx, int dy){
		//이 객체의 x,y를 기준으로 해당 좌표로 이동가능한지 확인해주는 기능
		return false;
		//미리 만들어야 후에 상속받아 사용할때 Override 해서 제어가능
	}
	void confirmMove(int dx, int dy){
		this.x = dx;
		this.y = dy;
	}

	String shape(){
		return "ⓧ"; //오버라이딩해서 폰, 비숍,룩 ... 마다 변경
	}

}
