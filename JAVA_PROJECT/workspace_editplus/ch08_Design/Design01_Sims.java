/*
	미용실 경영 타이쿤 게임을 만들려고 함.
	손님, 헤어디자이너, 아르바이트생 객체가 필요함.

	(public 클래스가 아니므로 파일에 class 여러개 생성가능)

	상속의 장점
	 2. 설계해야될 객체가 많을때 공통점을 추출해서 하나를 만들어두고,
		나머지는 다 확장시켜 추가부분만 설계함으로써 효율적으로 설계가 가능하다.
*/
class Sims {	
	int age;
	boolean gender;
	Sims(){ // 기본생성자가 존재하면 자식클래스에서 super를 사용할필요는 없다.
			// 다만 자식생성자에서 겹치는 부분이 있다면 재활용 차원에서 사용하는것이 가능
			// 코드 효율성차원에서 추천
	}

	Sims(int a, boolean g){
		age= a;
		gender = g;
	}

	String inform(){
		return "("+age+"세/"+(gender? "여성":"남성");
	}
	// 이 안에 만들고자 객체들중에 겹치는부분을 다 설계
}

//=======================================================================
class Guest extends Sims{
	long create;
	Guest(int a, boolean g){
		super(a,g);	// 매개변수로 넘겨버림, 직접 세팅을 하지 않음
		create = System.currentTimeMillis();		
	}

	boolean handle(){
		long now = System.currentTimeMillis();
		if(now - create <=5000){
			return true;
		}else
			return false; 
	}
}
//=======================================================================
class HairDesigner extends Sims{
	String name;
	boolean special;

	HairDesigner(String n, int a, boolean g, boolean s){
		super(a,g);	// 매개변수로 넘겨버림, 직접 세팅을 하지 않음
		name = n;
		special = s;
	}

	String detail(){
		return name + " / "+inform() +" / 추가능력 " + (special?"보유":"없음");
	}

}