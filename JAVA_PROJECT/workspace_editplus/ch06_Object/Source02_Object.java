import java.awt.Rectangle;

class Source02_Object {
	public static void main(String[] args)	{
		/*
			객체라는건 생성을 해서 나온 객체값을 받아줘야 사용이 가능하다?
			객체값은 무엇인가?
			생성되면서 JVM에서 부여되는 값으로 객체를 사용해야될 때 쓰이는 고유접근값(참조값)이다.
			정확한 값은 확인불가다.
		*/
		new Rectangle(); // strage + procedure 생성 
		//--> 이곳에 접근하게 할수있는 객체값, 주소값, 참조값, 레퍼런스...
		Rectangle r1 = new Rectangle();
			r1.x = 5;
		Rectangle r2; // 객체를 만든건 아니다.
		// Rectangle 객체값을 저장할 변수만 만든것

		r2 = r1;	// r2는 Rectangle 객체값 저장용도이기에, r1안에 저장되어있는 객체값(주소값)을 받을수 있다.
		System.out.println(r2.x);
		r2.y = 100;
		System.out.println(r1.toString());
		r1 = new Rectangle();
		r1.y = 500;
		r2 = r1;
		System.out.println(r2.y); // 주소값과 개념상 동일한듯
		// 객체를 생성하게 되면 객체를 구성하는데 필요한 메모리를 사용하게 되는데
		// 만약, 더 이상 사용되지 않는 객체들은 자바가상머신이 프로그램 실행중에 감지를 해나가면서
		// 알아서 객체를 지워나가면서 불필요한 메모리들을 정리해나간다.
		// 이 현상을 "자바가상머신에서는 가비지 컬렉션이 일어난다"고 표현한다.
		Rectangle one = new Rectangle();
			one.x = one.y = one.width = one.height = 100;
		System.out.println("one = "+ one.toString());


		Rectangle other = new Rectangle();
			other.x = other.y = other.width = other.height = 100;
		System.out.println("other = "+ other.toString());

		//객체값간에 지원 작업은 ==, != 이 두개밖에 없는데, 같은 객체인가 아닌가 비교
		System.out.println(one == other);
		Rectangle t = other;
		other = one;
		System.out.println(one == other);
		// ==> 객체의 프로시저는 void 형태가 많음 (일방적인 작업형태)


		/*
		※참조: 리턴값 확인
		System.out.println(r1.getClass());
		Object obj = r2;
		System.out.println("return type = "+ obj.getClass().getName());
		*/

	}
}
