

class Source03_UseAnimals {
	public static void main(String[] args) 	{
		Korean k = new Korean();
		European e = new European();
		Tiger t = new Tiger();
		Elephant p = new Elephant();
		/*
			Korean ��ü�� ���� animal �κ��� Human�� ���� Ȯ��Ǹ� ������� ��ü�̴�.
			Korean ��ü��, Animal�� ������ ������ �ϳ��� ������ ����� �Ǳ⿡
		*/
		Animal a = new Korean();	// Korean ��ü�� ����Ÿ���� ��ü������ �����Ҽ� �ִ�.
		
		Human b;	// HumanŸ���� ��ü������ ����Ǵ� ��ü�� Human�� �迭�̸� �� �����Ҽ� �ִ�.
		b = new Korean();
		b = new European();
		b = new Tiger();

		Tiger t;
			t= new Tiger();
			t= new Tiger();
			t = new Elephant();
		// �̰� �̿��ϱ� ���ؼ�, ��Ӱ��踦 ���� Ȱ���ϱ⵵ �Ѵ�.
	}
}