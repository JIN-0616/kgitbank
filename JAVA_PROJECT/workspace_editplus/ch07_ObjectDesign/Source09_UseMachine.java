/*
	패키지 처리 안했으니, 디폴트 패키지에서
	패키지 처리된 객체를 사용하는 상황이 되면?

	같은 패키지라면 별도의 지정없이도 연동이 된다.
	타 패키지라면, 이건 지정이 필요하다.
		-지정하는 방법은 두가지인데,
		1. 객체타입앞에 소속을 뭍여두거나,
		2. import 를 처리해두거나

		단, 해당 객체가 public 객체인 경우에 한해서,
	
	설계할수 있는 객체는 기본 access가 같은 패키지에서만 가능하다.
	타 패키지에서도 호환되는 객체타입을 설계하고 싶다면, public 객체로 설계해야된다.
	그래야 import 혹은 소속지정해서 사용할수 있다.
*/

import baseball.PitchingMachine;
import baseball.Ball;
import baseball.Hitter;

class Source09_UseMachine {
	public static void main(String[] args)	{
		Hitter h = new Hitter("로덱");
		//h.levelUpIn(0);

		baseball.PitchingMachine pm = new PitchingMachine(0);
		for(int cnt = 1; cnt<=10; cnt++){
			Ball b = pm.pitch();
			System.out.println(b.current());
			boolean r = h.swing(b);
			System.out.println("스윙결과 : "+r);
			System.out.println(h.current());

			//System.out.println(b.course);
		}
		// new Ball(1,4);
		// ball 생성자가 public이 아니므로 직접생성은 안됨
		// 같은 패키지인 피칭머신을 통해 간접적으로 가능
	}
}
/*
---------- 컴파일 ----------
Source09_UseMachine.java:27: error: course is not public in Ball; cannot be accessed from outside package
			System.out.println(b.course);
			                    ^
1 error

출력 완료 (0초 경과) - 정상 종료
*/

/*
	객체설계시 외부(설계한 패키지를 제외한)에서
	호출이 되면 안되거나, 직접 접근시 문제가 되는 것들을 보호하고,
	안전하게 쓰기 위해서 만들어둔 개념이다.

	객체타입에는 (defalut) / public 이 두개가 설정 가능하고

	변수, 생성자, 함수 에는 chd 4개를 설정할수 있다.

	: private	-같은 패키지에서도 직접 접근은 막히게 됨

	: (defalut)	-기본설정 : 같은패키지에서는 자유롭게 사용

	: protected	-타패키지라도 일부의 경우 접근이 되는 상황이 있음

	: public		-어디서든 자유롭게 접근 가능

	(객체타입은 선언할때 붙여두면 되고,
		변수나, 생성자나, 함수는 앞에다가 각각 지정을 따로 해야 함.)
	
*/

/*
---------- 컴파일 ----------
Source09_UseMachine.java:7: error: cannot find symbol
		PitchingMachine pm = new PitchingMachine();
		^
  symbol:   class PitchingMachine
  location: class Source09_UseMachine
Source09_UseMachine.java:7: error: cannot find symbol
		PitchingMachine pm = new PitchingMachine();
		                         ^
  symbol:   class PitchingMachine
  location: class Source09_UseMachine
Source09_UseMachine.java:9: error: cannot find symbol
			Ball b = pm.pitch();
			^
  symbol:   class Ball
  location: class Source09_UseMachine
3 errors

출력 완료 (0초 경과) - 정상 종료

--> 의도된 결과물
*/

/*
---------- 컴파일 ----------
Source09_UseMachine.java:23: error: constructor PitchingMachine in class PitchingMachine cannot be applied to given types;
		PitchingMachine pm = new PitchingMachine();
		                     ^
  required: int
  found: no arguments
  reason: actual and formal argument lists differ in length
Source09_UseMachine.java:25: error: pitch() is not public in PitchingMachine; cannot be accessed from outside package
			Ball b = pm.pitch();
			           ^
Source09_UseMachine.java:26: error: current() is not public in Ball; cannot be accessed from outside package
			System.out.println(b.current());
			                    ^
3 errors

출력 완료 (0초 경과) - 정상 종료
*/