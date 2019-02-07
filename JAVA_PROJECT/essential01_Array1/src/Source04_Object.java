/*
 *  Object로 부터 상속받아 갖게 될 기능중에
 *  
 *  2. public boolean.equals(Object obj)
 *   -기본은 같은 객체인지 확인하게 설계되어 있는데
 *    이걸 데이터가 같은 상태인지 확인할수 있게 개조 해두는 편이다.
 *    어떻게..?
 *    sample package create
 */
import java.awt.Rectangle;
import sample.Coord;

public class Source04_Object {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10,20,100,100);
	//  public Rectangle(int x, int y, int width, int height)
		
		System.out.println(r1);
		System.out.println(r1.toString());
	//    public String toString() {
	//        return getClass().getName() + "[x=" + x + ",y=" + y + ",width=" + width + ",height=" + height + "]";
	//    }
		
		Rectangle r2 = new Rectangle(10, 20, 100, 100);
		System.out.println(r1 == r2);
		boolean b =r1.equals(r2);
	/*
	    public boolean equals(Object obj) {
	        if (obj instanceof Rectangle) {	
	            Rectangle r = (Rectangle)obj;
	            return ((x == r.x) &&
	                    (y == r.y) &&
	                    (width == r.width) &&
	                    (height == r.height));
	        }
	        return super.equals(obj);
    */
		System.out.println(b);
		
		//=====================================
		Coord c = new Coord(3,2);
		System.out.println(c);
		Coord c2 = new Coord(3,2);
		System.out.println(c==c2);
		boolean bb = c.equals(c2);
		System.out.println(bb); // false가 뜨는 이유?
		
		Object o = new Coord(11,5);
		//o.x; 직접제어안됨
		System.out.println(o instanceof Coord);	//true
		
	//  객체값도 변환(캐스팅)이 된다.
	//	Coord t = (Coord)o;
	//	t.isDuplicated(c2);
		
		((Coord)o).isDuplicated(c2); //(괄호에 유의)
	//	따른객체값으로 인식시켜서 사용할때
	//	맞는 객체면 상관없지만
		
	//	Rectangle t2 =(Rectangle)o;
	//	t2.grow(3, 4);
	//	해당타입객체가 아니면 프로그램이 비정상종료됨
		
		o = null;
		System.gc(); //가비지컬렉션 사용 1번
		int n = 0;
		for(;n>0;)
			n++;
		
	//	그 외에 Object extends 걸리면서 가지게될 기능들이 더 존재한다.
	//	그 기능들도 override를 해서 변경을 시켜야될 때가 있을꺼다.
	}
}
