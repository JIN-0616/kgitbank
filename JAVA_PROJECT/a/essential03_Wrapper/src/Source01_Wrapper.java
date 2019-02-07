/*
 * 
 * Wrapper 객체는
 * 	: 기본데이터를 객체화시키기 위해서 만들어둔 것들이다.  
 */
public class Source01_Wrapper {
	public static void main(String[] args) {
		// 기본데이터 
		// (비객체형 데이터로  true,false  / 정수 / 실수 / 문자  데이터를 의미한다.) 
		
		boolean b = true;
		Boolean wb1 = new Boolean(b);	// Wrap
		Boolean wb2 = new Boolean(b);
		System.out.println(wb1 + " / " + wb2);
		// Wrapper 객체값을 출력하면 toString() 에 의해 가지고 있는 데이터가 찍힌다.
		System.out.println(wb1 == wb2);
		
		boolean d1 = wb1.booleanValue();	// UnWrap
		boolean d2 = wb2.booleanValue();	// UnWrap
		System.out.println(d1 == d2);
		/*
		 * Boolean  : Boolean(boolean)    , boolean  booleanValue() 
		 * Byte : Byte(byte) , byte byteValue();
		 * Short ..     : shortValue();
		 * Integer (int)   : intValue();
		 * Long (long)   : longValue();
		 * Float (float) : floatValue();
		 * Double (double) : doubleValue();
		 * Character (char) : charValue()
		 */
		
		
	}
}



