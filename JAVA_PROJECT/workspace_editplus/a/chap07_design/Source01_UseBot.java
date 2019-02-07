class Source01_UseBot {
	public static void main(String[] args) {
	//	new Bot();	이 객체는 이런식으로는 생성이 불가능해진다.

		Bot b1 = new Bot(50);
		System.out.println(b1.tell());	// STAMINA=0, COUNT=0
		boolean f1 = b1.move(30);
		System.out.println(f1);	// false
		System.out.println(b1.tell());	// STAMINA=0, COUNT=0
		b1.init();	// init() 초기생성시 사용했던 stamina로 초기화가 되고 싶으면..

		boolean f2 = b1.move(20);
		System.out.println(f2);	// true
		System.out.println(b1.tell());	// STAMINA=98, COUNT=1
		b1.move(11);
		b1.move(25);
		System.out.println(b1.tell());	// STAMINA=93, COUNT=3
	}
}
