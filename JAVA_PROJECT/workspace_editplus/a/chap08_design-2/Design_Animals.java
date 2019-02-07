
/*
	3. 상속/(확장) 을 시켜서 만든 객체는 다형성이라는 걸 적용시켜두었는데
	이걸 이용해서 객체 제어를 쉽게 할수 있다는 장점이 있다.

	다형성은 생물학에 있는 개념으로, 하나의 종은 여러가지 형태로 발현된다는 성질을 의미한다.
	(동물 - 포유류, 파충류,,, / 포유류 - 고래,사자,인간,등등)

*/

class Animal {
	int health;

	void healthUp() {
		health += 20;
	}
	String inform() {
		return "health = "+health;
	}
}

class Tiger extends Animal {		// 이거 사용

}

class Elephant extends Animal {		// 이거 사용

}

class Human extends Animal {

}

class Korean extends Human {		// 이거 사용

}

class European extends Human {		// 이거 사용

}
