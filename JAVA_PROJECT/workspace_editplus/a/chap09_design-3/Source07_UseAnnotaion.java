/*
	Annotation 설계 
		- 이 어노테이션은 프로그램자체에는 영향이 없지만, 프로그램을 실행시키는 환경쪽에 영향을
		끼칠 용도로 설계하는 경우가 많다. 
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
