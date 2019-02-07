
class Cage{
	static int idx;
	int num;

	Animal one;
	Animal other;
	
	Cage (){ // cage생성때마다 숫자++
		num = idx++;
	}
	
	boolean push(Animal t){
		if(one==null){
			one = t;
			return true;
		}else if(other == null){
			other = t;
			return true;
		}else{
			return false;
		}
	}

	Animal birth(){				// 상위객체로 만들면
		if(Math.random()>0.5){
			return new Tiger();		// 하위객체들을
		}else{
			return new Elephant();	// 모두 처리할수 있다.
		}
	} 
}

//=============================================================


class Source04_UsePolymorphism {
	public static void main(String[] args)	{
		Cage c = new Cage();
		Tiger t = new Tiger();
		c.push(t);
		Korean k = new Korean();
		c.push(k);
		// 특정타입에 국한된 처리가 아니라,
		// 계열전체를 처리할수 있는 형태의 기능구현이 가능해진다.
		Animal a = c.birth();
		System.out.println(a); // Tiger@6d06d69c ,Elephant@6d06d69c

		System.out.println(a instanceof Tiger);	// 객체 타입 확인 메소드
		System.out.println(a instanceof Korean);

		// 굳이 실제 타입으로 제어하지 않더라도, 이 객체를 쓰는데 지장이 없다.
		
		Human h = new Human();
			h.healthUp();
		System.out.println(h.inform());
		
		// extends를 걸어서 만들게 될때,
		// 알아둬야 되는 점들을 좀더 살펴봐야 이 특징들을 응용할수 있다.
	}
}
