import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Source05_Generic {
	static int[] makeArray() {
		int[] ar = new int[3];
		for(int i=0; i<ar.length; i++) {
			ar[i] = 1+(int)(Math.random()*10);
		}
		return ar;
	}
	
	public static void main(String[] args) {
		Set<int[]> set = new LinkedHashSet<>();
		
		set.add(makeArray());
		set.add(makeArray());
		set.add(makeArray());
		System.out.println(set.size());
		// 3칸짜리배열이 3개저장이 되 있음. 각 배열의 int값들의 합을 구하려면
		// 배열객체를 하나씩 빼서 그안의 int 값들을 처리를 해야되는데,
		System.out.println(set.toString());
		System.out.println();
		// 1. enhanced for : 
		for(   int[] s   :    set   ) {	
			System.out.println(s);
			for(int i=0; i<s.length; i++) {
				System.out.println("→ " +s[i]);
			}
		}
		System.out.println();
		// 2. enhanced for 는 이 아래형태로 바껴서 작동한다.
		for(Iterator<int[]> i = set.iterator(); i.hasNext(); ) {
			int[] s = i.next();
			System.out.println(s);
			for(int m : s) {
				System.out.println("→ " +m);
			}
		}
		String m = "string";
		/*
		for( String s: m) {	
			// can only iterate over array or instance of iterable (컬렉션)
			
		}
		
		enhanced for로 순회가능한 객체는 배열과 Iterable 인스턴스인 컬렉션 객체
		*/
		
		
		
	}
}
