class MukJJiBBar_YHH {
	public static void main(String[] args) {
		/*
			����ڿ� ��ǻ�Ͱ��� ����� �����ϴ� ����� ������ bra �ٽ�nch �۾�

			����� ���ӱ����� �������Ѿ� �Ǵ� �����ʹ� ���ݱ���.
		*/
		boolean attack = Math.random()> 0.5;
		System.out.println("������? " + attack + "/ ������? " + !attack);
		System.out.print("�̹����� ����(��:0, ��:1, ��:2) : ");
		int choice = Integer.valueOf(System.console().readLine());
		//============================================================
		int auto = (int)(Math.random()*3);		// 0, 1, 2
		System.out.println();
		System.out.println("AI�� ���� : "+ auto );
		// String[] mode = new String[]{"��","��","��"};
		String status ="�����:";
		switch(choice){
			case 0:	
				status += "�� VS ";	
				break;
			case 1:	
				status += "�� VS ";	
				break;
			case 2:	
				status += "�� VS ";	
		}

		switch(auto){
			case 0:	
				status += "��";	
				break;
			case 1:	
				status += "��";	
				break;
			case 2:	
				status += "��";	
		}
		status +=":AI";
		System.out.println(status);
		System.out.println();
		// branch �� ���� ����� ���ָ� �ȴ�.
		if(choice == auto) {
			System.out.println("�ºΰ� ����!" );
			// �� if branch �ȿ��� if~ else�� ������ ���ڸ� �ٸ��� ����ϴ� �۾� ����
			if(attack) {
				System.out.println("����ڴ��� �¸��Դϴ�.");
			}else {
				System.out.println("AI�� �¸��Դϴ�.");
			}
		} else {
			System.out.println("�ºΰ� ���� �ʾҴ�.." );
			if(choice == 0 && auto == 2 || choice==1 && auto ==0 || choice == 2 && auto ==1) {
				if(attack) {
					System.out.println("���ݱ��� �Ѿ���ϴ�.");
				} else {
					System.out.println("�����ϵ� �����Դϴ�.");
				}	
				attack= false;		
			} else {
				if(attack) {
					System.out.println("�����ϵ� �����Դϴ�.");
				} else {
					System.out.println("���ݱ��� �����Խ��ϴ�.");
				}				
				attack = true;	
			}
			System.out.println("������ ");
		}
		
	}
}
