/*
	초창기 Interface는 abstract 처리한 함수들만 설계가 가능했음
	지금은 default 설정을 해줄수가 있다.
	
	기존 class와는 반대로
	Interface 에서는 default설정이 abstract이므로
	default를 붙여주면 기본기능 설정이 가능하다.

	인터페이스는 extends가 아니므로 super를 바로 사용이 불가하다.
	직접 객체이름으로 호출한다.
*/

interface ItemShop {
	default void open(){
		System.out.println("ItemShop.open()");
	}
	void close();
}

class SwordShop implements ItemShop{
	public void open(){
		ItemShop.super.open();
		System.out.println("SwordShop!!!");
	}
	public void close(){

	}
}

class Source06_UseInterface {
	public static void main(String[] args)	{
		ItemShop is = new SwordShop();
			is.open();

	}
}
