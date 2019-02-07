import java.util.HashSet;
import java.util.Set;


/*
 * Set 컬렉션은 컬렉션간 집합/대규모연산(bulk operation) 이 가능하다. 
 * 
 */
public class Source06_Set {
	static Set<Integer> makeSample() {
		Set<Integer> s = new HashSet<>();
		for(int cnt=1; cnt<=5; cnt++) {
			int n = 1+ (int)(Math.random()*13);
			s.add(n);
		}
		return s;
	}
	
	public static void main(String[] args) {
		Set<Integer> s1 = makeSample();
		Set<Integer> s2 = makeSample();
		System.out.println("s1 = " + s1.toString());
		System.out.println("s2 = " + s2.toString());
		// 0. containsAll()
		boolean c = s1.containsAll(s2);
		System.out.println("containsAll = "+ c);
		
		// 1. addAll()
		boolean b = s1.addAll(s2);	// 하나이상이라도 추가가 되면, true
		System.out.println(b+" | s1 = " + s1.toString());
		System.out.println(s1.addAll(s2));
		
		// 0. containsAll()
		boolean c1 = s1.containsAll(s2);
		System.out.println("containsAll = "+ c1);
		
		// 2. removeAll();		retainAll()
		for(int cnt=1; cnt<=2; cnt++) {
			boolean r1 = s1.removeAll(s2);	// 하나이상이라도 삭제되면 true
			System.out.println("removeAll = "+ r1);
		}
		System.out.println("s1 = " + s1.toString());
		Set<Integer> s3 = makeSample();
		System.out.println("s3 = " + s3.toString());
		s3.retainAll(s1);
		System.out.println("s3 = " + s3.toString());
		
	}
}


