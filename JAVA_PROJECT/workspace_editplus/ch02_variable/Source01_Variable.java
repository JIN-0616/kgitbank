/*
	프로그램에서 사용할 수 있는 기본 데이터들의 종류에 대해서 알아보았다.
	데이터의 종류를 알았다해서 바로 사용자로부터 데이터를 입력받아서 처리하는건 아직 힘들다.
	데이터를 입력받아서 처리할려면, 데이터를 저장하는 방법을 알아야 한다.
	
	이 작업을 하려면 변수(variable) 라는걸 활용할 수 있어야 한다.
*/
class Source01_Variable {
	public static void main(String[] args) 	{
		/*
			데이터들은 굉장히 다양한 경로로 만들어질수 있다.
			(그중에 하나가 사용자로부터 입력이고)
			한번 만들어지는 데이터들은 여러번이고 계속 사용을 해야 되는 경우가 있다.
		*/
		// System.console().readLine() ==> 
		// 사용자로부터 콘솔창을 통해 입력받는 작업을 처리하고
		// 실제입력이 일어나기 전까지 대기하다, 사용자가 enter를 쳐서 입력을 완료하면
		// 그때 입력했던 내용을 데이터로 만들어주는 기능이다.
		System.out.println("input data plz...");
		System.out.println("thx...."+ System.console().readLine());
		// 변수라는건 데이터를 저장시키고, 다시 변경하고, 계산을 지원하는 프로그램적인 장치이다.

		String var;	// 데이터저장할수 있는 변수를 만든거고,
		
		var = "input data one more plz..." ; // = 기호는 변수에 데이터를 설정하는 기호
			// var <- "input data one more plz..." (다른언어일부)

		System.out.println(var); // 변수를 사용하게 되면 들어가져 있는 데이터가 사용
		var = System.console().readLine();
		System.out.println("vary thx..." + var);
		System.out.println("vary thx..." + var);

		/*
			변수라는걸 만들어서 사용하려면, 외워야되는 것들이 존재한다.
			자료형 이라는 것이다.
			처리하고자 하는 데이터가 어떤 형태냐에 따라서 다 다르게 만들어야 되기 때문에,
		*/
		// var = 30; 데이터타입이 다르므로 불가

		

	}
}
