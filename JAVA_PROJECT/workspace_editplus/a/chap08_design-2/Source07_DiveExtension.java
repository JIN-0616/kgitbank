class Stone {
	int x, y;
	Stone(int x, int y){
		this.x = x;
		this.y = y;
	}
	void move(int nx, int ny) {
		System.out.println("Stone.move()");
		x = nx;
		y = ny;
	}
	String inform() {
		return "(x="+x+ ", y=" +y+")";
	}
	// 이거 말고 더 기능이 있다고 생각하고... 이 객체를 오랫동안 사용했음.
	// 시간이 지나서 버전업을 해야되는 상황임.
}
//=========================================================
class MemoryStone extends Stone {	// 무브회수를 기억하는 Stone
	int cnt;
	MemoryStone(int x, int y) {
		super(x, y);
	}
	void memoryMove(int nx, int ny) {	
		cnt++;
		super.move(nx, ny);
	}
	// extends 걸고 설계하면서 같은 형태로 함수를 설계하면 이 객체를 사용할때 원래 기능이 덮어씌워지고
	// 새로 다시 만들어둔 기능으로 작동하게 되게 된다. 
	// 함수 재설계를 통해서 원본기능이 가려지게 되면 그럴때 super로 지정해야된다.
	// extends 를 걸고 설계하는 쪽에서 원본의 함수를 덮어버리는(재설계) 하는걸 override 라고 부른다.
	// 자바는 이걸 지원한다. -
	// 재정의 시에는 허용된 것들에 한해서만 가능하고, access를 최소한 유지해야만 한다.
	// 패턴이 다르면 오버라이드가 아니다.
	public void move(int nx, int ny) {	
		System.out.println("MemoryStone.move()");
		cnt++;
		super.move(nx, ny);
	}
	String inform() {
		return "이동회수:"+cnt+",현재위치:" +super.inform();
	}
}
/*
	기능을 추가해서 구현해도 되지만, 
	원래 기능을 바꿔서 설계하는것도 가능하고 (작동되면 안되는것들을 재조정해두는) 이렇게 됬을때
	이객체를 생성해서 함수 콜을 하게 되면, 원본의 기능을 작동시키는게 막혀서 작동되게 된다.
*/
//=========================================================
class Source07_DiveExtension {
	public static void main(String[] args) {
		MemoryStone ms;
		ms = new MemoryStone(5, 2);

		ms.move(4, 5);
		ms.memoryMove(5, 6);
		System.out.println(ms.inform());
		System.out.println(ms.cnt);
		// 오버라이드가 정말 효과를 보는건 다형성과 맞물렸을때이다.

		Stone s = new MemoryStone(0, 0);	//  상위 타입으로 이객체를 제어하더라도
		s.move(5, 5);	// 작동하는건 MemoryStone 객체이기 때문에
		System.out.println(s.inform());	// 이 객체가 실제로 가지고 있는 함수로 작동을 하게 된다.
		
		/*
			s 라는 변수로 제어가 되는 객체는 Stone 객체타입으로 인식되서 사용되서
			Stone 객체가 만들어지게 됬을때 가지는 기능들만을 호출할수 있음.
		*/
		s.memoryMove(4, 5);	// 이건 방법이 없음. 
		// 그것때문에 기능을 만들때 오버라이드를 해서 만들어야되는 상황이 생긴다.

	/*	
		Stone s = new Stone(1, 1);
		System.out.println(s.inform());
		s.move(3, 5);
		System.out.println(s.inform());
	*/
	}
}
