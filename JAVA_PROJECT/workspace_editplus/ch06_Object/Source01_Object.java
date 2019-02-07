import java.awt.Rectangle;	
// 기본으로 연동이 되는 것들을 처리하기 위해서 작성하는 코드

class Source01_Object {
	public static void main(String[] args)	{
		/*
			객체? 프로시저의 집합체 
				+ 데이터저장능력이 있고,
				작동할때 자신이 보유하고 있는 데이터 기반으로 프로시저가 작동하게 된다.				

			객체라는걸 이해하기 위해 ,
			자바에서 제공하는 2차원 평면관리시 사용되는	Ractangle이라는걸 살펴보자.
		*/
		
		// 객체라는걸 사용하기 위해서는 생성과정이 들어가게 되는데, 그때 new 라는 키워드가 쓰이게된다.
		new Rectangle();	// 데이터를 처리할수 있는 객체가 하나 만들어지게 된다.
		new Rectangle();	// 재차 생성을 하게되면 또 다른 객체가 하나 더 만들어지게 된다.
		// 생성시킨 객체를 쓰기 위해서는 new 해서 발생하는 객체값을 받아둬야 하는데, 
		// 객체명으로 변수잡고 선언해서 값을 받아주면 된다.
		Rectangle r1 = new Rectangle();
			// Rectangle 객체는 x, y, width, height 값(int)을 보관하는 능력이 있다.
			r1.x = 10;
			r1.y = 100;
			r1.width = 400;
			r1.height = 300;
		String s1 = r1.toString();
		System.out.println(s1);
		boolean b1 = r1.contains(200,200);

		System.out.println(b1); // true  0,0 오른아래로 1600,900

		Rectangle r2 = new Rectangle();
			r2.x = r2.y =20;
			r2.width = r2.height = 100;
		String s2 = r2.toString();
		System.out.println(s2);
		boolean b2 = r2.contains(200,200);
		System.out.println(b2); // 각 개체가 보유중인 값을 기반으로 프로시저를 시행함 false

		r1.grow(10,5);
		System.out.println( r1.toString());
		// 좌표(중점)기준에서 2차원상(상하좌우)로 각각 10(좌우), 5씩(위아래) 늘어남

		// r2 (20,20,100,100)
		r2.grow(20,10);
		System.out.println( r2.toString());
		// r2 ( 0,10,140,120)

		/*
			객체 =>	data storage + procedure

			객체 자체를 만들때는 객체가 하는일을 procedure 형태로 만들어야 함
		*/
	}
}
