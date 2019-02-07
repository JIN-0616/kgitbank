/*
	프로그램 구현에 필요한 프로시져를 어디에 설계할껀지는 선택이다.
	해당 main을 가지고 있는 파일안에 만들어도 되고, 그렇지 않아도 된다.
	어디다 설계했냐에 따라서 호출(사용) 하는 방법만 달라진다.

	지금은 호출을 간단하게 하기 위해 프로그램을 만드는 파일에 같이 설계해보자.

*/
class Source03_Procedure {
	
	// 프로시져결과물 호출시사용될이름(호출할때 전달받을 데이터형태)
	// 1. 정수형데이터 2개를 전달받아서 두 정수의 차를 결과물로 만들어내는 gap 이라는 프로시져를 만들려고 함
	static int gap(int n1, int n2) {
		System.out.println("gap procedure called.." +n1 +" / "+ n2);
		int d = n1 - n2;
		if(d<0)
			d *= -1;
		System.out.println("procedure done.."+d);
		// 프로시져작업의 결과물을 프로시져를 콜했던 지점으로 돌려주는 키워드인 return 을 이용해서 설정
		return d;	
	}

	// 2. 정수데이터 2개를 전달받아서 제곱값을 계산해서 결과물로 만들어내는 power 라는 프로시져를 만들어보고
	// 메인에서 만들어둔 프로시져 콜을 해서 제대로 결과물을 받는지 확인.
	static int power(int n, int step) {
		int r= 1;
		for(int cnt=1; cnt<=step; cnt++) {
			r *= n;
		}
		return r;
	}
	static int power_2(int n, int step) {
		int r= (int)Math.pow(n, step);
		return r;
	}

	// 3. 정수데이터 하나를 받아서 3자리마다 컴마를 찍은 문자열을 만들어내는 프로시져 이름 format
	static String format(int val) {
		String str="";
		int cnt=0;
		do {
			str = val%10+str;
			val /=10;
			if(val==0)
				break;
			cnt++;
			if(cnt%3==0)
				str = ","+str;
		}while(val>0);

		return str;
	}

	//────────────────────
	public static void main(String[] args) {
		System.out.println("main - start");
		System.out.println(format(1231));
		System.out.println(format(1111231));
		String s1 = format(231);
		// 만들어둔 프로시져를 써야 한다면	Math.pow() 와 비슷한 형태로 콜을 하면된다.
		// gap();
		// gap(true, 5);
		System.out.println(gap(5, 11));
		int r = gap(45, 32);
		System.out.println("r == "+ r);
		System.out.println(power(10, 3));
		int rr = power(2, 11);
		System.out.println(rr);
		System.out.println("main - end");
	}
}

