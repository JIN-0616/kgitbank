/*
	������ Sphere ��ü�� ���� �����Ǽ� �۵��ɶ� ����� ���ư����� Ȯ��
*/
class Source04_SphereUse {
	public static void main(String[] args) 	{
		new Sphere();
		Sphere sp1 = new Sphere();
		System.out.println(sp1.calcArea() + "   " + sp1.radius);	// �����͸� �������ϰ� ��ü�� ������ ?
							// 0.0                     0
		/*
			��ü�� ��������� ������ ������ ���ٸ� 0���� ������ �Ȼ��·� �۵��� �ȴ�.
			boolean : false , ���������� : 0 , �Ǽ������� : 0.0   ��ü�� : null (?)
		*/
			
		sp1.radius = 3;

		System.out.println(sp1.calcArea() + "   " + sp1.calcVolume());		
							// 113.0973~4           84.8229~  or  63.617~ or 113.0973~4 
		sp1.grow(2);
		System.out.println(sp1.radius);	// 5

		System.out.println(sp1.calcArea() + "   " + sp1.calcVolume());	
							// 314.1592~            392.699 ~ or 523.59866
	
		Sphere sp2 = new Sphere();
		sp2.change(5);
		System.out.println(sp2.calcArea() + "   " + sp2.calcVolume());	

		System.out.println(sp1 == sp2);
		System.out.println(sp1.radius == sp2.radius);

		System.out.println(sp1.greaterThan(3) );
		System.out.println(sp1.greaterThan(sp2.radius) );

	}
}
