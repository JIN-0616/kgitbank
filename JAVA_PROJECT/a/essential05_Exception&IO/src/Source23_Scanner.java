import java.util.Scanner;

public class Source23_Scanner {
	public static void main(String[] args) {
		/*
		 * Scanner 는 java.io 패키지의 객체는 아니다. java.util. 패키지의 객체
		 * 	입출력 작업 객체로 소속을 지정하지 않았다.
		 */
		String data = "오늘은 목요일이다.\n곧 있으면 저녁시간이다.\n2018 10.25";
		System.out.println(data);
		Scanner scan = new Scanner(data);
		String s1 = scan.nextLine();	// 줄바꿈까지를 추출
		System.out.println("→ " + s1);
		for(int cnt=1; cnt<=2; cnt++) {
		String s2 = scan.next();	// 공백까지를 추출
		System.out.println("→ " + s2);
		}
		String s3 = scan.nextLine();
		System.out.println("→ " + s3 + " .." +s3.length());
		int n = scan.nextInt();	// next() 한 string을 parseInt()
		System.out.println(n);
		System.out.println(scan.hasNext());
		double d = scan.nextDouble();
		System.out.println(d);
		System.out.println(scan.hasNext());
		scan.next();	// 남은 데이터가 없으면 NoSuchElementException 이 발생
		//=============================
		
		// Scanner 객체는  문자열을 직접 소스로 설정안해도, 
		// 문자byte를 읽어낼수 있는 InputStream 을 설정해도  
		// 해당 input을 알아서 개조해서 문자들을 확보하면서 작업을 한다.
		
		
	}
	
}


