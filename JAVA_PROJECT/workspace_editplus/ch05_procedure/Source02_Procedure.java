/*
	프로시저라는 건 어떻게 설계하고, 어떻게 사용하는건가를 살펴보자.
	 -(서브루틴 설계, 사용)
	프로시저는 3가지를 결정하고 만들어야 한다.
		- 묶인 작업을 사용할때(호출할때) 불릴 이름 : 함수명, 프로시저명, 메서드명
		- 이 작업이 어떤 데이터타입을 만들어내기 위함인지 : 반환형, 리턴타입, 프로시저 결과물
		- 이 작업을 사용될때 전달받을 데이터들의 형태 : 전달인자 형태, 매개변수 형태

	이렇게 설정을 하고 만들어둔 프로시저는 만들어진 형태로만 작동하게 된다.

*/
class Source02_Procedure {
	public static void main(String[] args)	{
		// 1. 제곱값 계산해주는 프로시저를 pow 라는 이름을 붙여서 만들어두었기 때문에
		//	그 이름을 통해서 사용이 됨
		//  Math.pow(3, 5);
		// 2. 이 프로시저는 double 형 실수데이터를 만들기 위해 설계되었다.
		//  String s = Math.pow(3, 5);
		int n = (int)Math.pow(3,5);
		// 3. 이 프로시저는 작동을 시킬때 수치 두개를 받아서 작동되게 설계되있다.
		Math.pow(3, 35);
		// ※ 설계된 프로시저는 그 사용법에 맞춰서 사용해야 된다.

	}
}
