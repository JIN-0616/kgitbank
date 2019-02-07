package Collection;
/*
	4. Generics
	collection 개체들이 object로 처리되므로 형변환이 자주 발생
	
	Generics 
	  - 형의 제약을 둠 : 객체들을 저장하는 구조적인 성격을 보강
	  - 타입 안정성을 제공
	  - 타입체크와 형변환이 생략되어 코드가 간결
	  - list, set, map 다 가능
	  - 선언시 <타입> 형태로 정의
	  - 메소드인 경우 컬렉션의 상속형태까지 기술해야 함
	    ex) List<타입> 리스트명 = new List<타입>();	     
*/

import java.util.ArrayList;
import java.util.Iterator;

class Product{}

class Tv extends Product{}

class bed{}

public class Chap13_9_Generics {
	
	static void meth_1(ArrayList ar) { }
	
	static void meth_2(ArrayList<Product> ar) { }
	
	static void meth_3(ArrayList<Tv> ar) { }
	
	static void meth_4(ArrayList<? extends Product> ar) { }
	// 상속관계의 형태로 제너릭을 유지
	
	public static void main(String[] args) {
		ArrayList l1 = new ArrayList<>();	// 일반 리스트
			l1.add(new Product());
			l1.add(new Tv());
			l1.add(new bed());
			l1.add("침대는 가구가 아냐");  	// 모든 Object를 추가가능함 - 제약 사항이 없음			
		System.out.println(l1);
		
		ArrayList<Product> l2 = new ArrayList<Product>(); // Generic을 이용하여 제약을 둠
			l2.add(new Product());
			l2.add(new Tv());				// 클래스의 다형성으로 추가 가능
		//	l2.add(new Bed());				// 추가 불가
		//	l2.add("침대는 가구가 아냐");	// 추가 불가
			
		ArrayList<Tv> l3 = new ArrayList<Tv>();
		//	l3.add(new Product());			// 추가 불가
			l3.add(new Tv());
			
		meth_1(l1);
		meth_1(l2);
		meth_1(l3);
		
		meth_2(l1);
		meth_2(l2);
		//meth_2(l3);	//상속관계로는 인수 접근 불가
		
		meth_3(l1);
		//meth_3(l2); 	//상속관계로는 인수 접근 불가
		meth_3(l3);
		
		meth_4(l1);
		meth_4(l2);
		meth_4(l3);
		
		
		Iterator it = l2.iterator();
		while(it.hasNext()) {
			Product data = (Product)it.next();
		}
		
		// ---------------------------------------
		
		Iterator<Product> git = l2.iterator();
		// git = l3.iterator();
		while (git.hasNext()) {
			Product data = git.next();			
		}
				
		// ---------------------------------------

		Iterator<Tv> tvit = l3.iterator();
		//tvit = l2.iterator();
		while (tvit.hasNext()) {
			Product data = tvit.next();			
		}
		
		// ---------------------------------------
		
		Iterator<? extends Product> exit = l2.iterator(); //Iterator 역시 상속관계로 제너릭을 설정
		exit = l3.iterator();
		while (exit.hasNext()) {
			Product data = exit.next();			
		}
		
	}
}
