/*
	branch 와 더불어 데이터 처리과정에서 loop 라는걸 구현하는법도 알아두어야 한다.

	loop ? 회전(고리/반복)

	데이터를 처리하다보면 한번의 작업으로 끝나는게 같은 여러번 처리해야만 얻어낼수 있는
	결과들이 존재한다.

	수치데이터를 토대로 3자리마다 컴마를 찍어서 표기한 문자열 생성의 경우..
*/	
class Source01_Loop {
	public static void main(String[] args) {
		int r = 100+(int)(Math.random()*900);
		System.out.println(r);
		/*
			만들어내기 위해서 어떤 과정을 되냐..?
			1의자리를 계속 뽑아다가 앞에다가 붙여나가면 됨.
			위 작업을 3번 했으면,를 찍고
			r이 0이될때까지하든지 ,자리수에 따라 회수를 정해놓고 하던가..
		*/
		String str ="";
		System.out.println(str);
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		str = ","+str;
		System.out.println(str);		
		str = r%10 + str;
		r /=10;
		System.out.println(str);		
		/*
			loop 는 while 혹은 for 를 이용해서 구현가능하다.
			
			while loop 부터 구현법을 살펴보자.
		*/
			
	}
}
