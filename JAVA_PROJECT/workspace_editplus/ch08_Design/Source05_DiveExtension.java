/*
	3. super 라는 키워드를 사용해야되는 상황이 있을수도 있다.

	 -원본(부모)쪽에 매개변수 없는 생성자가 존재하지 않는다면,
	 만들어내는 방식을 다르게 바꿔주어야 하는데, 이때 이 키워드가 사용된다.

	 -사용하고자 하는 변수나, 기능이 부모꺼임을 명시하고 싶을때
	 super를 지정해줄수 있다.

	 -(만약, extends 걸고 설계할 때, 원본에 있는데 있는 이름으로
	  다시 또 변수나 함수를 만드는걸 허용한다. 그럴때는 반드시
	  super, this 이렇게 구분해서 처리해야된다.
	  구분하지않으면 원본 쪽이 가려짐
*/
class Talent{
	Talent(String a){
		System.out.println("telent created " + a);
	}
	Talent(int a){
		System.out.println("telent created " + a);
	}
	String tell(){
		if(Math.random()>0.5)
			return "안녕하세요";
		else
			return "반갑습니다";

	}
}

class Actor extends Talent {
	Actor(){		
		// new Talent("??");
		super(11);
		System.out.println("actor created");
	}
	String performance(boolean mode){
		if(mode){
			return "(화색을 띄며)"+this.tell(); // 에러는 아니나 super가 맞음
		}else{
			return "(급정색 하며)"+super.tell(); 
		}
	}
}
class MovieStar extends Actor{
	MovieStar(){
		// new Actor(); 이런 역활의 코드를 작성해야되지만, 생략시 자동설정
		// == super(); [아무설정없이 생성하면 생략되어있는 코드]
		System.out.println("moviestar created");
	}
}

//==============================================================================
class Source05_DiveExtension {
	public static void main(String[] args)	{
		Actor a = new Actor();
		String m = a.tell();
		System.out.println(m);
		String b = a.performance(false);
		System.out.println(b);
		//new MovieStar();
		// 최상위 extends 된 객체부터 호출(생성)됨
		// 무조건 매개변수 없는 생성자를 찾아서 호출
		
		/*
			Container 객체를 하나 생성
		*/

		//Container c = new Container();
		/*
			만약에 생성하고자 하는 객체가 extends를 통해서 설계된 객체라면
			extends 의 최상위부터 하나씩 차례대로 만들어지면서 객체가 완성된다.
			이 때 윗단계의 객체를 생성시키는 과정에서
			매개변수 없는 형태의 생성자를 찾아서 생성되게 되있다.
		*/
	}
}
