package java_plus;
/*
5. 생성자 coustructor
 정의 : 클래스명(인수){}
 
 호출 : new 클래스명()
 
 클래스를 선언할 때 사용(메모리 할당)
  - 클래스를 선언하지 않고 사용하는 것을 익병클래스라 함 -- 재접근 불가
 
 클래스 생성시 최초 실행되는 작업
 
 메소드처럼 활용
  - 리턴형은 클래스
  - 오버로딩으로 사용가능
  - 생성자에 사용되는 인수가 다르면 생성자메소드가 다른것으로 인지
  
 정의하지 않은 생성자로 클래스를 선언할 수 없음
  - 오버로딩으로 정의되지 않았을 경우 사용불가
 
 생성자 실행시
  - 멤버 변수(1.클래스, 2.인스턴스), 메소드 먼저 메모리 할당 후에 실행  

*/

class con1 {
	int a;
	String s;

	con1() {
		// a=700;
		// s="정우성";
		// con1(700,"정우성"); 생성자로 생성자를 호출불가
		this(700, "정우성"); // 또 다른 생성자로의 접근은 this()를 사용
	}

	con1(int a, String s) { // 클래스이름으로 메소드처럼 정의
		System.out.println("와 생성자다");
		this.a = a;
		this.s = s;
	}
}

class shape_con {
	int r, w, h;

	shape_con(int r) {
		this.r = r;
		System.out.println("원의 넓이 : " + r * r * Math.PI);
	}

	shape_con(int w, int h) {
		this.w = w;
		this.h = h;
		System.out.println("사각형의 넓이 " + w * h);
	}
}

//-------------------------------------------------------------
class Student {
	String name;
	int kuk;
	int yung;
	int su;
	int kyo;
	int sum;
	double avg;

	Student(String name, int kuk, int yung, int su) {
		this.name = name;
		this.kuk = kuk;
		this.yung = yung;
		this.su = su;
		this.sum = kuk+yung+su;
		this.avg = Double.valueOf(String.format("%2f", sum/3.0));
	}

	Student(String name, int kuk, int yung, int su, int kyo) {
		this.name = name;
		this.kuk = kuk;
		this.yung = yung;
		this.su = su;
		this.sum = kuk+yung+su+kyo;
		this.avg = Double.valueOf(String.format("%2f", sum/3.0));
	}
}

//-------------------------------------------------------------

public class Chap07_5_생성자constructor {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		con1 c = new con1();
		System.out.println(c.a);
		shape_con sc1 = new shape_con(5); // 선언 및 생성
		shape_con sc2 = new shape_con(4, 5);

		new shape_con(6, 5); // 생성만 한 클래스 -- 익명클래스 : 재접근이 불가

		shape_con[] sc_arr = { new shape_con(5), new shape_con(10, 4), new shape_con(5, 56), new shape_con(20), };
		System.out.println(sc_arr[1].w);

		// 남학생 : 성명, 국어 , 영어 , 수학, 교련
		// 여학생 : 성명, 국어 , 영어 , 수학
		// 생성자를 이용하여 성명, 성별, 과목, 총점, 평균을 출력하세요
		// 이걸 토대로 반 배열을 만들어 반의 과목별 평균을 계산하세요
		
	}
}
