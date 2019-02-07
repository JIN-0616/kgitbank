class Source02_UseEnemy {
	public static void main(String[] args)	{
		System.out.println(Enemy.health);

		Enemy e1 = new Enemy();
		Enemy e2 = new Enemy();
		System.out.println("e1? " + e1.info());
		System.out.println("e2? " + e2.info());
		e1.attacked(25);
		System.out.println("e1? " + e1.info());
		System.out.println("e2? " + e2.info()); //health 25바뀌어짐
		Enemy e3 = new Enemy();
		System.out.println("e1? " + e1.info());
		System.out.println("e2? " + e2.info()); 
		/*
			Enemy
				int health - 공통요소
				+ heal()

			e1				e2				e3
			damaged			damaged			damaged
			attacked		attacked		attacked
			info			info			info
		*/

		/*
			객체가 가지게 될(가지고있는) static 변수나, 함수는
			바로 접근이 가능하다.
			객체를 생성하지 않아도 바로 사용가능
		*/
		System.out.println("e1? " + e1.health);
		e2.heal(44); 
		// 개별객체를 타고 접근해도 static 사용가능은 하다.
		// 다만 가독성 및 인식의 문제가 발생함

		System.out.println(Enemy.health);
		Enemy.heal(4);  // 일반적인 사용모습
//		Enemy.attacked(55);  error
	}
}
