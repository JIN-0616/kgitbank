class Fruit{
	int cnt;
	Fruit(int cnt){
		this.cnt = cnt;
	}
}
//========================================================================
class Apple extends Fruit {
	int cnt;
	Apple(int scnt, int tcnt){
		super(scnt);
		this.cnt = tcnt;
	}
	int total(){
		int cnt = this.cnt + super.cnt;
		System.out.println(cnt+ " / "+ this.cnt + " / "+ super.cnt);
							// 다른cnt
		return cnt;
	}
	double average(){
		System.out.println(cnt+"/"+this.cnt+"/"+super.cnt);
							//2개 동일
		return (cnt+super.cnt)/2.0;
	}
}
/*
	부모쪽에 있는걸로 또 만들면, 이렇게 쓰기도 불편한데 만들일이 있나..?
	변수를 겹쳐서 선언하는 경우는 거의 드물고,
	함수는 겹쳐서 선언을 하는 경우가 있다.
*/

//========================================================================
class Source06_DiveExtension {
	public static void main(String[] args)	{
		/*
			Apple 객체를 만들어서 total 함수를 콜 해보자.
		*/
		Apple apple = new Apple(10,20);
		System.out.println(apple.total());
		System.out.println(apple.average());

	}
}
