class StockGamble_YHH {
	public static void main(String[] args) {
		/*
			Ư������(7000��)���� ������ �ֽ��� ����ڷκ��� 
			�Է¹��� �ݾ����� ��� �ִ� ��ŭ ����ؼ�
			� ��� �ܾ� �󸶴� �ѹ� ���.

			�����Ǽ� ��ġ 0.0 ~ 30.0 �� �̾Ƽ�, �� ��ġ�� �̿��Ͽ�
			���ۼ�Ʈ ����߽��ϴ�. ������ �󸶰� ��ٶ�� ���. (10�������� ������)

			������ �󸶰� �����ϴ�.
		*/
		int price = 5+(int)(Math.random()*10);
		price *= 1000;
		System.out.print("���ִ� ����: " + price +" / ���ڱݾ� : " );
		int money = Integer.valueOf(System.console().readLine());

		int bought  = money / price;
		System.out.println(bought + "�� ���� ���� / �ܾ�: ��" + (money - (bought*price))  );
		System.out.println("...");
		System.out.println("���� �߻�!");
		System.out.println("...");

		double rate = (int)(Math.random()*300) / 10.0;

		int cprice = (int)(price + (price*rate/100));
		cprice -= cprice%50;	//  �� 50�� ���� ó���Ϸ��� ó�� �������� ����

		System.out.println( price +"����"+  cprice+""  );
		System.out.println( rate +"% ��� (" +  (cprice - price) + ")"  );

		System.out.println("���� : " + (cprice*bought - price*bought) );

	}
}
