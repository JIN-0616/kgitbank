import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 *  컬렉션 객체는 객체타입을 설정하고 사용하는게 권장이다.	(제너릭 설정을 할수있게 해두었다) 
 *	
 *	제너릭은 사용하고자 객체타입을 컴파일타임에 결정지을수 있게 가변 처리해둔걸 말하는 거다.
 *	(설정되지 않으면 Object로 처리 됨)  
 */

class Box<E> {
	E one;	// 
	E other;
	boolean setData(E e) {
		if(one == null) {
			one = e;
			return true;
		} else if(other == null) {
			other = e;
			return true;
		} else {
			return false;
		}
	}
	public String toString() {
		return "one = "+ one +", other = " + other;
	}
}

public class Source04_Generic {
	public static void main(String[] args) {
		Box b = new Box();
		// boolean setData(Object e)  로 처리된다.
		Box<String> bb = new Box<String>();	// 설정하게 되면
		bb.setData("33");	// 그타입으로 가변처리 해둔 객체타입이 지정되게 된다.
		
		
		// 설정하고 만들면 어떤게 좋냐..?
		Set<String> filter = new HashSet<>();	// 뒤는 생략을 해도 된다.	new HashSet<String>(); 써도 됨.
		// filter.add(3);
		filter.add("MON");
		filter.add("MON");
		filter.add("THU");
		// 해당타입의 객체값만 저장이 되고,
		// Iterator를 쓴다거나, enhanced for 를 돌릴때 바로 저장객체타입으로 객체값을 얻을수가 있다.
		Iterator<String> it =filter.iterator();
		while(it.hasNext()) {
			String m = it.next();
			System.out.println(m+" .. " + m.charAt(0));
		}
		for(String o  :  filter) {
			System.out.println(o +" .. " + o.charAt(1));
		}
		//==============================================================
		
		
		
	}
}



