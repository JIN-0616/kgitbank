


import design.Box;

class Container extends Box {
	String str;
	Container() {
//		data = 3;	
		// default access 였기 때문에, extends를 걸고 설계하긴 했지만 직접제어는 불가
		flag = true;	
		// protected는 extends 걸고 설계되는 객체라면, access를 허용이 된다.
		str ="extension";
		// public 은 원래 타패키지에서도 무조건 허용되는 access 단계기 때문에, access 가능
		rate = 0.25;
		System.out.println("container instance created");
	}



}
