class Exersice01_Branch {
	public static void main(String[] args) {
		/*
			����ڷκ��� ���嵥���Ϳ� ü�ߵ����͸� Ȯ���ؼ�
			�̰� ���� ��ü���������� �����
			�� ��� ����� ���� 3���� branch �� ����
			����ڿ��� �ٸ� ����� �Ͼ�� �ְ� ������.
		*/
		System.out.println("[BIO] �ǰ����� ���");
		System.out.print("[BIO] ����(����:m) �Է� : ");
		double m = Double.valueOf(System.console().readLine());
		System.out.print("[BIO] ü��(����:kg) �Է� : ");
		double kg = Double.valueOf(System.console().readLine());
		// ��ü�������� �� �����ü��/���������� ���� ������ ��.
		// �� ������� ���  - main 
		double bmi =kg/(m * m );
		System.out.println("[BIO] �м���ġ : " + bmi);
		// ��ü�� �̸� 18.5  ǥ��ü��  �̸� 23.0  ��ü��  �� 3���� �������� branch�� ����
		if( bmi <18.5 ) {
			// ��ü�� ó���ϴ� branch ������ ǥ��ü�߿� ���� ���� �ּ� ü���� ������ؼ� ���
			System.out.println("[BIO] ��ü������ �Ǵ�");
			double min = 18.5* m * m;
			System.out.println("[BIO] �ּ� ǥ��ü�� ���� " + min + " kg");
		} else if(bmi >=18.5 && bmi <23.0) {		// 18.5< bmi < 23.0 �̷� Ȯ�� �Ұ�
			// ǥ��ü�� ó���ϴ� branch ������ 
			System.out.println("[BIO] ǥ��ü������ �Ǵ�");
		} else {
			// ��ü�� ó���ϴ� branch ������ ǥ��ü�߿� ���� ���� �ִ� ü���� ������ؼ� ���
			System.out.println("[BIO] ��ü������ �Ǵ�");
			double max = 23.0* m * m;
			System.out.println("[BIO] �ִ� ǥ��ü�� ���� " + max + " kg");
		}
		System.out.println("[BIO] �ǰ��� ��ü�� �ǰ��� ������ ����.");
		/*
		if(bmi >=18.5 && bmi<23.0) {

		} else {
			if(bmi<18.5) {

			} else{

			}
		}
		*/
		// �ǰ��� ��ü�� �ǰ��� ������ ���� ��� main branch �շ� ������ ���
		
	}
}
/*

	�ڵ� ��ý�Ʈ�� �۵��ؼ� , ���ϴ� ������ �ڵ尡 �� �ۼ��� �ȵȴٸ�
	���� >> �⺻ ���� >> ���� >> ����&��������  >> �ڹ� �����ؼ� >> �ڵ��ϼ� ���� �ϼ���.

*/