/*
	�� �� ��üȭ.
	
	���α׷��� ����µ� �־ ��ü�� �����ϴµ�, 
	���õȰ͵��� ��� ��Ű��(����) ó���ؼ� �����ϴ°� �����Ѵ�.
	
	(�������� ���� ��Ű�� ó������ ���� ��ü���� ����Ʈ ��Ű�� �Ҽ����� ���谡 �ȴ�./)
	��Ű���� �����ؼ� ������ ��ü���� �����Ͻ� ����� �ٸ���.

	1. �ɼ����� �ذ��ϴ� ���
		javac -d . ���ϸ�(.java ����) /    cf.�Ϲ� ������ : javac  ���ϸ�(.java ����)

	2. ó���� ��Ű���� �۾������������� ����

*/

package baseball;

public class Ball {
	int speed;
	int course;

	Ball(int sp, int co) {
		this.speed = sp;
		this.course = co;
	}

	String current() {
		String str = speed+"Km ";
		switch(this.course) {
		case -1:
			return str + "�ٱ��� �ڽ�";
		case 0:
			return str + "���� �ڽ�";
		case 1:
			return str + "���� �ڽ�";
		}
		return str + " �˼����� �ڽ�";
	}
}