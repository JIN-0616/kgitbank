/*
	프로시져(=함수) 설계시 가능한 것들
*/
class Source05_Procedure {
	/*
		1. 오버로딩이 가능하다. (프로시져명이 같아도, 매개변수형태가 다르면 설계가 가능하다)
     	 변수명이나, 리턴타입은 영향을 주지 않는다. - 오버로드 (저그 유닛태워서 날라다니는 기능이 있음)
		 이미 이 혜택을 보고 있었다. 출력할때. 
	*/
	static double range(int x1, int y1, int x2, int y2) {
		return Math.sqrt( (x1-x2) *(x1-x2) + (y1-y2)*(y1-y2)  );
	}
	static double range(int x1, int y1) {
		return Math.sqrt( (x1) *(x1) + (y1)*(y1)  );
	}
/*	
	static double range(int a, int b, int c, int d) { ...
	static boolean range(int x1, int y1){ ...
	이패턴은 추가 등록이 안됨. (매개변수 패턴이 중요)
*/
	/*
		2. 프로시져가 결과물을 만들어내야된다거나, 데이터를 전달받는 형태로 설계할 필요는 없다.
		만드는 목적에 따라 1-1, 1-0, 0-1, 0-0 패턴이 가능하다.
		1-0 : Math.random();
	*/
	static String create() {
		int r = (int)(Math.random()*3);
		if(r==0)
			return "탱커";
		else if(r==1)
			return "딜러";
		else
			return "힐러";
	}
	// 0-1 패턴은 , 전달받을 데이터는 있지만, 발생시킬 데이터는 없는 형태의 프로시져
	static void output(int lv) {
		int need=0;
		int vip=0;
		while(vip<lv) {
			need +=  (vip++ +1)*1000;
		}
		System.out.println(lv+"등급의 필요 경험치 : " + need);
	}
	
	// 0-0 패턴은 , 전달받을 데이터도 없고, 발생시킬 데이터도 없는 프로시져
	static void empty(){
	}

	/*
		기대값이 없는 형태인 0-1 / 0-0 형태의 프로시져는 객체를 다루게 되면 자주 등장하게 된다.
	*/

	public static void main(String[] args) {
		String s = create();
		System.out.println(s);
//		System.out.println(output(3));

	}
}
