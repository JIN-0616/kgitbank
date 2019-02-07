/*
	초창기 interface는 abstract 처리한 함수들만 설계가 가능했지만,
	지금은 default 설정을 해둘수가 있다.
*/
interface ItemShop {
	default void open() { 
		System.out.println("ItemShop.open()");
	}
	void close();
}

class SwordShop implements ItemShop {
	public void open() {
		ItemShop.super.open();
		System.out.println("SwordShop!!!");
	}	
	public void close() {
	}
}

class Source06_UseInterface {
	public static void main(String[] args) 	{
		ItemShop is = new SwordShop();
			is.open();
	}
}
