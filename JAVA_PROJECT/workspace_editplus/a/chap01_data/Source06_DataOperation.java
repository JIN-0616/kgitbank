
class Source06_DataOperation {
	public static void main(String[] args) {
		/*
			수치형 데이터를 통해서 할수 있는 작업들을
			산술연산에 이어서 좀더 알아보자.

			# 비트연산  - 정수수치에 한해서만 가능한 작업 /
			 << , >>, >>>,    ^, &, |
			
			프로그램에서 사용한 정수 수치가 어떻게 컴퓨터를 인식해서 처리하는지를
			알아야만 이 기호들의 기능을 이해할수 있다.
			정수수치는 2진수로 데이터를 저장해두고 연산처리를 진행 (기본 4byte)
		*/
		System.out.println(  3 == 0b11);

		System.out.println(3 << 2);		//  수치 << 수치
		System.out.println( 0b1100 );

		System.out.println(13 >> 2);	// 0(28)1101  ==>  0(30)11  ==> 3
		System.out.println(13 >>> 2);	
		
		System.out.println(0b11111111_11111111_11111111_11111111);	// == -1?
		System.out.println(0b00000000_00000000_00000000_00000001);


		System.out.println(0b01111111_11111111_11111111_11111111);	// == 2147483647 ?

		System.out.println(0b10000000_00000000_00000000_00000000);	// == -2147483648 ?


		System.out.println(-13 >> 2);	
		// 비어지는 부분 맨앞칸이 0이였으면 0으로, 1이였으면 1로 채우는
		System.out.println(-13 >>> 2);	
		// 비어지는 부분을 무조건 0으로

		System.out.println(4 & 1);	// 비트별로 비교를 하는데 둘다 1이면 1, 그게아니면 0
		System.out.println(4 | 1);	// 비트별로 비교를 하는데 둘중에 하나라도 1이면 1, 그게아니면 0
		System.out.println(4 ^ 1);	// 두개가 다르면 1, 같으면 0
		
		System.out.println(0b100 & 0b001);	// 0b000	==> 0
		System.out.println(0b100 & 0b101);	// 0b100	==> 4
		System.out.println(0b101 | 0b001);	// ==> 5
		System.out.println(0b111 ^ 0b001);	// ==> ?
		// System.out.println( 3.14 << 2);
	}
}
/*
	정수 비트 연산은 일반 프로그램에서는 크게 사용되지 않는 연산(계산)이긴 하다.
	프로그램에서 사용한 정수 데이터가 어떻게 처리가 되는지 이해만 하시면 된다.
*/

