package java_plus;
	/*
	2. 메소드
	 1) 메소드의 정의
	  
	  리턴형 메소드이름(자료형 인수, 자료형 인수2, ...){
	  
	  	//인수는 생략가능
	  	
	  	실행문...
	  	
	  }
	
	 2) 메소드의 요소
	  1. 인수
	  	- 여러 자료형과 클래스를 받을 수 있다.
	  	- 클래스나 배열형은 주소참조를 조심
	  	- 지역변수나 멤버변수의 이름이 같을경우
	  	// 지역변수에 우선권이 있다.
	  	// 멤버변수에 접근하고자 할 경우 접근자 this 활용
	  
	  2. 리턴
	  	- 하나의 자료형태만 리턴가능함
	  	- 여러개의 리턴이 필요할 경우 상황에 따라 배열, 클래스형태를 이용
	  	- 메소드 내부에 메소드를 호출할 경우 리턴을 많이 사용
	  	- 멤버변수일 경우에는 구지배기 리턴을 사용할 필요 없음
	  	- 리턴값을 받을 처리를 해 주어야 한다
	  	
	  3. 메소드 안에 메소드를 호출하여 사용할 수 있다.
	   	- 각 작업단위의 메소드를 생성
	   	 : 작업 프로세스가 재사용이 용이
	   	- 메인 단위의 업무 메소드를 설정하여 작업자의 이해를 도모
	   
	*/
class cla_4_data { 
	int kor, eng, mat, sum;
	String name;
}

class cla_4_ret {
	cla_4_data dd = new cla_4_data(); //멤버변수 클래스
	int a=50;	


	void aSet(int a) {
		//지역변수와 멤버변수의 이름이 같은 경우
		//지역변수에 우선권이 있다
		//멤버변수에 접근하고자 할 경우 접근자 this 활용
		System.out.println("지역변수 a : "+a );
		System.out.println("멤버변수 a : "+this.a);
		return;
	}

	void dd_cal(String name, int kor, int eng, int mat) {
		ddSet(name, kor, eng, mat);
		ddPrint();
		return;
	}
	
	void ddSet(String name, int kor, int eng, int mat) {
		//멤버변수를 이용한 처리
		this.dd.name=name;
		dd.kor = kor;
		dd.eng = eng;
		dd.mat = mat;
		dd.sum = kor+eng+mat;
	}
	
	void ddPrint() {
		//멤버변수를 이용한 처리
		System.out.println(dd.name+"\t");
		System.out.println(dd.kor+"\t");
		System.out.println(dd.eng+"\t");
		System.out.println(dd.mat+"\t");
		
	}
	
	void meth_1() {
		System.out.println("메소드 출력");
		return; //return이 아무런 내용이 없음
	}
	
	int meth_2(int a, int b) {
		return a+b;
	}
	
	int[] meth_3(int a, int b) {
		int[] res = new int[2];
		res[0] = a+10;
		res[1] = b+10;
		return res;	
	}
	
	void meth_3_print(int res[]) {
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]+", ");		
		}
		System.out.println();
	}
	
	void meth_uni(int a, int b) {
		//각기 프로세스를 가진 메소드를 호출하여 만든 메소드
		
		//1. 연산부
		int res[] = meth_3(a,b);
		
		//2. 출력부
		meth_3_print(res);
	}
}
public class Chap07_2_method {
	public static void main(String[] args) {
		cla_4_ret aa = new cla_4_ret();
		
		aa.meth_1();
		
		System.out.println(aa.meth_2(10, 20));
		//System.out.println(aa.meth_3(10,20));

		aa.meth_uni(40, 50);
		//int res[]=aa.meth_3(40,50);
		//aa.meth_3_print(res);
		
		
		aa.dd_cal("수지", 34, 45, 56);
		
		
		//지역변수vs멤버변수 확인메소드
		aa.aSet(500);
	}
}

	
	
	
	
	

