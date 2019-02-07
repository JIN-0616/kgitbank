/*
	사용자가 보유중인 주식을 관리해줄 객체
*/
class Market {
	Stock s1, s2, s3;

	Market() {
		// 각각의 변수에 Stock객체 하나씩을 만들어서 설정을 해두자. 
		s1 = new Stock("네이처셀",10000);
		s2 = new Stock("한국전자");
		s3 = new Stock("동성제약", 7500);
	}
	
	String dayOff() {
		// s1,s2,s3에 저장시켜둔 객체값을 이용해서 Stock 객체들 change() 시켜두고,
		// Stock의 turn을 증가시켜두자.
		Stock.turn++;
		s1.change();
		s2.change();
		if(Math.random()>1.0 ) {
			s3 = new Stock("카카오뱅크", 3000);
		} else {
			s3.change();
		}
		return "별다른일없이 장이 마감되었다.";
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

