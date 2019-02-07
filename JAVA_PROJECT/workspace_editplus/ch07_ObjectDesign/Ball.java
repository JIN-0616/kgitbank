/*
	공 을 객체화

	프로그램을 만드는데 있어서 객체를 설계하는데,
	관련된것들은 묶어서 패키지(폴더) 처리해서 설계하는걸 권장한다.

	(이제까지 따로 패키지 처리하지 않은 객체들은 default 패키지 소속으로 설계가 된다)
	패키지를 지정해서 설계한 객체들은 컴파일 시 방법이 다르다.
	
	-2가지 방법

	1. 옵션으로 해결하는 방법
		javac -d , 파일명(.java 포함) / 일반 컴파일:  javac 파일명(.java포함)
		- 만들면서 폴더로 들어가지는게 정상처리
	
	2. 처리할 패키지를 작업폴더기준으로 만들어서 소스파일을 그 안에 저장
*/

package baseball;

public class Ball {
	//private int course;	//private를 지정하면 같은패키지에서도 접근불가
	public int course;
	public int speed;
	
	public Ball(int sp, int co){
		this.speed = sp;
		this.course = co;
	}

	public String current(){
		String str = speed + "Km ";
		switch(this.course){
		case -1:
			return str + "바깥쪽 코스";
		case 0:
			return str + "물린 코스";
		case 1:
			return str + "안쪽 코스";
		}
		return str + "알수없는 코스";

	}
}
