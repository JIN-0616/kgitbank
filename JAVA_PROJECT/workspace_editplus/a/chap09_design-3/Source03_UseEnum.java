class Source03_UseEnum {
	public static void main(String[] args) 	{
		// new Planet(456.142, 41234.2);	��ü ���� �ȵ�. may not be instantiated
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

		System.out.println(p2);	// ��ü���� ������ �ɶ� ��µǴ³����� ��ü ����� ������ ������.
		long h = System.identityHashCode(p2);	 // ��ü �������� ����..
		System.out.println(h);	
	}
}