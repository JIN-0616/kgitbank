
class Source02_While {
	public static void main(String[] args) {
		/*
			while �� 
			������ ���¿� ���� �۾� ó���� ������ �Ͼ�� �����ϴµ� �����ϴ�.
			(for loop �� Ư��ȸ���� �۾�ó���� �Ͼ�� �����ϴµ� ������)
		*/
		int val = 0;
		int cnt = 0;
		while( val <= 100 ) {
			cnt++;
			int r = (int)(Math.random()*10);
			val += r;
			System.out.println("[loop] r = " + r + "/ val = " + val +" .."+cnt+" tried");
		}
		System.out.println("[main] val = " + val);
	}
}
