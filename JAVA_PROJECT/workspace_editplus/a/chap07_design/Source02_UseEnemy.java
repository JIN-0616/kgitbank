class Source02_UseEnemy {
	public static void main(String[] args) 	{
		System.out.println(Enemy.health);

		Enemy e1 = new Enemy();
		Enemy e2 = new Enemy();
		System.out.println("e1? "+ e1.info());
		System.out.println("e2? "+ e2.info());
		e1.attacked(25);
		System.out.println("e1? "+ e1.info());
		System.out.println("e2? "+ e2.info());
		Enemy e3 = new Enemy();

		System.out.println("e1? "+ e1.info());
		System.out.println("e2? "+ e2.info());
		/*
			��ü�� ������ ��(������ �ִ�) static ������, �Լ��� 
			�ٷ� ������ �����ϴ�.
		*/
		System.out.println("e2? "+ e2.health);
		e2.heal(444);
		System.out.println(Enemy.health);
		Enemy.heal(4);
//		Enemy.attacked(55);
	}
}
