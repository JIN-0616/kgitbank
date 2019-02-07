/*
	�̿�� �濵 Ÿ���� ������ ������� ��.
	�մ�, �������̳�, �Ƹ�����Ʈ�� ��ü�� �ʿ���.


	����� ����. 
	 �����ؾߵ� ��ü�� ������ �������� �����ؼ� �ϳ��� �����ΰ�, 
	 �������� �� Ȯ����� �߰��κи� ���������ν� ������ ��ü�� �����Ҽ� ����.
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
		return age+"�� / "+ (gender? "����":"����");
	}
	// ... �̾ȿ� ������� ��ü���߿� ��ġ�ºκ��� �� ����
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
		return name+" / " + inform() + " / �߰��ɷ� " + (special ? "����" :"����");
	}
}