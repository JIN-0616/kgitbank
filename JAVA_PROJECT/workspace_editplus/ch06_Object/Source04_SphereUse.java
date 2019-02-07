/*
	설계한 sphere 객체가 실제 생성되서 작동될때 제대로 돌아가는지 확인
*/
class Source04_SphereUse {
	public static void main(String[] args)	{
		new Sphere();
		
		Sphere sp1 = new Sphere();
		System.out.println(sp1); //Sphere@15db9742
		System.out.println(sp1.calcArea()+ "..."+sp1.radius);//데이터를 설정안하고 객체를 돌리면?
								//0.0		...		0
		/*
			객체가 만들어지고 별도의 세팅이 없다면 0으로 설정이 된상태로 작동이 된다.

			boolean : false , 정수데이터 0, 실수데이터 : 0.0, 객체값 null
		*/
		sp1.radius = 3;
		System.out.println(sp1.calcArea()+ "..."+sp1.calcVolume()); 
						// 113.09731200000002...113.09731200000002
		sp1.grow(2);
		System.out.println(sp1.radius);		//	5

		System.out.println(sp1.calcArea()+ "..."+sp1.calcVolume()); 
							// 314.1592		...		523.5986666666666

		Sphere sp2 = new Sphere(); 
		System.out.println(sp2); //Sphere@6d06d69c
		sp2.change(5);
		System.out.println(sp2.calcArea()+ "..."+sp2.calcVolume()); 
							// 314.1592		...		523.5986666666666

		System.out.println(sp1 == sp2); // 같은객체아니므로 false
		System.out.println(sp1.radius == sp2.radius); //반지름값은 같으므로 true

		System.out.println(sp1.greaterThan(3)); //true
		System.out.println(sp1.greaterThan(sp2.radius));//false

		/*
		Sphere@15db9742
		0.0...0
		113.09731200000002...113.09731200000002
		5
		314.1592...523.5986666666666

		Sphere@6d06d69c
		314.1592...523.5986666666666
		false
		true
		true
		false
		*/
	}
}
