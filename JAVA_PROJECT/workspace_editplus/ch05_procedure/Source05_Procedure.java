//2018-09-20
/*
	프로시저(=함수) 설계시 가능한 것들
*/

class Source05_Procedure {
	/*
		1. 오버로딩이 가능하다. (프로시저명이 같아도, 매개변수형태가 다르면 추가설계가 가능하다.)
		  - 변수명이나 리턴타입은 영향을 주지 않는다. <->javascript는 불가능 1개명=1개
		  - 이미 이 혜택을 보고 있었다. 출력할때, 타입이 달라도 System.out.println()으로 가능
	*/
	static double range(int x1, int y1, int x2, int y2){
		return Math.sqrt(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
	}
	static double range(int x1, int y1){
		return Math.sqrt( (x1*x1)+(y1*y1) );
	}
/*	static boolean range(int x1, int y1){
		
	static double range(int a, int b, int c, int d){
*/		
	// 이 패턴은 위에서 존재하기때문에 추가 등록이 안됨 (매개변수 패턴이 중요)

	/*
		2. 프로시저가 결과물을 만들어내야된다거나, 데이터를 전달받는 형태로 설계할 필요는 없다.
		만드는 목적에 따라 1-1, 1-0, 0-1, 0-0 패턴이 가능하다. (return값-매개변수)

		1-1 : 기존에 지금까지 만들었던 함수들은 보통 1-1(매개변수, return값이 존재하는 함수)이었다.

		1-0 : Math.random(); // 외부데이터 입력없이 return 존재	
	*/
	static String create(){
		int r = (int)(Math.random()*3);
		if (r==0)
			return  "탱커";
		else if (r==1)
			return  "딜러";
		else
			return  "힐러";
	}
	/*
		0-1 : 패턴은, 전달받을 데이터는 있지만, 발생시킬 데이터는 없는 형태의 프로시저
		---( 객체형태에서 void를 주로 사용, 작업만 시킬 용도로서 사용되는게 일반적임)
	*/
	static void output(int lv){
		// void -> return 할 값이 없을때 사용
		int need=0;
		int vip=0;
		while(vip<lv){
			need += (vip++ +1)*1000;
		}
		System.out.println(lv+"등급의 필요 경험치 : "+need);

	}
	/*
		0-0 : 패턴은 전달받을 데이터도 없고, 발생시킬 데이터도 없는 프로시저
	*/
	static void empty(){

	}
	/*
		기대값이 없는 형태인 0-1 / 0-0 형태의 프로시저는 객체를 다루게 되면 자주 등장하게 된다.
	*/

	public static void main(String[] args)	{
		String s =create();
		System.out.println(s);
		output(3);

	}
}
