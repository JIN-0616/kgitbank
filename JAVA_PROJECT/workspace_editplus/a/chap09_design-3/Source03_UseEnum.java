class Source03_UseEnum {
	public static void main(String[] args) 	{
		// new Planet(456.142, 41234.2);	객체 생성 안됨. may not be instantiated
		Planet p = Planet.EARTH;

		double g = p.getGravity();
		System.out.println(g);
		

		Planet p2 = Planet.valueOf("MERCURY");

		Planet p3 = Planet.valueOf("MERCURY");

		System.out.println(p2 == p3);
		System.out.println(p2.getGravity());

		System.out.println(Planet.EARTH.getGravity());

		switch(p) {
		case EARTH :
			break;

		case MERCURY :

		}

		System.out.println(p2);	// 객체값이 찍히게 될때 출력되는내용은 객체 설계시 변경이 가능함.
		long h = System.identityHashCode(p2);	 // 객체 고유값을 얻어내는..
		System.out.println(h);	
	}
}
