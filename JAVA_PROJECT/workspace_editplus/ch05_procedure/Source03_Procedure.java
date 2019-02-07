/*
	프로그램 구현에 필요한 프로시저를 어디에 설계할껀지는 선택이다.
	해당 main을 가지고 있는 파일 안에 만들어도 되고, 다른 파일에 만들어도 된다.
	어디다 설계했냐에 따라서 호출(사용) 하는 방법이 달라진다.

	지금은 호출을 간단하게 하기 위해 프로그램을 만드는 파일에 같이 설계해보자.
*/
class Source03_Procedure {

	// 프로시저결과를 호출시 사용될 이름(호출할때 전달받을 데이터형태)
	// 1. 정수형데이터 2개를 전달받아서, 두 정수의 차를 결과물로 만들어내는 gap이라는 프로시저를 만들려고 함
	static int gap(int n1, int n2){
		System.out.println("gap procedure called.."+n1+" / "+n2);
		int d = n1 - n2;
		if (d<0)
			d *= -1;
		System.out.println("procedure done.."+d);
		// 프로시저작업의 결과물을 프로시저를 호출했던 지점으로 돌려주는 키워드인 return을 이용해서 설정
		return d; // 메소드 이름 앞에 타입 int와 d 가 같아야함 (int->double 자동 컨버팅되는것은 가능하긴함)
		
		//※static 메인에서 바로 콜을 하기 위해 설정( 나중에 설명)

		//독립 프로시저
	}
	// 2. 정수데이터 2개를 전달받아서 제곱값을 계산해서 결과물int로 만들어내는 power 라는 프로시저를 만들고
	//   메인에서 만들어둔 프로시저 콜을 해서 제대로 결과물을 받는지 확인.
	static int power(int n1, int n2){
		int d = 1;
		for(int i=1;i<=n2;i++){
			d *= n1;
		}
		return d;
	} // (int)(Math.pow(n1,n2))

	// 3. 정수데이터 하나를 받아서 3자리마다 컴마를 찍은 문자열을 만들어내는 프로시저 이름 format
	static String format(int val){
		String str="";
		//for(int i=1;i<=val.length();i++){
		
		//★★(자릿수 , 찍는 함수의 경우 do~ while이 아닌 while로 만들게되면 0을 넣을경우 에러 )★★
		int i=1;
		do{
			str = (val%10)+ str;
			val /= 10; 
			if (i % 3 == 0 && val !=0){
				str = ","+str;
			}
			i++;
		}while(val != 0);
		return str;
	}


	//================================================
	public static void main(String[] args)	{
		System.out.println("main - start");
		// 만들어둔 프로시저를 써야 한다면, Math.pow() 와 비슷한 형태로 콜을 하면 된다.
		// gap();
		// gap(true, 5);
		System.out.println(gap(5, 11));
		int r = gap(45,32);
		System.out.println("r == "+ r);
		
		int a = power(2, 10);
		System.out.println("power test "+ a);

		String aa = format(1000000);
		System.out.println(aa);
		//int b = Integer.valueOf(aa);
		//System.out.println(b); // ,넣은 정수(문자열)을 다시 정수로 역계산은 안되는듯

		System.out.println("main - end");
	}
}
