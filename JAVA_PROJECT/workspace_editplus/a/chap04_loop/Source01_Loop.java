/*
	branch �� ���Ҿ� ������ ó���������� loop ��°� �����ϴ¹��� �˾Ƶξ�� �Ѵ�.

	loop ? ȸ��(��/�ݺ�)

	�����͸� ó���ϴٺ��� �ѹ��� �۾����� �����°� ���� ������ ó���ؾ߸� ���� �ִ�
	������� �����Ѵ�.

	��ġ�����͸� ���� 3�ڸ����� �ĸ��� �� ǥ���� ���ڿ� ������ ���..
*/	
class Source01_Loop {
	public static void main(String[] args) {
		int r = 100+(int)(Math.random()*900);
		System.out.println(r);
		/*
			������ ���ؼ� � ������ �ǳ�..?
			1���ڸ��� ��� �̾ƴٰ� �տ��ٰ� �ٿ������� ��.
			�� �۾��� 3�� ������,�� ���
			r�� 0�̵ɶ������ϵ��� ,�ڸ����� ���� ȸ���� ���س��� �ϴ���..
		*/
		String str ="";
		System.out.println(str);
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		str = ","+str;
		System.out.println(str);		
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		/*
			loop �� while Ȥ�� for �� �̿��ؼ� ���������ϴ�.
			
			while loop ���� �������� ���캸��.
		*/
			
	}
}
