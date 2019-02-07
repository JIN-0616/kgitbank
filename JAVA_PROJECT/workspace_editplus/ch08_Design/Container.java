

import design.Box;
	// box가 public이 아니면 import가 불가능 / final 이면 불가능
class Container extends Box {
	String str;

	Container(){
//		data = 3;	
		// default access 였기 때문에, extends를 걸고 설계하긴 했지만 직접제어는 불가
		
		flag = true;
		// protected는 extends 걸고 설계되는 객체라면, access가 허용이 된다.
		
		str = "extendsion";
		
		rate = "0.25";
		// public은 원래 타 패키지에서도 무조건 허용되는 access 단계
		System.out.println("contanier instance created");

	}





}
