import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Source03_Set {
	public static void main(String[] args) {
		/*
		 * Set 형 객체의 고유 특징을 살펴보자
		 *  - 재확보시 어떻게 데이터가 나오는가?
		 */
		Set set;
		if(Math.random()>0.666) {
			System.out.println("HashSet");
			set = new HashSet();	// 순서X, 데이터관리속도 빠름	
		}else if(Math.random()>0.5) {
			System.out.println("TreeSet");
			set = new TreeSet();	// 크기순으로 정렬시켜 객체가 확보됨
		}else {
			System.out.println("LinkedHashSet");  
			set = new LinkedHashSet(); // 들어간 순서가 유지, 중복만 제거
		}
		//=====================================================================
		System.out.println(set.add("조운"));
		System.out.println(set.add("관우"));
		System.out.println(set.add("조조"));
		System.out.println(set.add("조운")); // 어떤 set이든 무조건 false (중복x)		
		System.out.println(set.add("사마의"));
		System.out.println(set.add("하우돈"));
		System.out.println(set.add("여포"));
		
		System.out.println("set.size() : "+set.size());
		System.out.println("set.toString() = "+set.toString());
		//객체를 toString()해서 문자열로 만들어준다. 저장된 객체들의 toString()의 합
		
		//HashSet
		//set.toString() = [관우, 사마의, 여포, 조조, 하우돈, 조운]

		//TreeSet
		//set.toString() = [관우, 사마의, 여포, 조운, 조조, 하우돈]
		
		//LinkedHashSet
		//set.toString() = [조운, 관우, 조조, 사마의, 하우돈, 여포]
		
		// 하나씩 뽑아서 제어를 하고 싶다면..? 객체값을 어떻게 뽑아서 사용하나?
		
		// 3가지 방법으로 순회 할수있다.
		// 1. toArray
		Object[] ar = set.toArray(); //내부 관리 객체를 배열에 옮겨준다.
		for (int i = 0; i < ar.length; i++) {
			// 이 안에 저장된 객체들이 전부 String 객체값이라면
			String s = (String)ar[i];
			System.out.println(ar[i]+ " : "+s+" / "+s.startsWith("조"));
		}
		
		// 2. Iterator 를 확보해서 처리하는 방법
		// 		 : 컬랙션에 저장된 객체를 접근할때 사용하는 커서 객체
		Iterator i = set.iterator(); //java.util.
			// Iterator 객체는 hasNext(), next(), remove()
		for (int cnt = 1; cnt <= 6; cnt++) {
			System.out.println(i.hasNext());//다음칸에 객체값이 있는지 boolean값으로 리턴
			Object o = i.next();			//커서초기값 , 이동(리턴), 마지막에서 next가면 에러
//			i.remove(); //
			System.out.println(o);
		}
		System.out.println("set.isEmpty? "+set.isEmpty());
		//================================================================
		// 자주 사용하는 방법
		for( Iterator ii = set.iterator(); ii.hasNext() ; ){
			String o = (String)ii.next();
			System.out.println(o+"//"+o.startsWith("초"));
		}
		
		// 3. enhanced for (Iterator를 자동 설정해서 돌려주는 for)
		for (Object obj :  set) {
			System.out.println("=="+obj+" / "+(obj instanceof String));	
			
		}
	}
}
