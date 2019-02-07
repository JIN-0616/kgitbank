class Source03_UseEnum {
	public static void main(String[] args)	{
		//new Planet(456.142,41234.2); //객체 생성 안됨 may not be instantiated
		Planet p = Planet.EARTH;

		double g = p.getGravity();
		System.out.println(g);
		// 지구의 중력 ... 9.8 ...

		Planet p2 = Planet.valueOf("MERCURY");

		Planet p3 = Planet.valueOf("MERCURY");

		System.out.println(p2==p3);

		System.out.println(p2.getGravity());
		System.out.println(p2.EARTH.getGravity());

		switch(p){ // int , String, enum 이 3개만 switch-case 가능
		case EARTH:
			break;
		case MERCURY:
		}
		System.out.println(p2);
		// 객체값이 출력이 될때 출력되는 내용은 객체를 설계하면서 변경이 가능함

		long h = System.identityHashCode(p2); // 객체 고유값을 얻어내는..
		System.out.println(h);
		// 해쉬코드 고유값
	
	}
}
