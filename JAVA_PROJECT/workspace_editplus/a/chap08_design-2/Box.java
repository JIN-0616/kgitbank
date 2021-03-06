/*
	extends 를 이용한 설계시 주의,알아둘것들

	1. extends 의 대상(상위,부모,슈퍼,원본 타입은)이 접근이 되고, 
	extends를 허용해두었어야만 가능하다. 

	2. extends 를 통해 설계되는 객체는 원본(부모)의 모든요소에 access 되진 않는다.
	access 단계에 따라 접근이 안되는것들이 있을수도 있다.

	3. super 키워드를 이용해야 될때가 있다.
*/
package design;

// public final class Box 
public class Box {		
	int data;
	protected boolean flag;
	public double rate;

	public Box(int n) {
		System.out.println("box instance created!");
	}


	public String inform() {
		return data+", "+ flag +", " + rate;
	}
}
