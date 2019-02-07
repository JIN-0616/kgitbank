/*
	procedure �� �̿��� UpDown Game�� �����غ��Ҵµ�, 
	�����Ͱ����� ó���� ���� ���ϰ� �ϱ� ���ؼ� UpDownEngine ��ü�� �����غ���
	�װ� ���� �ѹ� �� 1�ο�, �������� ������. 
*/
class UpDownEngine {
	// storage
	int target;	// ����-
	int min, max;	// ������ �ּҰ��� �ִ밪
	int tried;	// �õ�ȸ��
	boolean flag;	// �������� �ȳ������� �����ѵ� ��

	//==================================================
	// ������ü �ʱ�ȭ
	void start() {
		// target �� 1~200���� �������� �����ǰ�
		target = 1+(int)(Math.random()*200);
		// min, max �� 1�� 200���� �����ǰ�
		min =1;
		max =200;
		// tried �� 0 �̵ǰ�
		tried = 1;
		// flag �� true�� �ٲ��
		flag = true;
	}

	int recommend() {
		if(Math.random() >0.95) {
		// min ~ max ���� ���� �� �������� �ϳ��� ������ְ�
			return min + (int)(Math.random()* (max-min +1));
		}else {
			return target;
		}
	}

	String compare(int data) {
		// ���޹��� ���ڿ� �ڽ��� target �� ���ؼ�
		// "CORRECT", "TOO HIGH" , "HIGH" , "LOW", "TOO LOW"
		//   ������    data�� Ÿ�ٺ��� ū�� �� ���� 50 ������ "TOO HIGH", �׷��� ������ "HIGH"
		// data�� �ڽ��� target���� ������ ������ 50�� ������ "TOO LOW", �׷��� ������ "LOW"
		tried++;
		if(data == target) {
			flag = false;
			return "CORRECT";
		}else if(data <target) {
			min = data >min ? data : min ;
			if(target-data >50) 
				return "TOO LOW";
			else
				return "LOW";
		}else {
			if(data <max)
				max = data;

			if(data-target >50) 
				return "TOO HIGH";
			else
				return "HIGH";
		}

		// �̰��ϸ鼭 ���ÿ�, min~ max �����صΰ�, tried �ø���, ������ flag�� false�� �ٲٰ�.
	}

	boolean isRun() {
		// ������ �۵������� �ƴ��� �˷��ֱ�
		return flag == true;
	}

	String tell() {
		// ���� �ڽ��� ���� ���¸� ����¥�� ���ڿ��� ���� �˷��ֱ�
		return tried+"'s TRY ("+min +" ~ "+max+") ";
	}
}