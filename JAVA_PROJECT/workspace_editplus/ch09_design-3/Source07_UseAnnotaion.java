/*
	Annotation 설계
		-이 어노테이션은 프로그램자체에는 영향이 없지만, 이거에 영향받은 환경쪽에 영향을
		끼칠 용도로 설꼐하는 경우가 많다.
		
		-jvm , 메타데이터 관련이 많음 , 검증용도, 경고무시, 등등등....
		
		-.class파일로 생성됨(컴파일됨)

		-java 윗단계의 학습이 필요함, xml 등등...

		-컴파일러가 인식하는 단계
*/
@interface Test{

}

//===============================================================================
class ShieldShop implements ItemShop{
	@Override
	public void closed(){
		System.out.println("ShieldShop.close()");
	}
}


//===============================================================================
class Source07_UseAnnotaion {
	public static void main(String[] args)	{
		System.out.println("Hello World");
		ItemShop i = new ShieldShop();
		i.close();

	}
}
/*
---------- 컴파일 ----------
Source07_UseAnnotaion.java:14: error: ShieldShop is not abstract and does not override abstract method close() in ItemShop
class ShieldShop implements ItemShop{
^
Source07_UseAnnotaion.java:15: error: method does not override or implement a method from a supertype
	@Override
	^
2 errors

출력 완료 (0초 경과) - 정상 종료
*/

/*

	여기까지가 Editplus 로 자바라는 언어를 가지고 우리가 어떤 것들을 할수 있고,
	설계할수 있는 것들엔 어떤것들이 있는지 살펴보았다.

	앞으로는 우리가 설계할것들 말고, 기본적으로 제공되는 애들을 엮어서 작업을 해야되는데,
	Editplus는 그런 작업을 하기엔 좋은 툴은 아니다.

	tool 변경을 할껀데, 자바 개발자가 다뤄야되는 개발툴중에 필수인 Eclipse 로 작업을 해보자.

	eclipse.org 

*/