/*
	��â�� interface�� abstract ó���� �Լ��鸸 ���谡 ����������,
	������ default ������ �صѼ��� �ִ�.
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
