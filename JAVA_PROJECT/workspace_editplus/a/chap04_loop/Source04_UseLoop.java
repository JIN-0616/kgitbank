class Source04_UseLoop {
	public static void main(String[] args) {
		/*
			loop�� �̿��ؼ� �ʿ��� �����͸� Ȯ���ϴ� �Ϻκ��۾��� Ȱ���غ��Ҵµ�,
			loop�� ���α׷��� ��ü �帧�� �����µ��� ����� �ȴ�.
			
			���� ��� ����� ������ �������
			������Է¹ް�, ó���ϰ�, �Ϲٲ��ִ� �۾��� ũ�� loop ó���ϸ� �ϼ��ȴ�.
		*/
		boolean flag = true;
		boolean attack = Math.random()>0.5;

		System.out.println("���� �����! - �ڻ쳻�� AI");
		System.out.println();
		
		System.out.println((attack ? "���" : "AI") + "�� �������� �����մϴ�.");
	
		do {
			System.out.print((attack? "����!!" : "����..") + "(��:0, ��:1, ��:2) ?");
			int choice = Integer.valueOf(System.console().readLine());
			if(choice !=0 && choice != 1 && choice != 2) {
				System.out.println("�ȹٷ� ������!!");
				continue;
			}
			System.out.println();
			switch(choice){
			case 0:
				System.out.println("AI�� ���� �´�!");
				break;
			case 1:
				System.out.println("AI�� ���� �´�!");
				break;
			case 2:
				System.out.println("AI�� � �´�!");
				break;
			}
			System.out.println();
			if(attack) {
				System.out.println("���ݱ��� �Ѿ��!! ..");
				attack = false;
			} else {
				System.out.println("�ºΰ� ����!! ����� �й�..");
				flag = false;
			}
		} while(flag);
		
		System.out.println("��û�� �ΰ������϶�� ..");
	}
}
