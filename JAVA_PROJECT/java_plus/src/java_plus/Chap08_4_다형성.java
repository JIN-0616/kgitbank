package java_plus;
	/*
	3. 다형성
	  1) 클래스의 다형성
	   -한 타입의 참조변수로 여러 타입의 객체를 참조 가능
	   -부모클래스 타입의 참조변수로 자식 클래스의 인스턴스를 참조
	   
	  2) 형변환
	   -변수명 instanceof 클래스 이름 ---> 형변환이 가능한지 체크
	   -상속관계에 있는 클래스만 체크가능
	 	 
	 */

class dy_per{
	int a=30;
}
class dy_child extends dy_per{
	int b=20;	
}
class dy_a{
	int a=10;	
}

public class Chap08_4_다형성 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		dy_per p1 = new dy_per();
		dy_per p2 = new dy_child(); // 자식클래스로 부모클래스를 선언가능
		
		dy_child c1 = new dy_child();
		//dy_child c2 = new dy_per(); // 부모클래스로 자식클래스를 선언불가
			//메모리의 할당크기가 자식이 더 크기때문에 작은 부모로 할당불가
		
		System.out.println("p1.a="+p1.a);
		System.out.println("p2.a="+p2.a);
		//System.out.println(p2.b); //자식으로 메모리할당을 받았어도 자식으로 접근은 불가
		
		if(p1 instanceof dy_per) {
			System.out.println("p1->dy_per 변환가능");
		}else{
			System.out.println("p1->dy_per 변환불가");			
		}
		/*	상속관계등으로 접근할 수 있는 형태이어야만 클래스는 형변환이 가능하다
		 *  멤버의 형태가 동일하다고 해서 클래스는 같다고 볼 방법이 없다
		 *  다시 말해 클래스의 연결형태는 상속관계등으로 정의한다
		 *  
		 *  if(p1 instanceof by_a){
		 *  	System.out.println("변환가능");
		 *	}else{
		 *		System.out.println("변환불가");			
		 *	}
		 */
		if(p1 instanceof dy_child) { 		// 상속관계이어서 변환상태 유무를 확인할 수 있다.
			System.out.println("p1->dy_child 변환가능"); // 자기자신으로 할당받은 클래스는 자식으로 변환 불가			
		}else {
			System.out.println("p1->dy_child 변환불가");			
		}
		
		//dy_child c3 = (dy_child)p1;
		//부모로 할당받은 변수는 자식클래스로 변환불가 --> 자식의 멤버를 할당받을수가 없다
		
		if(p2 instanceof dy_child) { //상속관계이어서 변환상태 유무를 확인할 수 있다.
			System.out.println("p2->dy_child 변환가능");
		}else {
			System.out.println("p2->dy_child 변환불가");
		}
		
		dy_child c3 = (dy_child)p2;
		//부모이지만 자식으로 할당받은 변수는 자식클래스로 변환가능
		//---> 자식의 멤버가 들어올수 있는 메모리공간이 있다.
		
		System.out.println("c3.b="+c3.b);
		
		p2=c3;
		
		//System.out.println(p2.b);
		
		if(c1 instanceof dy_child) { //자식클래스는 부모 자식 다 변환가능
			System.out.println("c1->dy_child 변환가능");
		}else {
			System.out.println("c1->dy_child 변환불가");
		}
		
		if(c1 instanceof dy_per) { //자식클래스는 부모자식 다 변환가능
			System.out.println("c1->dy_per 변환가능");
		}else {
			System.out.println("c1->dy_per 변환불가");
		}
		
		dy_per p3 = c1;
		//System.out.println(p3.b);
		c1 = (dy_child)p3;
		System.out.println("c1.b="+c1.b);
		
		//시험결과 클래스로 자료를 만들어 주세요
		//시험결과 클래스 : 이름, 학교, 합격여부, 점수
		
		//상속받은 학교 클래스A : 국어 30%, 영어30%, 수학 40%, 합격점수 70
					//  클래스B : 국어 50%, 영어20%, 수학 30%, 합격점수 80
		
		//학생수는 약 5명 정도 입력하여 시험결과클래스로만 결과를 알게 해주세요
		//국어, 영어, 수학점수와 합격 컷트라인은 재접근이 불가능하게 해주세요 
	}
}
