
public class Source03_Wrapper {
	public static void main(String[] args) {
		// 특정 데이터를 가진 Wrapper 객체를 만들어내는 법은
		// 생성이 전부가 아니다.
		
		// 모든 Wrapper 객체는 valueOf 라는 기능이 있는데, 이걸 통해서도 만들어낼수 있다.
		// 매개변수로 설정가능한 것은, 각 객체의 데이터 타입이나, String이다
		Boolean b1 = new Boolean(true);
		Boolean b2 = Boolean.valueOf(true);	  // boolean
		Boolean b3 = Boolean.valueOf("true"); // String
		System.out.println(Boolean.TRUE); //미리 생성해둔 객체
		
		Integer i1 = new Integer(41);
		Integer i2 = Integer.valueOf(41);	 // int
		Integer i3 = Integer.valueOf("41");  // String
		/*
			valueOf  : 객체를 생성하는 메소드
			
			String d = "135000";
			int v = Integer.valueOf(d); // String -> Integer -> int 
		*/ 
		// b1 == b2 같은 객체? / b2 == b3 같은 객체?
		// i1 == i2 같은 객체? / i2 == i3 같은 객체?
		System.out.println(b1 == b2); // false
		System.out.println(b2 == b3); // true
		System.out.println(i1 == i2); // false
		System.out.println(i2 == i3); // true
		/*
		 * valueOf 를 이용해서 확보하는 Wrapper객체는 미리 만들어진 객체를 준다.
		 * 	(Boolean 은 true 가지고 있는 객체랑, false 가진 객체를 미리 만들어두고 둘중에 하나를 리턴)
		 *  수치형 Wrapper 같은 경우는, -128 ~ 127 까지만 만들어두고,
		 *  그 사이 객체는 만들어진걸로 리턴, 범위 밖은 새로 만듬
		 *  
		 * ########자동 Boxing 일어날때, valueOf()로 객체를 확보한다.##########
		 * 
		###### 	Boolean  #######
		
		      public static Boolean valueOf(boolean b) {
        		return (b ? TRUE : FALSE);
    		  }
    		  public static final Boolean TRUE = new Boolean(true);
    		  public static final Boolean FALSE = new Boolean(false);
    		  
    		  
		######	Integer  #######
		
			  public static Integer valueOf(int i) {
        		if (i >= IntegerCache.low && i <= IntegerCache.high)
            		return IntegerCache.cache[i + (-IntegerCache.low)];
        			return new Integer(i);
    			}
    			
		 */
		
		Double d1 = Double.valueOf(3.14);
		Double d2 = 3.14;
		System.out.println(3.14);
		/*  수치형객체의 경우 범위설정이 어려우므로 새로 객체를 생성한다.
		 
		###### Double  #######
		    public static Double valueOf(double d) {
        		return new Double(d);
    		}
    		
    	*/
	
	}
}
