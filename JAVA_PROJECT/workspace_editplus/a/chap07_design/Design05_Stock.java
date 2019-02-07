/*
	주식 투자 시뮬레이션을 위해서 사용할, 주식정보를 객체화시켜두자.
	# this 라는 값을 사용하는 법 #
	this는 객체가 만들어지게 됬을때 가지게 될 객체값이 설정될 변수 (미정)
	
	this.    : 만들어질 객체가 가지게 될 것들을 명시하고자 할때
	this();  : 생성자에서만 쓸수 있는 문법으로, 다른생성자로 넘겨서 생성시키고자 할때

*/
class Stock {
	static int turn;

	static {
		turn = 0;
	}

	String product;
	int value;
	int ammount;
	
	Stock(String product) {
		/*
			this.product = product;
			this.value = 500;
			ammount = 100;
		*/
		this(product, 500);
//		System.out.println("Stock(String)");
	}

	Stock(String initProduct, int v) {
		product = initProduct;
		value = v;
		ammount = 0;
//		System.out.println("Stock(String, int)");
	}

	String current() {
	//	this(product, 500);	// this(); 의 콜은 생성자안에서만 사용가능
		return "Day."+ Stock.turn+ " : " + this.product +"  ￦ "+ value + " / "+ammount+" 보유중";
	}
	
	void change() {
		int value = this.value;	
		// 이객체가 만들어지게 됬을때 가지게 될 변수지만,
		// 프로시져 구현하는데 있어서 변수로 써도 컴파일 실패가 뜨지 않는다.
		// 이 프로시져 안에서 사용되는 value 변수는, 객체가 가지게될 value가 아니라
		// 이 안에서 선언한  value 변수가 쓰이게 된다.
		// 이 프로시져안에서 객체가 가질 변수가 내부 선언에 의해서 가려지게 되면
		// 그땐 this를 지정해주면 구분해서 사용할수 있다.
		int high = (int)(value*1.3);
		if(high%100 !=0)
			high -= high%100;
		int low = (int)(value*0.7);
		if(low%100 !=0) {
			low += 100;
			low -= low%100;
		}
		/*
		high /=100;
		low /= 100;
		value = low +(int)(Math.random()*(high-low+1));
		value *= 100;
		*/
		value = low + (int)(Math.random()*(high-low+1) );
		value /= 100;
		value *= 100;
	//	System.out.println("value = "+ this.value + "/"+value);
		this.value = value;
		// 프로시져 구현할때 변수가 겹치지 않는다면, 굳이 this를 지정안해도 되지만, 
		// 겹쳐서 두개가 접근되는 상황이 된다면. this 를 붙여서 이 객체가 가지될 변수와 그렇지 않은 변수를
		// 구분지어줘야 된다.
		// 일부로 겹치는 상황이 있다. 생성자나 값을 특정데이터로 설장하게 하는 목적의 프로시져 일때
	}

}
