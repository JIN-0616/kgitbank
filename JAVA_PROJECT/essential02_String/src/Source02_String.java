/*
 * String 객체가 처리해주는 기능
 */
public class Source02_String {
	public static void main(String[] args) {
		String str = "사면초가";
		// 설정된 char[] 배열을 토대로 정보를 몇가지 준다.
		
		int len = str.length(); // 배열크기 : 문자열 크기
		System.out.println(len);
		char c = str.charAt(0);
		System.out.println("c ="+c);
		System.out.println(c == '사');
		
		char[] ar = str.toCharArray();
		// 자신이 가지고 있는 문자값을 배열에 담아서 리턴시켜줌
		for (int i = 0; i < ar.length; i++) {
			System.out.println(i+" : "+ar[i]);
		}
		//===============================================================

		// # 위치 찾아주기 - indexOf, lastIndexOf
		
		int s1 = str.indexOf('초');
			//해당문자의 위치 ,(없으면 -1, 여러개면 첫번째 찾은 문자의 index가 리턴)
		System.out.println("s1 = "+s1);
		
		int s2 = str.indexOf("면초"); // 문자열도 찾아진다.
		System.out.println("s2 = "+s2);
		
		// lastIndexOf(char), lastIndexOf(String)		
		int s3 = str.lastIndexOf('초');
		System.out.println("s3 = "+s3);
		
		// indexOf, lastIndexOf 둘 다 탐색문자(문자열), int값 설정이 하나 더 가능한데,
		// 탐색 시작위치를 변경할수 있다. 
		// (default : indexOf (0)칸부터, lastIndexOf (length-1) 부터 탐색)
		
		int s4 = str.indexOf('초',3);
		System.out.println("s4 = "+s4);
		
		//===============================================================

		// # 편집하기 - substring, split, replace, trim
		
		// substring(int b), substring(int b,int g)
		//  : 자기의 배열에서 일부분을 추출해서 String 객체를 생성시켜줌
		
		String b1 = str.substring(1,4); // 1<= <4
		System.out.println("b1 = "+b1);
		
		String b2 = str.substring(2);	// 2<= 끝까지
		System.out.println("b2 = "+b2);
		
		// String[].split(String) : 특정문자열을 기준으로 char[]을 끊어서 string[]을 만들어줌
		String data ="사면초가,풍전등화,진퇴양난,설상가상,전화위복";
		String[] arr = data.split(",");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// String.replace(char oldchar,char newchar) : 자신의 char값중에 특정문자를 변경해서 String을 생성시킴 
		// String.replace(String,String) : 
		String r1 = data.replace(',','-');
		System.out.println(r1);
		String r2 = data.replace("풍전등화","????????");
		System.out.println(r2);
		
		// String.trim() : 첫문자가 나오기 전까지 공백과, 마지막 문자뒤의 공백을 제거해서 새로운 문자열을 만들어냄
		String p = "   아무거나 작성 해보자!!  ";
		System.out.println("["+p+"]");
		String tp = p.trim();
		System.out.println("["+tp+"]");
	}
}
