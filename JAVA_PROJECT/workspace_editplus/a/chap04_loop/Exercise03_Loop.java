class Exercise03_Loop {
	public static void main(String[] args) {
		// vip ��ް��
		int vip = 0;
		System.out.print("�����ݾ� :");
		int charge = Integer.valueOf(System.console().readLine());
		// �����ݾ׸�ŭ vip ����� �ö�.
		boolean possible = true;
		do {
			switch(vip) {
			case 0: case 1: case 2:
				if(charge>= 5000) {
					charge -= 5000;
					vip++;
				}
				else
					possible = false;
				break;
			case 3: case 4: case 5:
				if(charge>= 10000) {
					charge -= 10000;
					vip++;
				}
				else
					possible = false;	
				break;
			default :
				if(charge >= 10000+vip*1000) {
					charge -= 10000+vip*1000;
					vip++;
				}else {
					possible = false;	
				}
			}
		} while(possible);
		System.out.println("���� ��� :"+  vip);
		// 0 �� 3 ��ޱ����� ��޴� 5000��
		// 3 �� 6 ��ޱ����� ��޴� 10000��
		// 6 �� 10 ��ޱ����� ��޴� 10000 + (������*1000) ��
		//===============================================
		//=======================================================
		// �� ��޺� ĿƮ���������� ��� loop�� �̿��ؼ� ���
		int need=0;
		for(int v=1; v<=10; v++) {
			System.out.println(v+"��� �ʿ� ����Ʈ");
			switch(v) {
			case 1: case 2: case 3:
				need +=5000;
				break;
			case 4: case 5: case 6:
				need += 10000;
				break;
			default :
				need += 10000+ (v - 1)*1000;
			}
			System.out.println("���� "+need);
		}
	}
}
/*
	vip1	 5000 
	vip2	10000 		
	vip3	15000 
	vip4	25000 
	vip5	35000 
	vip6	45000
	vip7	61000
	vip8	78000
	vip9	96000
	vip10  115000
*/
