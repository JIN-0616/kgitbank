class Player {
	String name;
	int balance;

	/*
		이 Player 객체가 만들어질때, name과 balance를 다 설정해서 만들수 있게도 생성자를 구현
		이름만 설정해서 만들수 있게도 구현(이름만 설정할 경우는 100000원을 초기자금으로 가질수 있게)
	*/

	Player(String name){
		this(name,100000);
	}

	Player(String name, int balance){
		this.name = name;
		this.balance = balance;
	}
	
	String current(){
		return "현재 사용자명 : "+name + " / 현재 금액 : " +balance;
	}
}
