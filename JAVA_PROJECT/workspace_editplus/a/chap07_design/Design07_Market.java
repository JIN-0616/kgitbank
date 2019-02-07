/*
	����ڰ� �������� �ֽ��� �������� ��ü
*/
class Market {
	Stock s1, s2, s3;

	Market() {
		// ������ ������ Stock��ü �ϳ����� ���� ������ �ص���. 
		s1 = new Stock("����ó��",10000);
		s2 = new Stock("�ѱ�����");
		s3 = new Stock("��������", 7500);
	}
	
	String dayOff() {
		// s1,s2,s3�� ������ѵ� ��ü���� �̿��ؼ� Stock ��ü�� change() ���ѵΰ�,
		// Stock�� turn�� �������ѵ���.
		Stock.turn++;
		s1.change();
		s2.change();
		if(Math.random()>1.0 ) {
			s3 = new Stock("īī����ũ", 3000);
		} else {
			s3.change();
		}
		return "���ٸ��Ͼ��� ���� �����Ǿ���.";
	}
	
	void buyStock(int stockNo, int cnt) {
		if(stockNo==1) {
			s1.ammount += cnt;
		} else if(stockNo ==2) {
			s2.ammount += cnt;
		} else {
			s3.ammount += cnt;
		}
	}

	boolean buyStock(int stockNo, int cnt, Player p) {
		Stock target;
		if(stockNo==1) {
			target = this.s1;
		}else if(stockNo ==2) {
			target = s2;
		}else {
			target = s3;
		}
		//======================================================
		if(target.value * cnt <= p.balance) {
			target.ammount += cnt;
			p.balance -= target.value * cnt;
			return true;
		}else {
			return false;
		}
	}

	boolean sellStock(int stockNo, int cnt, Player p) {
		Stock target;
		if(stockNo==1) {
			target = this.s1;
		}else if(stockNo ==2) {
			target = s2;
		}else {
			target = s3;
		}
		//======================================================
		if(target.ammount >= cnt) {
			target.ammount -= cnt;
			p.balance += target.value * cnt;
			return true;
		}else {
			return false;
		}
	}


	
	void sellStock(int stockNo, int cnt) {
		Stock target;
		if(stockNo==1) {
			target = this.s1;
		}else if(stockNo ==2) {
			target = s2;
		}else {
			target = s3;
		}
		target.ammount -= cnt;
	}
	
	int totalValue() {
		return s1.value*s1.ammount + s2.value*s2.ammount + s3.value*s3.ammount;
	}
}

