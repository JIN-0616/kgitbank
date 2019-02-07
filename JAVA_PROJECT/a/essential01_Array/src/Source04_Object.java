
/*
 * 	Object로 부터 물려받아 갖게 될 기능중에
 *	
 *	2. public boolean equals(Object obj) 
 * 		기본은 같은객체인지 확인하게 설계되있는데, 
 * 		이걸 데이터가 같은 상태인지 확인할수 있게 개조해두는 편 
 * 		어떻게..?  
 * 		sample package create 
 * 
 */
import java.awt.Rectangle;
import sample.Coord;

public class Source04_Object {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10, 20, 100, 100);
		System.out.println(r1);
		System.out.println(r1.toString());
		
		Rectangle r2 = new Rectangle(10, 20, 100, 100);
		System.out.println(r1 == r2);
		
		boolean b = r1.equals(r2);
		System.out.println(b);
		
		//============================================
		Coord c = new Coord(3, 2);
		System.out.println(c);
		Coord c2 = new Coord(3, 2);
		System.out.println(c == c2);
		boolean bb = c.equals(c2);
		System.out.println(bb);	// false가 뜨는 이유..?
		
		Object o = new Coord(11, 5);
		System.out.println(o instanceof Coord);
		
		// 객체값도 변환이 된다?
		
		((Coord)o).isDuplicated(c2);	// 다른객체값으로 인식시켜서 사용할때
										// 맞는객체면 상관없지만.
		/*
		Rectangle t = (Rectangle)o;		// 안맞는 객체면 이건 프로그램 비정상종료됨 
		t.grow(2, 5);
		*/
		o = null;
		System.gc();
		
		int n = 0;
		for(;n>0;)
			n++;
		
		// 그외에 Object extends 걸리면서 가지게될 기능들이 더 존재한다.
		// 그 기능들도 override 를 해서 변경을 시켜야될 때가 있을꺼다.
		
		
		
	}
}






