class Exercise02_Operation{
	public static void main(String[] args) 	{
		//총 3줄을 출력하는 프로그램
		//한글자음부분은 ㄱ ???? ㅎ ??? 으로 총 ???개 등록되있고,
		//한글모음부분은 'ㅏ'는 ???? 으로 l는 ???으로 총 ???개 등록되있고,
		///한글완성형문자는 가는 ??? 힣은 ???으로 총 ????개 등록되있다.
		/*
		System.out.println('ㄱ'+0); // 12593
		System.out.println('ㅎ'+0); // 12622

		System.out.println('ㅏ'+0); // 12623
		System.out.println('ㅣ'+0); // 12643

		System.out.println('가'+0); // 44032
		System.out.println('힣'+0); // 55203
		*/
		System.out.println("한글자음부분은 ㄱ은 "
				+ ('ㄱ'+0) +", ㅎ은 " + ('ㅎ'+0)+"으로 총 "+(('ㅎ'-'ㄱ')+1)+"개 등록되있고");
		System.out.println("한글모음부분은 ㅏ은 "
				+ ('ㅏ'+0) +", ㅣ은 " + ('ㅣ'+0)+"으로 총 "+(('ㅣ'-'ㅏ')+1)+"개 등록되있고");
		System.out.println("한글완성형문자는 가는 "
				+ ('가'+0) +", 힣은 " + ('힣'+0)+"으로 총 "+(('힣'-'가')+1)+"개 등록되있다.");

		
		
		System.out.println("ㄱ으로 시작되는 완성형문자는 가는 "
				+ ('가'+0) +", 나는 " + ('나'+ 0)+"으로 총 "+('나'-'가')+"개 등록되있다."); //빈공간없다가정하에
		
		System.out.println( (char)(45207)); // ㄱ 끝글자 끟

	}
}
