
/*
 * 	Object�� ���� �����޾� ���� �� ����߿�
 *	
 *	2. public boolean equals(Object obj) 
 * 		�⺻�� ������ü���� Ȯ���ϰ� ������ִµ�, 
 * 		�̰� �����Ͱ� ���� �������� Ȯ���Ҽ� �ְ� �����صδ� �� 
 * 		���..?  
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
		System.out.println(bb);	// false�� �ߴ� ����..?
		
		Object o = new Coord(11, 5);
		System.out.println(o instanceof Coord);
		
		// ��ü���� ��ȯ�� �ȴ�?
		
		((Coord)o).isDuplicated(c2);	// �ٸ���ü������ �νĽ��Ѽ� ����Ҷ�
										// �´°�ü�� ���������.
		/*
		Rectangle t = (Rectangle)o;		// �ȸ´� ��ü�� �̰� ���α׷� ����������� 
		t.grow(2, 5);
		*/
		o = null;
		System.gc();
		
		int n = 0;
		for(;n>0;)
			n++;
		
		// �׿ܿ� Object extends �ɸ��鼭 �����Ե� ��ɵ��� �� �����Ѵ�.
		// �� ��ɵ鵵 override �� �ؼ� ������ ���Ѿߵ� ���� ��������.
		
		
		
	}
}






