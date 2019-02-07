package java_plus;
/*

5. 캡슐화 - 멤버변수를 모드 은닉(private)하고 메소드로 접근(public) 하는 것을 통칭

 멤버 변수의 직접접근은 데이터의 값을 변질시킬수 있는 보안의 큰 문제점을 가지고 있음
 변수 (메모리공간)의 직접접근을 제한 하기 위해 private 사용
 메소드 - 접근허용을 위해서 public 사용, 메소드에 의한 변수의 변환이 기본적 방법
 	setter - 변수의 값을 지정
 	getter - 변수의 값을 호출
 	
 	메소드이름 -set변수명(인수)
 				1. 변수명의 첫글자는 대문자
 				2. 사용하는 인수명은 멤버변수와 같은 이름으로 한다.
 				
 			   -get변수명()
 			    1. 변수명의 첫글자는 대문자

 이클립스 활용시
  메뉴 - source - generate getters and setters... 로 쉽게 캡슐화 가능
  
 */

class cap_c{
	private String name;
	private String id;
	private int tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	private int a = 10;
	
	public void setA(int a) {
		this.a=a;
	}
	public int getA() {
		return a;
	}
}

class cap_exam{
	private String name;
	private int kor, eng, mat, tot, avg;
	public cap_exam(String name, int kor, int eng, int mat) {
		setName(name);
		setKor(kor);
		setEng(eng);
		setMat(mat);
		setTot();
		setAvg();
	}
	public void print() {
		System.out.println("성명 : "+getName());
		System.out.println("국어 : "+getKor());
		System.out.println("영어 : "+getEng());
		System.out.println("수학 : "+getMat());
		System.out.println("총점 : "+getTot());
		System.out.println("평균 : "+getAvg());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
		
	public void setMat(int mat) {
		this.mat=mat;
	}
	public int getMat() {
		return mat;
	}
	
	public void setTot() {
		this.tot = kor+eng+mat;
	}
	public int getTot() {
		return tot;
	}
	
	public void setAvg() {
		this.avg=tot/3;
	}
	public int getAvg() {
		return avg;
	}
}

public class Chap08_3_캡슐화 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cap_c aa = new cap_c();
		
		//aa.a =30;
		aa.setA(3);
		System.out.println(aa.getA());
		
		cap_exam eee = new cap_exam("장동건",99,88,77);
		
		eee.print();
	}
	// 영화예약 클래스를 생성하여 출력해보세요
	
	// 예약시 필수 입력 사항 : id, 성명, 전화번호, 상영시간, 좌석번호
	
	// 예약후 변경 가능사항 : 성명, 전화번호
	
	// 출력시 모든 항목이 다 있어야 함
}
