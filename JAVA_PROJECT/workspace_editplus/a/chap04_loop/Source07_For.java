class Source07_For {
	public static void main(String[] args) {
		/*
			for �� Ư�������� ��ġ�� �̿��� loop ó�� �������� ������.
		*/
		for(int val = (int)'��'; val <= '��'; val++) {
			System.out.println("val = "+val + " / " + (char)val);
		}
		for(int val = (int)'��'; val >= '��'; val -- ) {
			System.out.println("val = "+val + " / " + (char)val);
		}
		System.out.println();
		// 2018�⸸ ó���Ѵٰ� ���� �ϰ�, ��ȿ�� �����͸� ���Դٰ� ����
		// ��� ������ 1���� ����° �Ǵ� ���ΰ�..?
		System.out.print("���? ");
		int month = Integer.valueOf(System.console().readLine());
		System.out.print("����? ");
		int day = Integer.valueOf(System.console().readLine());
		int total= 0;
		/*
			month ���ޱ��� �����ϼ� + day �� ���Ѱ� ���ϼ���.
		*/
		
		// 1��1���� ��������. �׷� �Է¹��� ���� ���������ϱ�? (������ 7�ϸ��� �ݺ���)
		for(int m =1; m<= month-1; m++) {
			int md;
			switch(m) {
			default :
				md = 31;
				break;
			case 4:	case 6:	case 9:	case 11:
				md= 30;			
				break;
			case 2:
				md = 28;
			}
			System.out.println(m+"���� ���� = " + md);
			total += md;
		}
		System.out.println("���ޱ����� �����ϼ� " + total);
		total += day;
		System.out.println(month+"�� "+ day+"���� 1���� " +total+"��° ���̴�");
		System.out.println(total%7);
	}
}
