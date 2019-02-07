/*
	주식 투자 시뮬레이션을 위해서, 주식정보를 객체화시켜두자
	# this 라는 값을 사용하는 법 #
	this 는 객체가 만들어지게 됬을때 가지게 될 객체값이 설정될 변수 (미정)

	this.		만들어질 객체가 가지게 될 것들을 명시하고자 할때

	this();		생성자에서만 쓸수 있는 문법으로, 다른생성자로 넘겨서 생성시키고자 할때

*/

class Stock {
	//--------어제복습
	static int turn;

	static {
		turn = 0;
	}
	//---------------
	String product;
	int value;
	int amount;		
	
	Stock(String product){
		/*
		this.product = product;
		this.value = 500;
		amount = 100;
		*/
		this(product, 5000);	// 생성자에서만 사용가능, 재귀에 주의할것!
//		System.out.println("Stock(String)");
	}
	
	Stock(String product, int value){
		this.product = product;
		this.value = value;
		amount = 0;
//		System.out.println("Stock(String,int)");
	}

	String current(){
	//	this(product, 500); // this(); 의 호출은 생성자 안에서만 가능하다
		return "Day." + Stock.turn + " :	" +this.product + "	현재가격 : " + this.value
			+"	보유중 : "+amount;
	}
	
	void change(){
		int value = this.value;	
		/*
			이 객체가 만들어지게 됬을때 가지게 될 변수값이지만
			프로시저 구현하는데 있어서 변수로 써도 컴파일 실패가 뜨지않는다.

			이 프로시저 안에서 사용되는 value 변수는,
			객체가 가지게될 value가 아닌 이 안에서 선언한 value가 쓰인다.

			이 프로시저 안에서 객체가 가질 변수가 내부 선언에 의해서
			가려지게 되면 this를 지정해주면 구분해서 사용할 수 있다.
		*/
		int high = (int)(value*1.3);
		if(high%100 !=0){
			high -= high%100;
		}
		
		int low = (int)(value*0.7);
		if(low%100 != 0){
			low += 100;
			low -= low%100;
		}
		
		high /= 100;
		low /= 100;

		value = low +(int)(Math.random()*(high-low+1));
		value *= 100;
		//System.out.println("this.value , value = " + this.value + " , " + value);
		this.value = value;
		/* ==
		value = low +(int)(Math.random()*(high-low+1));
		value /= 100;
		value *= 100;
		*/
		/*
			프로시저 구현할때 변수가 겹치지 않는다면, 굳이 this를 지정안해도 되지만,
			겹처서 두개가 접근되는 상황이 된다면, 
			this를 붙여서 이 객체가 가리킬 변수와 그렇지 않은 변수를 구분지어줘야 된다.

			일부로 겹치는 상황이 있다.
			
			생성자나 값을 특정데이터로 설정하게 하는 목적의 프로시저 일때

		*/
		/* ?
		per = (7 + (int)(Math.random()*(13-7+1)))/10.0;
		int result = value*per;

		if(result%100!=0){
			if(
		}
		*/

		// 버림은 쉬움 796 -> 7 -> 700 

		

	}
}
