/*
	미용실 경영 타이쿤 게임을 만들려고 함.
	손님, 헤어디자이너, 아르바이트생 객체가 필요함.


	상속의 장점. 
	 설계해야될 객체가 많을때 공통점을 추출해서 하나를 만들어두고, 
	 나머지는 다 확장시켜 추가부분만 설계함으로써 빠르게 객체를 설계할수 있음.
*/
abstract class Sims {
	int age;
	boolean gender;
	Sims() {

	}
	Sims(int a, boolean g) {
		age =a;
		gender = g;
	}

	String inform() {
		return age+"세 / "+ (gender? "여성":"남성");
	}
	// ... 이안에 만들고자 객체들중에 겹치는부분을 다 설계
}
//====================================================================================
class Guest extends Sims {
	long create;
	Guest(int a, boolean g) {
		super(a, g);
		create = System.currentTimeMillis();
	}
	boolean handled() {
		long now =System.currentTimeMillis();
		if(now - create <=5000)
			return true;
		else
			return false;
	}
}
//====================================================================================
class HairDesigner extends Sims {
	String name;
	boolean special;

	HairDesigner(String n, int a, boolean g, boolean s) {
		super(a, g);
		name = n;
		special = s;
	}

	String detail() {
		return name+" / " + inform() + " / 추가능력 " + (special ? "보유" :"없음");
	}
}
