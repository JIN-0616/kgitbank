class Source03_UseAnimals {
	public static void main(String[] args)	{
		Korean k = new Korean();
		European e = new European();
		Tiger t = new Tiger();
		Elephant l = new Elephant();
		/*
			!! extends 를 받은 개체는 extends를 건 개체의 객체변수로 담을수 있다. !!

			Korean 객체는 최초 animal 로부터 Human을 거처 확장되며 만들어진 객체이다.
			Korean 객체도, Animal의 성질이 발현한 하나의 종으로 취급이 되기에
		*/
		Animal a = new Korean();	// Korean 객체는 상위타입의 객체변수로 제어할수 있다.

		Human b;	//Human타입의 객체변수로 제어되는 객체는 Human의 계열이면 다 제어할 수 있다.
		b = new Korean();
		b = new European();
		// b = new Tiger(); // Error

		Tiger t;
			t = new Tiger();
			t = new Tiger();
			//t = new Elephant(); //Error
		// 이걸 이용하기 위해서, 상속관계를 만들어서 활용하기도 한다.

		/*	
						   Promotion(묵시적 타입변환)

						 ----------------------------->    

			[ 인간 ]                                           [ 포유류 ]

						<-----------------------------

						   Cast (명시적 타입변환)

		*/

		// 상속받은 객체가 많을 경우 누가 누구인지 헷갈릴 수 있다.
        // instanceof 를 사용하면 본래 객체를 확인할 수 있다.
		/*

        if(mamal instanceof Cat) {
            Cat cat = (Cat)mamal;
            cat.mew();
        }else {
            System.out.println("고양이 객체가 아닙니다.");

		*/
		
		/*

		한 java파일에 여러 class를 생성할 수 있다.
		다만 파일이름과 class이름은 일치해야하는데  같은 이름의 class가 여러개일 수는 없다.

		따라서 대표 class를 정해준다.
		대표 class는 public으로 설정해주고 나머지 class들은 public을 붙이지 않는다.

		변수명은 최소 3글자가 좋다.
		어떤 쓰임이 있는지 확인하기 쉽게 !

		*/
	}
}
