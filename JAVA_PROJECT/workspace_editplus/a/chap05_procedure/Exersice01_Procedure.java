class Exersice01_Procedure {
	/*
		���ν��� ��� �����ؼ� �װ� ���� �۵��ϴ� ���α׷��� �ϳ� ������.
		���شٿ� ? 
			����ߵǴ� ���ڴ� �������ְ�, 
			����ڷκ��� �Է¹޾Ƽ� ����ڰ� �Է��� ���ڰ� ���� ��ǥ���� �������ڴ� Ȥ�� �������ڴ�
			��°� �˷��ָ鼭 ���ڸ� ���߰� �����ϴ� ���� ����

		�����ʹ� ��ǥ����, ����, �õ��� ȸ�� �� �����Ϸ��� ��.
	*/

	// Ư������������ ���������� ������ ��� : int random(int n1, int n2) { .. 
	static int random(int n1, int n2) {
		return n1+(int)(Math.random()*(n2-n1+1) );
	}
	// 1~200������ �������� ������ ��� : int random() { ..
	static int random( ) {
		return random(1, 200);
	}
	
	// �μ��߿� ū���� ������ִ� ��� : int greater(int n1, int n2) { ..
	static int greater(int n1, int n2) {
		return n1> n2 ? n1 : n2;
	}
	// �μ��߿� �������� ������ִ� ��� : int less(int n1, int n2) { ..
	static int less(int n1, int n2) {
		if(n1<n2)
			return n1;
		else
			return n2;
	}
	// �����ϳ��� ������ ��� : int handle(String data, int min, int max) { ..
	static int handle(String data, int min, int max) { 
		int r;
		switch(data){
		case "":
			r = random(min, max);
			break;
		default :
			r = Integer.valueOf(data);
		}
		return r;
	}

	public static void main(String[] args) {
		int min = 1;
		int max = 200;
		int target = random();
		int tried = 0;
		//������������������������������������������������
		System.out.println("[SYSTEM] UP_AND_DOWN");
		while(tried<10) {
			System.out.print("[SYSTEM] "+ (++tried) + " TRIED ("+min +" ~ "+max+") : ");
			String in = System.console().readLine();
			int got = handle(in, min, max);
				
			handle("",min,max);
			if(got == target) {
				System.out.println("[SYSTEM] CORRECT VALUE !!! " + got);
				break;
			} else if(got<target) {
				System.out.println("[SYSTEM] TARGET VALUE IS GREATER THAN " + got);
				min = greater(got, min);
			} else {
				System.out.println("[SYSTEM] TARGET VALUE IS LESS THAN " + got);
				max = less(got, max);
			}
		}
		/*��������������������������������������������������������������������������������������
			���⼭ �۾��ߴ��� �������,
			��ǻ�Ϳ� ���� �� ���� ���߱�� �ٲ��ֽø� �ȴ�.
			
				1. ����� �Ǵ� ���ڴ� ����ڿ� ��ǻ�ʹ� �ٸ��� �����ش޶�. (������ �ƴ� ����)
				 - �������� �ϳ��� �� �ʿ����� ������.
				2. ������Ϻ��� ó���� �ϰ�, ����ڰ� ���߸� ������ �Ҳ��� 
	 			�ƴϸ� ��ǻ�Ϳ��� ��ȸ�� �ѹ� �� �༭ ���ºε� �߰� �Ҳ����� ���� ����

			UpDown_�̴ϼ�.class �� ���� �ϼ��Ǹ� ���ε�

		������������������������������������������������������������������������������������������*/
	}
}
