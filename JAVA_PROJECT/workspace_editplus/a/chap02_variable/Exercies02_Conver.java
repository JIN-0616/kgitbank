class Excersie02_Convert {
	public static void main(String[] args) {
		/*
			����ڷκ��� ��� ������� �Է��� �޾Ƽ�,
			�׷��� �׽ð��� �Ϸ���� ���ʳ� �귶�� ����ؼ�
			0.xxx �� �����̴�.
			�Ҽ����� 3�ڸ�°������ ��µǰ� �غ���. 
			�� 4°�ڸ� ���ĸ� 0���� �� �ٲٸ� ����� ����.
		*/
		System.out.print("�� �Է�:");
		String hour = System.console().readLine();
		String minute = System.console().readLine("�� �Է�:");

		int total = Integer.valueOf(hour)*60*60 + Integer.valueOf(minute)*60;
		double rate = (double)total/(60*60*24);
		double simpleRate = (int)(rate*1000)/1000.0;
		System.out.println( hour+":"+ (Integer.valueOf(minute)<10 ? "0":"") +minute +" �� �Ϸ���� " + simpleRate +" �� �Դϴ�"); 

	}
}
