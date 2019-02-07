class Source07_VariableOperation {
	public static void main(String[] args) {
		/*
			변수의 데이터를 조작하는 작업이  = (할당/대입) 외에도 더 존재한다.

			수치형 변수에 한해 ,
				+=, -=, *= , /=, %=, ++, --  조작이 가능하다.
		*/
		int ammount;
		ammount = 10000;
		ammount += 100;	// ammount = ammount + 100;
		System.out.println("ammount = "+ ammount);
		ammount -= 6000;
		System.out.println("ammount = "+ ammount);
		ammount *= 3;
		System.out.println("ammount = "+ ammount);

		ammount++;	// 1증가
		System.out.println("ammount = "+ ammount);
		ammount--;	// 1감소
		System.out.println("ammount = "+ ammount);
		++ammount;	// ++는 변수 앞이나 뒤에 설정이 가능
		System.out.println("ammount = "+ ammount);
		// 지금은 처리결과가 같지만, 다른경우가 있다.
		//=======================================================
		int val = 30;
		System.out.println(val++);	// 30 
		System.out.println(++val);	// 32
		System.out.println(val);	// 32
		/*
			++, -- 가 변수 뒤쪽에 있으면, 로드되고 변화가 됨.
						 앞쪽에 있으면, 변화가 먼저 되고 로드 된다.
		*/
		val = 10;
		int check = val++ + ++val + ++val + val++ + val;
				//   10   + 12  + 13  +     13    + 14
		System.out.println("val = " + val);	// 14
		System.out.println("check = " + check);	// 62
		val = 10;
		val %= 3;	// 1
		check = ++val * val++ * val * ++val * val--;
				// 2  *  2  * 3 * 4 * 4
		System.out.println("val = " + val);	// 3
		System.out.println("check = " + check);	// 192
		System.out.println(16*12);	// 192
	}
}
