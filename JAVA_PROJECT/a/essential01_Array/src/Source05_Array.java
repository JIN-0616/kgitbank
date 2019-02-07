import sample.Coord;

/*
 * 	배열 객체?
 * 		- 값(데이터,객체값) 여러개(유한)를 한꺼번에 저장시킬수 있게 설계된 객체 
 * 
 * 	생성방법이 일반 객체생성법이랑은 조금 다르다.
 * 
 * 	new 데이터종류[개수];
 */
public class Source05_Array {
	public static void main(String[] args) {
		System.out.println( new int[5] ) ;	
		// 생성후 객체값을 출력만 하고 어딘가에 저장을 안했기 이 배열객체는 다시 접근이 안됨.
		
		System.out.println(new Sword[3] );
		// 이 배열객체를 제어하기 위해서는 객체값을 받아야 되는데, 
		// 타입선언을 데이터종류[] 변수;
		
		int[] a;
		Sword[] b;
		boolean[] f;
		Coord[] c;	// ctrl+shif+o : smart import
		
		a = new int[3];
		int[] aa = new int[5];
		Object o = aa;
		// 배열객체는 접근되는 변수가 length 라는 이름을 가진 int형 변수가 있다.
		System.out.println(a.length);	// 몇칸짜리 저장소인지 length에 설정되있다.
		System.out.println(aa.length);	//  
		
		// 배열객체가 가지고 있는 실제 데이터 저장공간을 사용하려면,
		// 변수[칸번호] : 인덱스(칸번호) 설정은 0번부터 차례대로 붙여져 있음.
		a[0] = 4;
		a[1] = 9;
		a[2] = 30;
		// 칸번호가 잘못설정되서 접근되면 프로그램이 그 즉시 오류 뜨면서 멈춤
		//	a[5] = 2;
		Sword[] sw = new Sword[2];
		System.out.println("sw.length = " + sw.length);
		sw[0] = new Sword();
		
		Sword s = new Sword();
		sw[1] = s;
				
		
		
		
		
		
		
		
		
		
		
	}
}
