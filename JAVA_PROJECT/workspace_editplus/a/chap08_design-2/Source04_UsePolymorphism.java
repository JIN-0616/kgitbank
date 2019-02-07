

class Cage {
	static int idx;
	int num;

	Animal one;
	Animal other;
	Cage() {
		num = idx++;
	}
	boolean push(Animal t) {
		if(one==null) {
			one = t;
			return true;
		} else if(other == null) {
			other = t;
			return true;
		} else {
			return false;
		}
	}
	
	Animal birth() {
		if(Math.random() >0.5) {
			return new Tiger();
		} else {
			return new Elephant();
		}
	}
}
//����������������������������������������������������������������������

class Source04_UsePolymorphism {
	public static void main(String[] args) {
		Cage c = new Cage();
		Tiger t = new Tiger();
		c.push(t);
		Korean k = new Korean();
		c.push(k);
		// Ư��Ÿ�Կ� ���ѵ� ó���� �ƴ϶�, �迭��ü�� ó���Ҽ� �ִ� ������ ��� ������ ����������.
		// 
		Animal a = c.birth();
		System.out.println(a);
		System.out.println(a instanceof Tiger);		// ��ü Ÿ��Ȯ��
		System.out.println(a instanceof Korean);	//  "
		
		// ���� ���� Ÿ������ �������� �ʴ���, �� ��ü�� ���µ� ������ ����. 
		Animal h = new Human();
			h.healthUp();
		System.out.println(h.inform());
		
		// extends�� �ɾ ����� �� ��ü�϶�, �˾Ƶ־� �Ǵ� ������ �� �� ������� �� Ư¡���� �����Ҽ� �ִ�.
		
	}
}
