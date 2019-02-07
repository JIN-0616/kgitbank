package java_plus;
/*
1. Object
  -자바의 모든 클래스는 슈퍼클래스를 가지며,
   새로운 클래스 생성 시 특정 슈퍼클래스를 상속받도록 명시하지 않으면 object class를 상속받는다.
  -java.lang패키지를 import하지 않아도 Object class는 complier에 의해 자동 로드된다.
  -java.lang의 각 class들도 object class를 상속받는다.
  
 * method
 
  - equals() : 현재 객체와 인자의 객체 참조형이 메모리에서 같은 객체를 참조하는지 검사한다.
      --> 주소값의 검사이지 값의 검사가 아니다.
      : public boolean equals(Object obj)
      
  - hashCode() : heap에 있는 객체의 메모리의 주소값을 얻어온다.
      : public int hashCode()
      
  - clone() : 객체 자신을 복제하여 똑같은 객체를 새롭게 하나 더 생성한다.
	  : protected Object clone() throws CloneNotSupportedException
	  
  @@@@@@@@@@@@@@@@@@@@@@@@ equals() 와 hashCode()의 관계 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  
    - Heap에 객체가 두 개 들어있고, 두 reference가 각 객체를 참조하고 있을때,
     hashCode()와 equals() method를 모두 오버라이드 하면 두 객체가 동치인것으로 간주 할 수 있다.
     
    - hashCode()를 오버라이드 하지 않으면 기본적으로 객체마다 서로다른 유일한 hashCode값을 반환한다.
    
    - equals()는 메소드 내부에서 == 연산자를 써서 두 reference가 한 객체를 참조하는지 확인한다.
    
    - 두 객체의 hashCode 값이 같다고 해서 반드시 같은 것은 아니다.
      --> a.hashCode() == b.hashCode() 가 성립해도 a.equals(b)가 반드시 true는 아니다.
      
    - 두 객체가 같으면 반드시 같은 hashCode를 가져야한다.
      --> a.equals(b)가 true 라면 a.hashCode() == b.hashCode()도 성립한다.
      
    - 두 객체가 같으면 equals() 메소드 호출 시 true를 반환해야 한다.
      --> a.equals(b)와 b.equals(a) 모두 true
      
    - equals()를 오버라이드 하면 반드시 hashCode()도 오버라이드 해야한다.
    
    - equals() 와 hashCode() 메소드를 오버라이드 하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
    
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
*/
class O_c{
	int a = 10;
	
	@Override
	public String toString() {
		// 주소를 호출하는 기본 메소드
		return "선생님은 귀여워요";
	}
}

public class Chap11_1_package_lang {
	public static void main(String[] args) {
		O_c oc = new O_c();
		
		O_c oc2 = oc; 				// 주소 대입 ==> toString()을 대입
		oc2.a = 100;
		System.out.println(oc.a);	//100
		System.out.println(oc2.a);	//100
		
		System.out.println(oc);		// 주소 출력 --> toString()
		System.out.println(oc2);	// 선생님은 귀여워요;
									// 선생님은 귀여워요;
		
		System.out.println(oc.toString());	// 선생님은 귀여워요;
		// Object가 가지고 있는 기본 메소드 ==> 모든 클래스의 슈퍼클래스 : Object
		// --> 상속하지 않아도 자동 상속
		System.out.println(oc2.toString());	// 선생님은 귀여워요;
		
		System.out.println(oc.hashCode());	//1311053135
		System.out.println(oc2.hashCode()); //1311053135
		// hashCode() 클래스의 주소값을 숫자형태로 리턴
		
		if(oc==oc2)
			System.out.println("주소가 같아요");
		else
			System.out.println("주소가 달라요");
		
		if(oc.equals(oc2))			// 주소값의 비교 --> hashCode()의 비교
			System.out.println("주소가 같아요");
		else
			System.out.println("주소가 달라요");
		
		O_c oc3 = new O_c();
		
		//oc3 = oc.clone() 일반적인 경우 작동 되지 않는다.
		
		int [] arr_1 = {1,3,5};
		
		int [] arr_2 = arr_1.clone();
		// 할당받지 않은 곳에 복사할 경우 자동으로 동적할당 실행후 deep copy
		// deep copy ==> 모든 Object가 다 되는 것이 아니라 리스트 형태와 같은 경우에만 가능
		
		arr_2[1]=4;
		System.out.println("arr_1[0]:"+arr_1[0]);
		System.out.println("arr_2[0]:"+arr_2[0]);
		System.out.println("arr_1[1]:"+arr_1[1]);
		System.out.println("arr_2[1]:"+arr_2[1]);
		//arr_1[0]:1
		//arr_2[0]:1
		//arr_1[1]:3
		//arr_2[1]:4

	}
}
