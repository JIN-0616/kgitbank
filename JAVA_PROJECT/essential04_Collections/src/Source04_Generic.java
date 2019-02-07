import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 컬렉션 객체는 객체타입을 설정하고 사용하는 것을 권장한다 (제너릭 설정을 할수있게 해두었다)
 * 
 * 제너릭은 사용하고자 하는 타입을 컴파일탐에 결정지을수 있게 가변처리 해둔것을 말하는 것이다.
 * (설정하지 않으면 Object로 처리 됨)
 */

class Box<E>{
	E one;
	E other;
	
	boolean	setData(E e) {
		if(one==null) {
			one = e;
			return true;
		}else if(other==null) {
			other = e;
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "one = "+ one + ", other = "+ other;
	}
}

public class Source04_Generic {
	public static void main(String[] args) {
		Box b = new Box();
		// boolean setData(Object e) 로 처리된다
		Box<String> bb = new Box<String>(); //사용자가 처리타입을 지정
		bb.setData("33");
		//가변처리후 - 사용자가 설정해서 사용 - 컴파일단계에서 지정이 됨
		//bb.setData(1); 이미 제너릭설정을 해서 고정되었으므로 불가
		
		// 설정하고 만들면 어떻게 좋나?
		Set<String> filter = new HashSet<>(); // 뒤는 생략을 해도 된다. new HashSet<String>(); 써도 됨
		//filter.add(3);
		filter.add("MON");
		filter.add("MON");
		// 이 타입만 저장이 되고
		// Iterator를 쓴다거나, enhanced for를 돌릴때 바로 저장객체타입으로 객체값을 얻을수가 있다.
		// -->Casting을 안해도 됨
		Iterator<String> it = filter.iterator();
		while(it.hasNext()) {
	//		Object o = it.next(); //미설정시 Object로 받아서 casting해줘야함
			String m = it.next();	
			System.out.println(m+ "..."+m.charAt(0));
		}
	//	for (Object o : filter) // 미설정시
		for (String o : filter) {
			System.out.println(o+ "..."+o.charAt(1));
		}
	}
}
