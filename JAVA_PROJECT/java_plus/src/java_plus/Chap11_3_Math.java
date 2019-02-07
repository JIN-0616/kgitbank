package java_plus;

import java.util.Scanner;

/*
	3.Math
	 수학연산 클래스
	 - 생성자가 private이므로 new를 통한 객체 생성이 불가능하다
	 - method는 static이므로 : 별도의 객체 인스턴스가 필요없다.
	
	#상수
	 - Math.PI(원주율)
	 - Math.E(자연로그 및)
	
	#메소드
	 -cell() : 올림
	 -floor() : 버림
	 -round() : 반올림
	 -abs() : 절대값
	 -rounds : 반올림
	 -max() : 최대값
	 -min() : 최소값
	 
	 -삼각함수
	 . toRadias() : 각도를 라디안으로 변환한다.
	 . toDegrees() :  라디안을 각도로 변환한다.
	 . sin() : sin함수
	 . cos() : cos함수
	 . tan() : tan함수
	 
	 -과학 계산용 프로그래밍시 자주 필요로 하는 함수
	 . exp() : 입력받은 인수에 대한 상수e의 지수승을 계산
	 . log() : 입력받은 인수의 자연 로그 값을 계산
	 . pow() : 첫번째 인수를 두번째 인수 승 하여 반환
	 .sqrt() : 제곱근을 구한다.
	 -random() : 0.0~1.0 사이의 랜덤 한 실수를 생성한다. (0.0000000.... ~ 0.99999999)
	 
*/
public class Chap11_3_Math {
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.ceil(34.46)); //올림
		System.out.println(Math.floor(34.76)); //내림
		System.out.println(Math.round(34.46)); //반올림
		System.out.println(Math.abs(34.46)); //절대값
		System.out.println(Math.max(20, 30));//큰수
		System.out.println(Math.min(20, 30));//작은수
		System.out.println(Math.pow(2,3));	 //지수
		System.out.println(Math.sqrt(2));	 //제곱근
		System.out.println(Math.random()); 	 //난수 0< 난수 <1
		
		System.out.println((int)(Math.random()*46)+5); //난수
		
		System.out.println("참참참 게임");
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while(input!=3) {
			System.out.println("1:왼쪽, 2:오른쪽, 3:종료");
			System.out.println("입력: ");
			input = sc.nextInt();
			int com = (int)(Math.random()*2)+1;
			if(com==input)
				System.out.println("패");
			else
				System.out.println("승");
			
		}
		System.out.println("게임종료");
	}

}
