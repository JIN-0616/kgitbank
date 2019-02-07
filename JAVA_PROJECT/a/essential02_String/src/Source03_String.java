/*
 * String 객체의 해주는 것들..
 * 
 */
public class Source03_String {
	public static void main(String[] args) {
		/*
		 * 다른 문자열객체와 비교해서 비교결과를 알려주는 ..  
		 */
		// 1. boolean equals(Object) : 문자구성이 같은지 확인.
		// 2. boolean endsWith(String) , boolean startsWith(String) 
		//  해당 문자열로 시작을 한다거나, 끝난다거나,,
		// 3. int compareTo(String) : 크기비교 / abc▷가나다순 으로 갈수록 숫자가 커지고
		// 4. boolean matches(String) : 특정 패턴(정규식)에 부합하는지 확인
		String[] names = "관우,조운,관은평,조조,황충,하후돈,마초,사마의,제갈량,하후연,국의".split(",");
		for(int i=0; i<names.length; i++) {
			String s = names[i];	// names[i] 를 해도 되고,
			System.out.println(s +" .. " + s.equals("관우"));
			System.out.println("   .. " + s.startsWith("하후") + " .. " + s.endsWith("의"));
			System.out.println("   .. " + s.compareTo("조조") );	// s - "조조"
			// 자기가 가진 문자열구성이 더 작으면 음수, 같으면0, 크면 양수
			System.out.println(" .. " + s.matches("관[가-힇]{1}"));
		}
		// 정규식? 
		
		
	}
}
