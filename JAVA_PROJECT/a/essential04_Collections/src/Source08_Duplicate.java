import java.util.HashSet;
import java.util.Set;

class Position {
	int x;
	int y;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[x="+x+", y="+y+"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// 2. ���� �����͵�� �ִ� ��ü��� equals() �񱳰� true �� �߰� ����.
		System.out.println("equals called...!!!");
		// return super.equals(obj);
		if(obj instanceof Position) {
			Position other = (Position)obj;
			return this.x == other.x && this.y == other.y;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode called...!!!");
		// return x * y;	// ������ ���� �����Ͱ� �޶� ���� hashCode�� ��������� �ִ�.
		return (x*x+y*y - x+y)*3;	
		// 1.��� �ִ� �����ͷ� ���� �ο����� hashCode�� �ƴ϶� ���ο� hashCode�� ���Ͻ��Ѽ�
		// ���� �����͵�� �ִ� ��ü������ hashCode ���� ������ �ؼ� equals �� ���Ҽ� �ְ� �����ϰ�.
	}
}
//============================================================
public class Source08_Duplicate {
	public static void main(String[] args) {
		System.out.println("������".hashCode());
		System.out.println("������".hashCode());
		
		// ��ġ�� �ʰ� Position �� Ȯ���غ���.
		// �迭���ٴ� Set �÷����� ���� ��ü�� �������� �ʴ´ٴ°� �˾Ƽ� �̿�
		Set<Position> ps = new HashSet<>();
		Position t = new Position(1, 1);
	//	System.out.println(t.toString()+" / "+ t.hashCode() +" / " + System.identityHashCode(t) );
		ps.add(t);
		ps.add(t);	// ���� ��ü���� ������ ���ϴ°���..
		System.out.println(ps.size());
		while(ps.size()<7) {
			int rx = (int)(Math.random()*4);
			int ry = (int)(Math.random()*4);
			Position p = new Position(rx, ry);	
		//	System.out.println(p.toString()+" / "+ p.hashCode() +" / " + System.identityHashCode(p) );
			System.out.println("before ADD!");
			boolean r = ps.add(p);	
			// ������ü�� �ٸ���, ���Բ� �Ǵ��ϰ� �Ϸ���.. �߰� �۾��� �ʿ��ϴ�.
			// 1��° �۾���. hashCode �� �����ؾ� �Ѵ�.
			// 2��° �۾��� . equals()�� �����ؾ� �Ѵ�.
			System.out.println("After ADD ! "+r);
		}
		System.out.println(ps.toString());
	}
}