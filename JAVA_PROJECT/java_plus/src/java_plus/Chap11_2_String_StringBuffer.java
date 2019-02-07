package java_plus;
/*
	2. String / StringBuffer
		-문자열을 다루기 위해 제공되는 클래스
		
	   #불변성
		-String class : 불변성을 가지기 때문에 문자열이 생성되어 초기화된 이후에는 항상 읽기 전용상태를 유지한다.
						메소드를 이용하여 문자열 변경시 원본은 그대로 있고 새로운 객체가 생성된다.
		-StringBuffer class : 불변성이 없기 때문에 변경 가능하다.
		
	  * 객체의 선언 및 생성
	    -String class : 2가지 방법
	     -1-기본데이터형처럼 선언하고 대입하는 문자열 상수 방식 : s1과 s2는 같은 주소를 가진다.
	    	String s1 = "java"; String s2 = "java";
	   	 -2-new 연산자를 사용하는 일반적인 객체 생성 방법 : s3과 s4는 다른 주소를 가진다.
	   		String s3 = new String("java"); String s4 = new String("java");
	  
	  * 메소드
	  	 toString() : value가 나옴
	  	 대입		: value의 대입
	  	 equals(value): value의 비교
	  	 length()	: 글자 길이
	  	 charAt(22); 	//글자번호 char 추출
	  	 subString(22); //일부 문자열 추출 글자번호->끝
	  	 SubString(4,10); //일부 문자열 시작번호->끝나는 다음번호 4->8
	  	 split("@");  	//문자열을 구분기호로 나누어 문자열배열
	  	 split("[.]"); 	//점만 [] 사용
	  	 indexOf("a"); 	//찾는 문자열의 처음 등장번호
	  	 indexOf("avz",7); //찾는 문자열의 시작번호에서부터 처음 등장하는 번호
	  	 lastindexOf("a"); //찾는 문자열의 마지막 등장번호
	  	 toUpperCase();	//대문자
	  	 toLowerCase(); //소문자
	  	 replaceAll("이전문자열","바뀔문자열"); //문자열 치환
	  	 toCharArray();	//문자열을 글자배열
	  	 trim();		//문자열의 앞뒤 공백제거
	  	 concat("Java");//문자열 뒤에 붙이기
	  	  
*/
public class Chap11_2_String_StringBuffer {
	public static void main(String[] args) {
		String a = "선생님 귀여워요 AbcD ef Java 만세 1234";
		//			0 1 2 34---------------------------->28
		String email = "aaa_bbb@abc.co.kr";
		String b = a; //대입은 값의 대입
		b = "선생님 사랑해요";
		String c = "선생님 사랑해요";
		System.out.println(a.toString());
		System.out.println(b);
		if(b.equals(c)) //값의 비교
			System.out.println("같아요");
		else
			System.out.println("달라요");
		
		System.out.println(a.length()); // 0,28 => 29 글자길이
		char ch = a.charAt(2);	//문자열의 번호글자 -> 한글자
		System.out.println(ch); //글자길이
		System.out.println(a.substring(22)); //일부 문자열 추출, {글자번호,}
		System.out.println(a.substring(4, 10));
		//일부 문자열 시작번호 -> 끝나는 다음번호 4->8
		String arr[] = email.split("@"); //문자열을 구분기호로 나누어 문자열 배열
		System.out.println(arr.length);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		String arr2[] = email.split("[.]");
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		
		String d = "abcd avze avz akj";
		System.out.println(d.indexOf("a")); //찾는 문자열의 처음 등장번호
		System.out.println(d.indexOf("avz" ,7));
		System.out.println(d.lastIndexOf("a"));
		String filename = "abc.234.567.tyu.jpg";
		String file_arr[] = filename.split("[.]");
		System.out.println(file_arr[file_arr.length-1]);
		System.out.println(filename.substring(filename.lastIndexOf(".")+1));
		
		System.out.println(a.toUpperCase()); //대문자
		System.out.println(a.toLowerCase()); //소문자
		char[] ch_arr = d.toCharArray(); // 문자열을 글자배열
		for (int i = 0; i < ch_arr.length; i++) {
			System.out.print(ch_arr[i]+", ");			
		}
		System.out.println();
		String tr = "   선생님 귀여워요    ";
		System.out.println(tr.length());
		System.out.println(tr.trim().length()); //문자열 앞뒤 공백제거
		
		
				
		
		
	}
}
