
public class Source02_Wrapper {
	public static void main(String[] args) {
		// Wrap(Boxing) , UnWrap(UnBoxing) 은 자동으로 일어난다.
		Integer n1 = new Integer(4561);
		Integer n2 = 4561;
		Integer n3 = 4561;
		System.out.println(n1+" / "+n2+" / "+n3);
		System.out.println(n1==n2); //false
		System.out.println(n1==n3); //false
		System.out.println(n2==n3); //false
		System.out.println();
		System.out.println(n1.equals(n2));	// true;
	    /*
				public boolean equals(Object obj) {
			        if (obj instanceof Integer) {
			            return value == ((Integer)obj).intValue();
			        }
			        return false;
			    }
	    */
		System.out.println(n1.intValue()==n2.intValue()); //true;
		
		int v1 = n1; // UnWrap(UnBoxing)  알아서 풀려서 들어가짐
		System.out.println(v1);
		System.out.println(n2 + n3); // UnWrap(UnBoxing) 객체값 더하기, 1.5 이후 자동지원
		/*
		 * 이걸 오토박싱,언박싱 이라고 부른다
		 */		
		System.out.println("======================================");
		boolean b1 = true;		//원래는 new로 생성하는것이 맞음
		boolean b2 = true;
		System.out.println(b1 == b2); //원래는 false가 맞으나 true, 같은 객체
		
		Integer i1 = 127; // -128 ~ 127 까지는 true 같은객체
		Integer i2 = 127; // 			이외의 값은 false 다른객체
		// i1++; //
		System.out.println(i1 == i2); // true, 같은 객체
		// why?
		
		Integer i3 = 128; // -128 ~ 127 까지는 true 같은객체
		Integer i4 = 128; // 			이외의 값은 false 다른객체
		// i1++; //
		System.out.println(i1 == i2); // false 다른 객체
	}
}
