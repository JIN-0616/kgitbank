/*
	사용자가 보유중인 주식(객체)를 관리해줄 객체
*/
class Market {
	Stock s1, s2, s3;

	Market(){
		//	각각의 변수에 Stock객체 하나씩을 만들어서 설정을 해두자
		s1 = new Stock("삼송");
		s2 = new Stock("에르지");
		s3 = new Stock("횬다이");
	}

	String dayOff(){
		// s1, s2, s3에 저장시켜둔 객체값을 이용, Stock 객체들 change() 시켜두고,
		// Stock의 turn을 증가시켜두자.
		Stock.turn++;
		s1.change();
		s2.change();
		if (Math.random()>1.0){ //잠김
			s3 = new Stock("가가와뱅크");
		}else{
			s3.change();
		}
		return "별다른일 없이 장이 마감되었다.";

	}

	void buyStock(int num, int amount){
		switch(num){
		case 1: 
			s1.amount += amount; break;
		case 2: 
			s2.amount += amount; break;
		case 3: 
			s3.amount += amount;
		}
		/*
			if(num==1)
				s1.amount += amount;
			else if(num==2)
				s2.amount += amount;
			else
				s3.amount += amount;
		*/

	}

	boolean buyStock(int stockNo, int cnt, Player p){
		/*
			사고자하는 주식의 총액이 플레이어의 자산보다 작으면,
			처리를 해주고(주식개수를 늘린다거나, 플레이어의 자산을 줄려주는 작업) return true;
			그게 아니면 return false;
		*/
		Stock snum;
		if(stockNo==1)
			snum = s1;
		else if(stockNo==2)
			snum = s2;
		else if(stockNo==3)
			snum = s3;
		else 
			return false;

		if(snum.value * cnt <= p.balance){
			snum.amount += cnt;
			p.balance -= snum.value*cnt;
			return true;
		}else{
			return false;
		}


		/* n.1
		Stock snum;
		switch(stockNo){
			case 1: snum = s1; break; 
			case 2: snum = s2; break; 
			case 3: snum = s3;  
		}

		if(snum.value * cnt <= p.balance){
			snum.amount += cnt;
			p.balance -= snum.value*cnt;
			return true;
		}else{
			return false;
		}
		*/
	}

	boolean sellStock(int stockNo, int cnt, Player p){
		/*
			팔고자하는 주식의 개수가 보유개수보다 적거나 같으면 ,
			처리를 해주고(주식개수를 줄이고, 플레이어의 자산을 늘려주는 작업) return true;
			그게 아니면 return false;
		*/
		Stock snum;
		if(stockNo==1)
			snum = s1;
		else if(stockNo==2)
			snum = s2;
		else if(stockNo==3)
			snum = s3;
		else 
			return false;

		if(cnt <= snum.amount){
			snum.amount -= cnt;
			p.balance += snum.value*cnt;
			return true;
		}else{
			return false;
		}


		/*
		Stock snum;
		switch(stockNo){
			case 1: snum=s1; break; 
			case 2: snum=s2; break; 
			case 3: snum=s3; break; 
		}

		if(cnt <= snum.amount){
			snum.amount -= cnt;
			p.balance += snum.value*cnt;
			return true;
		}else
			return false;
		*/
	}

	void sellStock(int num, int amount){
		switch(num){
		case 1: 
			s1.amount -= amount; break;
		case 2: 
			s2.amount -= amount; break;
		case 3: 
			s3.amount -= amount;
		}
		/*
			Stock target;
			if(num==1)
				target = this.s1;
			else if(num==2)
				target = s2;
			else
				target = s3;
			
			target.amount -= amount;
		*/
		


	}

	int totalValue(){
		return s1.value*s1.amount +s2.value*s2.amount +s3.value*s3.amount ; 
	}
}
