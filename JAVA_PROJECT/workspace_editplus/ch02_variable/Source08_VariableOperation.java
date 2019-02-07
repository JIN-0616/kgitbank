class Source08_VariableOperation {
	public static void main(String[] args) {
		/*
			String 을 관리하는 변수에도 = 외에 사용할수 있는 작업이 있는데
			 += 작업이고, 이건 현재 가진 문자열에 뒤에 데이터를 포함한 문자열이 만들어진다.
		*/
		int hour = 13;
		String str = "입력하신 시간은";
		str += hour>=12 ? "오전" : "오후"; // str = str + ??;
		str += "입니다.";
		str += 13;
		str += 1;
		str += 2; //원래 가지고 있는 문자열에 해당 문자열 뒤에 더해서 설정

		System.out.println(str);

		String rev = "집에..";
		//rev = "가고싶다.." +rev;
		rev = rev + "가고싶다.." ;
		//rev = "미치도록.." +rev;
		rev = rev +"미치도록.." ;
		System.out.println(rev); // 앞에다 추가해야할 경우
		
	}
}
