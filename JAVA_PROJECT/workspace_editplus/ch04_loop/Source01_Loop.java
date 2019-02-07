/*
	branch 와 더불어 데이터 처리과정에서 loop라는걸 구현하는법도 알아두어야 한다.

	loop : 회전(고리/반복)

	데이터를 처리하다보면 한번의 작업으로 끝나는게 아니라
	같은 처리를 여러번 해야만 얻어낼수 있는 결과들이 존재한다.
	
	수치데이터를 토대로 3자리마다 콤마를 찍어서 표기한 문자열 생성의 경우
*/

class Source01_Loop {
	public static void main(String[] args) 	{
		int r = 1000+(int)(Math.random()*9000);
		System.out.println(r);
		/*
			만들어내기 위해서 어떤 과정을 거처야 하나?
			1의 자리를 계속 뽑아다가 앞에다가 붙여나가면 됨.
			위 작업을 3번 했으면 ,를 찍고
			r이 0이 될때까지 반복, or (자리수에 따라 회수를 정해놓고 하던가)
		*/
		String str = "";
		str = r%10 +str; 
		r /= 10;
		System.out.println(r); 
		System.out.println(str);
		System.out.println();

		str = r%10 +str;
		r /= 10;
		System.out.println(r);
		System.out.println(str);
		System.out.println();

		str = r%10 +str;
		r /= 10;
		System.out.println(r);
		System.out.println(str);
		System.out.println();

		str = ","+str;

		str = r%10 +str;
		r /= 10;
		System.out.println(r);
		System.out.println(str);
		System.out.println();

		/*
			loop 구현도 while 혹은 for를 이용해서 구현가능하다.

			while loop 부터 구현법을 살펴보자.
		*/
	}
}
