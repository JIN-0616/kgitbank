/*
	패키지 처리 안했으니, 디폴트 패키지에서..
	패키지 처리된 객체를 사용하는 상황이 되면..?

	같은 패키지라면 별도의 지정없이도 연동이 된다.
	타 패키지라면, 이건 지정이 필요하다.
		지정하는 방법은 두가지인데,
		1. 객체타입앞에 소속을 붙여두거나,
		2. import 를 처리해두거나,

		단, 해당 객체가 public 타입으로 설계한 경우에 한해서.
	
	설계할수 있는 객체는 기본 access가 같은 패키지에서만 가능하다.
	타 패키지에서도 호환되는 객체타입을 설계하고 싶다면, public 객체로 설계해야 한다.
	그래야 import 혹은 소속지정해서 사용할수 있다.
*/

import baseball.PitchingMachine;
import baseball.Ball;
import baseball.Hitter;

class Source09_UseMachine {
	public static void main(String[] args) {
		Hitter h = new Hitter("로멕");
	//	h.levelUp(0);
	//	h.levelUp(0);
	//	h.levelUp(0);

		baseball.PitchingMachine pm = new PitchingMachine(0);
	
		for(int cnt=1; cnt<=10; cnt++) {
			Ball b = pm.pitch();
			System.out.println(b.current());
			boolean r = h.swing(b);
			System.out.println("스윙결과 : " + r);
//			System.out.println(b.course);
		}

		// new Ball(1, 4);
		// new Math();
	}
}

/*
	객체 설계할때 외부(설계된패키지 제외 한)에서 
	호출이 되면 안되거나, 직접 접근시 문제가 되는것들을
	보호하고, 안전하게 쓰기 위해서 구현해둔 개념이다. 

	객체타입에는  (default) / public  이걸 두개를 설정할수 있고,

	변수,생성자,함수 에는   총 4개를 설정할수 있다.
	: private    - 같은 패키지에서도 직접 접근은 막히게 됨.
	: (default)  - 기본설정 : 같은패키지에서는 자유롭게 사용.(직접 접근 됨)
	: protected  - 타패키지라도 일부의 경우 접근이 되는 상황이 있음.
	: public     - 어디서든 자유롭게 접근 가능.

	(객체타입은 선언할때 붙여두면 되고, 
		변수나,생성자나,함수는 선언시 일일이 지정을 따로 해야 함.)
*/

