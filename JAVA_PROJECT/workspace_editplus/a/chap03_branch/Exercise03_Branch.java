class Exercise03_Branch {
	public static void main(String[] args) {
		// swtich-case �� Ư���⵵�� Ư������ �ϼ� ����ϱ�
		System.out.print("[SYSTEM] �⵵ �Է� : ");
		int year = Integer.valueOf(System.console().readLine());
		System.out.print("[SYSTEM] �� �Է� : ");
		int month = Integer.valueOf(System.console().readLine());
		// �ش�⵵ �ش���� ���ϱ��� �ִ��� ����ؼ� ���
		if( month <1 || month >12  ) {
			System.out.println("[SYSTEM] ��ȿ���� ���� �������̴�.");
		} else {
			System.out.println("[SYSTEM] ��ȿ�� �������̴�.");
			String result = "[SYSTEM] "+year+"�� " + month+"���� ������ ";
			switch(month) {
			default :
				result += "31 ���̴�.";
				break;
			case 4:	case 6:	case 9:	case 11:
				result += "30 ���̴�.";
				break;
			case 2:
				// if(year%4==0 && year%100 !=0  || year%4==0 && year%400 ==0 )
				if(year %4 != 0) 
					result += "28 ���̴�.";
				else {
					if(year%100!=0) {	
						result += "29 ���̴�.";
					} else {
						if(year % 400 == 0) 
							result += "29 ���̴�.";
						else 
							result += "28 ���̴�.";
					}
					// if(year%100 !=0 && year %400==0)  / else �θ� ������ �ɵ�.
				}
			}
			System.out.println(result);

		}
		



		// if ~ else �� month ������ ��ȿ�� üũ �Ͻð� (1~12 �����϶��� ����� ó��)
		// ��ȿ�������϶� �۵��Ǵ� branch���� 
		// switch case / 4,6,9,11 �� ���̽����� ��Ƽ� ���� ���
		//		  case / 2 ��Ƽ� ���� ��� 
		//        default / ���� �޵� �Ѳ����� ó��
		// 
		// �� case 2 ó���Ҷ� ���� ó���ؾߵ� : 
		// 4�ǹ�� �⵵�̸�, 100�ǹ���� �ƴϿ����Ѵ�.(400�ǹ���� ����ó����)
		// 2004 : ���� O , 1900 : ����X,  2000 : ���� O , 2100 : ���� X
		// 400�� ����ų� Ȥ�� 4�ǹ���̸鼭, 100�� ����� �ƴϸ� ����

		 
	}
}
