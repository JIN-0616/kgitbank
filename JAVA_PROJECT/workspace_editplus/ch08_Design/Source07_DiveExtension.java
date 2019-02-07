class Stone {
	int x, y;
	Stone (int x, int y){
		this.x = x;
		this.y = y;
	}
	void move(int nx, int ny){
		System.out.println("stone.move()");
		x= nx;
		y= ny;
	}
	String inform(){
		return "(x="+x+",y="+y+")";
	}
	// 이거 말고 더 기능이 있다고 생각하고... 이 객체를 오랫동안 사용했음
	// 후에, 버전업을 해야되는 상황임
}
//========================================================================
class MemoryStone extends Stone { // 무브회수를 기억하는 Stone
	int cnt;
	MemoryStone(int x, int y){
		super(x,y);
	}
	void memoryMove(int nx, int ny){
		System.out.println("memorystone.memoryMove()");
		cnt++;
		super.move(nx,ny);
	}
	// extends 걸고 설계하면서 같은 형태로 함수를 설계하면 기존의 것은 덮어씌워지고
	// 이 객체를 사용할때, 새로 다시 만들어진 형태로 작동하게된다.

	// 함수 재설계를 통해서 원본기능이 가려지게 되면 이때 super로 지정해야된다.
	// extends 를 걸고 설계하는 쪽에서 원본의 함수(메소드)를 덮어버리는(재설계) 라는걸

	// ==> Override 라고 부른다.
	// 자바는 이걸 지원한다 - 
	// 오버라이드(재정의) 시에는 허용된 것들에 한해서만 가능하고, access를 최소한 유지해야만 한다.
	//							(not final)			(not private, 더 약하게불가,최소 유지 (public)->public)
	// 패턴이 다르면 오버라이드가 아니다.(-> 오버로딩 추가)

	// 함수에 final을 붙이면 수정불가
	// 변수에 final을 붙이면 extends 불가
	void move(int nx,int ny){ 
		System.out.println("memorystone.move()");
		cnt++;
		super.move(nx,ny);
	}
	String inform(){
		return "이동회수:"+cnt+", 현재위치"+super.inform();
	}
}
/*
	기능을 추가해서 구현해도 되지만,
	원래 기능을 바꿔서 설계하는것도 가능하고,(작동되면 안되는것들을 재조정해두는)
	이렇게 되었을때 이 객체를 생성해서 함수 콜을 하게 되면,
	원본의 기능을 작동시키는게 막혀서 작동되게 된다.

*/

//========================================================================
class Source07_DiveExtension {
	public static void main(String[] args)	{
	/*	Stone s = new Stone(1,1);
		System.out.println(s.inform());
		s.move(3,5);
		System.out.println(s.inform());
	*/	
		MemoryStone ms;
		ms = new MemoryStone(5,2);

		ms.move(4,5);
		ms.memoryMove(5,5);
		System.out.println(ms.inform());
		System.out.println(ms.cnt); // 하나만 카운트됨
		
		// Override가 정말 효과를 보는건 다형성과 맞물렸을때이다.

		Stone s = new MemoryStone(0,0); // 상위 타입으로 이 객체를 제어하더라도
		s.move(5,5);					// 작동하는건 MemoryStone 객체이기 때문에
		System.out.println(s.inform()); // 이 객체가 실제로 가지고 있는 함수로 작동을 하게 된다.
										// override된 함수는 변환된 함수 그대로 작동한다.

		/*
			s 라는 변수로 제어가 되는 객체는 Stone 객체타입으로 간주되어 인식되어 사용된다.
			Stone 객체가 만들어지게 됬을때 가지는 기능들만을 호출할수 있음
		*/
		//s.memoryMove(4,5); // 추가된 부분에 대한 부분은 제어가 안됨

		// 이때문에 기능을 만들때 오버라이드를 해서 만들어야되는 상황이 생긴다.

	}
}
