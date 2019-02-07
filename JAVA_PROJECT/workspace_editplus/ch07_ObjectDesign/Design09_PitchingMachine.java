/*
	처리할 패키지 내부에다가 객체를 설계하고, 일반컴파일을 진행해도 됨
*/
package baseball;

public class PitchingMachine {

	int hard;	// 0 , 1 , 2

	PitchingMachine(int hard){
		this.hard = hard;
	}

	Ball pitch(){ //리턴타입이 Ball 객체
		int s = 80 + hard*20 + (int)(Math.random()*20);
		int c = -1 + (int)(Math.random()*3);
		
		Ball b = new Ball(s, c);
		return b;
	}
}
/*
---------- 패키지컴파일 ----------
Design09_PitchingMachine.java:6: error: class PitchingMachine is public,
should be declared in a file named PitchingMachine.java

public class PitchingMachine {
       ^
1 error

출력 완료 (0초 경과) - 정상 종료

 --> public 설계시 제한사항 파일명 == 객체명
*/