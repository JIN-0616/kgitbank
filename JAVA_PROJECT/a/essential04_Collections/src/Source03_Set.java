import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Source03_Set {
	public static void main(String[] args) {
		/*
		 * Set 형 객체의 고유 특징을 살펴보자.
		 * 	재확보시 어떻게 데이터가 나오냐..
		 */
		Set set;
		if(Math.random()>0.666) {
			System.out.println("HashSet()");
			set = new HashSet();
		}else if(Math.random()> 0.5) {
			System.out.println("TreeSet()");
			set = new TreeSet();	// 크기순으로 정렬시켜 객체가 확보됨
		}else {
			System.out.println("LinkedHashSet()");
			set = new LinkedHashSet();	// 들어간순서로 정렬시켜 객체가 확보됨
		}
		//=========================================================
		System.out.println(set.add("조운"));
		System.out.println(set.add("관우"));
		System.out.println(set.add("조조"));
		System.out.println(set.add("조운"));	//  false 
		System.out.println(set.add("사마의"));
		System.out.println(set.add("하후돈"));
		System.out.println(set.add("여포"));
		System.out.println("set.size() = " + set.size());
		System.out.println("set.toString() = " + set.toString());	
		// 객체들 toString() 해서 문자열로 만들어준다. (저장된객체들의 toString()의 합)

		// 하나씩 뽑아서 제어를 하고 싶다면..? 객체값을 어떻게 뽑아서 사용하냐.
		
		// 3가지중 방법으로 순회할수 있다.
		// 1. toArray
		Object[] ar =set.toArray();	// 내부 관리 객체를 배열에 옮겨준다.
		for(int i=0; i<ar.length; i++) {
			// 이 안에 저장된 객체들이 전부 String 객체값이라면,
			String s = (String)ar[i];
			System.out.println(ar[i] + " : "+ s + "/" + s.startsWith("조"));	
		}
		// 2. Iterator 를 확보해서 처리하는,
		//    : 컬렉션에 저장된 객체를 접근할때 사용하는 커서 객체
		Iterator i = set.iterator();
			// Iterator 객체는 hasNext(), next(), remove()
		for(int cnt=1; cnt<=6; cnt++) {
			System.out.println(i.hasNext());	// next()를 해도 되는건가.?
			Object o = i.next();
			// i.remove();	//  
			System.out.println(o);
		}
		System.out.println("set.isEmpty? " + set.isEmpty());
		//=========================================================
		for( Iterator ii = set.iterator(); ii.hasNext() ;   ) {
			String o = (String)ii.next();
			System.out.println(o+"//" +o.startsWith("조"));
		}
		// 3. enhanced for  (Iterator를 자동 설정해서 돌려주는 for)
		for(Object obj  :   set) {
			System.out.println("→" + obj + " / " + (obj instanceof String) );
		}
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
	}
}


