/*
	처리할 패키지 내부에다가 객체를 설계하고, 일반컴파일을 진행해도 됨
*/
package baseball;

/*
	패키지 처리했다면,
	public 으로 설계해두어야 타 패키지에서 연동이 됨.
	(public으로 설계하려면 파일이름을 무조건 일치시켜야 함)

	public class 인 경우라면 인식되긴 하지만,

	그 안에 설계된 생성자, 변수, 함수가 호출되는건 별도로 다시 지정을 해야만 한다.
*/
public class PitchingMachine {

	int hard;	// 0 , 1 , 2

	public PitchingMachine(int hard){
		this.hard = hard;
	}

	public Ball pitch(){ //리턴타입이 Ball 객체
		int s = 80 + hard*20 + (int)(Math.random()*20);
		int c = -1 + (int)(Math.random()*3);
		
		Ball b = new Ball(s, c);
		if(Math.random() >0.8){
			b.course = -2;
		}
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