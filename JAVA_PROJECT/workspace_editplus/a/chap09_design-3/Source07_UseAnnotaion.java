/*
	Annotation ���� 
		- �� ������̼��� ���α׷���ü���� ������ ������, ���α׷��� �����Ű�� ȯ���ʿ� ������
		��ĥ �뵵�� �����ϴ� ��찡 ����. 
*/
@interface Test {
}

//==================================================
class ShieldShop implements ItemShop {
	@Override
	public void closed() {
		System.out.println("ShieldShop..close()");
	}
}


//======================================================
@Test
class Source07_UseAnnotaion {
	@Test
	public static void main(@Test String[] args) 	{
	//	System.out.println("Hello World!");
		ItemShop i = new ShieldShop();
		i.close();
	}
}