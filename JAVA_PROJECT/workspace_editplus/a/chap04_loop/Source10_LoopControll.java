class Source10_LoopControll {
	public static void main(String[] args) {
		
		for(int cnt=1; cnt<=10; cnt++) {
			int r = (int)(Math.random()*100);
			if(r/10 == r%10){
				System.out.println("�ʱ⼳�� ������� ����!! " + r);
				break;
			}
			System.out.println("r ==" +r);
		}
		
		/*
			���� loop �϶��� break�� cotinue�� ��� �۵��ϰ� �Ǵ°�..?
			�ҼӵǾ��ִ� loop �� ������ ��ġ�� �ȴ�.
		*/
		for(int out=1; out<=5; out++) {
			System.out.println("out "+ out);
					
			for(int in=1; in<=5; in++) {
				int r = (int)(Math.random()*3);
				if(r==0)
					continue;
				else if(r==1)
					break;
				System.out.println("in .." + out+"-"+in); 
			}
			System.out.println("out turn end");
		}
		
	}
}
