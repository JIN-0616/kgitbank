import java.util.HashSet;
import java.util.Set;

class Position{
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
	public int hashCode() {
		System.out.println("hashCode called..");
		//return x*y; 실제로 가진 데이터가 달라도, 같은 hashCode가 만들어질수 있다.
		return (x*x+y*y - x+y)*3;
		// 1.들고있는 데이터로 실제 부여밭은 hashCode가 아니라
		//  새로운 hashCode를 리턴시켜서 같은 데이터를 들고 있는 객체끼리만
		//  hashCode가 같게 나오게 해서 equals 를 돌릴수 있게 유도
	}
	
	@Override
	public boolean equals(Object obj) {
		// 2. 같은 데이터를 들고 있는 객체라면 equals() 비교가 true가 뜨게 변경
		System.out.println("equals called..");
		//return super.equals(obj);
		
		//------- 실제 equals 문 Override 예제 ---------
		
		if(obj instanceof Position) {
			Position other = (Position)obj;
			return this.x == other.x && this.y == other.y;
		}else {
			return false;
		}
		//----------------------------------------------
	}
}
//--------------------------------------------------------------------------------
public class Source08_Duplicate {
	public static void main(String[] args) {
		// 겹치지 않게 Position 을 확보해보자
		// 배멸보다는 Set 컬렉션이 같은 객체를 저장하지 않는다는걸 알아서 이용
		Set<Position> ps = new HashSet<>();
		Position t = new Position(1, 1);
		//System.out.println(t.toString()+" / "+t.hashCode()+" / "+System.identityHashCode(t));
		ps.add(t);
		ps.add(t);  // 같은 객체값은 저장을 안하는거지.
		System.out.println(ps.size());
		while(ps.size()<7) {
			int rx = (int)(Math.random()*4);
			int ry = (int)(Math.random()*4);
			Position p = new Position(rx, ry);
			//System.out.println(p.toString()+" / "+p.hashCode()+" / "+System.identityHashCode(p));
			System.out.println("before ADD...");
			boolean b = ps.add(p); 
			System.out.println("after ADD...");
			// 실제 객체가 다른데, 같게끔 판단하게 하려면, 추가 작업이 필요하다
			// 1번째 작업이 hashCode 를 수정해야 한다.
			// 2번째 작업이 equals()를 수정해야 한다.
			
			
			
			System.out.println(b);
		}
		System.out.println(ps.toString());
		
		// Integer나 String의 경우를 예제로 들어서 볼것
		// Object의 hashCode(), equals() 와
		// Override한 hashCode(), equals()를 비교해볼것
		
		
		//##################################################
		
		//※ 실제처리순서 HashSet, LinkedHashSet 
		
		// @Override  hashCode() --> .equals()
		
		// 1. public int hashCode() 

		// 2. public boolean equals(Object obj) 
		
		//##################################################

	}
}
