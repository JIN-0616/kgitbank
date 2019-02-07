/*
	설계한 Sphere 객체가 실제 생성되서 작동될때 제대로 돌아가는지 확인
*/
class Source04_SphereUse {
	public static void main(String[] args) 	{
		new Sphere();
		Sphere sp1 = new Sphere();
		System.out.println(sp1.calcArea() + "   " + sp1.radius);	// 데이터를 설정안하고 객체를 돌리면 ?
							// 0.0                     0
		/*
			객체가 만들어지고 별도의 세팅이 없다면 0으로 설정이 된상태로 작동이 된다.
			boolean : false , 정수데이터 : 0 , 실수데이터 : 0.0   객체값 : null (?)
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
