class Exercise02_StockSimul {
	public static void main(String[] args) 	{
		/*
			1. Player ��ü�� ���鶧 ����� �̸��� �Է�
			�̰����� Player ��ü�� ����, �⺻�ڻ� 20���� �����ؼ� 
			*/
		System.out.print("������̸�? ");
		String data = System.console().readLine();
		Player p = new Player(data, 200000);
		/*
			2. Market ��ü�� ����.
		*/
		Market mk = new Market();
		System.out.println("");
		System.out.println("�ֽ� ������ 7�ϵ��� ������ �˴ϴ�.");
		System.out.println("20������ ������ �ҷ��ּ���!!");
		
		System.out.println("");
		mk.dayOff();
		while(Stock.turn <= 7 ) {
			
			int c;
			do{
				System.out.println("");
				System.out.println(mk.s1.current());
				System.out.println(mk.s2.current());
				System.out.println(mk.s3.current());
					System.out.print(p.current()+" | 1.�ż� 2.�ŵ� 0.������> ");	
				c = Integer.valueOf(System.console().readLine());
				if(c == 1|| c==2) {
					System.out.print("��ǰ��ȣ(1~3) > ");	
					int sno = Integer.valueOf(System.console().readLine());
					System.out.print("��û����> ");	
					int cnt = Integer.valueOf(System.console().readLine());

					boolean r=false;
					switch(c) {
					case 1:
						r= mk.buyStock(sno, cnt, p);	
						break;
					case 2:
						r= mk.sellStock(sno, cnt, p);	
						break;
					}
					if(r) 
						System.out.println("�ֹ��Ͻ� �ż�/�ŵ� ��û�� ó���Ǿ����ϴ�.");
					else 
						System.out.println("�ֹ��Ͻ� ��û�� ó������ ���߽��ϴ�.(�ں��ݺ���or�ż��ʰ�)");
				}
			}while(c != 0);
			mk.dayOff();
			System.out.println("������ ���� �����Ǿ����ϴ�.");
			System.out.println("���ݺ����� �Ͼ�ϴ�.");
		}

		/*
			3. �ݺ��� Player �ڻ�(�ܾ�+�����ֽ��ǰ�ġ) �� 0���ϰ� �ȴٰų�, 
			   7���� �Ѿ�ԵǸ� �۵��� ���߰� ����

			4-1 �ݺ����鼭 �ؾߵ���
			���� ���Ͽ��� �������� �ֽ� ���¶�, �÷��̾� �ڻ��� ����ְ�
			�ֽ��� 1.�첫�� 2.�Ȳ���, 0�ƹ��͵� ���Ҳ��� ����ټ� �Է¸� �޾��ְ�,
			�Է°��� ���� if Ȥ�� switch�� branch ó���Ҽ� �ְ� ������ �����ְ�

			

			���� �� �������� �Ѱ��ּ���.
		*/


	}
}
