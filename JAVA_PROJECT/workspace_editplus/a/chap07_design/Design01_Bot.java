/*
	����� ��ü�� �����ϸ鼭, ������ ���念�� �̶�, �ؾߵ� ����� �������
	�����صξ���ϴ��� ���캸�Ҵ�. 
	�̰� ���� ����� �߿��� �κ��̱� �ϳ�, �׿ܿ� �˾Ƶθ� ���� �͵��� �� �����Ѵ�.

	1. constructor (������)
		: ��ü�� ����� �� ����, �ʱ�ȭ�� ��Ű�°� �ƴ϶�
		��������鼭 ����°� ���ֱ� ���Ҷ� �����صθ� ����.
		�����ϴ� ��ü������ ����Ÿ�Ծ��� Procedure ���·� �����ϸ� �ȴ�.
		: ������ �ʿ��� �����͸� �ѱ�鼭 ��������Ե� ������ �����ϴ�.

		: ��ü �����ڸ� �ϳ��� �����صѼ� �ִ°� �ƴϴ�. �����ε��� �����ϴ�.
	
*/
class Bot {
	static int per;
	int stamina;	// ü��
	int count;		// �۾�ȸ��
	
	Bot(int initStamina) {
		stamina = initStamina;
		count = 0;
		System.out.println("constructed..");
	}

	Bot() {
		stamina = 100;
		count = 0;
		System.out.println("constructed..");
	}	

	void init() {
		stamina = 100;
		count = 0;
	}

	String tell() {
		return "STAMINA : " + stamina+ ", COUNT = "+ count;
	}
	
	boolean move(int distance) {
		/*
			���޹��� �Ÿ���ŭ �̵��Ѵٰ� �����ϰ�,
			ü�¼Ҹ� �̵��Ÿ� 10�� 1��
			�� ��ü�� �̵��� �ʿ��� ���¹̳ʰ� �ִٸ�, count++,
			�Ҹ� stamina ���� ���ҽ�Ű�� return true
			�װ� �ƴϸ� return false
		*/
		/*
		int need = 0;
		while(distance >0) {
			need++;
			distance -=10;
		}
		*/
		int need = distance/10;
		if(distance % 10 > 0)
			need++;
		
		// System.out.println("need =  "+ need);
		if(stamina>=need) {
			stamina -= need;
			count++;
			return true;
		}else {
			return false;
		}

	}
}