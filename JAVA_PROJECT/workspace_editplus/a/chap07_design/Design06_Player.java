
class Player {
	String name;
	int balance;

	/*
		�� Player��ü�� ���������, name�� balance �� �� �����ؼ� ����� �ְԵ� ������ ����
		�̸��� �����ؼ� ����� �ְԵ� ����(�̸��� �����ϴ� ���� 100000���� �ʱ��ڱ����� ������ �ְ�)
	*/
	Player(String name) {
		this(name,100000);
//		this.name = name;
//		balance = 100000;
	}

	Player(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}

	String current() {
		return name + " (�ں��� ��"+balance+")";
	}
}