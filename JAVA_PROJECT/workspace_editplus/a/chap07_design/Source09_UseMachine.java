/*
	��Ű�� ó�� ��������, ����Ʈ ��Ű������..
	��Ű�� ó���� ��ü�� ����ϴ� ��Ȳ�� �Ǹ�..?

	���� ��Ű����� ������ �������̵� ������ �ȴ�.
	Ÿ ��Ű�����, �̰� ������ �ʿ��ϴ�.
		�����ϴ� ����� �ΰ����ε�,
		1. ��üŸ�Ծտ� �Ҽ��� �ٿ��ΰų�,
		2. import �� ó���صΰų�,

		��, �ش� ��ü�� public Ÿ������ ������ ��쿡 ���ؼ�.
	
	�����Ҽ� �ִ� ��ü�� �⺻ access�� ���� ��Ű�������� �����ϴ�.
	Ÿ ��Ű�������� ȣȯ�Ǵ� ��üŸ���� �����ϰ� �ʹٸ�, public ��ü�� �����ؾ� �Ѵ�.
	�׷��� import Ȥ�� �Ҽ������ؼ� ����Ҽ� �ִ�.
*/

import baseball.PitchingMachine;
import baseball.Ball;
import baseball.Hitter;

class Source09_UseMachine {
	public static void main(String[] args) {
		Hitter h = new Hitter("�θ�");
	//	h.levelUp(0);
	//	h.levelUp(0);
	//	h.levelUp(0);

		baseball.PitchingMachine pm = new PitchingMachine(0);
	
		for(int cnt=1; cnt<=10; cnt++) {
			Ball b = pm.pitch();
			System.out.println(b.current());
			boolean r = h.swing(b);
			System.out.println("������� : " + r);
//			System.out.println(b.course);
		}

		// new Ball(1, 4);
		// new Math();
	}
}

/*
	��ü �����Ҷ� �ܺ�(�������Ű�� ���� ��)���� 
	ȣ���� �Ǹ� �ȵǰų�, ���� ���ٽ� ������ �Ǵ°͵���
	��ȣ�ϰ�, �����ϰ� ���� ���ؼ� �����ص� �����̴�. 

	��üŸ�Կ���  (default) / public  �̰� �ΰ��� �����Ҽ� �ְ�,

	����,������,�Լ� ����   �� 4���� �����Ҽ� �ִ�.
	: private    - ���� ��Ű�������� ���� ������ ������ ��.
	: (default)  - �⺻���� : ������Ű�������� �����Ӱ� ���.(���� ���� ��)
	: protected  - Ÿ��Ű���� �Ϻ��� ��� ������ �Ǵ� ��Ȳ�� ����.
	: public     - ��𼭵� �����Ӱ� ���� ����.

	(��üŸ���� �����Ҷ� �ٿ��θ� �ǰ�, 
		������,�����ڳ�,�Լ��� ����� ������ ������ ���� �ؾ� ��.)
*/
